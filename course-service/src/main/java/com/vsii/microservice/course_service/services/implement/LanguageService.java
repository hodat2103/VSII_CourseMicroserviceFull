package com.vsii.microservice.course_service.services.implement;

import com.vsii.microservice.course_service.components.Translator;
import com.vsii.microservice.course_service.entities.Language;
import com.vsii.microservice.course_service.exceptions.DataNotFoundException;
import com.vsii.microservice.course_service.repositories.LanguageRepository;
import com.vsii.microservice.course_service.services.ILanguageService;
import com.vsii.microservice.course_service.utils.MessageKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service tiep nhan cac cong viec tu IService nay xu ly cac logic lien quan den language
 */
@Service

public class LanguageService implements ILanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    /**
     * method de lay ra tat ca cac ngon ngu trong bang du lieu language
     *
     * @return tra ve (http code, massage or ( data)) theo ket qua tuong ung
     */
    @Override
    public List<Language> getAllLanguages() throws DataNotFoundException {

            List<Language> languages = languageRepository.findAll();

            if (languages.isEmpty()) {
                // nem ra ex DataNotFoundException khi danh sach rong
                throw new DataNotFoundException(Translator.toLocale(MessageKey.NO_LANGUAGES_FOUND));
            }

            // tra ve danh sach co du lieu
            return languages;

    }
}
