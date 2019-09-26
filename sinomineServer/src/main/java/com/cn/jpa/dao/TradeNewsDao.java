package com.cn.jpa.dao;

import com.cn.jpa.entity.TradeNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeNewsDao extends JpaRepository<TradeNews, String> {
}
