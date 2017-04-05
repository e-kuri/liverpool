package mx.com.liverpool.liverpool.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class Record {

    @SerializedName("@class")
    @Expose
    private String clazz;



    @SerializedName("attributes")
    @Expose
    Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
