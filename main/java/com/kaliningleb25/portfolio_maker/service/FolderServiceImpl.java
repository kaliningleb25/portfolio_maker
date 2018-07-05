package com.kaliningleb25.portfolio_maker.service;

import com.kaliningleb25.portfolio_maker.dao.FolderRepository;
import com.kaliningleb25.portfolio_maker.entity.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {
    @Autowired
    FolderRepository folderRepository;

    @Override
    public List<Folder> findFolders(String userNickname) {
        return folderRepository.findFoldersByUserNickname(userNickname);
    }

    @Override
    public Folder findFolder(Long id) {
        return folderRepository.getOne(id);
    }


}
