package com.example.demo7.service;

import com.example.demo7.entity.PlayerItem;
import com.example.demo7.repository.PlayerItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerItemService {
    @Autowired
    private PlayerItemRepository playerItemRepository;

    public boolean addPlayerItem(PlayerItem playerItem) {
        playerItemRepository.save(playerItem);
        return true;
    }
}

