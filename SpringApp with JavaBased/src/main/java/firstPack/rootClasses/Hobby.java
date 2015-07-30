package firstPack.rootClasses;

import javax.persistence.*;

/**
 * Created by Stas on 17.06.2015.
 */
@Entity
@Table (name ="HOBBIES")
public class Hobby {
    @Id
    @GeneratedValue
    private int id;

    @Column (name = "hobby_title")
    private String title;
    @Column (name = "hobby_description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobby hobby = (Hobby) o;

        if (!getTitle().equals(hobby.getTitle())) return false;
        return getDescription().equals(hobby.getDescription());

    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
