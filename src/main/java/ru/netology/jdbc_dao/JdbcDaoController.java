package ru.netology.jdbc_dao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JdbcDaoController {
    private final JdbcDaoRepository jdbcDaoRepository;

    public JdbcDaoController (JdbcDaoRepository jdbcDaoRepository) {
        this.jdbcDaoRepository = jdbcDaoRepository;
    }

    @GetMapping("/products/fetch-product")
    public List getProductName(@RequestParam("name") String name) {
        jdbcDaoRepository.createDataBase();
        return jdbcDaoRepository.getProductName(name);
    }
}
