package com.app.api.sample;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "STORE_ID", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column
    private String storePhotoUrl;

    @Column(nullable = false)
    private String phone;

    @Column
    private String content;

    @Column(nullable = false)
    private int star;

    @Column(nullable = false)
    private int reviewCount;

    @Column(nullable = false)
    private String status;

    // 연관관계 매핑 3개
    @OneToMany(mappedBy = "store")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Menu> menus = new ArrayList<>();
}
