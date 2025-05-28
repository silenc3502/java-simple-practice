package fruit.repository;

import fruit.entity.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitRepository {
    int save(Fruit fruit);
    Optional<Fruit> findByFruitType(int fruitTypeId);
    List<Fruit> findAll();
}
