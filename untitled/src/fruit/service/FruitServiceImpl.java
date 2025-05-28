package fruit.service;

import fruit.entity.Fruit;
import fruit.entity.FruitType;
import fruit.repository.FruitRepository;
import fruit.repository.FruitRepositoryImpl;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    private static FruitServiceImpl instance;

    private final FruitRepository fruitRepository;

    private FruitServiceImpl() {
        this.fruitRepository = FruitRepositoryImpl.getInstance();
    }

    public static FruitServiceImpl getInstance() {
        if (instance == null) {
            instance = new FruitServiceImpl();
        }
        return instance;
    }

    @Override
    public int register(FruitType type, int quantity, int price) {
        Fruit fruit = new Fruit(type, quantity, price);
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> list() {
        System.out.println("과일 재고 현황을 출력합니다.");
        return fruitRepository.findAll();
    }
}
