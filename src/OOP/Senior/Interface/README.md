## 接口（Interface）

在 Java 中，**接口**（interface）是一种特殊的引用类型，用于定义类之间的契约。它只包含常量、抽象方法（没有方法体）和默认方法（从 Java 8 开始），以及静态方法。接口是实现多重继承的一个重要机制。

### 接口的特性：

1. **方法的默认实现**：接口可以包含抽象方法和默认方法（使用 `default` 关键字定义），允许接口提供某些方法的默认实现。
2. **常量**：接口中的字段默认是 `public static final`，即常量，必须在声明时初始化。
3. **不允许实例化**：与抽象类一样，接口也不能被实例化。
4. **多重继承**：一个类可以实现多个接口，从而支持多重继承。
5. **只包含方法声明**：接口只能包含方法的声明（抽象方法），不能包含方法的实现（除非是默认方法）。

### 1. **定义接口**

接口使用 `interface` 关键字定义，包含方法声明和常量：

```java
interface Animal {
    // 抽象方法
    void makeSound();
    
    // 默认方法
    default void sleep() {
        System.out.println("I am sleeping");
    }
}
```

在这个例子中，`Animal` 接口定义了一个抽象方法 `makeSound()` 和一个默认方法 `sleep()`。

### 2. **实现接口**

类通过 `implements` 关键字实现接口，必须实现接口中定义的所有抽象方法：

```java
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
```

在上面的例子中，`Dog` 和 `Cat` 类实现了 `Animal` 接口，并提供了 `makeSound()` 方法的具体实现。

### 3. **使用接口**

接口提供了一种方式，可以通过多态来使用不同的实现：

```java
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();  // 输出: Woof
        dog.sleep();      // 输出: I am sleeping

        Animal cat = new Cat();
        cat.makeSound();  // 输出: Meow
        cat.sleep();      // 输出: I am sleeping
    }
}
```

### 4. **接口的多重继承**

Java 允许一个类实现多个接口，这意味着类可以继承多个接口的方法。例如：

```java
interface Swimmer {
    void swim();
}

class Duck implements Animal, Swimmer {
    @Override
    public void makeSound() {
        System.out.println("Quack");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}
```

在这个例子中，`Duck` 类实现了 `Animal` 和 `Swimmer` 两个接口，提供了各自的方法实现。

### 5. **接口 vs 抽象类**

接口和抽象类有一些相似之处，但也有关键区别：

- **方法实现**：接口可以有默认方法和抽象方法，而抽象类可以有具体方法和抽象方法。
- **多重继承**：一个类可以实现多个接口，但只能继承一个抽象类。
- **用途**：接口通常用于定义行为规范，而抽象类则用于提供共享的代码实现。

### 6. **接口的用途**

- **实现多态**：接口可以用来表示多种行为，方便代码的解耦和可扩展性。
- **约定**：接口可以作为类的协议，强制实现某些功能。
- **灵活性**：使用接口可以轻松替换实现类，而不影响使用它们的代码。

### 总结

接口是一种强大的机制，用于定义类之间的行为约定。它支持多重继承，并通过抽象方法和默认方法提供灵活的代码实现方案。在 Java 中，接口是实现多态和代码解耦的重要工具。



TODO 

- 接口多态实操