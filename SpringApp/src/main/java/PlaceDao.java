import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
public class PlaceDao {

    private List<Place> placetList = new ArrayList<Place>();

    public void addPlace(Place place)
    {
        placetList.add(place);
    }

    public Set<Contact>  getAllContactsForPlace (Place place)
    {

    }
}
