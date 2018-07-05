package com.kaliningleb25.portfolio_maker.service;

import com.kaliningleb25.portfolio_maker.entity.Picture;

import java.util.List;

public interface PictureService {
    Picture findPicture(Long id);

    List<Picture> findPictures(Long folderId);
}
