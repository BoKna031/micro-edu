package unit;

import dummy.HotelCreator;
import org.example.dto.hotel.HotelDescriptionResponse;
import org.example.dto.hotel.RegisterHotelRequest;
import org.example.exception.EntityNotFoundException;
import org.example.model.Hotel;
import org.example.repository.HotelRepository;
import org.example.service.HotelServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class HotelServiceTest {

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Mock
    private HotelRepository hotelRepositoryMock;

    @BeforeEach
    public void SetUp(){
        Hotel dummyHotel = HotelCreator.createdHotel();
        BDDMockito.when(hotelRepositoryMock.save(
                        Mockito.argThat(hotel -> {
                           return hotel.getId() == null;
                        })
                ))
                .thenReturn(dummyHotel);

        BDDMockito.when(hotelRepositoryMock.findById(dummyHotel.getId()))
                .thenReturn(Optional.of(dummyHotel));
        BDDMockito.when(hotelRepositoryMock.findById(-1L))
                .thenReturn(Optional.empty());

        BDDMockito.when(hotelRepositoryMock.findAll())
                .thenReturn(List.of(dummyHotel));
    }

    @Test
    public void createSuccessfully(){
        Hotel hotel = HotelCreator.createdHotel();
        RegisterHotelRequest request = new RegisterHotelRequest(hotel.getName(), hotel.getAddress(), hotel.getNumberOfStars());
        HotelDescriptionResponse hotelDescriptionResponse =  hotelService.create(request);

        Assertions.assertNotNull(hotelDescriptionResponse);
        Assertions.assertNotNull(hotelDescriptionResponse.getId());
        Assertions.assertEquals(request.getAddress(), hotelDescriptionResponse.getAddress());
        Assertions.assertEquals(request.getName(), hotelDescriptionResponse.getName());
        Assertions.assertEquals(request.getCategory(), hotelDescriptionResponse.getCategory());
    }

    @Test
    public void getByIdSuccessfully(){
        Hotel hotel = HotelCreator.createdHotel();
        HotelDescriptionResponse hotelDescriptionResponse =  hotelService.getById(hotel.getId());

        Assertions.assertNotNull(hotelDescriptionResponse);
        Assertions.assertNotNull(hotelDescriptionResponse.getId());
        Assertions.assertEquals(hotel.getId(), hotelDescriptionResponse.getId());
        Assertions.assertEquals(hotel.getAddress(), hotelDescriptionResponse.getAddress());
        Assertions.assertEquals(hotel.getName(), hotelDescriptionResponse.getName());
        Assertions.assertEquals(hotel.getNumberOfStars(), hotelDescriptionResponse.getCategory());
    }

    @Test
    public void getByNotExistingId(){
        Assertions.assertThrows(EntityNotFoundException.class, () -> hotelService.getById(-1L));
    }

    @Test
    public void getAll(){
        Hotel hotel = HotelCreator.createdHotel();
        List<HotelDescriptionResponse> hotels = hotelService.getAll();

        Assertions.assertNotNull(hotels);
        Assertions.assertFalse(hotels.isEmpty());
        Assertions.assertNotNull(hotels.get(0).getId());
        Assertions.assertEquals(hotel.getId(), hotels.get(0).getId());
        Assertions.assertEquals(hotel.getAddress(), hotels.get(0).getAddress());
        Assertions.assertEquals(hotel.getName(), hotels.get(0).getName());
        Assertions.assertEquals(hotel.getNumberOfStars(), hotels.get(0).getCategory());
    }
}
