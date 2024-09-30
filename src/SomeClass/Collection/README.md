## Collection

Java 的 `Collection` 是 Java 集合框架中所有集合类的根接口，定义了操作集合对象的通用方法。常见的子接口有 `List`、`Set`、`Queue` 等。`Collection` 提供了集合的基本操作方法，比如添加、删除、迭代等。所有实现 `Collection` 接口的类如 `ArrayList`、`HashSet`、`LinkedList` 等都可以使用这些方法。

### 1. **`Collection` 常用方法**

#### 1.1 **`add(E e)`**

将指定的元素添加到集合中。如果集合发生了变化，则返回 `true`，否则返回 `false`。

```
java复制代码Collection<String> collection = new ArrayList<>();
collection.add("Hello");
collection.add("World");
System.out.println(collection);  // 输出: [Hello, World]
```

#### 1.2 **`addAll(Collection<? extends E> c)`**

将指定集合中的所有元素添加到此集合中。如果集合发生了变化，返回 `true`，否则返回 `false`。

```
java复制代码Collection<String> collection1 = new ArrayList<>();
Collection<String> collection2 = Arrays.asList("Hello", "World");
collection1.addAll(collection2);
System.out.println(collection1);  // 输出: [Hello, World]
```

#### 1.3 **`clear()`**

清空集合，移除集合中的所有元素。

```
java复制代码collection.clear();
System.out.println(collection);  // 输出: []
```

#### 1.4 **`contains(Object o)`**

判断集合是否包含指定的对象。如果包含返回 `true`，否则返回 `false`。

```
java复制代码Collection<String> collection = new ArrayList<>(Arrays.asList("Hello", "World"));
System.out.println(collection.contains("Hello"));  // 输出: true
```

#### 1.5 **`containsAll(Collection<?> c)`**

判断当前集合是否包含指定集合中的所有元素。

```
java复制代码Collection<String> collection1 = Arrays.asList("Hello", "World");
Collection<String> collection2 = Arrays.asList("Hello");
System.out.println(collection1.containsAll(collection2));  // 输出: true
```

#### 1.6 **`isEmpty()`**

判断集合是否为空。如果集合没有任何元素，返回 `true`，否则返回 `false`。

```
java复制代码Collection<String> collection = new ArrayList<>();
System.out.println(collection.isEmpty());  // 输出: true
```

#### 1.7 **`remove(Object o)`**

从集合中移除指定的元素。如果集合包含该元素并成功移除，返回 `true`，否则返回 `false`。

```
java复制代码Collection<String> collection = new ArrayList<>(Arrays.asList("Hello", "World"));
collection.remove("World");
System.out.println(collection);  // 输出: [Hello]
```

#### 1.8 **`removeAll(Collection<?> c)`**

从集合中移除包含在指定集合中的所有元素。

```
java复制代码Collection<String> collection1 = new ArrayList<>(Arrays.asList("Hello", "World", "Java"));
Collection<String> collection2 = Arrays.asList("World", "Java");
collection1.removeAll(collection2);
System.out.println(collection1);  // 输出: [Hello]
```

#### 1.9 **`retainAll(Collection<?> c)`**

保留当前集合中只包含指定集合中元素的部分，其他元素会被移除。

```
java复制代码Collection<String> collection1 = new ArrayList<>(Arrays.asList("Hello", "World", "Java"));
Collection<String> collection2 = Arrays.asList("World", "Java");
collection1.retainAll(collection2);
System.out.println(collection1);  // 输出: [World, Java]
```

#### 1.10 **`size()`**

返回集合中的元素数量。

```
java复制代码Collection<String> collection = Arrays.asList("Hello", "World");
System.out.println(collection.size());  // 输出: 2
```

#### 1.11 **`toArray()`**

将集合中的所有元素转换为一个数组。

```
java复制代码Collection<String> collection = Arrays.asList("Hello", "World");
Object[] array = collection.toArray();
System.out.println(Arrays.toString(array));  // 输出: [Hello, World]
```

#### 1.12 **`toArray(T[] a)`**

将集合中的所有元素存储在指定类型的数组中。如果数组大小不足，会创建一个新的数组来存储元素。

```
java复制代码Collection<String> collection = Arrays.asList("Hello", "World");
String[] array = collection.toArray(new String[0]);
System.out.println(Arrays.toString(array));  // 输出: [Hello, World]
```

### 2. **`Collection` 的迭代方法**

#### 2.1 **`iterator()`**

返回集合的迭代器，可以通过 `Iterator` 遍历集合中的元素。

```
java复制代码Collection<String> collection = Arrays.asList("Hello", "World", "Java");
Iterator<String> iterator = collection.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
// 输出:
// Hello
// World
// Java
```

### 3. **示例代码**

以下是使用 `Collection` 方法的一个完整示例：

```
java复制代码import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // 创建集合
        Collection<String> collection = new ArrayList<>();
        
        // 添加元素
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Orange");
        
        // 检查集合是否包含某个元素
        System.out.println(collection.contains("Apple"));  // true
        
        // 获取集合的大小
        System.out.println(collection.size());  // 3
        
        // 通过迭代器遍历集合
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // 转换为数组
        String[] array = collection.toArray(new String[0]);
        System.out.println(Arrays.toString(array));  // [Apple, Banana, Orange]
        
        // 清空集合
        collection.clear();
        System.out.println(collection.isEmpty());  // true
    }
}
```

### 4. **注意事项**

- `Collection` 只是一个接口，不能直接实例化，通常我们会使用它的实现类，如 `ArrayList`、`HashSet`、`LinkedList` 等。
- `Collection` 接口定义的很多方法，如 `remove()`、`contains()`，在 `List` 和 `Set` 中的具体行为不同，尤其是 `List` 允许重复元素，而 `Set` 不允许重复。

### 总结

Java 的 `Collection` 接口为所有集合类提供了一个通用的操作方法集。通过这些方法，你可以方便地添加、删除、检查元素，遍历集合等。不同的集合类根据其特性（如有序性、是否允许重复元素等）会实现这些方法并提供特定的行为。