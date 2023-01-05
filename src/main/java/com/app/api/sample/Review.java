package com.app.api.sample;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private int star;

    @Column(nullable = false)
    private String content;

    @Column
    private String reviewPhotoUrl;

    @Column(nullable = false)
    private String status;

    // 연관관계 매핑 3개
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID") //다대일 관계에서 '일'의 PK이름을 '다'의 조인컬럼으로 매핑해준다.
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;
}

