package com.cn.jpa.dao;

import com.cn.jpa.entity.OnlineSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineSupportDao extends JpaRepository<OnlineSupport, String> {
}
