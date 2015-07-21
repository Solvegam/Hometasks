package firstPack.DAO;

import firstPack.DTO.ContactDTO;
import firstPack.JavaContactService;
import firstPack.rootClasses.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.management.Query;
import javax.transaction.Transactional;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by Stas on 17.06.2015.
 */
@Component
public class ContactDao {

    @Autowired
    public SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Set<Contact> contactList = new HashSet<Contact>();


    public void addContact (ContactDTO contactDTO)
    {
        Contact contact = new Contact();
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setBirthDate(contactDTO.getBirthday());
        contactList.add(contact);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(contact);
        tx.commit();
    }

    @Test
    public void testAddContact () throws NoSuchFieldException, IllegalAccessException
    {

        ContactDao cd = new ContactDao();

        ContactDTO cdto = new ContactDTO();
        cdto.setFirstName("John");
        cdto.setLastName("McClane");
        cdto.setBirthday(LocalDate.parse("1960-01-01"));


        cd.addContact(cdto);
        Contact contact = new Contact();

        contact.setFirstName("John");
        contact.setLastName("McClane");
        contact.setBirthDate(LocalDate.parse("1960-01-01"));
        contact.friends = null;
        contact.places = null;
        contact.hobbies = null;

        assertTrue(cd.getContactList().contains(contact));

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

    public Set<Contact> getContactList() {
        return contactList;
    }
}
