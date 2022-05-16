package com.zh.sergei.specalc.controller;

import com.zh.sergei.specalc.model.Spender;
import com.zh.sergei.specalc.model.entity.SpenderEntity;
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
@RequestMapping("/v1/spending")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpendingsCRUDController {

    SpendingsCRUDService spendingsCRUDService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSpending(@RequestBody Spender spender) {
        SpenderEntity spenderEntity = spendingsCRUDService.addNewSpending(spender);
        return ResponseEntity.ok(spenderEntity);
    }
}
