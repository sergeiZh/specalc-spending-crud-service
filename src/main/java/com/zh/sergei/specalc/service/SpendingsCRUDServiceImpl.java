package com.zh.sergei.specalc.service;

import com.zh.sergei.specalc.model.Spender;
import com.zh.sergei.specalc.model.Spending;
import com.zh.sergei.specalc.model.entity.SpenderEntity;
import com.zh.sergei.specalc.model.entity.SpendingEntity;
import com.zh.sergei.specalc.repository.SpenderRepository;
import com.zh.sergei.specalc.repository.SpendingRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpendingsCRUDServiceImpl implements SpendingsCRUDService {

    SpenderRepository spenderRepository;

    SpendingRepository spendingRepository;

    @Override
    public SpenderEntity addNewSpender(Spender spender) {
        SpenderEntity spenderEntity = new SpenderEntity();
        spenderEntity.setId(spender.getId());
        spenderEntity.setFirstName(spender.getFirstName());
        spenderEntity.setLastName(spender.getLastName());

        return spenderRepository.save(spenderEntity);
    }

    @Override
    public SpendingEntity addNewSpending(Spending spending) {
        SpendingEntity spendingEntity = new SpendingEntity();
        SpenderEntity spenderEntity = spenderRepository.findById(spending.getSpenderId());
        if(spenderEntity != null) {
            spendingEntity.setSpender(spenderEntity);
            spendingEntity.setName(spending.getName());
            spendingEntity.setTotal(spending.getTotal());
            return spendingRepository.save(spendingEntity);
        }
        return null;
    }

    @Override
    public SpendingEntity findById(long id) {
        return spendingRepository.getById(id);
    }

    @Override
    public List<Spending> findAllForSpenderWithId(String spenderId) {
        List<SpendingEntity> spendingEntities = spendingRepository.findBySpenderId(spenderId);
        return spendingEntities.stream()
                               .map(spendingEntity -> {
                                   Spending spending = new Spending();
                                   spending.setName(spendingEntity.getName());
                                   spending.setSpenderId(spendingEntity.getSpender().getId());
                                   spending.setTotal(spendingEntity.getTotal());
                                   return spending;
                               }).collect(Collectors.toList());
    }
}
