package account.repository;

import account.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {
    private static final Map<Integer, Account> accountHashMap = new HashMap<>();

    @Override
    public int save(Account account) {
        int accountUniqueId = (int) account.getId();
        accountHashMap.put(accountUniqueId, account);
        return accountUniqueId;
    }
}
