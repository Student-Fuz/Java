## Static关键字

​	在 Java 中，静态变量和静态方法是与类本身相关联的，而不是与类的实例相关联。

### 1. **静态变量（static variables）**

- **定义**：使用 `static` 关键字定义的变量。
- **与类相关**：静态变量属于类，而不是某个具体的对象。它在所有对象中共享，并且只在类加载时初始化一次，不会随着对象的创建而重复创建。
- **生命周期**：静态变量的生命周期与类的生命周期一致。类加载时分配空间，类卸载时释放空间。
- **共享特性**：因为静态变量是全局共享的，所以对静态变量的修改会影响所有该类的对象。

### 2. **静态方法（static methods）**

- **定义**：使用 `static` 关键字定义的方法。
- **与对象无关**：静态方法是与类本身关联的，而不是与类的实例关联的。可以通过类名直接调用，而不需要实例化对象。
- 限制：
  - 静态方法**不能访问**非静态成员（变量和方法），因为静态方法在类加载时就存在，而非静态成员只有在对象创建后才会存在。
  - 静态方法可以**访问静态变量**和**调用静态方法**。
- **常用场景**：通常用于工具类方法、全局状态或与对象实例无关的逻辑。

### 3. **静态块（Static Block）**

#### 3.1 代码块(Code Block)

##### 1. **实例代码块（Instance Block）**

- **定义**：在类中定义，但不带任何修饰符。实例代码块在每次创建对象时执行。

- **用途**：用于初始化对象的状态或执行一些初始化操作，提高代码重用性。

- **示例**：

  ```Java
  public class MyClass {
      {
          System.out.println("实例代码块执行");
      }
  
      public MyClass() {
          System.out.println("构造函数执行");
      }
  
      public static void main(String[] args) {
          new MyClass();  // 输出：实例代码块执行
                          // 输出：构造函数执行
      }
  }
  ```

##### 2. **静态代码块（Static Block）**

- **定义**：使用 `static` 修饰符定义的代码块。只会在类加载时执行一次。

- **用途**：用于初始化静态变量或执行类级别的初始化操作，提高代码重用性。

- **示例**：

  ```Java
  public class MyClass {
      static {
          System.out.println("静态代码块执行");
      }
  
      public MyClass() {
          System.out.println("构造函数执行");
      }
  
      public static void main(String[] args) {
          new MyClass();  // 输出：静态代码块执行
                          // 输出：构造函数执行
      }
  }
  ```

##### 3. **同步代码块（Synchronized Block）**

- **定义**：用于控制对某个共享资源的访问，防止多个线程同时执行某段代码。

- **用途**：在多线程环境中确保线程安全。

- **示例**：

  ```Java
  public class MyClass {
      public void synchronizedMethod() {
          synchronized (this) {  // 锁定当前对象
              System.out.println("同步代码块执行");
          }
      }
  }
  ```

##### 4. **局部代码块（Local Block）**

- **定义**：在方法内部定义的代码块，用于限制变量的作用域。

- **用途**：创建临时变量，避免命名冲突。

  **示例**：

  ```java
  public class MyClass {
      public void method() {
          int x = 10;  // 方法范围变量
          {
              int y = 5;  // 局部代码块变量
              System.out.println("y = " + y);  // 可以访问y
          }
          // System.out.println(y);  // 错误，y 在此不可见
      }
  }
  ```

#### 3.2 初始化调用顺序

静态块用于在类加载时执行静态初始化代码。静态块中的代码在类加载时自动执行，通常用于初始化静态变量。

创建一个对象时，在一个类调用顺序是：

 	1. 调用静态代码块和静态属性初始化（若存在多个，则按照顺序执行）
 	2. 调用普通代码块和普通属性的初始化（若存在多个，则按照顺序执行）
 	3. 调用构造方法

```java
Class A{
    public A() {
        super();
        // 调用普通代码块
        System.out.println("ok");
    }
}
```

​	[说明例程]()

### **4. main函数（public static void main(String args[]）**

[main函数](.\PublicStaticVoidMain\README.md)
