package order.repository;

import order.entity.AccountOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountOrderRepositoryImpl implements AccountOrderRepository {

    private static AccountOrderRepositoryImpl instance;

    private static final Map<Long, AccountOrder> orderMap = new HashMap<>();

    private AccountOrderRepositoryImpl() {}

    public static AccountOrderRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new AccountOrderRepositoryImpl();
        }
        return instance;
    }

    @Override
    public int save(AccountOrder order) {
        System.out.println("주문 정보 저장: " + order);
        orderMap.put(order.getId(), order);
        return (int) order.getId();
    }

    @Override
    public List<AccountOrder> findAll() {
        return new ArrayList<>(orderMap.values());
    }
}
