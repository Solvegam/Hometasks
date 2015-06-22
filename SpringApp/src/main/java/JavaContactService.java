import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
public class JavaContactService {

    ApplicationContext context = new ClassPathXmlApplicationContext("context-Application.xml");
    public ContactDao contactDao;
    public HobbyDao hobbyDao;
    public PlaceDao placeDao;
    public MessageDao messageDao;

    public static void main(String[] args) {

    }

    public void createContact(String firstName, String lastName, LocalDate birthDate)
    {

        Contact contact = (Contact)context.getBean("contact");

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthDate(birthDate);

        contactDao.addContact(contact);
    }

    public void addHobby(String title,String desription)
    {
        Hobby hobby = new Hobby (title,desription);
        hobbyDao.addHobby(hobby);
    }

    public void addPlace (String title,String desription, double longitude, double latitude)
    {
        Place place = new Place(title,desription,longitude,latitude);
        placeDao.addPlace(place);
    }

    public  void addFriendship (Contact firstContact,Contact secondContact)
    {

    }

    public Set<Contact> getFriendList (Contact person)
    {

    }

    public List<Message> Conversation (Contact firstContact,Contact secondContact)
    {

    }


}
