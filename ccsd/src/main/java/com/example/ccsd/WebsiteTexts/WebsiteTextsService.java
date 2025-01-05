package com.example.ccsd.WebsiteTexts;

import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteTextsService {
    @Autowired
    private WebsiteTextsRepository websiteTextsRepository;

    @Autowired
    private com.example.ccsd.Users.usersRepository usersRepository; // This doesn't seem to be used here, but it's fine if it's needed elsewhere.

    // Adds new WebsiteText
    public WebsiteTexts addText(WebsiteTexts websiteTexts) {
        return websiteTextsRepository.save(websiteTexts);
    }

    // Updates an existing WebsiteText
    public WebsiteTexts updateText(String id, WebsiteTexts textDetails) {
        return websiteTextsRepository.findById(id)
                .map(websiteTexts -> {
                    websiteTexts.setText(textDetails.getText());  // Updating text
                    websiteTextsRepository.save(websiteTexts);
                    return websiteTextsRepository.save(websiteTexts); // Save the updated text
                })
                .orElse(null); // If the text is not found, return null
    }

    // Deletes a WebsiteText by ID
    public void deleteText(String id) {
        websiteTextsRepository.deleteById(id);
    }

    // Returns a list of all WebsiteTexts
    public List<WebsiteTexts> getAllText() {
        return websiteTextsRepository.findAll();
    }

    // Fetches a WebsiteText by its ID
    public Optional<WebsiteTexts> getTextById(String id) {
        return websiteTextsRepository.findById(id);  // Here, you should return the text found by its ID
    }
}

