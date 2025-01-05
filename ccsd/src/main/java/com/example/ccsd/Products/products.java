package com.example.ccsd.Products;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document(collection = "products")
public class products {
    @Id
    private String id;

    @Field(name = "title")
    private String title;

    @Field(name = "shortDescription")
    private String shortDescription;

    @Field(name = "postSlug")
    private String postSlug;

    @Field(name = "tag")
    private String tag;

    @Field(name = "images")
    private List<String> images;

    @Field(name = "place")
    private String place;

    @Field(name = "date")
    private List<String> date;

    @Field(name="status")
    private String status;

    @Field(name="type")
    private String type;

    @Field(name="product64")
    private String product64;

    @Field(name = "imageStore")
    private byte[] imageStore;

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setDescription(String description) {
        this.shortDescription = shortDescription;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setPostShortDescription(String postShortDescription) {
        this.postSlug = postShortDescription;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDateProduct(String date) {
        this.date = Arrays.asList(date.split(","));
    }
    public void setStatus(String status) {
        this.status = status;

    }
    public void setType(String type) {
        this.type = type;
    }

    public void setImageStore(byte[] imageBytes) {
        this.images = new ArrayList<>();
    }

    public String getImageAsBase64() {
        this.product64 = Base64.getEncoder().encodeToString(imageStore);
        return product64;
    }

    public void setImageStore64String(String product64) {
        this.product64 = product64;
    }
}

