package unit;

import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.dto.location.LocationResponse;
import org.example.exception.EntityNotFoundException;
import org.example.model.Hotel;
import org.example.repository.HotelRepository;
import org.example.service.HotelServiceImpl;
import org.example.service.interfaces.LocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
public class HotelServiceTest {

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Mock
    private HotelRepository hotelRepositoryMock;

    @Mock
    private LocationService locationService;

    @Test
    public void createSuccessfully(){
        Hotel expectedHotel = new Hotel("Sheraton", UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"), 4, null);
        RegisterHotelRequest request = new RegisterHotelRequest(expectedHotel.getName(), UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"), expectedHotel.getNumberOfStars());
        expectedHotel.setId(1L);

        BDDMockito.when(hotelRepositoryMock.save(ArgumentMatchers.any(Hotel.class)))
                .thenReturn(expectedHotel);
        BDDMockito.when(locationService.getAddressFromLocationUUID(expectedHotel.getLocationId()))
                .thenReturn(createDummyLocation(expectedHotel.getLocationId()));


        HotelDescriptionResponse actualResponse =  hotelService.create(request);

        Assertions.assertNotNull(actualResponse);
        Assertions.assertNotNull(actualResponse.getId());
        Assertions.assertEquals(expectedHotel.getAddress(), actualResponse.getAddress());
        Assertions.assertEquals(expectedHotel.getName(), actualResponse.getName());
        Assertions.assertEquals(expectedHotel.getNumberOfStars(), actualResponse.getCategory());
    }

    @Test
    public void getByIdSuccessfully(){
        Hotel expectedHotel = createHotel(1L, "Sheraton", UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"), 4);

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
    public void getAll_whenAddressIsNullAndUpdated(){
        Hotel expectedHotel = createHotel(1L, "Name1", UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"), 3);
        BDDMockito.when(locationService.getAddressFromLocationUUID(ArgumentMatchers.any()))
                .thenReturn(createDummyLocation(UUID.fromString("58e0a7d7-eebc-11d8-9669-0800200c9a66")));
        BDDMockito.when(hotelRepositoryMock.findAll())
                .thenReturn(List.of(
                        expectedHotel,
                        createHotel(2L, "Name2", UUID.fromString("58e0a7d7-eebc-11d8-9669-0800200c9a66"), 5)
                        ));
        BDDMockito.when(hotelRepositoryMock.save(ArgumentMatchers.any()))
                .thenReturn(createHotel(expectedHotel.getId(), expectedHotel.getName(), expectedHotel.getLocationId(), expectedHotel.getNumberOfStars(), "Spain, Sevilla, C. Tamarguillo"));

        List<HotelDescriptionResponse> actualHotelList = hotelService.getAll();
        HotelDescriptionResponse actualFirstHotel = actualHotelList.get(0);


        Assertions.assertNotNull(actualHotelList);
        Assertions.assertNotNull(actualFirstHotel.getId());
        Assertions.assertEquals(expectedHotel.getId(), actualFirstHotel.getId());
        Assertions.assertEquals(expectedHotel.getLocationId(), actualFirstHotel.getLocation());
        Assertions.assertNotNull(actualFirstHotel.getAddress());
        Assertions.assertFalse(actualFirstHotel.getAddress().isEmpty());
        Assertions.assertEquals(expectedHotel.getName(), actualFirstHotel.getName());
        Assertions.assertEquals(expectedHotel.getNumberOfStars(), actualFirstHotel.getCategory());
    }

    @Test
    public void getAll(){
        Hotel expectedHotel = createHotel(1L, "Name1", UUID.fromString("5fc03087-d265-11e7-b8c6-83e29cd24f4c"), 3, "addr1");
        BDDMockito.when(locationService.getAddressFromLocationUUID(ArgumentMatchers.any()))
                .thenReturn(createDummyLocation(UUID.fromString("58e0a7d7-eebc-11d8-9669-0800200c9a66")));
        BDDMockito.when(hotelRepositoryMock.findAll())
                .thenReturn(List.of(
                        expectedHotel,
                        createHotel(2L, "Name2", UUID.fromString("58e0a7d7-eebc-11d8-9669-0800200c9a66"), 5, "addr2")
                ));

        List<HotelDescriptionResponse> actualHotelList = hotelService.getAll();
        HotelDescriptionResponse actualFirstHotel = actualHotelList.get(0);


        Assertions.assertNotNull(actualHotelList);
        Assertions.assertNotNull(actualFirstHotel.getId());
        Assertions.assertEquals(expectedHotel.getId(), actualFirstHotel.getId());
        Assertions.assertEquals(expectedHotel.getLocationId(), actualFirstHotel.getLocation());
        Assertions.assertNotNull(actualFirstHotel.getAddress());
        Assertions.assertFalse(actualFirstHotel.getAddress().isEmpty());
        Assertions.assertEquals(expectedHotel.getName(), actualFirstHotel.getName());
        Assertions.assertEquals(expectedHotel.getNumberOfStars(), actualFirstHotel.getCategory());
    }

    private Hotel createHotel(Long id, String name, UUID location, int category){
        Hotel hotel = new Hotel(name, location, category, null);
        if(id != null)
            hotel.setId(id);
        return hotel;
    }

    private Hotel createHotel( Long id, String name, UUID location, int category, String address){
        Hotel hotel = createHotel(id, name, location, category);
        hotel.setAddress(address);
        return hotel;
    }

    private LocationResponse createDummyLocation(UUID id){
        return new LocationResponse(id, "Spain", "Sevilla", "C. Tamarguillo");
    }

}
