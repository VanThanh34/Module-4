package com.example.user.service;


import com.example.user.entity.Category;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    List<Category> findAllCategory();
}
