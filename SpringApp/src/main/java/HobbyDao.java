import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
public class HobbyDao {

    private List<Hobby> hobbyList = new ArrayList<Hobby>();

    public void addHobby(Hobby hobby)
    {
        hobbyList.add(hobby);
    }

    public Set<Contact> getAllContactsWithHobby (Hobby hobby)
    {

    }
}
