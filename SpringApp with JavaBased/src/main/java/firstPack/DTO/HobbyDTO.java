package firstPack.DTO;

import org.springframework.stereotype.Component;

/**
 * Created by Stas on 27.06.2015.
 */


public class HobbyDTO {
    private String title;
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
}
