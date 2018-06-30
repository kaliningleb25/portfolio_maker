package com.kaliningleb25.portfolio_maker.dao;

import com.kaliningleb25.portfolio_maker.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    // Just one for first time
    @Query("SELECT u FROM Folder u WHERE u.userNickname = ?1")
    List<Folder> findFolderByUserNickname(String nickname);
}
