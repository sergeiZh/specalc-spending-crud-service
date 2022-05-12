package com.zh.sergei.specalc.controller;

import com.zh.sergei.specalc.model.entity.Spender;
import com.zh.sergei.specalc.model.entity.SpenderEntity;
import com.zh.sergei.specalc.service.SpendingsCRUDService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/spending")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpendingsCRUDController {

    SpendingsCRUDService spendingsCRUDService;

    @PostMapping
    public ResponseEntity addSpending(Spender spender) {
        SpenderEntity spenderEntity = spendingsCRUDService.addNewSpending(spender);
        return ResponseEntity.ok(spenderEntity);
    }
}
