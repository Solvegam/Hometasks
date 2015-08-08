package firstPack.DAO;

import firstPack.DTO.HobbyDTO;
import firstPack.rootClasses.Contact;
import firstPack.rootClasses.Hobby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

/**
 * Created by Stas on 17.06.2015.
 */
@Component
public class HobbyDao {

    @Autowired
    public SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Set<Hobby> hobbyList = new HashSet<Hobby>();

    public void addHobby(HobbyDTO hobbyDTO)
    {
        Hobby hobby = new Hobby();
        hobby.setTitle(hobbyDTO.getTitle());
        hobby.setDescription(hobbyDTO.getDescription());
        hobbyList.add(hobby);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(hobby);
        tx.commit();
    }

    @Test
    public void testAddHobby (){
        HobbyDTO hobbyDTO = new HobbyDTO();
        String description = "Saving the world is one of the most interesting";
        String title = "Saving the world";
        hobbyDTO.setDescription(description);
        hobbyDTO.setTitle(title);
        HobbyDao hd = new HobbyDao();
        hd.addHobby(hobbyDTO);

        Hobby hobby = new Hobby();
        hobby.setDescription(description);
        hobby.setTitle(title);

        Assert.assertTrue(hd.hobbyList.contains(hobby));
    }

//    public Set<Contact> getAllContactsWithHobby (Hobby hobby)
//    {
//        return
//    }
}
