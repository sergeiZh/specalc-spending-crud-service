package com.zh.sergei.specalc.controller;

import com.zh.sergei.specalc.model.Spender;
import com.zh.sergei.specalc.model.Spending;
import com.zh.sergei.specalc.model.entity.SpenderEntity;
import com.zh.sergei.specalc.model.entity.SpendingEntity;
import com.zh.sergei.specalc.service.SpendingsCRUDService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpendingsCRUDController {

    SpendingsCRUDService spendingsCRUDService;

    @PostMapping(value = "/spending", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSpending(@RequestBody Spending spending) {
        SpendingEntity spendingEntity = spendingsCRUDService.addNewSpending(spending);
        return ResponseEntity.ok(spendingEntity);
    }

    @PostMapping(value = "/spender", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spender> addSpender(@RequestBody Spender spender) {
        SpenderEntity spenderEntity = spendingsCRUDService.addNewSpender(spender);
        return ResponseEntity.ok(spender);
    }
}
