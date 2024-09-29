# Object类详解

## equals方法

- ==与equals的对比

  ​	==是一个比较运算符。

  1. ==：既可以判断基本类型，又可以判断引用类型
  2. ==：如果判断基本类型，判断的值是否相等；
  3. ==：如果判断引用类型，判断的是地址是否相等，即判定是不是同一个对象

​			equals方法：是Object类中的方法，只能判断引用类型。

​			1. 默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等，比如Interger， String。如：

```Java
Interger int1 = new Interger(1000);
Interger int2 = new Interger(1000);

System.out.println(int1 == int2);		// false
System.out.println(int1.equals(int2));	// true

String str1 = new String("abc");
String str2 = new String("abc");

System.out.println(str1 == str2);		// false
System.out.println(str1.equals(str2));	// true
```

## hashCode方法

1. 提高具有哈希结构的容器的效率
2. 两个引用，如果指向的是**同一个对象**，则**哈希值**肯定是**一样的**！
3. 两个引用，如果指向的是不同对象，则哈希值是不一样的
4. 哈希值主要是根据地址号来的！但不能玩全将哈希值等价于地址。

## toString方法

- **基本介绍**

   默认返回类型：全类名+@+哈希值的十六进制，子类往往重写toString方法，用于返回对象的属性信息。

- 重写toString方法，打印对象或拼接对象时，都对自动调用该对象的toString形式。
- 当直接输出一个对象时，toString方法会被默认的调用。

## finalize方法

1. 当对象被回收时，系统自动调用该对象的finalize方法。子类可以重写该方法，做一些释放资源的擦欧总。
2. **什么时候被回收**：当某个对象没有任何引用时，则jvm就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁这个对象，在销毁该对象时，会先调用finalize方法。
3. 垃圾回收机制的调用，是由系统来决定的，也可以通过System.gc()主动出发垃圾机制。

**注意**：从Java 9开始，`finalize()`方法已经被**弃用**，因为它可能导致性能问题，并且它的行为不确定，不能保证及时执行。替代方案是使用`try-with-resources`和`AutoCloseable`接口进行资源管理。