/**
 * Created by Stas on 17.06.2015.
 */
public class Place {
    String title;
    double longtitude;
    double latitude;
    String description;

    public Place(String title,String description, double longtitude, double latitude) {
        this.title = title;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.description = description;
    }
}
