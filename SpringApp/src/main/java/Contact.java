import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
public class Contact
{
    String firstName;
    String lastName;
    LocalDate birthDate;
    Set<Hobby> hobbies;
    List<Place> places;
    Set<Contact> friends;

    public Contact (String firstName,String lastName,LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
