package com.example.demo7.controller;

import com.example.demo7.service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/playerinfo")
public class PlayerInfoController<PlayerInfoResponse> {
    @Autowired
    private PlayerInfoService playerInfoService;

    @GetMapping
    public ResponseEntity<List<PlayerInfoResponse>> getPlayerInfo() {
        List<PlayerInfoResponse> response = playerInfoService.getPlayerInfo();
        return ResponseEntity.ok(response);
    }
}

