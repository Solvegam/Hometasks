package firstPack.Test;

import firstPack.DAO.HobbyDao;
import firstPack.DTO.ContactDTO;
import firstPack.DTO.HobbyDTO;
import firstPack.JavaContactService;
import firstPack.rootClasses.Hobby;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;


import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by Stas on 05.07.2015.
 */
public class HobbyTest extends MockitoJUnit{

    @Test
    public void addingHobbyTest () throws NoSuchFieldException, IllegalAccessException {


        HobbyDao hobbyDao = new HobbyDao();

        HobbyDTO hobbyDTO = new HobbyDTO();
        hobbyDTO.setTitle("Saving the world");
        hobbyDTO.setDescription("It is the most meaningful activity");

        hobbyDao.addHobby(hobbyDTO);

//        JavaContactService service = new JavaContactService();
//
//        Class serviceReflect = service.getClass();
//        Field hobbyDAO = serviceReflect.getDeclaredField("contactDao");
//        hobbyDAO.set(service,hobbyDao);
//
//        HobbyDTO hobbyDTO = new HobbyDTO();
//        hobbyDTO.setTitle("Saving the world");
//        hobbyDTO.setDescription("It is the most meaningful activity");
//
//        service.addHobby("Saving the world", "It is the most meaningful activity");
//
//        Class hobby = hobbyDao.getClass();
//        Field hobbies = hobby.getDeclaredField("hobbyList");
//        HashSet<Hobby> list = (HashSet<Hobby>)hobbies.get(hobbyDao);
//
//        assertTrue(list.contains(hobbyDTO));
    }
}
