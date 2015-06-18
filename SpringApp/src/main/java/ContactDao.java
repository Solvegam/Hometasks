import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.06.2015.
 */
public class ContactDao {

    private List<Contact> contactList = new ArrayList<Contact>();
    public void addContact (Contact person)
    {
        contactList.add(person);
    }

    public void deleteContact (Contact person)
    {

    }

    public void addFriendship (Contact firstPerson,Contact seconPerson)
    {

    }

    public void removeFriendShip (Contact firstPerson,Contact seconPerson)
    {

    }
}
