package firstPack.DAO;

import firstPack.DTO.ContactDTO;
import firstPack.rootClasses.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;

/**
 * Created by Stas on 17.06.2015.
 */

@Repository
public class ContactDao {

    @Autowired
    SessionFactory sessionFactory;

    private Set<Contact> contactList = new HashSet<Contact>();

    public void addContact (ContactDTO contactDTO)
    {
        Contact contact = new Contact();
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setBirthDate(contactDTO.getBirthday());
        contactList.add(contact);
        Session session = sessionFactory.openSession();
        session.save(contact);
        session.close();
    }

    public void deleteContact (ContactDTO contactDTO)
    {
        Contact contactToDelete = null;

        for(Contact contact: contactList)
        {
            if (contact.getFirstName().equals(contactDTO.getFirstName())&&contact.getLastName().equals(contactDTO.getLastName()))
            {
                contactToDelete = contact;
                System.out.println("yes");
            }
        }
        System.out.println(contactToDelete.getFirstName());
        Session session = sessionFactory.openSession();
        session.delete(contactToDelete);
    }

    public void addFriendship (ContactDTO firstContactDTO, ContactDTO secondContactDTO) {
        Contact firstContact = null;
        Contact secondContact = null;

        for (Contact contact : contactList) {
            if (contact.getFirstName().equals(firstContactDTO.getFirstName()) && contact.getLastName().equals(firstContactDTO.getLastName())) {
                firstContact = contact;
            }

            if (contact.getFirstName().equals(secondContactDTO.getFirstName()) && contact.getLastName().equals(secondContactDTO.getLastName())) {
                secondContact = contact;
            }
        }


        if (firstContact.getFriends().size() == 0 || !(firstContact.getFriends().contains(secondContact))) {

            firstContact.getFriends().add(secondContact);
            System.out.println(secondContact.getFirstName() + " was added to the freindlist of " + firstContact.getFirstName());
        }
        else
        {
            System.out.println("There is such friend in " + firstContact.getFirstName() + "'s " + "friendlist");
        }

        if (secondContact.getFriends().size() == 0 || !(secondContact.getFriends().contains(firstContact))) {

            secondContact.getFriends().add(firstContact);
            System.out.println(firstContact.getFirstName() + " was added to the freindlist of " + secondContact.getFirstName());
        }
        else
        {
            System.out.println("There is such friend in " + secondContact.getFirstName() + "'s " + "friendlist");
        }
        System.out.println(firstContact.getFriends().contains(secondContact));
        System.out.println(secondContact.getFriends().contains(firstContact));

            Session session = sessionFactory.openSession();
            session.saveOrUpdate(firstContact);
            session.saveOrUpdate(secondContact);
            session.close();
    }

    public Set<Contact> getContactList() {
        return contactList;
    }

    @Test
    public void testAddFriendship ()
    {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstName("John");
        contactDTO.setLastName("McLane");
        contactDTO.setBirthday(LocalDate.parse("1960-01-01"));
        this.addContact(contactDTO);

        contactDTO.setFirstName("Homer");
        contactDTO.setLastName("Simpson");
        contactDTO.setBirthday(LocalDate.parse("1980-12-12"));
        this.addContact(contactDTO);

        ContactDTO firstContactDTO = new ContactDTO();
        firstContactDTO.setFirstName("John");
        firstContactDTO.setLastName("McLane");

        ContactDTO secondContactDTO = new ContactDTO();
        secondContactDTO.setFirstName("Homer");
        secondContactDTO.setLastName("Simpson");
        this.addFriendship(firstContactDTO, secondContactDTO);

        for (Contact contact: contactList)
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

    public void removeFriendShip (Contact firstPerson,Contact secondPerson)
    {

    }
}
