package com.uggthon.team01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uggthon.team01.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String> {}
