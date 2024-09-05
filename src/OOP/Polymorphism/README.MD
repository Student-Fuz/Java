# OOP--Polymorphism

[例程](Polymorphism.java)

## 技术背景


## 介绍

 - **基本介绍：**方法或对象具有多种形态。是面对对象的的第三大特征，**多态**是建立在**封装**和**继承**基础上的。

### 方法多态（静态多态）

 - **基本介绍：**同一方法名字拥有不同的参数列表（类型、个数或顺序），成为方法多态。

### 对象多态（动态多态）

 - **基本介绍：** 当子类重写父类的方法时，父类的引用可以指向子类对象，并在运行时根据引用对象的实际类型调用相应的**重写方法**。
 - **实现背景：继承与接口**。

1. 多态的实现也可以看作子类型引用（如Dog类型）**向上转型（Upcasting）**成为父类型引用（如Animal类型），这是自动发生的，不需要显示的类型转换。

   ```java
   Animal animal = new Dog();	// 向上转型 Dog类型引用->Animal类型引用
   ```

2. 同样也存在**向下转型（Downdcasting）**，即将父类引用转换为子类引用。但，向下转型必须显式地进行。因为这种操作有潜在的风险：如果父类引用实际并没有指向该子类类型的对象，程序会抛出`ClassCastException`。

   ```Java
   Dog myDog = (Dog) animal;	// 向下转型 Animal类型引用->Dog类型引用
   ```

   **注意：**

   1. 父类引用只能调用子类对象的重写方法，**不能调用**子类对象的**特有**属性、方法。

   2. 属性没有重写值说！属性的值看编译类型（引用类型）。

      ```Java
      public class Base {
          int value = 10;
      }
      public class Sub extends Base{
          int value = 20;
      }
      
      Base base = new Sub();
      Base sub = new Sub();
      
      System.out.printlin(base.value);	//output is 10
      System.out.printlin(sub.value);		// output is 20
      ```

      

   3. instanceof比较操作符，用于判断对象的**运行类型**是否为XX类型或XX类型的子类型。

      ```Java
      Base base = new Sub();
      System.out(base instanceof Base);		// output is true
      System.out(base instanceof Sub);		// output is true
      
      Base base = new Base();
      System.out(base instanceof Base);		// output is true
      System.out(base instanceof Sub);		// output is false
      ```

      

   ## 动态绑定机制（非常重要）

   [例程](DynamicBinding/DynamicBinding.java)

   - **介绍：**
     1. 当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定。
     2. 当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用。

## 多态数组

    [例程](./PolyArray/PolyArray.java)
