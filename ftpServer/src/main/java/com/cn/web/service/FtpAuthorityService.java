package com.cn.web.service;

import com.cn.jpa.dao.FtpAuthorityDao;
import com.cn.jpa.entity.FtpAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FtpAuthorityService {
    @Autowired
    private FtpAuthorityDao ftpAuthorityDao;

    public FtpAuthority save(FtpAuthority ftpAuthority) {
        return ftpAuthorityDao.save(ftpAuthority);
    }

    public void delete(FtpAuthority ftpAuthority){
        ftpAuthorityDao.delete(ftpAuthority);
    }

}
