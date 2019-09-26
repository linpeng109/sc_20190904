package com.cn.web;

import com.cn.jpa.entity.Picture;
import com.cn.web.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictureinfo")
public class PictureInfo {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/insert/")
    public Picture save(Picture picture) {
        return pictureService.save(picture);
    }
}
