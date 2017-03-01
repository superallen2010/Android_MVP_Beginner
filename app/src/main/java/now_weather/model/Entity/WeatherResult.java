package now_weather.model.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Allen on 2017/3/1.
 */

public class WeatherResult implements Parcelable {

    @SerializedName("location")
    private Location location;
    @SerializedName("now")
    private NowWeather nowWeather;
    @SerializedName("last_update")
    private String last_update;


    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public NowWeather getNowWeather() {
        return nowWeather;
    }

    public void setNowWeather(NowWeather nowWeather) {
        this.nowWeather = nowWeather;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.location, flags);
        dest.writeParcelable(this.nowWeather, flags);
        dest.writeString(this.last_update);
    }

    public WeatherResult() {
    }

    protected WeatherResult(Parcel in) {
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.nowWeather = in.readParcelable(NowWeather.class.getClassLoader());
        this.last_update = in.readString();
    }

    public static final Parcelable.Creator<WeatherResult> CREATOR = new Parcelable.Creator<WeatherResult>() {
        @Override
        public WeatherResult createFromParcel(Parcel source) {
            return new WeatherResult(source);
        }

        @Override
        public WeatherResult[] newArray(int size) {
            return new WeatherResult[size];
        }
    };

    @Override
    public String toString() {
        return "WeatherResult{" +
                "last_update='" + last_update + '\'' +
                ", location=" + location +
                ", nowWeather=" + nowWeather +
                '}';
    }
}
