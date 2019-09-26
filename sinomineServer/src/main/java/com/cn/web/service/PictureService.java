package com.cn.web.service;

import com.cn.jpa.dao.PictureDao;
import com.cn.jpa.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    @Autowired
    private PictureDao pictureDao;

    public Picture save(Picture picture) {
        return pictureDao.save(picture);
    }

    public Page<Picture> findAll(int pageSize, int pageNum) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return pictureDao.findAll(pageRequest);
    }
}
