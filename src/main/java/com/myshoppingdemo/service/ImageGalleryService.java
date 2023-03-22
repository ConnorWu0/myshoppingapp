package com.myshoppingdemo.service;


import com.myshoppingdemo.entity.ImageGallery;
import com.myshoppingdemo.repository.ImageGalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageGalleryService {
    @Autowired
    private ImageGalleryRepository imageGalleryRepository;

    public void saveImage(ImageGallery imageGallery) {
        imageGalleryRepository.save(imageGallery);
    }

    public List<ImageGallery> getAllActiveImages() {
        return imageGalleryRepository.findAll();
    }

    public Optional<ImageGallery> getImageId(Long id) {
        return imageGalleryRepository.findById(id);
    }
}
