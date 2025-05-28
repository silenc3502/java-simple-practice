package fruit.repository;

import fruit.entity.Fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitRepositoryImpl implements FruitRepository {
    private static final Map<Integer, Fruit> fruitHashMap = new HashMap<>();

    @Override
    public int save(Fruit fruit) {
        System.out.println("과일 정보 저장: " + fruit);
        int fruitUniqueId = (int) fruit.getId();
        fruitHashMap.put(fruitUniqueId, fruit);
        return fruitUniqueId;
    }
}
