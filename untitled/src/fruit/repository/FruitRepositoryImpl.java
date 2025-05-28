package fruit.repository;

import fruit.entity.Fruit;

import java.util.*;

public class FruitRepositoryImpl implements FruitRepository {

    private static FruitRepositoryImpl instance;

    private FruitRepositoryImpl() {}

    public static FruitRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new FruitRepositoryImpl();
        }
        return instance;
    }

    private static final Map<Integer, Fruit> fruitHashMap = new HashMap<>();

    @Override
    public int save(Fruit fruit) {
        int fruitUniqueId = (int) fruit.getId();
        fruitHashMap.put(fruitUniqueId, fruit);
        return fruitUniqueId;
    }

    @Override
    public Optional<Fruit> findByFruitType(int fruitTypeId) {
        return fruitHashMap.values().stream()
                .filter(fruit -> fruit.getType().getId() == fruitTypeId)
                .findFirst();
    }

    @Override
    public List<Fruit> findAll() {
        return new ArrayList<>(fruitHashMap.values());
    }
}
