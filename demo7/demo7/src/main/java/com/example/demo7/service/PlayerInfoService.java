package com.example.demo7.service;

import com.example.demo7.repository.ItemRepository;
import com.example.demo7.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerInfoService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ItemRepository itemRepository;

    public <PlayerInfoResponse> List<PlayerInfoResponse> getPlayerInfo() {
        return List.of();
    }
}
