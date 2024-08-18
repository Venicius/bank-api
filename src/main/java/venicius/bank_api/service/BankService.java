package venicius.bank_api.service;

import org.springframework.stereotype.Service;
import venicius.bank_api.model.Bank;

import java.util.List;

@Service
public interface BankService {
    List<Bank> findAll();
    Bank findById(String id);
    Bank save(Bank bank);
    Bank update(String id, Bank bank);
    boolean delete(String id);
}
