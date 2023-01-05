package com.app.api.sample;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ORDER_ID", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private String status;

    // 연관관계 매핑 3개
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @OneToMany(mappedBy = "order")
    private List<Order_Menu> order_menus = new ArrayList<>();
}
