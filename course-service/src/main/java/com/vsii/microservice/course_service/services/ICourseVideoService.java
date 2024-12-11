package com.vsii.microservice.course_service.services;

import  com.vsii.microservice.course_service.config.CloudinaryConfig;

public interface ICourseVideoService {
    /**
     * phuong thuc nay de lay ra video url theo courseId
     * @param courseId
     * @return tra ve url cua video khoa hoc theo courseId tuong ung
     * @throws Exception nem ra ex chua ro rang khi loi lay video tu cloudinary (sai {@link CloudinaryConfig} CLOUD_NAME, API_SECRET, API_KEY)
     */
    String getByCourseId(Long courseId) throws Exception;
}
