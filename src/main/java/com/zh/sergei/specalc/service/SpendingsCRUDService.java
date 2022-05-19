package com.zh.sergei.specalc.service;

import com.zh.sergei.specalc.model.Spender;
import com.zh.sergei.specalc.model.Spending;
import com.zh.sergei.specalc.model.entity.SpenderEntity;
import com.zh.sergei.specalc.model.entity.SpendingEntity;

public interface SpendingsCRUDService {

    SpenderEntity addNewSpender(Spender spender);

    SpendingEntity addNewSpending(Spending spending);
}
