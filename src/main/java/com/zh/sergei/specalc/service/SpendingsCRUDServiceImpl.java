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
        spenderEntity.setFirstName(spender.getFirstName());
        spenderEntity.setLastName(spender.getLastName());


        SpendingEntity spendingEntity = new SpendingEntity();
        spendingEntity.setName("spending name");
        spendingEntity.setSpender(spenderEntity);
        spenderRepository.save(spenderEntity);
        spendingRepository.save(spendingEntity);

        return spendingEntity.getSpender();
    }

    @Override
    public SpendingEntity addNewSpending(Spending spending) {
        SpendingEntity spendingEntity = new SpendingEntity();
        Optional<SpenderEntity> spender = spenderRepository.findById(spending.getSpenderId());
        spendingEntity.setSpender(spender.get());
        spendingEntity.setName(spending.getName());
        return spendingRepository.save(spendingEntity);
    }
}
