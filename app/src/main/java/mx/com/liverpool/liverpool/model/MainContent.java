package mx.com.liverpool.liverpool.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class MainContent {

    @SerializedName("contents")
    @Expose
    List<Object> contents;

    public List<Object> getContents() {
        return contents;
    }

    public void setContents(List<Object> contents) {
        this.contents = contents;
    }
}
