package com.zh.sergei.specalc.service;

import com.zh.sergei.specalc.model.entity.Spender;
import com.zh.sergei.specalc.model.entity.SpenderEntity;

public interface SpendingsCRUDService {

    SpenderEntity addNewSpending(Spender spender);
}
