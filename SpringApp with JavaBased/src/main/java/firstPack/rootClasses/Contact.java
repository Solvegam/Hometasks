package firstPack.rootClasses;


import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
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
    private Date birthDate;

    @ManyToMany
    @JoinTable(name = "hobbies")
    private Set<Hobby> hobbies;

    @Transient
    private List<Place> places;

    @ManyToMany
    @JoinTable(name = "friends")
    private Set<Contact> friends;

    public Contact ()
    {
        super();
    }

    public Set<Contact> getFriends() {
        if (friends == null)
        {
            friends = new HashSet<Contact>();
        }
        return friends;
    }

    public void setFriends(HashSet<Contact> friends) {
        this.friends = friends;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
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

        LocalDate birthDate = this.birthDate.toLocalDate();
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = Date.valueOf(birthDate);
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
