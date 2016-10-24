//package com.charniauski.training.horsesrace.daodb.impl;
//
//import com.charniauski.training.horsesrace.daodb.ClientDao;
//import com.charniauski.training.horsesrace.daodb.util.SqlInsertCreate;
//import com.charniauski.training.horsesrace.datamodel.Client;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.inject.Inject;
//import java.util.List;
//
///**
// * Created by Andre on 19.10.2016.
// */
//@Repository
//public class ClientDaoImpl1 implements ClientDao {
//    public ClientDaoImpl1() {
//    }
//
//    @Inject
//    private JdbcTemplate jdbcTemplate;
//
//    @Inject
//    private SqlInsertCreate sqlInsertCreate;
//
//    @Override
//    public Client get(Long id) {
//        return jdbcTemplate.queryForObject(
//                "select * from client where id = ?",
//                new Object[] { id }, new BeanPropertyRowMapper<>(Client.class));
//    }
//
//    @Override
//    public Long insert(Client entity) {
//        String sql = sqlInsertCreate.sqlInsertAndUpdateEntity(entity);
//        jdbcTemplate.execute(sql);
//        return null;
//    }
//
//    @Override
//    public void update(Client entity) {
//        // TODO: 19.10.2016
//    }
//
//    @Override
//    public void delete(Long id) {
//        // TODO: 19.10.2016
//    }
//
//    @Override
//    public List<Client> getAll() {
//        // TODO: 19.10.2016
//        return null;
//    }
//}
