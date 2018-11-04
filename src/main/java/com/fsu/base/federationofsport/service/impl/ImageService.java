package com.fsu.base.federationofsport.service.impl;

import com.fsu.base.federationofsport.dao.ImagesDao;
import com.fsu.base.federationofsport.model.Image;
import com.fsu.base.federationofsport.service.IImageService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {

    private ImagesDao imagesDao;
    private StorageService storageService;

    @Autowired
    public ImageService(ImagesDao imagesDao, StorageService storageService) {
        this.imagesDao = imagesDao;
        this.storageService = storageService;
    }

    @Override
    public Iterable<Image> getAll() {
        return imagesDao.findAll();
    }

    @Override
    public Image get(long id) {
        return imagesDao.findOne(id);
    }

    @Override
    public Image add(Image image) {
        String fileName =  storageService.store(image.getImageBase64());
        image.setFileName(fileName);
        image.setTimestamp(System.currentTimeMillis());
        image.setImageBase64(null);

        return imagesDao.save(image);
    }

    @Override
    public void delete(long id) {
        imagesDao.delete(id);
    }

}
