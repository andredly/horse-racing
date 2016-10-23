package com.charniauski.training.horsesrace.daodb.impl;
//
//import com.charniauski.training.horsesrace.daodb.GenericDao;
//import com.charniauski.training.horsesrace.daodb.util.SqlCreate;
//import com.charniauski.training.horsesrace.datamodel.AbstractModel;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//
//import javax.inject.Inject;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * Created by ivc4 on 21.10.2016.
// */
//public class AbstractDao1<T extends AbstractModel, PK> implements GenericDao<T, PK> {
//
//    @Inject
//    private JdbcTemplate jdbcTemplate;
//
//    @Inject
//    private SqlCreate sqlCreate;
//
//
//
//    @Override
//    public T get(PK id) {
////        Gson gson=new Gson();
////
////        TypeToken<T> stringListTok = new TypeToken<T>(){};
////
////        System.out.println(stringListTok.getClass());
////        System.out.println(stringListTok.getType());
////        try {
////            System.out.println(stringListTok.getRawType().newInstance());
////        } catch (InstantiationException e) {
////            e.printStackTrace();
////        } catch (IllegalAccessException e) {
////            e.printStackTrace();
////        }
////        AbstractModel entity= (AbstractModel) new Object();
////
////        Class<? extends AbstractModel> c = entity.getClass();
////        String sql=sqlInsertCreate.sqlSelectEntity(entity);
////        return jdbcTemplate.queryForObject(
////                sql+/*"SELECT * FROM client*/ "WHERE id = ?",
////                new Object[]{id}, new BeanPropertyRowMapper<T>());
//        return null;
//    }
//
//    @Override
//    public PK insert(T entity) {
//        String sql = sqlCreate.sqlInsertEntity(entity,false);
//        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                return con.prepareStatement(sql);
//            }
//        }, generatedKeyHolder);
//
////        jdbcTemplate.execute(sql);
////        System.out.println("---------"+generatedKeyHolder.getKey().longValue());
//        return null;
//    }
//
//    @Override
//    public void update(T entity) {
//
//    }
//
//    @Override
//    public boolean delete(PK id) {
//return false;
//    }
//
//    @Override
//    public List<T> getAll() {
//        return null;
//    }

//    public <T> List<T> listEntity(Class<T> clazz)
//             {
//
//                 Gson gson=new Gson();
//                 gson.fromJson()
//        try {
//            // Consuming remote method
//            String strJson = getService().listEntity(clazz.getName());
//
//            JsonParser parser = new JsonParser();
//            JsonArray array = parser.parse(strJson).getAsJsonArray();
//
//            List<T> lst =  new ArrayList<T>();
//            for(final JsonElement json: array){
//                T entity = GSON.fromJson(json, clazz);
//                lst.add(entity);
//            }
//
//            return lst;
//
//        } catch (Exception e) {
//            throw new WsIntegracaoException(
//                    "WS method error [listEntity()]", e);
//        }
//    }

//}
