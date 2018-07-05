package com.kaliningleb25.portfolio_maker.service;

import com.kaliningleb25.portfolio_maker.entity.Folder;

import java.util.List;

public interface FolderService {
    List<Folder> findFolders(String userNickname);

    Folder findFolder(Long id);
}
