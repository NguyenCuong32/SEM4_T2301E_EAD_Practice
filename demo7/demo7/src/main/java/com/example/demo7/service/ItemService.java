package com.example.demo7.service;

import com.example.demo7.entity.Item;
import com.example.demo7.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public boolean addItem(Item item) {
        itemRepository.Save(item);
        return true;
    }
}

