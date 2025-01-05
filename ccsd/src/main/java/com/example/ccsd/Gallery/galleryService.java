package com.example.ccsd.Gallery;

import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; //added


@Service
public class galleryService {

    @Autowired
    private galleryRepository GalleryRepository;

    //Delete a gallery
    public void deletegallery(String id) {
        GalleryRepository.deleteById(id);

    }

    public gallery updategallery(String id, gallery galleryDetails) {
        return GalleryRepository.findById(id)
                .map(existingGallery -> {
                    existingGallery.setTitle(galleryDetails.getTitle());
                    existingGallery.setPostSlug(galleryDetails.getPostSlug());
                    existingGallery.setpostShortDescription(galleryDetails.getpostShortDescription());
                    existingGallery.setTag(galleryDetails.getTag());
                    existingGallery.setPlace(galleryDetails.getPlace());
                    existingGallery.setDate(galleryDetails.getDate());
                    existingGallery.setStatus(galleryDetails.getStatus());
                    existingGallery.setimage(galleryDetails.getimage());
                    existingGallery.setContent(galleryDetails.getContent());
                    return GalleryRepository.save(existingGallery);
                }).orElse(null);
    }

    public gallery addGallery(gallery Gallery) {
        return GalleryRepository.save(Gallery);
    }

    public List<gallery> getAllGallerys() {

        return GalleryRepository.findAll();
        /**
         * paramm to call gallery*/
    }

    public Optional<gallery> getGalleryById(String id) {
        return GalleryRepository.findById(id);
    }
}
