package firstPack.rootClasses;


import com.sun.javafx.beans.IDProperty;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 17.06.2015.
 */
@Entity
@Table (name = "Contacts")
public class Contact
{
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "first_Name")
    private String firstName;
    @Column (name = "second_Name")
    private String lastName;
    @Column (name ="birthday")
    private LocalDate birthDate;
    @Transient
    public Set<Hobby> hobbies;
    @Transient
    public List<Place> places;
    @Transient
    public Set<Contact> friends;

    public Contact ()
    {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!firstName.equals(contact.firstName)) return false;
        if (!lastName.equals(contact.lastName)) return false;
        return birthDate.equals(contact.birthDate);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }
}
