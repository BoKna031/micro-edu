package integration;

import org.example.HotelMain;
import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = HotelMain.class)
public class HotelControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private final String host = "http://localhost:";


    @Test
    public void registerNewHotel_CreateNewHotelWithId(){
        ResponseEntity<HotelDescriptionResponse> response = testRestTemplate.postForEntity(
                host + port + "/rest/hotels",
                new RegisterHotelRequest("Name1", "Adr1", 4),
                HotelDescriptionResponse.class
        );

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotNull(response.getBody().getId());
    }

    @Test
    public void getAll_ReturnList(){
        ResponseEntity<HotelDescriptionResponse[]> response = testRestTemplate.getForEntity(
                host + port + "/rest/hotels",
                HotelDescriptionResponse[].class
        );

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertTrue(response.getBody().length >= 1);
    }
    @Test
    public void getById_getHotelWith(){

        Long id = getExistingHotel();

        if(id == null)
            Assertions.fail("There is not any hotel in database to test!");

        ResponseEntity<HotelDescriptionResponse> response = testRestTemplate.getForEntity(
                host + port + "/rest/hotels/" + id,
                HotelDescriptionResponse.class
        );

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNotNull(response.getBody().getId());
    }

    @Test
    public void getById_throwsNotFound(){
        ResponseEntity<HotelDescriptionResponse> response = testRestTemplate.getForEntity(
                host + port + "/rest/hotels/" + -1L,
                HotelDescriptionResponse.class
        );

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }



    @Test
    public void delete_deletesAlsoRooms(){
        Long id = getExistingHotel();

        if(id == null)
            Assertions.fail("There is no hotel to delete!");

        ResponseEntity<String> response = testRestTemplate.exchange(
                host + port + "/rest/hotels/" + id,
                HttpMethod.DELETE,
                null,
                String.class
        );

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Hotel successfully deleted!", response.getBody());

        //TODO: prove that room is also deleted
    }

    @Test
    public void delete_notExistingEntity_ReturnNotFoundStatus(){
        ResponseEntity<String> actualResponse = testRestTemplate.exchange(
                host + port + "/rest/hotels/" + -1L,
                HttpMethod.DELETE,
                null,
                String.class
        );

        Assertions.assertEquals(HttpStatus.NOT_FOUND, actualResponse.getStatusCode());
        Assertions.assertNotNull(actualResponse.getBody());
        Assertions.assertNotEquals("Hotel successfully deleted!", actualResponse.getBody());
    }

    private Long getExistingHotel(){
        HotelDescriptionResponse[] hotels = testRestTemplate.getForEntity(
                host + port + "/rest/hotels",
                HotelDescriptionResponse[].class
        ).getBody();
        if(hotels == null || hotels.length == 0)
            return null;
        return hotels[0].getId();
    }
}
