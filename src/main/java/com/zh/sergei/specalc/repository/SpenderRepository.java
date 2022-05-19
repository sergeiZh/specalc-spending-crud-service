package com.zh.sergei.specalc.repository;

import com.zh.sergei.specalc.model.entity.SpenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpenderRepository extends JpaRepository<SpenderEntity, Long> {

  Optional<SpenderEntity> findById(String id);
}
