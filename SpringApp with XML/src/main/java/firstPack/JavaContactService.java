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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


/**
 * Created by Stas on 17.06.2015.
 */

public class JavaContactService {


    private ContactDao contactDao;

    private HobbyDao hobbyDao;

    private PlaceDao placeDao;

    private MessageDao messageDao;

    public void createContact(String firstName, String lastName, LocalDate birthDate)
    {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName(firstName);
        contactDTO.setLastName(lastName);
        contactDTO.setBirthday(birthDate);
        contactDao.addContact(contactDTO);
    }

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

    public  void addFriendship (String firstFriendFirstName,String firstFriendLastName,String secondFriendFirstName,String secondFriendLastName)
    {
        ContactDTO firstContactDTO = new ContactDTO();
        firstContactDTO.setFirstName(firstFriendFirstName);
        firstContactDTO.setLastName(firstFriendLastName);

        ContactDTO secondContactDTO = new ContactDTO();
        secondContactDTO.setFirstName(secondFriendFirstName);
        secondContactDTO.setLastName(secondFriendLastName);
        contactDao.addFriendship(firstContactDTO,secondContactDTO);
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

    //    public Set<Contact> getFriendList (Contact person)
//    {
//
//    }
//
//    public List<Message> Conversation (Contact firstContact,Contact secondContact)
//    {
//
//    }


}
