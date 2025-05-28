package fruit.service;

import fruit.entity.FruitType;

public interface FruitService {
    int register(FruitType type, int quantity, int price);
}
