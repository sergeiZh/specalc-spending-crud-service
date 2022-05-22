package com.zh.sergei.specalc.repository;

import com.zh.sergei.specalc.model.entity.SpendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpendingRepository extends JpaRepository<SpendingEntity, Long> {

  List<SpendingEntity> findBySpenderId(String spenderId);
}
