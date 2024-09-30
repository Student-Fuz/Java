## Arrays

`Arrays` 是 Java 中的一个工具类，属于 `java.util` 包，提供了操作数组的各种方法，如排序、搜索、填充、复制等。`Arrays` 类中的方法都是静态方法，因此可以直接调用，无需创建对象。它极大地方便了对数组的操作和管理。

### 1. **创建数组**

在 Java 中，数组是一种固定大小的数据结构，用于存储相同类型的元素。数组可以是基本数据类型或对象类型。

- 创建整型数组：

  ```java
  int[] intArray = new int[5];  // 声明一个长度为5的数组
  ```

- 创建并初始化数组：

  ```java
  int[] intArray = {1, 2, 3, 4, 5};  // 创建并赋初始值
  ```

- 创建二维数组：

  ```java
  int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
  };
  ```

### 2. **常用方法**

#### 2.1 **`Arrays.toString()`**

将数组转换为字符串，方便查看数组的内容。

```java
int[] intArray = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(intArray));  // 输出: [1, 2, 3, 4, 5]
```

对于多维数组，可以使用 `Arrays.deepToString()`：

```java
int[][] matrix = {{1, 2}, {3, 4}};
System.out.println(Arrays.deepToString(matrix));  // 输出: [[1, 2], [3, 4]]
```

#### 2.2 **`Arrays.sort()`**

对数组进行排序，采用的是快速排序算法。对于基本数据类型，使用的是自然顺序（升序）。

```java
int[] intArray = {5, 3, 1, 4, 2};
Arrays.sort(intArray);
System.out.println(Arrays.toString(intArray));  // 输出: [1, 2, 3, 4, 5]
```

对于对象数组，可以提供自定义的比较器：

```java
String[] strArray = {"banana", "apple", "pear"};
Arrays.sort(strArray, Comparator.reverseOrder());
System.out.println(Arrays.toString(strArray));  // 输出: [pear, banana, apple]
```

#### 2.3 **`Arrays.binarySearch()`**

使用二分查找法在有序数组中查找元素。返回值是找到的元素的索引，如果未找到，则返回负数。

```java
int[] intArray = {1, 2, 3, 4, 5};
int index = Arrays.binarySearch(intArray, 3);
System.out.println(index);  // 输出: 2
```

**注意**：在调用 `binarySearch` 之前，数组必须是已排序的，否则结果不可靠。

#### 2.4 **`Arrays.equals()`**

用于比较两个数组是否相等。对于基本类型数组，比较的是数组内容；对于对象数组，默认比较的是对象的引用。

```java
int[] intArray1 = {1, 2, 3};
int[] intArray2 = {1, 2, 3};
System.out.println(Arrays.equals(intArray1, intArray2));  // 输出: true
```

对于多维数组，使用 `Arrays.deepEquals()` 来逐元素比较内容：

```java
int[][] matrix1 = {{1, 2}, {3, 4}};
int[][] matrix2 = {{1, 2}, {3, 4}};
System.out.println(Arrays.deepEquals(matrix1, matrix2));  // 输出: true
```

#### 2.5 **`Arrays.fill()`**

将数组的每个元素都填充为同一个值。

```java
int[] intArray = new int[5];
Arrays.fill(intArray, 7);
System.out.println(Arrays.toString(intArray));  // 输出: [7, 7, 7, 7, 7]
```

可以指定填充的范围：

```java
int[] intArray = new int[5];
Arrays.fill(intArray, 1, 4, 9);  // 填充索引 1 到 3 的元素为 9
System.out.println(Arrays.toString(intArray));  // 输出: [0, 9, 9, 9, 0]
```

#### 2.6 **`Arrays.copyOf()`**

复制一个数组并生成一个新的数组，可以指定新数组的长度。如果指定的长度大于原数组，填充默认值；如果小于原数组，则截断原数组。

```java
int[] intArray = {1, 2, 3};
int[] newArray = Arrays.copyOf(intArray, 5);  // 复制长度为5的新数组
System.out.println(Arrays.toString(newArray));  // 输出: [1, 2, 3, 0, 0]
```

类似的，**`Arrays.copyOfRange()`** 可以复制数组的某个子区间：

```java
int[] intArray = {1, 2, 3, 4, 5};
int[] subArray = Arrays.copyOfRange(intArray, 1, 4);
System.out.println(Arrays.toString(subArray));  // 输出: [2, 3, 4]
```

### 3. **并行排序**

Java 8 引入了 **`Arrays.parallelSort()`** 方法，使用多线程并行地对数组进行排序，提升了排序的性能，尤其是在排序大数组时。

```java
int[] intArray = {5, 3, 1, 4, 2};
Arrays.parallelSort(intArray);
System.out.println(Arrays.toString(intArray));  // 输出: [1, 2, 3, 4, 5]
```

### 4. **数组转换**

#### 4.1 **数组与 `List` 的转换**

- **`Arrays.asList()`**：将数组转换为 `List`，但这个 `List` 的大小是固定的，不能添加或删除元素。

  ```java
  String[] strArray = {"A", "B", "C"};
  List<String> list = Arrays.asList(strArray);
  System.out.println(list);  // 输出: [A, B, C]
  ```

**注意**：通过 `Arrays.asList()` 转换的 `List` 不能进行添加、删除等结构性修改操作。

#### 4.2 **基本类型数组与对象类型数组的转换**

Java 提供了一些工具类（如 `Integer[]` 和 `int[]`）之间的转换工具，不过需要借助第三方库（如 Apache Commons 或 Guava），因为 `Arrays` 类不直接支持基本类型数组与对象数组的转换。

### 5. **数组的局限性**

- **固定大小**：数组的大小在创建时确定，不能动态扩展。
- **类型限制**：数组只能存储相同类型的数据。
- **灵活性不足**：Java 提供了集合框架（如 `ArrayList`）以应对数组的这些局限性，集合可以动态调整大小，并提供了更多操作方法。

### 6. **Arrays 与流（Streams）**

Java 8 引入了流（Streams），可以通过 `Arrays.stream()` 将数组转换为流，便于进行过滤、映射、统计等操作。 TODO（什么是流）

```java
int[] intArray = {1, 2, 3, 4, 5};
int sum = Arrays.stream(intArray).sum();  // 计算数组元素的和
System.out.println(sum);  // 输出: 15
```

### 总结

- `Arrays` 是 Java 提供的一个工具类，简化了数组的操作。
- 它提供了丰富的静态方法，用于排序、搜索、比较、填充和复制数组等操作。
- 对于更复杂的应用场景，Java 的集合框架（如 `ArrayList`）是数组的有效替代方案。