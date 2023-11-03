package dummy;

import org.example.model.Hotel;

public class HotelCreator {

    public static Hotel nonexistingHotel(){
        return new Hotel("Sheraton", "Bulevar Evrope 3", 4, null);
    }
    public static Hotel createdHotel(){
        Hotel hotel = nonexistingHotel();
        hotel.setId(1L);
        return hotel;
    }
}
