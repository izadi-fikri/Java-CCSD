package com.example.ccsd.WebsiteTexts;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "websitetexts")
public class WebsiteTexts {
    private String id;
    private String texts;
    private String content;
    private String title;

    public String getId() {
        return id;
    }

    // Setter for the ID
    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return texts;
    }
    public void setText(Object text) {
        this.texts = (String) text; }

    public String getTitle() {
        return title;
    }
    public void setContent(String content)
    {
        this.content = content;

    }
}




