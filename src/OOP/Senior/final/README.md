# final关键字

`final` 关键字在 Java 中用于表示 **不可更改** 的特性。它可以用来修饰变量、方法和类，并在不同的情况下有不同的含义。我们分别来看：

### 1. **`final` 变量**

当 `final` 修饰一个变量时，意味着这个变量的值 **只能被赋值一次**，不能再次更改。它可以是成员变量、局部变量或参数。

- **常量：** 对于基本类型的变量，`final` 使得变量的值一旦被赋值后无法更改。例如：

  ```java
  final int x = 10;
  x = 20;  // 错误，无法再次赋值
  ```

- **引用类型：** 对于引用类型（如对象、数组），`final` 并不意味着对象的内容不可更改，而是意味着变量的引用不可改变。也就是说，你不能重新指向另一个对象，但可以修改对象的内部状态：

  ```java
  final StringBuilder sb = new StringBuilder("Hello");
  sb.append(" World");  // 允许，因为改变的是对象的内容
  sb = new StringBuilder();  // 错误，不能重新指向新对象
  ```

- **未初始化的 `final` 变量：** 如果 `final` 修饰的成员变量没有立即赋值，它必须在构造器中进行初始化，确保每个对象都有确定的值。

  ```java
  class Example {
      final int x;
      Example(int value) {
          x = value;  // 必须在构造器中初始化
      }
  }
  ```

### 2. **`final` 方法**

当 `final` 修饰一个方法时，意味着这个方法 **不能被子类重写** (override)。它的目的通常是为了保持方法的安全性或不允许修改其行为。

```java
class Parent {
    public final void display() {
        System.out.println("This is a final method.");
    }
}

class Child extends Parent {
    @Override
    public void display() {  // 错误，不能重写
        System.out.println("Trying to override.");
    }
}
```

使用 `final` 修饰方法的常见场景是，在类中定义了一些敏感或核心的逻辑，不希望子类修改这些方法的实现。

### 3. **`final` 类**

当 `final` 修饰一个类时，意味着这个类 **不能被继承**。所有的方法在 `final` 类中隐式地是 `final` 的。

```java
final class Vehicle {
    // Class body
}

class Car extends Vehicle {  // 错误，不能继承 Vehicle
}
```

使用 `final` 修饰类通常是为了设计上确保这个类的行为不被改变，比如一些安全类或工具类，如 `String` 类就是 `final` 的，防止被继承或修改。

### 使用场景总结：

1. **`final` 变量：** 用于定义常量（尤其是 `static final`），或确保某个变量只被赋值一次。
2. **`final` 方法：** 用于防止子类重写方法，确保方法的行为不可更改。
3. **`final` 类：** 用于确保类不被继承，保持类的不可变性或安全性。

### 常见问题：

- **`static final` 变量：** 常用于定义常量（即类常量），因为它们既不会改变，也属于类本身，而不是某个实例。

  ```
  java复制代码public class Constants {
      public static final double PI = 3.14159;
  }
  ```

- **`final` 参数：** 你可以在方法参数中使用 `final`，防止参数在方法体中被修改：

  ```
  java复制代码public void print(final int x) {
      x = 20;  // 错误，参数 x 不能被修改
  }
  ```

### 总结：

- `final` 关键字主要用于保持不可变性。它可以用来防止变量被重新赋值、方法被重写、类被继承。