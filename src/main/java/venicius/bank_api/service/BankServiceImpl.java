package venicius.bank_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import venicius.bank_api.model.Bank;
import venicius.bank_api.repository.BankRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    public List<Bank> findAll() {
        return StreamSupport.stream(bankRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Bank findById(String id) {
        return bankRepository.findById(id);
    }

    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    public Bank update(String id, Bank bank) {
        Bank existingBank = findById(id);
        if (existingBank == null) {
            return null;
        }

        existingBank.setName(bank.getName());
        existingBank.setCode(bank.getCode());
        existingBank.setLocation(bank.getLocation());
        return bankRepository.update(existingBank);
    }

    public boolean delete(String id) {
        Bank existingBank = findById(id);
        if (existingBank != null) {
            bankRepository.delete(id);
            return true;
        }
        return false;
    }
}
