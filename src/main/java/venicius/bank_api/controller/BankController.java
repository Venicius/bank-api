package venicius.bank_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import venicius.bank_api.model.Bank;
import venicius.bank_api.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> banks = bankService.findAll();
        return ResponseEntity.ok(banks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable String id) {
        Bank bank = bankService.findById(id);
        return bank != null ? ResponseEntity.ok(bank) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank createdBank = bankService.save(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable String id, @RequestBody Bank bank) {
        Bank updatedBank = bankService.update(id, bank);
        return updatedBank != null ? ResponseEntity.ok(updatedBank) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable String id) {
        boolean isDeleted = bankService.delete(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}