import fruit.entity.FruitType;
import fruit.repository.FruitRepositoryImpl;
import fruit.service.FruitService;
import fruit.service.FruitServiceImpl;

public class Main {
    public static void main(String[] args) {
        FruitRepositoryImpl fruitRepository = new FruitRepositoryImpl();
        FruitServiceImpl fruitService = new FruitServiceImpl(fruitRepository);

        fruitService.register(FruitType.APPLE, 5000, 1000);
    }
}