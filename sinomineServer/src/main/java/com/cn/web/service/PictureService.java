package com.cn.web.service;

import com.cn.jpa.dao.PictureDao;
import com.cn.jpa.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    @Autowired
    private PictureDao pictureDao;

    public void delete(Picture picture) {
        pictureDao.delete(picture);
    }

    public Picture saveAndFlush(Picture picture) {
        return pictureDao.saveAndFlush(picture);
    }

    public Picture findById(String pictureId) {
        return pictureDao.getOne(pictureId);
    }

    public Page<Picture> findAllOrderByCreateTime(int pagesize, int pagenum) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable= PageRequest.of(pagesize,pagenum,sort);
        return pictureDao.findAll(pageable);
    }
    public Page<Picture> findAllOrderByOrderNum(int pagesize,int pagenum){
        Sort sort=new Sort(Sort.Direction.DESC,"orderNum");
        Pageable pageable=PageRequest.of(pagesize,pagenum,sort);
        return pictureDao.findAll(pageable);
    }

}
