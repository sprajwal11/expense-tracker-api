package com.expensetracker.expensetrackerapi.servicies;

import com.expensetracker.expensetrackerapi.domain.Transaction;
import com.expensetracker.expensetrackerapi.exception.EtBadRequestException;
import com.expensetracker.expensetrackerapi.exception.EtResourceNotFoundException;

import java.util.List;

public class TransactionServiceImpl implements TransactionService{
    @Override
    public List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId) {
        return null;
    }

    @Override
    public Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException {
        return null;
    }

    @Override
    public void updateTransaction(Integer userId, Integer categoryId, Integer TransactionId, Transaction transaction) throws EtBadRequestException {

    }

    @Override
    public void RemoveTransaction(Integer userId, Integer categoryId, Integer TransactionId, Transaction transaction) throws EtBadRequestException {

    }
}
