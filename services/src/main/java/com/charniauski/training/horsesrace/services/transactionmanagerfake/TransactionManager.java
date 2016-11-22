package com.charniauski.training.horsesrace.services.transactionmanagerfake;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

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
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
    }
}
