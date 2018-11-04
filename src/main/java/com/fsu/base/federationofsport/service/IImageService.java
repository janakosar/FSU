package com.fsu.base.federationofsport.service;

import com.fsu.base.federationofsport.model.Image;

public interface IImageService {

    Iterable<Image> getAll();

    Image get(long id);

    Image add(Image imageBase64);

    void delete(long id);
}
