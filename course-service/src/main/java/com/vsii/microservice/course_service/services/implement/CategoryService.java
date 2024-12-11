package com.vsii.microservice.course_service.services.implement;


import com.vsii.microservice.course_service.components.Translator;
import com.vsii.microservice.course_service.entities.Category;
import com.vsii.microservice.course_service.exceptions.DataNotFoundException;
import com.vsii.microservice.course_service.repositories.CategoryRepository;
import com.vsii.microservice.course_service.services.ICategoryService;
import com.vsii.microservice.course_service.utils.MessageKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service tiep nhan cac cong viec tu IService nay xu ly cac logic lien quan den category
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * method de lay ra tat ca cac ngon ngu trong bang du lieu category
     *
     * @return tra ve (http code, massage or ( data)) theo ket qua tuong ung
     */
    @Override
    public List<Category> getAllCategories() throws DataNotFoundException {
        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()) {
            // tra ve voi ma 204 khong co du lieu
            throw new DataNotFoundException(Translator.toLocale(MessageKey.NO_CATEGORIES_FOUND));
        }

        // tra ve danh sach co du lieu
        return categories;
    }
}
