package com.app.api.sample;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"order"})
@Table(name = "ITEM")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    private Long id;

    @Column(name = "ITEM_NAME")
    private String name;

    @Column(name = "PRICE")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
}
