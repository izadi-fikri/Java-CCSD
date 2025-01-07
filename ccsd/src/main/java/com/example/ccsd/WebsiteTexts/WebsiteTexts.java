package com.example.ccsd.WebsiteTexts;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "websitetexts")
public class WebsiteTexts {
    private String id;
    private String postShortDescription;
    private String status;
    private String tag;
    private String title;

    public String getId() {
        return id;
    }

    // Setter for the ID
    public void setId(String id) {
        this.id = id;
    }
    
    public String getPostShortDescription() {
        return postShortDescription;
    }
    
    public void setPostShortDescription(String postShortDescription) {
        this.postShortDescription = postShortDescription;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }


}




