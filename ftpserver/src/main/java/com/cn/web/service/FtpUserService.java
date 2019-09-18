package com.cn.web.service;

import com.cn.jpa.dao.FtpAuthorityDao;
import com.cn.jpa.dao.FtpUserDao;
import com.cn.jpa.entity.FtpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FtpUserService {
    @Autowired
    public FtpUserDao ftpUserDao;

    @Autowired
    public FtpAuthorityDao ftpAuthorityDao;

    public FtpUser save(FtpUser ftpUser) {
        return ftpUserDao.save(ftpUser);
    }

    public void delete(FtpUser ftpUser) {
        ftpUserDao.delete(ftpUser);
    }

}
