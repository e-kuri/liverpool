package mx.com.liverpool.liverpool.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class Item {

    @SerializedName("sku.smallImage")
    @Expose
    private String thumbnail;

    @SerializedName("product.displayName")
    @Expose
    private String title;

    @SerializedName("common.id")
    @Expose
    private String location;

    @SerializedName("sku.list_Price")
    @Expose
    private String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String  price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
