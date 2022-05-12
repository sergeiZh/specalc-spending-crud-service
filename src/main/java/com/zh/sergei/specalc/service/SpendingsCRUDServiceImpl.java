package com.zh.sergei.specalc.service;

import com.zh.sergei.specalc.model.entity.Spender;
import com.zh.sergei.specalc.model.entity.SpenderEntity;
import com.zh.sergei.specalc.repository.SpenderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpendingsCRUDServiceImpl implements SpendingsCRUDService {

    SpenderRepository spenderRepository;

    @Override
    public SpenderEntity addNewSpending(Spender spender) {
        SpenderEntity spenderEntity = new SpenderEntity();
        spenderEntity.setExternalId(spender.getExternalId());
        spenderEntity.setFirstName(spender.getFirstName());
        spenderEntity.setLastName(spender.getLastName());
        return spenderRepository.save(spenderEntity);
    }
}
