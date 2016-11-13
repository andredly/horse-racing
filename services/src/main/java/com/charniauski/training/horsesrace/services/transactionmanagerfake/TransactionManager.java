package com.charniauski.training.horsesrace.services.transactionmanagerfake;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Andre on 13.11.2016.
 */
public class TransactionManager implements PlatformTransactionManager {



    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
    return null;
    }
    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        status.isCompleted();
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {

    }
}
