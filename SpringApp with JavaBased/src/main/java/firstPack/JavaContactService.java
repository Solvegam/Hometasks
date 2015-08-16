package firstPack;

import firstPack.DAO.ContactDao;
import firstPack.DAO.HobbyDao;
import firstPack.DAO.MessageDao;
import firstPack.DAO.PlaceDao;
import firstPack.DTO.ContactDTO;
import firstPack.DTO.HobbyDTO;
import firstPack.DTO.MessageDTO;
import firstPack.DTO.PlaceDTO;
import firstPack.rootClasses.Contact;
import firstPack.rootClasses.Hobby;
import firstPack.rootClasses.Message;
import firstPack.rootClasses.Place;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Stas on 17.06.2015.
 */
@Repository
public class JavaContactService {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private MessageDao messageDao;

    @Transactional
    public void createContact(String firstName, String lastName, LocalDate birthDate)
    {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName(firstName);
        contactDTO.setLastName(lastName);
        contactDTO.setBirthday(birthDate);
        contactDao.addContact(contactDTO);
    }
    @Transactional
    public void addHobby(String title,String description)
    {
        HobbyDTO hobbyDTO = new HobbyDTO();
        hobbyDTO.setTitle(title);
        hobbyDTO.setDescription(description);
        hobbyDao.addHobby(hobbyDTO);
    }

    public void addPlace (String title,String description, double longitude, double latitude)
    {
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setTitle(title);
        placeDTO.setDescription(description);
        placeDTO.setLongtitude(longitude);
        placeDTO.setLatitude(latitude);
        placeDao.addPlace(placeDTO);
    }

    @Transactional
    public  void addFriendship (String firstFriendFirstName,String firstFriendLastName,String secondFriendFirstName,String secondFriendLastName)
    {
        ContactDTO firstContactDTO = new ContactDTO();
        firstContactDTO.setFirstName(firstFriendFirstName);
        firstContactDTO.setLastName(firstFriendLastName);

        ContactDTO secondContactDTO = new ContactDTO();
        secondContactDTO.setFirstName(secondFriendFirstName);
        secondContactDTO.setLastName(secondFriendLastName);
        contactDao.addFriendship(firstContactDTO, secondContactDTO);

        System.out.println("Friendship was added");
    }

    @Test
    public void testAddFriendship ()
    {
        createContact("John", "McLane", LocalDate.parse("1960-01-01"));
        createContact("Homer", "Simpson", LocalDate.parse("1980-12-12"));
        addFriendship("John", "McLane", "Homer", "Simpson");

        for (Contact contact: contactDao.getContactList())
        {
            if(contact.getFirstName().equals("John")&&contact.getFirstName().equals("McLane"))
            {
                for(Contact contact2: contact.getFriends())
                {
                    System.out.println(contact2.getFirstName());
                }
            }
        }
    }

    @Transactional
    public void deleteContact (String contactID)
    {
        contactDao.deleteContact(contactID);
    }
    @Transactional
    public void addHobbyToContact (String name, String lastName)
    {

        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName(name);
        contactDTO.setLastName(lastName);

        System.out.println("Choose correct hobby for this person from the list below");
        System.out.println("");

        hobbyDao.getAllHobbies();

//        HobbyDTO hobbyDTO = new HobbyDTO();
//        hobbyDTO.setTitle(hobbyTitle);
//        hobbyDTO.setDescription(hobbyDescription);
//
//        contactDao.;
    }

    @Transactional
    public Set<Contact> getAllContacs()
    {
//        createContact("John", "McLane", LocalDate.parse("1960-01-01"));

        Set<Contact> allContacs = contactDao.getContactList();

        return allContacs;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }



//    @Transactional
//        public Set<Contact> getFriendList (ContactDTO person)
//    {
//
//    }

//    public List<Message> Conversation (Contact firstContact,Contact secondContact)
//    {
//
//    }


}
