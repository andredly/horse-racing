package com.charniauski.training.horsesrace.daodb.impl;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * Created by Andre on 31.10.2016.
 */
public class AccountDaoImplTest<T, PK> {

    @Mock
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void test_update()  {
        int check = jdbcTemplate.update("* from t");
        assertNotNull(check);
        verify(jdbcTemplate).update("* from t");
    }


}
