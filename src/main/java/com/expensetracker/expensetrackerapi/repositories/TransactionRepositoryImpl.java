package com.expensetracker.expensetrackerapi.repositories;

import com.expensetracker.expensetrackerapi.domain.Transaction;
import com.expensetracker.expensetrackerapi.exception.EtBadRequestException;
import com.expensetracker.expensetrackerapi.exception.EtResourceNotFoundException;

import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public List<Transaction> findAll(Integer userId, Integer categoryId) {
        return null;
    }

    @Override
    public Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException {
        return null;
    }

    @Override
    public void update(Integer userId, Integer categoryId, Integer TransactionId, Transaction transaction) throws EtBadRequestException {

    }

    @Override
    public void removeById(Integer userId, Integer categoryId, Integer TransactionId) throws EtResourceNotFoundException {

    }
}
