package mx.com.liverpool.liverpool.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class ItemSearchResponse {

    @SerializedName("contents")
    @Expose
    List<ResultMainInfo> generalInfo;

    @SerializedName("contents")
    @Expose
    List<Item> items = null;

    public List<Item> getItems(){
        return items;
    }
}
