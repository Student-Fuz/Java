## 内部类

在 Java 中，**内部类**（inner class）是定义在另一个类内部的类。内部类可以访问其外部类的成员（包括私有成员），并在某些情况下提供更好的封装性和逻辑组织。内部类的主要类型有四种：非静态内部类、静态内部类、局部内部类和匿名内部类。

### 1. **非静态内部类**

非静态内部类是最常见的类型，它与外部类的实例相关联。

```java
class OuterClass {
    private String outerField = "Outer field";

    class InnerClass {
        void display() {
            System.out.println("Accessing: " + outerField);
        }
    }
}
```

#### 使用：

要创建非静态内部类的实例，必须先创建外部类的实例：

```java
public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();  // 输出: Accessing: Outer field
    }
}
```

### 2. **静态内部类**

静态内部类与外部类的实例无关，可以直接通过外部类的名称访问。静态内部类不能访问外部类的实例成员，但可以访问外部类的静态成员。

```java
class OuterClass {
    private static String staticOuterField = "Static outer field";

    static class StaticInnerClass {
        void display() {
            System.out.println("Accessing: " + staticOuterField);
        }
    }
}
```

#### 使用：

静态内部类的实例可以直接通过外部类访问：

```java
public class Main {
    public static void main(String[] args) {
        OuterClass.StaticInnerClass inner = new OuterClass.StaticInnerClass();
        inner.display();  // 输出: Accessing: Static outer field
    }
}
```

### 3. **局部内部类**

局部内部类是在方法或构造函数中定义的类。它们只能在定义它们的方法内使用，不能在方法外部访问。

```java
class OuterClass {
    void outerMethod() {
        final String localVariable = "Local variable";

        class LocalInnerClass {
            void display() {
                System.out.println("Accessing: " + localVariable);
            }
        }

        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();  // 输出: Accessing: Local variable
    }
}
```

### 4. **匿名内部类**

匿名内部类是在创建实例时定义的，没有名称，通常用于实现接口或继承类。它们可以在创建对象的同时实现方法。

```java
abstract class AbstractClass {
    abstract void display();
}

public class Main {
    public static void main(String[] args) {
        AbstractClass obj = new AbstractClass() {
            void display() {
                System.out.println("Anonymous inner class");
            }
        };
        obj.display();  // 输出: Anonymous inner class
    }
}
```

### 5. **内部类的用途**

- **逻辑分组**：内部类可以将相关的类组织在一起，使代码更具可读性。
- **访问外部类成员**：内部类可以轻松访问外部类的私有成员。
- **事件处理**：在图形用户界面（GUI）编程中，匿名内部类常用于事件处理，例如按钮点击。

### 总结

内部类为 Java 提供了更灵活和封装的方式来组织类结构。通过不同类型的内部类，开发者可以根据需要实现更好的代码逻辑和访问控制。选择使用内部类时，考虑其用途和上下文，可以提升代码的可读性和可维护性。