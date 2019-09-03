package com.cn.web;

import com.cn.jpa.entity.Authority;
import com.cn.jpa.entity.UserBase;
import com.cn.web.service.AuthorityService;
import com.cn.web.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/userbaseinfo")
public class UserBaseInfo {
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/init")
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
    public Iterable<UserBase> findAll() {
        return userBaseService.findAll();
    }

    @RequestMapping(value = "/findallbypage/{pagesize}/{pagenum}")
    public Page<UserBase> findAllByPage(@PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        System.out.print("pagenum=" + pagenum);
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize);
        return userBaseService.findAllByPage(pageRequest);
    }

    @RequestMapping("/count")
    public long count() {
        return userBaseService.count();
    }

    @RequestMapping("/findallorderbyusername/{pagesize}/{pagenum}")
    public Page<UserBase> findAllOrderByUsername(@PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize, Sort.Direction.ASC, "username");
        return userBaseService.findAllByPage(pageRequest);
    }

    @RequestMapping("/findbyusername/{username}/{pagesize}/{pagenum}")
    public Page<UserBase> findByUsername(@PathVariable(name = "username") String username, @PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize, Sort.Direction.ASC, "username");

        return userBaseService.findByUsername(username, pageRequest);
    }

    @RequestMapping("/findbyusernamelikeandenableistrue")
    public Page<UserBase> findByUsernameLikeAndEnableIsTrue(@PathVariable(name = "username") String username, @PathVariable(name = "pagesize") int pagesize, @PathVariable(name = "pagenum") int pagenum) {
        PageRequest pageRequest = PageRequest.of(pagenum, pagesize, Sort.Direction.ASC, "username");
        return userBaseService.findByUsernameLikeAndAndEnableIsTrue(username, pageRequest);
    }

}
