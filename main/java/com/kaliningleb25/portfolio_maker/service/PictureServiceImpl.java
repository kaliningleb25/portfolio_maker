package com.kaliningleb25.portfolio_maker.service;

import com.kaliningleb25.portfolio_maker.dao.PictureRepository;
import com.kaliningleb25.portfolio_maker.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public Picture findPicture(Long id) {
        return pictureRepository.getOne(id);
    }

    @Override
    public List<Picture> findPictures(Long folderId) {
        return pictureRepository.findPictureByFolderId(folderId);
    }
}
