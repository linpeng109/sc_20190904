package com.cn.web;

import com.cn.jpa.entity.Authority;
import com.cn.jpa.entity.UserBase;
import com.cn.web.service.AuthorityService;
import com.cn.web.service.UserBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/userbaseinfo")
@Api(value = "用户controller", tags = {"用户操作接口"})
public class UserBaseInfo {
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/init")
    @ApiIgnore
    public String init() {
        List<String> authorityStringList = new ArrayList<String>();
        authorityStringList.add("ROLE_ADMIN");
        authorityStringList.add("ROLE_USER");
        authorityStringList.add("ROLE_GUEST");
        for (int i = 0; i < 3; ++i) {
            Authority authority = new Authority();
            authority.authorityName = authorityStringList.get(i);
            authority.authorityDescript = authorityStringList.get(i);
            authorityService.save(authority);
        }
        UserBase abcd = new UserBase();
        abcd.username = "abcd";
        abcd.password = "abcd";
        abcd.authoritys = authorityService.findAll();
        userBaseService.save(abcd);
        return "Success";
    }

    @RequestMapping("/insert/{num}")
    @ApiIgnore
    public String insert(@PathVariable(name = "num") int num) {
        List<Authority> authorities = authorityService.findAll();
        int size = authorities.size();
        for (int i = 0; i < num; ++i) {
            UserBase user = new UserBase();
            user.username = UUID.randomUUID().toString().substring(24, 32);
            user.password = UUID.randomUUID().toString().substring(24, 32);
            int j = new Random().nextInt(size);
            user.authoritys.add(authorities.get(j));
            userBaseService.save(user);
        }
        return "success";
    }

    @RequestMapping(value = "/findall")
    @ApiOperation(value = "查询全部", httpMethod = "GET")
    public Iterable<UserBase> findAll() {
        return userBaseService.findAll();
    }

    @RequestMapping(value = "/findallbypage/{pagesize}/{pagenum}")
    @ApiOperation(value = "分页查询全部", notes = "分页查询全部数据")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "pagesize", value = "页面容量"), @ApiImplicitParam(name = "pagenum", value = "页面号码")})
    public Page<UserBase> findAllByPage(@PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        System.out.print("pagenum=" + pagenum);
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize);
        return userBaseService.findAllByPage(pageRequest);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long count() {
        return userBaseService.count();
    }

    @RequestMapping(value = "/findallorderbyusername/{pagesize}/{pagenum}", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询全部并按照username升序排列", notes = "分页查询全部并按照username升序排列")
    public Page<UserBase> findAllOrderByUsername(@PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize, Sort.Direction.ASC, "username");
        return userBaseService.findAllByPage(pageRequest);
    }

    @RequestMapping(value = "/findbyusernameorderbyusername/{username}/{pagesize}/{pagenum}", method = RequestMethod.GET)
    @ApiOperation(value = "根据username特征字符分页查询全部并按照username升序排列", notes = "根据username特征字符分页查询全部并按照username升序排列")
    public Page<UserBase> findByUsername(@PathVariable(name = "username") String username, @PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize, Sort.Direction.ASC, "username");

        return userBaseService.findByUsername(username, pageRequest);
    }

    @RequestMapping(value = "/findbyusernamelikeandenableistrue", method = RequestMethod.GET)
    public Page<UserBase> findByUsernameLikeAndEnableIsTrue(@PathVariable(name = "username") String username, @PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize, Sort.Direction.ASC, "username");
        return userBaseService.findByUsernameLikeAndAndEnableIsTrue(username, pageRequest);
    }

}
