package com.expensetracker.expensetrackerapi.servicies;

import com.expensetracker.expensetrackerapi.domain.Category;
import com.expensetracker.expensetrackerapi.exception.EtBadRequestException;
import com.expensetracker.expensetrackerapi.exception.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {
    List<Category> fetchAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;

    void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;

    void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws  EtResourceNotFoundException;



}
