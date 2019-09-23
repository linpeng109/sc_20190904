package com.cn.web;

import com.cn.jpa.entity.FtpAuthority;
import com.cn.jpa.entity.FtpUser;
import com.cn.web.service.FtpAuthorityService;
import com.cn.web.service.FtpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ftpuserinfo")
public class FtpUserBaseInfo {
    @Autowired
    private FtpUserService ftpUserService;

    @Autowired
    private FtpAuthorityService ftpAuthorityService;

    @RequestMapping("/init")
    public String init() {
        List<FtpAuthority> authorities = new ArrayList<FtpAuthority>();
        String[] authoritys = {"ROLE_ADMIN", "ROLE_USER1", "ROLE_USER2", "ROLE_USER3", "ROLE_GUEST"};
        for (int j = 0; j < authoritys.length; ++j) {
            FtpAuthority ftpAuthority = new FtpAuthority();
            ftpAuthority.setFtpAuthorityString(authoritys[j]);
            ftpAuthorityService.save(ftpAuthority);
            authorities.add(ftpAuthority);
        }
        FtpUser abcd = new FtpUser();
        abcd.setUsername("abcd");
        abcd.setUserpassword("abcd");
        abcd.setWritepermission(true);
        abcd.setAuthorities(authorities);
        ftpUserService.save(abcd);

        return "SUCCESS";
    }
}
