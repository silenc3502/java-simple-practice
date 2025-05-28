package order.service;

import fruit.entity.Fruit;
import fruit.entity.FruitType;
import fruit.repository.FruitRepository;
import fruit.repository.FruitRepositoryImpl;
import order.entity.AccountOrder;
import order.repository.AccountOrderRepository;
import order.repository.AccountOrderRepositoryImpl;
import utility.KeyboardInput;

import java.util.List;
import java.util.Optional;

public class AccountOrderServiceImpl implements AccountOrderService {

    private static AccountOrderServiceImpl instance;

    private final AccountOrderRepository accountOrderRepository;
    private final FruitRepository fruitRepository;

    private AccountOrderServiceImpl() {
        this.accountOrderRepository = AccountOrderRepositoryImpl.getInstance();
        this.fruitRepository = FruitRepositoryImpl.getInstance();
    }

    public static AccountOrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new AccountOrderServiceImpl();
        }
        return instance;
    }

    @Override
    public int register(long accountId, FruitType fruitType) {
        System.out.println("주문을 진행합니다!");
        int quantity = Integer.parseInt(KeyboardInput.getStringInput("수량을 입력하세요: "));
        long fruitTypeId = fruitType.getId();

        Optional<Fruit> maybeFruit = fruitRepository.findByFruitType((int) fruitTypeId);

        if (maybeFruit.isEmpty()) {
            System.out.println("해당 과일이 존재하지 않습니다. 주문을 취소합니다.");
            return -1;
        }

        Fruit fruit = maybeFruit.get();

        if (fruit.getQuantity() < quantity) {
            System.out.printf("재고 부족: 현재 재고는 %d개입니다. 주문을 취소합니다.%n", fruit.getQuantity());
            return -1;
        }

        fruit.setQuantity(fruit.getQuantity() - quantity);
        fruitRepository.save(fruit);

        AccountOrder order = new AccountOrder(accountId, fruitTypeId, quantity);
        return accountOrderRepository.save(order);
    }

    @Override
    public List<AccountOrder> list() {
        System.out.println("주문 내역을 출력합니다.");
        return accountOrderRepository.findAll();
    }
}
