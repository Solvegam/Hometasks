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

    public void addFriendship (ContactDTO firstContactDTO, ContactDTO secondContactDTO)
    {
        Contact firstContact = null;
        Contact secondContact = null;

        for(Contact contact: contactList)
        {
            if(contact.getFirstName().equals(firstContactDTO.getFirstName())&&contact.getLastName().equals(firstContactDTO.getLastName()))
            {
                firstContact = contact;
            }

            if(contact.getFirstName().equals(secondContactDTO.getFirstName())&&contact.getLastName().equals(secondContactDTO.getLastName()))
            {
                secondContact = contact;
            }
        }

        //проверка на наличие друга в списке друзей. Если такой друг уже есть, то его не добавляем
        for(Contact contact: firstContact.friends)
        {
            if(contact.equals(secondContact))
            {
                System.out.println("There is such friend in " + firstContact.getFirstName() + "'s " + "friendlist");
            }
            else
            {
                firstContact.friends.add(secondContact);
                System.out.println(secondContact.getFirstName() + " was added to the freindlist of " + firstContact.getFirstName());
            }
        }

        for(Contact contact: secondContact.friends)
        {
            if(contact.equals(firstContact))
            {
                System.out.println("There is such friend in " + secondContact.getFirstName() + "'s " + "friendlist");
            }
            else
            {
                secondContact.friends.add(firstContact);
                System.out.println(firstContact.getFirstName() + " was added to the freindlist of " + secondContact.getFirstName());
            }
        }


    }

    public void removeFriendShip (Contact firstPerson,Contact secondPerson)
    {

    }
}
