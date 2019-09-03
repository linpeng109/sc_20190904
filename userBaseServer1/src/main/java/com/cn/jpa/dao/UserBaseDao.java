package com.cn.jpa.dao;

import com.cn.jpa.entity.UserBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBaseDao extends JpaRepository<UserBase, String> {
    public Page<UserBase> findByUsernameStartingWith(String username, Pageable pageable);

    public Page<UserBase> findByUsernameLikeAndEnableIsTrue(String username, Pageable pageable);
}

