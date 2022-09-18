package com.expensetracker.expensetrackerapi.servicies;

import com.expensetracker.expensetrackerapi.domain.Transaction;
import com.expensetracker.expensetrackerapi.exception.EtBadRequestException;
import com.expensetracker.expensetrackerapi.exception.EtResourceNotFoundException;

import java.util.List;

public interface TransactionService {

    List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);

    Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

    Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException;

    void updateTransaction(Integer userId, Integer categoryId, Integer TransactionId, Transaction transaction) throws EtBadRequestException;

    void RemoveTransaction(Integer userId, Integer categoryId, Integer TransactionId, Transaction transaction) throws EtBadRequestException;

}
