package firstPack.DTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Stas on 27.06.2015.
 */
@Component
public class ContactDTO {
    String firstName;
    String lastName;
    LocalDate birthday;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
