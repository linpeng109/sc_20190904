package com.cn.web;

import com.cn.jpa.entity.News;
import com.cn.web.service.NewsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsinfo")
public class NewsInfo {
    @Autowired
    private NewsService newsService;

    @ApiOperation(value = "按排序号升序分页查询全部新闻")
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "每页记录数", name = "pagesize"), @ApiImplicitParam(value = "页码", name = "pagenum")})
    @RequestMapping("/findallorderbyordernum/{pagesize}/{pagenum}")
    public Page<News> findallorderbyordernum(@PathVariable("pagesize") int pageSize, @PathVariable("pagenum") int pageNum) {
        return newsService.findAllOrderByOrderNum(pageSize, pageNum);
    }

    @ApiOperation(value = "按创建时间降序分页查询全部新闻")
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "每页记录数", name = "pagesize"), @ApiImplicitParam(value = "页码", name = "pagenum")})
    @RequestMapping("/findallorderbycreatetime/{pagesize}/{pagenum}")
    public Page<News> findallorderbycreatetime(@PathVariable("pagesize") int pagesize, @PathVariable("pagenum") int pagenum) {
        return newsService.findAllOrderByCreateTime(pagesize, pagenum);
    }

    @ApiOperation(value = "插入或更新指定新闻")
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "news", name = "news")})
    @RequestMapping("/saveandflush/{news}")
    public News saveAndFlush(News news){
        return newsService.saveAndFlush(news);
    }

}
