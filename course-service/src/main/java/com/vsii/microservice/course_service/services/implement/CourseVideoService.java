package com.vsii.microservice.course_service.services.implement;

import com.cloudinary.utils.ObjectUtils;

import com.vsii.microservice.course_service.config.CloudinaryConfig;
import com.vsii.microservice.course_service.entities.CourseVideo;
import com.vsii.microservice.course_service.exceptions.DataNotFoundException;
import com.vsii.microservice.course_service.repositories.CourseVideoRepository;
import com.vsii.microservice.course_service.services.ICourseVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service nay thuc hien cac method lien quan den thong tin ve video cua chi tiet khoa hoc
 */
@Service
@RequiredArgsConstructor
public class CourseVideoService implements ICourseVideoService {

    private final CourseVideoRepository courseVideoRepository;
    private final CloudinaryConfig cloudinaryConfig;

    /**
     * Ham nay de lay ra url video cua khoa hoc theo id
     *
     * @param courseId
     * @return tra ve url video neu thanh cong, that bai nem ra exception
     */
    @Override
    public String getByCourseId(Long courseId) throws Exception {

        CourseVideo existCourseService = courseVideoRepository.getByCourseId(courseId);
        if (existCourseService == null) {
            throw new DataNotFoundException("Not found course video by course id " + courseId);
        }
        return getVideoUrlFromCloudinary(existCourseService.getVideoUrl());

    }

    /**
     * Method nay lay ra url video theo public_id cua video do tren cloudinary
     *
     * @param publicId truyen vao public_id dai dien cho moi video khi duoc upload len cloudinary
     * @return tra ve url video
     * @throws Exception
     */
    public String getVideoUrlFromCloudinary(String publicId) throws Exception {
        Map<String, Object> resource = cloudinaryConfig.cloudinary().api().resource(publicId, ObjectUtils.asMap(
                "resource_type", "video"
        ));

        // url tu map rouse
        return (String) resource.get("url");
    }
}
