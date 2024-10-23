package com.example.demo7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
@Table(name = "item_t")
public class Item {
    @Id
    private String itemId;

    private String itemName;

    @ManyToOne
    @JoinColumn(name = "item_type_id", referencedColumnName = "itemTypeId")
    private ItemType itemType;

    private BigDecimal price;
    @jakarta.persistence.Id
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
