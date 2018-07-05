package com.kaliningleb25.portfolio_maker.dao;

import com.kaliningleb25.portfolio_maker.entity.Picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    @Query("SELECT u FROM Picture u WHERE u.folderId = ?1")
    List<Picture> findPictureByFolderId(Long folderId); // TODO: сделать правильное отношение таблиц (чтобы они соединялись не по folderId)


}
