package com.example.ccsd.WebsiteImages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;


@Service
public class WebsiteImagesService {


    @Autowired
    private WebsiteImagesRepository websiteImagesRepository;


    public List<WebsiteImages> getAllWebsiteImageses() {
        return websiteImagesRepository.findAll();
    }

    public Optional<WebsiteImages> getWebsiteImagesById(String id) {
        return websiteImagesRepository.findById(id);
    }

    public WebsiteImages addWebsiteImages(WebsiteImages websiteImages) {
        return websiteImagesRepository.save(websiteImages);
    }

    public WebsiteImages updateWebsiteImages(String id, WebsiteImages websiteImagesDetails) {
        if (websiteImagesRepository.existsById(id)) {
            websiteImagesDetails.setId(id);
            return websiteImagesRepository.save(websiteImagesDetails);
        } else {
            return null;
        }
    }

    public void deleteWebsiteImages(String id) {
        websiteImagesRepository.deleteById(id);
    }
}