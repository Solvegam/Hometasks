package firstPack.DAO;

import firstPack.DTO.HobbyDTO;
import firstPack.rootClasses.Contact;
import firstPack.rootClasses.Hobby;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
@Component
public class HobbyDao {

    private Set<Hobby> hobbyList = new HashSet<Hobby>();

    public void addHobby(HobbyDTO hobbyDTO)
    {
        Hobby hobby = new Hobby();
        hobby.setTitle(hobbyDTO.getTitle());
        hobby.setDescription(hobbyDTO.getDescription());
        hobbyList.add(hobby);
    }

//    public Set<Contact> getAllContactsWithHobby (Hobby hobby)
//    {
//        return
//    }
}
