package com.cn.web;

import com.cn.jpa.entity.Picture;
import com.cn.web.service.PictureService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictureinfo")
public class PictureInfo {
    @Autowired
    private PictureService pictureService;

    @ApiOperation(value = "按排序号升序分页查询全部图片")
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "每页记录数", name = "pagesize"), @ApiImplicitParam(value = "页码", name = "pagenum")})
    @RequestMapping("/findallorderbyordernum/{pagesize}/{pagenum}")
    public Page<Picture> findallorderbyordernum(@PathVariable("pagesize") int pageSize, @PathVariable("pagenum") int pageNum) {
        return pictureService.findAllOrderByOrderNum(pageSize, pageNum);
    }

    @ApiOperation(value = "按创建时间降序分页查询全部图片")
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "每页记录数", name = "pagesize"), @ApiImplicitParam(value = "页码", name = "pagenum")})
    @RequestMapping("/findallorderbycreatetime/{pagesize}/{pagenum}")
    public Page<Picture> findallorderbycreatetime(@PathVariable("pagesize") int pagesize, @PathVariable("pagenum") int pagenum) {
        return pictureService.findAllOrderByCreateTime(pagesize, pagenum);
    }

    @ApiOperation(value = "插入图片")
    @ApiImplicitParam(name = "图片", value = "TUPIAN")
    @RequestMapping("/insert/")
    public Picture save(Picture picture) {
        return pictureService.saveAndFlush(picture);
    }
}
