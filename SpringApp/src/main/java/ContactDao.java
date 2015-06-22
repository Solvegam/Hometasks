import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
public class ContactDao {

    private Set<Contact> contactList = new HashSet<Contact>();
    public void addContact (Contact person)
    {
        contactList.add(person);
    }

    public void deleteContact (Contact person)
    {

    }

    public void addFriendship (Contact firstPerson,Contact secondPerson)
    {

    }

    public void removeFriendShip (Contact firstPerson,Contact secondPerson)
    {

    }
}
