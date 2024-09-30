## String

`String` 是 Java 中的一个重要类，用于表示字符序列。它广泛应用于处理文本数据。Java 中的 `String` 类是不可变的（immutable），一旦创建，`String` 对象就不能修改。

### 1. **`String` 的不可变性**

Java 中的 `String` 是不可变对象。这意味着创建后，字符串的内容无法更改。任何对 `String` 的修改都会创建一个新的字符串对象。例如：

```java
String s1 = "Hello";
String s2 = s1.concat(" World");
System.out.println(s1);  // 输出 "Hello"
System.out.println(s2);  // 输出 "Hello World"
```

尽管调用了 `concat()` 方法，但 `s1` 仍然保持不变，`s2` 是一个新的字符串。

不可变性的优点：

- **线程安全**：多个线程可以安全地共享同一个 `String` 对象而不需要同步。
- **缓存优化**：JVM 会在内存中优化和重用 `String` 对象（即字符串常量池），提高效率。

### 2. **字符串常量池**

Java 中 `String` 对象有一个字符串常量池，池中存储着不变的字符串常量。在创建字符串时，Java 会先检查池中是否已经存在相同内容的字符串，如果存在，就会直接返回池中的引用，而不会创建新的对象。这减少了内存消耗。

```java
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1 == s2);  // 输出 true，s1 和 s2 指向同一对象
```

如果通过 `new` 关键字创建 `String`，则会在堆上创建一个新的字符串对象，而不会使用常量池中的字符串。

```java
String s1 = new String("Hello");
String s2 = "Hello";
System.out.println(s1 == s2);  // 输出 false
```

### 3. **常用方法**

`String` 类提供了许多有用的方法来操作和处理字符串。以下是一些常见的方法：

- **`length()`**：返回字符串的长度。

  ```java
  String s = "Hello";
  System.out.println(s.length());  // 输出 5
  ```

- **`charAt(int index)`**：返回指定位置的字符。

  ```java
  String s = "Hello";
  System.out.println(s.charAt(1));  // 输出 'e'
  ```

- **`substring(int beginIndex, int endIndex)`**：返回字符串的子字符串。（左闭右开）

  ```java
  String s = "Hello World";
  System.out.println(s.substring(0, 5));  // 输出 "Hello"
  ```

- **`equals(Object obj)`**：比较两个字符串的内容是否相等。

  ```java
  String s1 = "Hello";
  String s2 = "Hello";
  System.out.println(s1.equals(s2));  // 输出 true
  ```

- **`equalsIgnoreCase(String anotherString)`**：忽略大小写比较字符串。

  ```java
  String s1 = "hello";
  String s2 = "Hello";
  System.out.println(s1.equalsIgnoreCase(s2));  // 输出 true
  ```

- **`indexOf(String str)`**：返回指定子字符串的首次出现位置。

  ```java
  String s = "Hello World";
  System.out.println(s.indexOf("World"));  // 输出 6
  ```

- **`replace(char oldChar, char newChar)`**：将字符串中的字符替换为新字符。

  ```java
  String s = "Hello";
  System.out.println(s.replace('l', 'p'));  // 输出 "Heppo"
  ```

- **`split(String regex)`**：根据正则表达式分割字符串，返回字符串数组。

  ```java
  String s = "a,b,c";
  String[] parts = s.split(",");
  for (String part : parts) {
      System.out.println(part);  // 输出 "a", "b", "c"
  }
  ```

- **`trim()`**：去除字符串前后的空格。

  ```java
  String s = "  Hello  ";
  System.out.println(s.trim());  // 输出 "Hello"
  ```

- **`toUpperCase()` / `toLowerCase()`**：转换为大写或小写。

  ```java
  String s = "Hello";
  System.out.println(s.toUpperCase());  // 输出 "HELLO"
  ```

### 4. **字符串连接**

Java 提供了多种方式连接字符串，常用方法有 `+` 运算符和 `concat()` 方法：

- **`+` 运算符**：最常用的字符串连接方式。

  ```java
  String s1 = "Hello";
  String s2 = "World";
  String s3 = s1 + " " + s2;  // 输出 "Hello World"
  ```

- **`concat()` 方法**：拼接字符串，效果类似 `+`。

  ```java
  java复制代码String s1 = "Hello";
  String s2 = s1.concat(" World");
  System.out.println(s2);  // 输出 "Hello World"
  ```

不过，在需要频繁修改字符串时，`+` 操作符可能会带来性能问题，因为每次连接都会创建新的 `String` 对象。此时，建议使用 **`StringBuilder`** 或 **`StringBuffer`** 类。

### 5. **`StringBuilder` 和 `StringBuffer`**

- **`StringBuilder`**：可变字符串类，适合在单线程环境下使用，提供了对字符串进行高效修改的操作。

  ```java
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(" World");
  System.out.println(sb.toString());  // 输出 "Hello World"
  ```

- **`StringBuffer`**：与 `StringBuilder` 类似，但它是线程安全的，适合在多线程环境下使用。不过通常情况下，`StringBuilder` 的性能会更高。

### 6. **装箱与拆箱（String.valueOf 和 toString）**

Java 提供了 `String.valueOf()` 方法，用于将基本类型转换为字符串：

```java
int num = 123;
String s = String.valueOf(num);  // 将 int 转换为 String
```

`toString()` 方法用于将对象转换为字符串表示：

```java
Integer num = 123;
String s = num.toString();  // 输出 "123"
```

### 7. **字符串比较**

在 Java 中，比较字符串有两种方式：

- **`==`**：比较对象的引用是否相同。

  ```java
  String s1 = "Hello";
  String s2 = "Hello";
  System.out.println(s1 == s2);  // 输出 true（因为字符串常量池）
  ```

- **`equals()`**：比较字符串的内容是否相同。

  ```java
  String s1 = new String("Hello");
  String s2 = new String("Hello");
  System.out.println(s1.equals(s2));  // 输出 true
  ```

### 8. **`String` 的性能问题**

由于 `String` 是不可变的，频繁进行字符串拼接可能导致性能问题。每次拼接都会创建新的 `String` 对象，浪费内存和 CPU 时间。在这种情况下，建议使用 `StringBuilder` 或 `StringBuffer` 来进行高效的字符串操作。

### 总结

- `String` 是不可变的，用于表示字符序列。
- 它有丰富的内置方法来处理字符串。
- 频繁的字符串拼接可以使用 `StringBuilder` 或 `StringBuffer` 来优化性能。