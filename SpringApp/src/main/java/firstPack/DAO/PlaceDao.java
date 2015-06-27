package firstPack.DAO;

import firstPack.DTO.PlaceDTO;
import firstPack.rootClasses.Contact;
import firstPack.rootClasses.Place;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
@Component
public class PlaceDao {

    private Set<Place> placetList = new HashSet<Place>();

    public void addPlace(PlaceDTO placeDTO)
    {
        Place place = new Place();
        place.setTitle(placeDTO.getTitle());
        place.setDescription(placeDTO.getDescription());
        place.setLongtitude(placeDTO.getLongtitude());
        place.setLatitude(placeDTO.getLatitude());
        placetList.add(place);
    }

//    public Set<Contact>  getAllContactsForPlace (Place place)
//    {
//
//    }
}
