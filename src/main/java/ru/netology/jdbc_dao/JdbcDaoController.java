package ru.netology.jdbc_dao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class JdbcDaoController {
    private final JdbcDaoRepository jdbcDaoRepository;

    public JdbcDaoController (JdbcDaoRepository jdbcDaoRepository) {
        this.jdbcDaoRepository = jdbcDaoRepository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String name) throws SQLException {
        return jdbcDaoRepository.getProductName(name);
    }
}