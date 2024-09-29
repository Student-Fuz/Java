## Wrapper类

Java 的八大 **SomeClass.Wrapper 类**（包装类）是 Java 提供的基本数据类型的对象包装器，它们位于 `java.lang` 包中。每种基本数据类型都有一个对应的包装类，使得基本数据类型可以以对象的形式存在。包装类允许基本类型与 Java 的面向对象特性（如集合、泛型等）兼容。

### 1. **八大基本数据类型和对应的包装类**

| 基本数据类型 | 包装类      |
| ------------ | ----------- |
| `byte`       | `Byte`      |
| `short`      | `Short`     |
| `int`        | `Integer`   |
| `long`       | `Long`      |
| `float`      | `Float`     |
| `double`     | `Double`    |
| `char`       | `Character` |
| `boolean`    | `Boolean`   |

### 2. **为什么需要包装类**

- **面向对象的特性**：在 Java 中，集合类如 `ArrayList` 不能直接存储基本数据类型（如 `int`），而只能存储对象。包装类使得基本数据类型可以作为对象使用。
- **提供了许多实用方法**：包装类提供了许多静态方法和实例方法来进行类型转换、比较、解析等操作。
- **支持泛型**：泛型只支持引用类型，而包装类是基本类型的对象包装形式，允许泛型操作。
- **自动装箱和拆箱**：Java 5 引入了自动装箱（Autoboxing）和自动拆箱（Unboxing），使得基本类型和包装类可以自动转换。

### 3. **自动装箱与拆箱**

- **自动装箱**：将基本类型自动转换为对应的包装类对象。

  ```java
  int a = 5;
  Integer obj = a;  // 自动装箱，将基本类型 int 转换为 Integer 对象
  ```

- **自动拆箱**：将包装类对象自动转换为基本类型。

  ```java
  Integer obj = 5;
  int a = obj;  // 自动拆箱，将 Integer 对象转换为基本类型 int
  ```

### 4. **常用的包装类方法**

#### 4.1 `parseXXX()`：将字符串转换为基本数据类型

每个包装类都提供了 `parseXXX()` 静态方法，可以将字符串转换为相应的基本类型。

```java
int num = Integer.parseInt("123");  // 将字符串 "123" 转换为 int 类型
double d = Double.parseDouble("3.14");  // 将字符串 "3.14" 转换为 double 类型
```

#### 4.2 `valueOf()`：将字符串或基本类型转换为包装类对象

`valueOf()` 方法将字符串或基本类型转换为包装类对象。

```java
Integer obj = Integer.valueOf(10);  // 基本类型 int 转换为 Integer 对象
Integer obj2 = Integer.valueOf("123");  // 字符串 "123" 转换为 Integer 对象
```

#### 4.3 `xxxValue()`：将包装类对象转换为基本类型

包装类提供 `xxxValue()` 方法，可以将对象转换为对应的基本类型。

```java
Integer obj = 100;
int num = obj.intValue();  // 将 Integer 对象转换为 int 类型
double d = obj.doubleValue();  // 将 Integer 对象转换为 double 类型
```

#### 4.4 `compareTo()` 和 `equals()`：比较两个包装类对象

- `compareTo()`：比较两个包装类对象的值，返回 `0` 表示相等，返回正数表示大于，返回负数表示小于。

  ```java
  Integer a = 100;
  Integer b = 200;
  int result = a.compareTo(b);  // 返回负数，表示 a 小于 b
  ```

- `equals()`：比较两个包装类对象的值是否相等。

  ```java
  Integer a = 100;
  Integer b = 100;
  boolean isEqual = a.equals(b);  // 返回 true
  ```

### 5. **包装类中的常量**

每个包装类都提供了一些常量，例如 `MAX_VALUE` 和 `MIN_VALUE`，分别表示该类型的最大值和最小值。

```java
int max = Integer.MAX_VALUE;  // 2147483647
int min = Integer.MIN_VALUE;  // -2147483648
```

### 6. **不可变性**

所有包装类都是**不可变对象**。一旦创建了包装类对象，不能改变它的值。例如：

```java
Integer obj = 100;
obj = 200;  // 实际上创建了新的 Integer 对象，而不是修改原来的对象
```

### 7. **包装类的缓存机制（Integer 缓存）**

Java 的 `Integer`、`Byte`、`Short`、`Long` 和 `Character` 包装类有一个缓存机制，范围为 `-128` 到 `127`。当创建这些类型的包装类对象时，如果值在此范围内，Java 会从缓存中获取相同的对象，而不是创建新的对象。

```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b);  // 输出 true，因为使用了缓存

Integer c = 128;
Integer d = 128;
System.out.println(c == d);  // 输出 false，因为超出缓存范围，创建了新的对象
```

### 8. **包装类的应用场景**

- **集合框架**：如 `ArrayList<Integer>`，因为集合不支持基本类型，必须使用包装类。
- **类型转换**：使用包装类的静态方法（如 `parseInt()`）将字符串转换为基本类型。
- **泛型**：包装类作为基本类型的替代，用于泛型中。

### 9. **常见问题**

- **自动装箱和拆箱的性能问题**：频繁的装箱和拆箱操作会带来性能开销，尤其是在大量的数值计算中，应尽量避免不必要的装箱和拆箱。
- **使用 `==` 比较对象**：包装类对象使用 `==` 比较时，会比较引用是否相同，而不是值相同。应使用 `equals()` 方法比较包装类的值。

### 总结

Java 的八大包装类为基本类型提供了对象形式，使得基本类型可以在需要对象的地方使用。它们不仅提供了丰富的实用方法，如类型转换和比较，还支持自动装箱和拆箱功能，大大简化了代码的编写。在编写性能敏感的代码时，了解包装类的缓存机制和避免不必要的装箱拆箱也是重要的优化点。