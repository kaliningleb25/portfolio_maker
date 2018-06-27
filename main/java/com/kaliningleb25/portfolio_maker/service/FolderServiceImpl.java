package com.kaliningleb25.portfolio_maker.service;

import com.kaliningleb25.portfolio_maker.dao.FolderRepository;
import com.kaliningleb25.portfolio_maker.entity.Folder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FolderServiceImpl implements FolderService {
    @Autowired
    FolderRepository folderRepository;

    @Override
    public Folder findFolders(String userNickname) {

        return folderRepository.findFolderByUserNickname(userNickname);
    }
}
