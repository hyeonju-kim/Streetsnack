//package com.app.api.sample;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transaction;
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//@Component
//@RequiredArgsConstructor
//public class TestRunner implements ApplicationRunner {
//
//    @PersistenceContext
//    private final EntityManager entityManager;
//
//    @Transactional
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        //init
//        System.out.println("=========================================");
//
//        Order order = Order.builder().name("order-1").build();
//
//        Item item1 = Item.builder().name("computer1").price(100L).build();
//        Item item2 = Item.builder().name("computer2").price(100L).build();
//        Item item3 = Item.builder().name("computer3").price(100L).build();
//        Item item4 = Item.builder().name("computer4").price(100L).build();
//        Item item5 = Item.builder().name("computer5").price(100L).build();
//        Item item6 = Item.builder().name("computer6").price(100L).build();
//
//        entityManager.persist(order);
//
//        entityManager.persist(item1);
//        entityManager.persist(item2);
//        entityManager.persist(item3);
//        entityManager.persist(item4);
//        entityManager.persist(item5);
//        entityManager.persist(item6);
//
//        item1.setOrder(order);
//        item2.setOrder(order);
//        item3.setOrder(order);
//        item4.setOrder(order);
//        item5.setOrder(order);
//        item6.setOrder(order);
//
//        Order lastOrder = Order.builder().name("order-2").build();
//        entityManager.persist(lastOrder);
//
//        System.out.println("=========================================");
//        entityManager.flush();
//        entityManager.clear();
//
//        System.out.println();
//        System.out.println("=========================================");
//        List<Order> orders = entityManager.createQuery("select o from Order as o").getResultList();
//        System.out.println();
//        System.out.println("=========================================");
//        for(Order fOrder : orders){
//           System.out.println(fOrder.getItems());
//        }
//        System.out.println("=========================================");
//
//
//
//
//    }
//}
