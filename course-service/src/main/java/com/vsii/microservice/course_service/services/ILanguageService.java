package com.vsii.microservice.course_service.services;


import com.vsii.microservice.course_service.entities.Language;
import com.vsii.microservice.course_service.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILanguageService {
    /**
     * phuong thuc nay de lay ra tat ca cac du lieu cua instructor
     *
     * @return tra ve tat ca du lieu cua instructor
     * @throws DataNotFoundException nem ex ra khi loi url hay gia tri rong
     */
    List<Language> getAllLanguages() throws DataNotFoundException;
}
