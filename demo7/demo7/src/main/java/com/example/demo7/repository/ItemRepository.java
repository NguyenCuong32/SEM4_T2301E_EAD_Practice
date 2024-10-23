package com.example.demo7.repository;

import com.example.demo7.entity.Item;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<AbstractReadWriteAccess.Item, String> {
    void Save(Item item);
}

