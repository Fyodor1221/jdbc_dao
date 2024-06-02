package ru.netology.jdbc_dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcDaoRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final List<Customer> customers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    @Transactional
    public List getProductName(String name) {
        return entityManager.createQuery("select o from ORDERS as o left join o.customer where o.customer.name like :name")
                .setParameter("name", name)
                .getResultList();
    }

    @Transactional
    public void createDataBase() {
        customers.add(Customer.builder().name("Ivan").surname("Ivanov").age(17).phone_number("1111").build());
        customers.add(Customer.builder().name("Fyodor").surname("Fyodorov").phone_number("2222").age(27).build());
        customers.add(Customer.builder().name("Pavel").surname("Pavlov").age(37).phone_number("3333").build());
        customers.add(Customer.builder().name("Stepan").surname("Stepanov").age(47).phone_number("4444").build());

        orders.add(Order.builder().date("13.01.2017").customer(customers.get(0)).product_name("shampoo").amount(2).build());
        orders.add(Order.builder().date("22.01.2017").customer(customers.get(1)).product_name("hat").amount(5).build());
        orders.add(Order.builder().date("01.01.2017").customer(customers.get(2)).product_name("watch").amount(1).build());
        orders.add(Order.builder().date("15.02.2017").customer(customers.get(3)).product_name("flowers").amount(100).build());

        customers.forEach(entityManager::persist);
        orders.forEach(entityManager::persist);
    }
}