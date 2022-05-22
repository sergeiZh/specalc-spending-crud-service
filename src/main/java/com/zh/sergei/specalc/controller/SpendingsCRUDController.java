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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpendingsCRUDController {

    SpendingsCRUDService spendingsCRUDService;

    @PostMapping(value = "/spending", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spending> addSpending(@RequestBody Spending spending) {
        SpendingEntity spendingEntity = spendingsCRUDService.addNewSpending(spending);
        return ResponseEntity.ok(spending);
    }

    @GetMapping(value = "/spending/{spendingId}")
    public ResponseEntity<Spending> getSpendingById(@PathVariable long spendingId){
        SpendingEntity actualSpendingEntity = spendingsCRUDService.findById(spendingId);
        Spending spending = new Spending();
        spending.setName(actualSpendingEntity.getName());
        spending.setSpenderId(actualSpendingEntity.getSpender().getId());
        spending.setTotal(actualSpendingEntity.getTotal());
        return ResponseEntity.ok(spending);
    }

    @GetMapping(value = "/spender/{spenderId}/spending")
    public ResponseEntity<List<Spending>> getAllSpendingsForSpender(@PathVariable String spenderId){
        List<Spending> spendings = spendingsCRUDService.findAllForSpenderWithId(spenderId);
        return ResponseEntity.ok(spendings);
    }

    @PostMapping(value = "/spender", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spender> addSpender(@RequestBody Spender spender) {
        SpenderEntity spenderEntity = spendingsCRUDService.addNewSpender(spender);
        return ResponseEntity.ok(spender);
    }
}
