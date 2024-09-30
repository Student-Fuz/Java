## Math类

Java 的 `Math` 类提供了各种静态方法，用于执行基本的数学运算，如三角函数、指数、对数、平方根、舍入等操作。`Math` 类是 `java.lang` 包的一部分，不需要导入即可使用。常见的 `Math` 方法包括以下几类：

### 1. **常量**

- **`Math.PI`**：表示圆周率 π 的常量。

  ```java
  System.out.println(Math.PI);  // 输出 3.141592653589793
  ```

- **`Math.E`**：表示自然对数的底数 e 的常量。

  ```java
  System.out.println(Math.E);  // 输出 2.718281828459045
  ```

### 2. **基本运算方法**

- **`Math.abs()`**：返回绝对值。 

  ```java
  System.out.println(Math.abs(-10));  // 输出 10
  System.out.println(Math.abs(10.5));  // 输出 10.5
  ```

- **`Math.max()` 和 `Math.min()`**：返回两个数中的最大值或最小值。

  ```java
  System.out.println(Math.max(10, 20));  // 输出 20
  System.out.println(Math.min(10, 20));  // 输出 10
  ```

- **`Math.pow()`**：返回第一个参数的第二个参数次方。

  ```java
  System.out.println(Math.pow(2, 3));  // 输出 8.0
  ```

- **`Math.sqrt()`**：返回平方根。

  ```java
  System.out.println(Math.sqrt(16));  // 输出 4.0
  ```

- **`Math.cbrt()`**：返回立方根。

  ```java
  System.out.println(Math.cbrt(27));  // 输出 3.0
  ```

- **`Math.hypot()`**：返回直角三角形斜边的长度，即 `sqrt(x^2 + y^2)`。

  ```java
  System.out.println(Math.hypot(3, 4));  // 输出 5.0
  ```

### 3. **舍入与取整方法**

- **`Math.round()`**：将浮点数四舍五入为最近的整数。

  ```java
  System.out.println(Math.round(10.5));  // 输出 11
  System.out.println(Math.round(10.4));  // 输出 10
  ```

- **`Math.floor()`**：向下取整，返回小于或等于指定数字的最大整数。

  ```java
  System.out.println(Math.floor(10.9));  // 输出 10.0
  ```

- **`Math.ceil()`**：向上取整，返回大于或等于指定数字的最小整数。

  ```java
  System.out.println(Math.ceil(10.1));  // 输出 11.0
  ```

- **`Math.rint()`**：返回与给定值最接近的整数。如果两个整数距离一样，则返回偶数。

  ```java
  System.out.println(Math.rint(8.5));  // 输出 8.0
  System.out.println(Math.rint(7.5));  // 输出 8.0
  ```

### 4. **随机数生成**

- **`Math.random()`**：生成一个 `0.0` 到 `1.0` 之间的随机数（不包括 1.0）。

  ```java
  System.out.println(Math.random());  // 输出介于 0.0 到 1.0 之间的随机小数
  ```

可以用它生成范围内的随机数：

```java
int random = (int) (Math.random() * 100);  // 生成 0 到 99 的随机整数
```

### 5. **指数和对数运算**

- **`Math.exp()`**：返回 `e^x`（自然对数的底数的 x 次方）。

  ```java
  System.out.println(Math.exp(1));  // 输出 2.718281828459045
  ```

- **`Math.log()`**：返回自然对数（以 e 为底数的对数）。

  ```java
  System.out.println(Math.log(2.718281828459045));  // 输出 1.0
  ```

- **`Math.log10()`**：返回以 10 为底数的对数。

  ```java
  System.out.println(Math.log10(100));  // 输出 2.0
  ```

### 6. **三角函数**

- **`Math.sin()`**、**`Math.cos()`**、**`Math.tan()`**：计算正弦、余弦和正切值。参数为弧度值。

  ```java
  System.out.println(Math.sin(Math.PI / 2));  // 输出 1.0
  System.out.println(Math.cos(0));  // 输出 1.0
  System.out.println(Math.tan(Math.PI / 4));  // 输出 1.0
  ```

- **`Math.asin()`**、**`Math.acos()`**、**`Math.atan()`**：计算反正弦、反余弦和反正切值，返回的角度为弧度。

  ```java
  System.out.println(Math.asin(1));  // 输出 π/2 弧度
  System.out.println(Math.acos(1));  // 输出 0.0 弧度
  System.out.println(Math.atan(1));  // 输出 π/4 弧度
  ```

- **`Math.toRadians()`**：将角度转换为弧度。

  ```java
  System.out.println(Math.toRadians(180));  // 输出 π 弧度
  ```

- **`Math.toDegrees()`**：将弧度转换为角度。

  ```java
  =System.out.println(Math.toDegrees(Math.PI));  // 输出 180.0
  ```

### 7. **符号函数**

- **`Math.signum()`**：返回数字的符号，正数返回 1.0，负数返回 -1.0，0 返回 0.0。

  ```java
  System.out.println(Math.signum(-10));  // 输出 -1.0
  ```

### 8. **特殊函数**

- **`Math.absExact()`**：返回参数的绝对值，如果结果溢出则抛出异常（仅限整数类型）。

  ```java
  System.out.println(Math.absExact(-2147483647));  // 输出 2147483647
  ```

- **`Math.addExact()`**、**`Math.subtractExact()`**、**`Math.multiplyExact()`**：执行加法、减法、乘法操作，如果发生溢出会抛出异常。

  ```java
  System.out.println(Math.addExact(100, 200));  // 输出 300
  ```

### 总结

Java 的 `Math` 类提供了丰富的静态方法来进行各种数学运算，从基础的加减乘除到复杂的指数、对数和三角函数操作。使用这些方法，可以简洁、高效地处理复杂的数学问题。