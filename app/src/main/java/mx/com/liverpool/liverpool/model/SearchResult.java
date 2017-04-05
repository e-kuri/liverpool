package mx.com.liverpool.liverpool.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class SearchResult {

    @SerializedName("contents")
    @Expose
    List<ResultMainInfo> contents;

    public List<ResultMainInfo> getContents() {
        return contents;
    }

    public void setContents(List<ResultMainInfo> contents) {
        this.contents = contents;
    }
}
