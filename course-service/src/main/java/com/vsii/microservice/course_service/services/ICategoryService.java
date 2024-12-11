package com.vsii.microservice.course_service.services;

import com.vsii.microservice.course_service.entities.Category;
import com.vsii.microservice.course_service.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    /**
     * phuong thuc nay de lay ra tat ca cac du lieu cua category
     *
     * @return tra ve tat ca du lieu cua category
     * @throws DataNotFoundException nem ex ra khi loi url hay gia tri rong
     */
    List<Category> getAllCategories() throws DataNotFoundException;
}
