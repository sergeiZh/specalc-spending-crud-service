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

import java.util.Optional;

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
}
