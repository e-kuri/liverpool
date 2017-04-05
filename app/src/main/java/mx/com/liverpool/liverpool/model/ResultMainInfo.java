package mx.com.liverpool.liverpool.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class ResultMainInfo {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("metaKeywords")
    @Expose
    private String metaKywords;

    @SerializedName("metaDescription")
    @Expose
    private String metaDescription;

    @SerializedName("mainContent")
    @Expose
    private List<MainContent> mainContent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaKywords() {
        return metaKywords;
    }

    public void setMetaKywords(String metaKywords) {
        this.metaKywords = metaKywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public List<MainContent> getMainContent() {
        return mainContent;
    }

    public void setMainContent(List<MainContent> mainContent) {
        this.mainContent = mainContent;
    }
}
