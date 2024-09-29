package SomeClass.Enum;

public class Fruits {
    public static void main(String[] args) {
        for (Fruit fruit : Fruit.values()) {
            System.out.println(fruit + " has " + fruit.getCalories() + " calories.");
        }
    }
}

enum Fruit {
    APPLE(100), BANANA(80), ORANGE(90);

    private final int calories;

    // 构造函数
    Fruit(int calories) {
        this.calories = calories;
    }

    // 方法
    public int getCalories() {
        return calories;
    }
}