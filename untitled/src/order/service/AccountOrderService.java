package order.service;

import fruit.entity.FruitType;
import order.entity.AccountOrder;

import java.util.List;

public interface AccountOrderService {
    int register(long accountId, FruitType fruitType);
    List<AccountOrder> list();
}
