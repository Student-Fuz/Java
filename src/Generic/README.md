## 泛型

**泛型**（Generics）是 Java 5 引入的一个重要特性，它允许定义类、接口和方法时，可以指定参数的类型，从而提高代码的可复用性和类型安全性。通过泛型，代码可以更加灵活、简洁，并且在编译时就可以检查类型错误。

### 1. **泛型的基本概念**

泛型允许你在类、接口、方法中使用**类型参数**，这些类型参数在使用时才会确定具体的类型。常用的泛型符号是 `T`、`E`、`K`、`V` 等。以下是泛型的常见使用形式：

- **泛型类**：在类定义时使用泛型。
- **泛型方法**：在方法定义时使用泛型。
- **泛型接口**：在接口定义时使用泛型。

### 2. **泛型类**

定义泛型类时，使用尖括号 `<>` 来指定类型参数。示例代码如下：

```java
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(123);  // 使用 Integer 类型的泛型
        System.out.println(integerBox.getValue());

        Box<String> stringBox = new Box<>("Hello");  // 使用 String 类型的泛型
        System.out.println(stringBox.getValue());
    }
}
```

### 3. **泛型方法**

泛型方法允许在方法中定义自己的类型参数，可以和泛型类的类型参数不同。泛型方法使用 `<T>` 声明类型参数，示例代码如下：

```java
public class GenericMethod {
    // 泛型方法
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"A", "B", "C"};

        printArray(intArray);  // 传入 Integer 数组
        printArray(stringArray);  // 传入 String 数组
    }
}
```

### 4. **泛型接口**

与类一样，接口也可以使用泛型。例如：

```java
// 泛型接口
interface GenericInterface<T> {
    T performAction(T input);
}

// 实现泛型接口的类
class StringAction implements GenericInterface<String> {
    @Override
    public String performAction(String input) {
        return "Processed: " + input;
    }
}

public class Main {
    public static void main(String[] args) {
        GenericInterface<String> action = new StringAction();
        System.out.println(action.performAction("Hello"));
    }
}
```

### 5. **泛型的好处**

- **类型安全**：泛型使得在编译时就可以检测类型错误，避免运行时类型转换错误。
- **代码复用**：通过泛型，类、方法或接口可以处理多种不同的数据类型，从而实现代码复用。
- **可读性和灵活性**：泛型代码更加简洁和可读，减少了不必要的类型转换。

### 6. **通配符 `?`**

泛型中的通配符 `?` 表示一个未知类型，通常用于方法的参数中，表示可以接收任何类型的泛型对象。

- **`? extends T`**：表示该泛型类型是 `T` 或其子类（上限）。

  ```java
  public static void printNumbers(List<? extends Number> list) {
      for (Number num : list) {
          System.out.println(num);
      }
  }
  ```

  这个方法可以接收任何 `Number` 的子类（如 `Integer`、`Double`）的列表。

- **`? super T`**：表示该泛型类型是 `T` 或其父类（下限）。

  ```
  java复制代码public static void addNumbers(List<? super Integer> list) {
      list.add(123);  // 可以向该列表中添加 Integer 类型
  }
  ```

  这个方法可以接收 `Integer` 的父类类型列表（如 `Number` 或 `Object`）。

### 7. **泛型擦除**

Java 的泛型是通过**类型擦除**实现的。在编译时，所有泛型信息都会被擦除，泛型类型参数将被替换为它的限定类型（例如 `Object`）。这意味着在运行时，泛型类型的信息是不保留的。

例如：

```java
List<String> stringList = new ArrayList<>();
List<Integer> intList = new ArrayList<>();

// 编译后，两个列表都被擦除为 List
System.out.println(stringList.getClass() == intList.getClass());  // 输出 true
```

### 8. **限制泛型类型**

可以通过 `extends` 关键字对泛型类型进行限定：

```java
public class NumberBox<T extends Number> {  // T 必须是 Number 或其子类
    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

此时 `T` 只能是 `Number` 的子类，例如 `Integer` 或 `Double`。

### 9. **泛型的局限性**

- **基本类型不能作为泛型类型**：如 `int`、`double` 不能直接作为泛型参数使用，必须使用它们的包装类（如 `Integer`、`Double`）。

  ```java
  List<int> intList = new ArrayList<>();  // 错误
  List<Integer> integerList = new ArrayList<>();  // 正确
  ```

- **泛型类型参数不能用于静态字段或静态方法**：因为泛型在编译时被擦除，静态成员无法确定其类型。

### 10. **泛型与数组**

数组不支持泛型参数。例如，不能创建泛型数组：

```java
T[] array = new T[10];  // 错误
```

不过，可以通过创建 `Object` 数组并强制转换来实现：

```java
T[] array = (T[]) new Object[10];
```

### 总结

泛型提供了 Java 强大的类型系统，增强了代码的灵活性和安全性。它避免了大量的类型转换操作，并且让代码能够适应多种不同的数据类型。在实际编程中，熟练使用泛型可以使代码更加高效、简洁和可维护。
