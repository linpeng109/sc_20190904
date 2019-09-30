package com.cn.jpa.dao;

import com.cn.jpa.entity.Productor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductorDao extends JpaRepository<Productor,String> {
}
