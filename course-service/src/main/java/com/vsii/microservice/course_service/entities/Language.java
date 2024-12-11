package com.vsii.microservice.course_service.entities;
import jakarta.persistence.*;
import lombok.*;
/**
 *  lop entity nay la dai dien cho du lieu language cua he thong
 *  Su dung cac annotation de toi uu code, su dung khi can den viec truy xuat hay xu ly du lieu
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "language")
@Builder
public class Language {
    /**
     * id la khoa chinh va tu dong tang
     * id duy nhat
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long id;

    //ten ngon ngu duoc su dung trong 1 khoa hoc ex(Java , Php, Nodejs, Reactjs,...)
    @Column(name = "name")
    private String name;
}
