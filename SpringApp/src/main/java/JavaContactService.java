import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.lang.reflect.*;

/**
 * Created by Stas on 17.06.2015.
 */
public class JavaContactService {

    static ApplicationContext context = new ClassPathXmlApplicationContext("context-Application.xml");
    public static ContactDao contactDao;
    public static HobbyDao hobbyDao;
    public static PlaceDao placeDao;
    public static MessageDao messageDao;

    public static void main(String[] args) throws ParseException {
        System.out.println("Please, type one of the command number: \n 1 – create contact \n 2 - add Hobby \n 3 – addPlace \n 4 – addFriendship" );
        Scanner scanner = new Scanner (System.in);
        int command = scanner.nextInt();

        switch (command)
        {
            case 1:
            {
                System.out.println("Type first name");
                String firstName = scanner.nextLine();
                System.out.println("Type last name");
                String lastName = scanner.nextLine();
                System.out.println("Type birthday just like yyyy-mm-dd");
                LocalDate birthday  = new LocalDate(scanner.nextLine());
                createContact(firstName,lastName,birthday);
            }
            case 2:
            case 3:
            case 4:
        }

    }

    public static void createContact(String firstName, String lastName, LocalDate birthDate)
    {

        Contact contact = (Contact)context.getBean("newContact");

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthDate(birthDate);

        contactDao.addContact(contact);
    }

    public static void addHobby(String title,String description) throws IllegalAccessException {
        Hobby hobby = (Hobby)context.getBean("newHobby");
        Class hobbyClass = hobby.getClass();
        hobbyClass.getFields()[0].set(hobby,title);
        hobbyClass.getFields()[1].set(hobby,description);

        hobbyDao.addHobby(hobby);
    }

    public static void addPlace (String title,String description, double longitude, double latitude)
    {
        Place place = new Place(title,description,longitude,latitude);
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
