package now_weather.model.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Allen on 2017/3/1.
 */

public class NowWeather implements Parcelable {

    @SerializedName("text")
    private String text;

    @SerializedName("code")
    private String code;

    @SerializedName("temperature")
    private String temperature;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeString(this.code);
        dest.writeString(this.temperature);
    }

    public NowWeather() {
    }

    protected NowWeather(Parcel in) {
        this.text = in.readString();
        this.code = in.readString();
        this.temperature = in.readString();
    }

    public static final Parcelable.Creator<NowWeather> CREATOR = new Parcelable.Creator<NowWeather>() {
        @Override
        public NowWeather createFromParcel(Parcel source) {
            return new NowWeather(source);
        }

        @Override
        public NowWeather[] newArray(int size) {
            return new NowWeather[size];
        }
    };


    @Override
    public String toString() {
        return "NowWeather{" +
                "code='" + code + '\'' +
                ", text='" + text + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
