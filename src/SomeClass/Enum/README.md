## 枚举类(Enum class)

在 Java 中，**枚举类**（enum class）是一种特殊的类，用于定义一组常量。枚举类提供了一种类型安全的方式来表示有限的离散值，通常用于表示状态、选项或其他一组固定的值。

### 枚举类的特性：

1. **类型安全**：枚举提供了一个明确的类型，确保只能使用定义好的常量，避免了使用整数或字符串常量时可能出现的错误。
2. **内置方法**：每个枚举类自动继承自 `java.lang.Enum` 类，具有一些内置方法，例如 `values()`、`valueOf()` 和 `ordinal()`。
3. **可以有构造函数、字段和方法**：枚举类不仅可以定义常量，还可以有属性和方法。

### 1. **定义枚举类**

枚举类使用 `enum` 关键字定义，可以像普通类一样定义字段和方法：

```java
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```

### 2. **使用枚举类**

枚举类的常量可以直接使用：

```java
public class Main {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        switch (today) {
            case SUNDAY:
                System.out.println("It's Sunday!");
                break;
            case MONDAY:
                System.out.println("It's Monday!");
                break;
            // 其他情况...
            default:
                System.out.println("It's a weekday!");
        }
    }
}
```

### 3. **枚举类的构造函数、字段和方法**

枚举类可以有构造函数、字段和方法，这样可以为每个枚举常量定义特定的行为或属性：

```java
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
```

使用枚举类的属性和方法：

```java
public class Main {
    public static void main(String[] args) {
        for (Fruit fruit : Fruit.values()) {
            System.out.println(fruit + " has " + fruit.getCalories() + " calories.");
        }
    }
}
```

### 4. **内置方法**

- **`values()`**：返回一个包含所有枚举常量的数组。
- **`valueOf(String name)`**：返回与给定名称匹配的枚举常量。
- **`ordinal()`**：返回枚举常量的序数（从 0 开始的索引）。

`valueOf` 方法接受一个字符串参数，返回与该字符串名称匹配的枚举常量。如果没有找到匹配的常量，则会抛出 `IllegalArgumentException`。

#### valueOf示例代码：

```java
enum Color {
    RED, GREEN, BLUE;
}

public class Main {
    public static void main(String[] args) {
        // 使用 valueOf 方法获取枚举常量
        Color color = Color.valueOf("GREEN");
        System.out.println("The color is: " + color);  // 输出: The color is: GREEN

        // 尝试使用无效名称将抛出异常
        try {
            Color invalidColor = Color.valueOf("YELLOW");  // 这个常量不存在
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid color name: " + e.getMessage());  // 输出: Invalid color name: YELLOW
        }
    }
}
```

`ordinal()` 方法返回枚举常量的序数（即常量在枚举定义中的位置，从 0 开始计数）。

#### ordinal示例代码：

```java
enum Fruit {
    APPLE, BANANA, ORANGE;
}

public class Main {
    public static void main(String[] args) {
        // 获取每个枚举常量的序数
        for (Fruit fruit : Fruit.values()) {
            System.out.println(fruit + " has ordinal: " + fruit.ordinal());
        }
    }
}
```

#### 输出：

```java
APPLE has ordinal: 0
BANANA has ordinal: 1
ORANGE has ordinal: 2
```

### 5. **枚举类的优点**

- **代码可读性**：枚举常量具有明确的名称，提高了代码的可读性。
- **类型安全**：避免了使用魔法字符串或数字常量带来的错误。
- **封装常量的行为**：可以为常量添加属性和方法，使得常量不仅仅是值，还能携带相关的逻辑。

### 总结

枚举类是一种强大而灵活的机制，用于定义一组固定的常量，提供类型安全和清晰的代码结构。它不仅可以简单地表示常量，还可以为常量添加行为和状态，是现代 Java 编程中不可或缺的特性之一。