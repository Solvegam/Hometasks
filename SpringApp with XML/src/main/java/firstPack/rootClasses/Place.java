package firstPack.rootClasses;

/**
 * Created by Stas on 17.06.2015.
 */
public class Place {
    String title;
    double longtitude;
    double latitude;
    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
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

        Place place = (Place) o;

        if (Double.compare(place.getLongtitude(), getLongtitude()) != 0) return false;
        if (Double.compare(place.getLatitude(), getLatitude()) != 0) return false;
        if (!getTitle().equals(place.getTitle())) return false;
        return getDescription().equals(place.getDescription());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTitle().hashCode();
        temp = Double.doubleToLongBits(getLongtitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLatitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
