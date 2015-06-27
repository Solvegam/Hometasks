package firstPack.DAO;

import firstPack.DTO.ContactDTO;
import firstPack.rootClasses.Contact;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
@Component
public class ContactDao {

    private Set<Contact> contactList = new HashSet<Contact>();
    public void addContact (ContactDTO contactDTO)
    {
        Contact contact = new Contact();
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setBirthDate(contactDTO.getBirthday());
        contactList.add(contact);
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
