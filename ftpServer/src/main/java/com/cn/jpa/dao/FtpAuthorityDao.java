package com.cn.jpa.dao;

import com.cn.jpa.entity.FtpAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface FtpAuthorityDao extends JpaRepository<FtpAuthority, String> {

}
