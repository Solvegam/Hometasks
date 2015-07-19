package firstPack.Test;

import firstPack.DAO.ContactDao;
import firstPack.JavaContactService;
import firstPack.rootClasses.Contact;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Stas on 04.07.2015.
 */
public class ContactTests
{
    ApplicationContext context = new ClassPathXmlApplicationContext("context-Application.xml");

    JavaContactService service = context.getBean(JavaContactService.class);

    @Ignore
    @Test
    public void testCreatingContact () throws NoSuchFieldException, IllegalAccessException
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("context-Application.xml");

        JavaContactService service = context.getBean(JavaContactService.class);
        service.createContact("John","McClane",LocalDate.parse("1960-01-01"));

        Contact contactForTesting = new Contact();
        contactForTesting.setFirstName("John");
        contactForTesting.setLastName("McClane");
        contactForTesting.setBirthDate(LocalDate.parse("1960-01-01"));
        Set <Contact> contactList = service.getContactDao().getContactList();
        assertTrue(contactList.contains(contactForTesting));
    }

}
