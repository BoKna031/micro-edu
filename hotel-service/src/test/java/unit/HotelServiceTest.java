package unit;

import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.exception.EntityNotFoundException;
import org.example.model.Hotel;
import org.example.repository.HotelRepository;
import org.example.service.HotelServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class HotelServiceTest {

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Mock
    private HotelRepository hotelRepositoryMock;

    @Test
    public void createSuccessfully(){
        Hotel expectedHotel = new Hotel("Sheraton", "Bulevar Evrope 3", 4, null);
        RegisterHotelRequest request = new RegisterHotelRequest(expectedHotel.getName(), expectedHotel.getAddress(), expectedHotel.getNumberOfStars());
        expectedHotel.setId(1L);

        BDDMockito.when(hotelRepositoryMock.save(ArgumentMatchers.any(Hotel.class)))
                .thenReturn(expectedHotel);

        HotelDescriptionResponse actualResponse =  hotelService.create(request);

        Assertions.assertNotNull(actualResponse);
        Assertions.assertNotNull(actualResponse.getId());
        Assertions.assertEquals(expectedHotel.getAddress(), actualResponse.getAddress());
        Assertions.assertEquals(expectedHotel.getName(), actualResponse.getName());
        Assertions.assertEquals(expectedHotel.getNumberOfStars(), actualResponse.getCategory());
    }

    @Test
    public void getByIdSuccessfully(){
        Hotel expectedHotel = createHotel(1L, "Sheraton", "Bulevar Evrope 3", 4);

        BDDMockito.when(hotelRepositoryMock.findById(expectedHotel.getId()))
                .thenReturn(Optional.of(expectedHotel));

        HotelDescriptionResponse actualResponse =  hotelService.getById(expectedHotel.getId());

        Assertions.assertNotNull(actualResponse);
        Assertions.assertNotNull(actualResponse.getId());
        Assertions.assertEquals(expectedHotel.getId(), actualResponse.getId());
        Assertions.assertEquals(expectedHotel.getAddress(), actualResponse.getAddress());
        Assertions.assertEquals(expectedHotel.getName(), actualResponse.getName());
        Assertions.assertEquals(expectedHotel.getNumberOfStars(), actualResponse.getCategory());
    }

    @Test
    public void getByNotExistingId(){
        BDDMockito.when(hotelRepositoryMock.findById(-1L))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> hotelService.getById(-1L));
    }

    @Test
    public void getAll(){
        Hotel expectedHotel = createHotel(1L, "Name1", "Addr1", 3);

        BDDMockito.when(hotelRepositoryMock.findAll())
                .thenReturn(List.of(
                        expectedHotel,
                        createHotel(2L, "Name2", "Addr2", 5)
                        ));

        List<HotelDescriptionResponse> actualHotelList = hotelService.getAll();
        HotelDescriptionResponse actualFirstHotel = actualHotelList.get(0);


        Assertions.assertNotNull(actualHotelList);
        Assertions.assertNotNull(actualFirstHotel.getId());
        Assertions.assertEquals(expectedHotel.getId(), actualFirstHotel.getId());
        Assertions.assertEquals(expectedHotel.getAddress(), actualFirstHotel.getAddress());
        Assertions.assertEquals(expectedHotel.getName(), actualFirstHotel.getName());
        Assertions.assertEquals(expectedHotel.getNumberOfStars(), actualFirstHotel.getCategory());
    }

    private Hotel createHotel(Long id, String name, String address, int category){
        Hotel hotel = new Hotel(name, address, category, null);
        if(id != null)
            hotel.setId(id);
        return hotel;
    }
}
