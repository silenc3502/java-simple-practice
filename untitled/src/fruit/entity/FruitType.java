package fruit.entity;

public enum FruitType {
    WATERMELON(1L),
    APPLE(2L),
    PEACH(3L),
    SHINEMUSCAT(4L);

    private final long id;

    FruitType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

