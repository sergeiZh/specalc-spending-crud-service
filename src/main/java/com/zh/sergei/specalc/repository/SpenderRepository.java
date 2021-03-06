package com.zh.sergei.specalc.repository;

import com.zh.sergei.specalc.model.entity.SpenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpenderRepository extends JpaRepository<SpenderEntity, Long> {

  SpenderEntity findById(String id);
}
