package com.example.demo7.repository;

import com.example.demo7.entity.PlayerItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerItemRepository<PlayerItemId> extends JpaRepository<PlayerItem, PlayerItemId> {
}
