package com.example.saiworx.repository;

import com.example.saiworx.entity.Component;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComponentRepository extends JpaRepository<Component , UUID> {

}
