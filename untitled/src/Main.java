import account.service.AccountService;
import account.service.AccountServiceImpl;
import fruit.entity.Fruit;
import fruit.entity.FruitType;
import fruit.repository.FruitRepositoryImpl;
import fruit.service.FruitService;
import fruit.service.FruitServiceImpl;
import order.entity.AccountOrder;
import order.service.AccountOrderService;
import order.service.AccountOrderServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitService fruitService = FruitServiceImpl.getInstance();
        fruitService.register(FruitType.APPLE, 5000, 1000);
        fruitService.register(FruitType.WATERMELON, 2000, 10000);
        fruitService.register(FruitType.PEACH, 3000, 5000);
        fruitService.register(FruitType.SHINEMUSCAT, 4000, 6000);

        AccountService accountService = AccountServiceImpl.getInstance();
        accountService.register();

        Integer userIdToken = null;
        while (userIdToken == null) {
            userIdToken = accountService.signIn();
        }
        System.out.println("로그인된 사용자 ID (임시 유저 토큰): " + userIdToken);

        AccountOrderService orderService = AccountOrderServiceImpl.getInstance();
        orderService.register(userIdToken, FruitType.WATERMELON);

        List<AccountOrder> orderList = orderService.list();
        for (AccountOrder order : orderList) {
            System.out.println(order);
        }

        List<Fruit> fruitList = fruitService.list();
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }
}