package com.cn.jpa.dao;

import com.cn.jpa.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureDao extends JpaRepository<Picture, String> {
}
