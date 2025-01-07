package com.example.ccsd.WebsiteTexts;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "websitetexts")
public class WebsiteTexts {
    private String id;
    private String texts;
    private String content;
    private String title;

    // Getter for the ID
    public String getId() {
        return id;
    }

    // Setter for the ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter for the texts
    public String getText() {
        return texts;
    }

    // Setter for the texts
    public void setText(Object text) {
        this.texts = (String) text;
    }

    // Getter for the title
    public String getTitle() {
        return title;
    }

    // Setter for the title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the content
    public String getContent() {
        return content;
    }

    // Setter for the content
    public void setContent(String content) {
        this.content = content;
    }
}


