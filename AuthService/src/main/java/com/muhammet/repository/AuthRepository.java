package com.muhammet.repository;

import com.muhammet.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthRepository extends JpaRepository<Auth,Long> {
}
