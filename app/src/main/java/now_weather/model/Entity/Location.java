package now_weather.model.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Allen on 2017/3/1.
 */

public class Location implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("path")
    private String path;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("timezone_offset")
    private String timezone_offset;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(String timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.country);
        dest.writeString(this.path);
        dest.writeString(this.timezone);
        dest.writeString(this.timezone_offset);
    }

    public Location() {
    }

    protected Location(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.country = in.readString();
        this.path = in.readString();
        this.timezone = in.readString();
        this.timezone_offset = in.readString();
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };


    @Override
    public String toString() {
        return "Location{" +
                "country='" + country + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", timezone='" + timezone + '\'' +
                ", timezone_offset='" + timezone_offset + '\'' +
                '}';
    }
}
