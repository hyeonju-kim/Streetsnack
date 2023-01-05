package com.app.api.sample;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MENU_ID", nullable = false)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CategoryEnum category; //Enum으로 변경완료

    @Column(nullable = false)
    private String name; //메뉴이름

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String menuPhotoUrl;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StatusEnum status; // Enum으로 변경완료

    //연관관계 매핑 3개
    @OneToMany(mappedBy = "menu")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<Order_Menu> order_menus = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private Store store;
}
