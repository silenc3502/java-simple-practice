package order.repository;

import order.entity.AccountOrder;

import java.util.List;

public interface AccountOrderRepository {
    int save(AccountOrder order);
    List<AccountOrder> findAll();
}
