package com.expensetracker.expensetrackerapi.repositories;

import com.expensetracker.expensetrackerapi.domain.Transaction;
import com.expensetracker.expensetrackerapi.exception.EtBadRequestException;
import com.expensetracker.expensetrackerapi.exception.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {


    private static final String SQL_FIND_BY_ID="SELECT TRANSACTION_ID, CATEGORY_ID, USER_ID, AMOUNT, NOTE,TRANSACTION_DATE FROM ET_WHERE USER_ID=? ANF CATEGORY_ID=? AND TRANSACTION_ID=?";
    private static final String SQL_create="INSERT ET_TRANSACTION (TRANSACTION_ID, CATEGORY_ID,USER_ID, AMOUNT,NOTE, TRANSACTION_DATE) VALUE(NEXTVAL('ET_TRANSACTION_SEQ'),?,?,?,?,?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Transaction> findAll(Integer userId, Integer categoryId) {
        return null;
    }

    @Override
    public Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException {
        try{
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId, categoryId,transactionId},transactionRowMapper);

        }
        catch (Exception e){
            throw new EtResourceNotFoundException("Transaction not found");
        }
    }

    @Override
    public Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException {
        try{
            KeyHolder keyHolder=new GeneratedKeyHolder();
            jdbcTemplate.update(connection->{
                PreparedStatement ps=connection.prepareStatement(SQL_create, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, categoryId);
                ps.setInt(2, userId);
                ps.setDouble(3,amount);
                ps.setString(4,note);
                ps.setLong(5,transactionDate);
                return ps;
            },keyHolder);
            return (Integer) keyHolder.getKeys().get("TRANSACTION_ID");

        }
        catch (Exception e){
            throw new EtBadRequestException("Invalid Request");
        }
    }

    @Override
    public void update(Integer userId, Integer categoryId, Integer TransactionId, Transaction transaction) throws EtBadRequestException {

    }

    @Override
    public void removeById(Integer userId, Integer categoryId, Integer TransactionId) throws EtResourceNotFoundException {

    }
    private RowMapper<Transaction> transactionRowMapper=((rs,rowNum)->{
        return new Transaction(rs.getInt("TRANSACTION_ID"),rs.getInt("CATEGORY_ID"),rs.getInt("USER_ID"),rs.getDouble("AMOUNT"),rs.getString("NOTE"),rs.getLong("TRANSACTION"));
    });
}
