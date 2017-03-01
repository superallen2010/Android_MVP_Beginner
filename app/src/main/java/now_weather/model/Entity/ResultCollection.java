package now_weather.model.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Allen on 2017/3/1.
 */

public class ResultCollection<T extends Parcelable> implements Parcelable {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("results")
    private List<T> results;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.message);
        if (results == null || results.size() == 0) {
            dest.writeInt(0);
        } else {
            dest.writeInt(results.size());
            Class<?> type = results.get(0).getClass();
            dest.writeSerializable(type);
            dest.writeList(this.results);
        }


    }

    public ResultCollection() {
    }

    protected ResultCollection(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        int size = in.readInt();
        if (size == 0) {
            this.results = null;
        } else {
            Class<?> type = (Class<?>) in.readSerializable();
            this.results = in.readArrayList(type.getClassLoader());
        }
    }

    public static final Creator<ResultCollection> CREATOR = new Creator<ResultCollection>() {
        @Override
        public ResultCollection createFromParcel(Parcel source) {
            return new ResultCollection(source);
        }

        @Override
        public ResultCollection[] newArray(int size) {
            return new ResultCollection[size];
        }
    };

    @Override
    public String toString() {
        return "ResultCollection{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", results=" + results +
                '}';
    }
}
