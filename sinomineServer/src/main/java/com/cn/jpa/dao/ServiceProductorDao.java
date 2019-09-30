package com.cn.jpa.dao;

import com.cn.jpa.entity.ServiceProductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProductorDao extends JpaRepository<ServiceProductor, String> {
}
