package com.muhammet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long authId;
    String userName;
    String email;
    String phone;
    String about;
    String address;
    String webSite;
    String instagram;
    String youtube;
    Boolean isActive;
    Long createAt;
    Long updateAt;
}
