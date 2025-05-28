package fruit.service;

import fruit.entity.Fruit;
import fruit.entity.FruitType;
import fruit.repository.FruitRepository;
import lombok.RequiredArgsConstructor;

public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public int register(FruitType type, int quantity, int price) {
        Fruit fruit = new Fruit(type, quantity, price);
        return fruitRepository.save(fruit);
    }
}
