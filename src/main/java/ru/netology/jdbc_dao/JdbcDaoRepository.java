package ru.netology.jdbc_dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class JdbcDaoRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String query;
    private final String SCRIPTFILENAME = "/myScript.sql";

    public JdbcDaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.query = read(SCRIPTFILENAME);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);

        return this.namedParameterJdbcTemplate.query(
                this.query,
                params,
                (rs, rowNum) -> rs.getString("product_name")
        );
    }
}
