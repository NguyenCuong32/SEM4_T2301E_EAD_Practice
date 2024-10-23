package com.example.demo7.service;

import com.example.demo7.entity.Player;
import com.example.demo7.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public boolean addPlayer(Player player) {
        playerRepository.save(player);
        return true;
    }
}
