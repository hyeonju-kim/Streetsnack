package com.app.api.sample;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @Column(name = "USER_ID")
     private Long id;

     @Column(nullable = false, unique = true)
     private String loginId;

     @Column(nullable = false, unique = true)
     private String nickname;

     @Column(nullable = false)
     private String password;

     @Column(nullable = false)
     @Enumerated(value = EnumType.STRING) //편하게 enum타입을 DB에 저장할 수 있는 어노테이션!!
     private UserRoleEnum role; // enum 클래스명을 적기

     @Column(nullable = false)
     private String status;

     // 연관관계 매핑 2개
     @OneToMany(mappedBy = "user")
     private List<Review> reviews = new ArrayList<>();

     @OneToMany(mappedBy = "user")
     private List<Order> orders = new ArrayList<>();
}
