package com.example.ccsd.Gallery;

import java.util.Base64;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Gallery")
public class gallery {
    @Id
    private String id;
    private String title;
    private String postSlug;
    private String postShortDescription;
    private String tag;
    private String place;
    private String date;
    private String status;
    private String content;
    private byte[] image;
    private  String  image64String;

    //Getter and Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostSlug() {
        return postSlug;
    }
    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public String getpostShortDescription() {
        return postShortDescription;
    }
    public void setpostShortDescription(String postShortDescription) {
        this.postShortDescription = postShortDescription;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getimage() {
        return image;
    }
    public void setimage(byte[] image) {
        this.image = image;
    }

    public String getImageAsBase64(){
        this.image64String= Base64.getEncoder().encodeToString(image);
        return image64String;

    }

    public void setImage64String(String image64String){
        this.image64String = image64String;
    }

}


