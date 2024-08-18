package venicius.bank_api.repository;

import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import venicius.bank_api.model.Bank;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BankRepository {

        private final DynamoDbTable<Bank> bankTable;

        public BankRepository(DynamoDbEnhancedClient enhancedClient) {
            this.bankTable = enhancedClient.table("MyTable", TableSchema.fromBean(Bank.class));
        }

    public List<Bank> findAll() {
        return bankTable.scan(ScanEnhancedRequest.builder().build())
                .items()
                .stream()
                .collect(Collectors.toList());
    }

        public Bank save(Bank bank) {
            bankTable.putItem(bank);
            return bank;
        }

        public Bank findById(String id) {
            Key key = Key.builder().partitionValue(id).build();
            return bankTable.getItem(key);
        }

        public void delete(String id) {
            Key key = Key.builder().partitionValue(id).build();
            bankTable.deleteItem(key);
        }

        public Bank update(Bank bank) {
            bankTable.updateItem(bank);
            return bank;
        }

}
