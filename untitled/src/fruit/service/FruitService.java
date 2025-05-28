package fruit.service;

import fruit.entity.Fruit;
import fruit.entity.FruitType;

import java.util.List;

public interface FruitService {
    int register(FruitType type, int quantity, int price);
    List<Fruit> list();
}
