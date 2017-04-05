package mx.com.liverpool.liverpool.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class MainContentContents {

    @SerializedName("records")
    @Expose
    List<Object> records;

    public List<Object> getRecords() {
        return records;
    }

    public void setRecords(List<Object> records) {
        this.records = records;
    }
}
