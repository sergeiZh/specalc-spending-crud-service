package com.zh.sergei.specalc.repository;

import com.zh.sergei.specalc.model.entity.SpenderEntity;
import com.zh.sergei.specalc.model.entity.SpendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendingRepository extends JpaRepository<SpendingEntity, Long> {
}
