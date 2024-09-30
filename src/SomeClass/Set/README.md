## Set

`Set` 是 Java 集合框架中的一个接口，继承自 `Collection`，它的主要特点是**不允许重复元素**。与 `List` 不同，`Set` 不会维护元素的插入顺序，某些实现类如 `HashSet` 更加注重高效的元素存取，而 `TreeSet` 则可以保持元素的排序。 TODO 阅读

### 1. **Set 的特点**

- **不允许重复**：集合中的每个元素是唯一的，重复的元素将被忽略。
- **无索引**：不像 `List`，`Set` 没有 `get(int index)` 方法，不能通过索引来访问元素。
- **不同实现有不同的行为**：例如 `HashSet` 不保证顺序，`LinkedHashSet` 保持插入顺序，`TreeSet` 按照自然排序或自定义排序。

### 2. **常见的 Set 实现类**

- **`HashSet`**：基于哈希表实现的集合，存取速度非常快，元素没有特定顺序。
- **`LinkedHashSet`**：是 `HashSet` 的子类，保留了元素的插入顺序。
- **`TreeSet`**：基于红黑树实现的集合，能对元素进行排序。

### 3. **常用方法**

`Set` 继承了 `Collection` 接口中的方法，因此 `Set` 中也包含诸如 `add`、`remove`、`contains`、`size` 等操作。

#### 3.1 **`add(E e)`**

将元素添加到集合中。如果集合已经包含该元素，`add()` 方法返回 `false`，即不会插入重复元素。

```
java复制代码Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");  // 重复元素不会被添加
System.out.println(set);  // 输出: [Banana, Apple]，顺序可能不同
```

#### 3.2 **`remove(Object o)`**

从集合中移除指定元素。如果元素存在并被移除，返回 `true`，否则返回 `false`。

```
java复制代码set.remove("Banana");
System.out.println(set);  // 输出: [Apple]
```

#### 3.3 **`contains(Object o)`**

检查集合中是否包含指定的元素，存在则返回 `true`，否则返回 `false`。

```
java复制代码System.out.println(set.contains("Apple"));  // 输出: true
System.out.println(set.contains("Banana"));  // 输出: false
```

#### 3.4 **`size()`**

返回集合中元素的数量。

```
java


复制代码
System.out.println(set.size());  // 输出: 1
```

#### 3.5 **`clear()`**

清空集合，移除集合中的所有元素。

```
java复制代码set.clear();
System.out.println(set.isEmpty());  // 输出: true
```

#### 3.6 **`isEmpty()`**

检查集合是否为空。

```
java


复制代码
System.out.println(set.isEmpty());  // 输出: true
```

#### 3.7 **`iterator()`**

返回一个迭代器用于遍历集合中的元素。

```
java复制代码Set<String> set = new HashSet<>(Arrays.asList("Apple", "Banana", "Orange"));
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
// 输出:
// Apple
// Banana
// Orange
```

### 4. **Set 的实现类**

#### 4.1 **`HashSet`**

`HashSet` 是基于哈希表的实现，具有以下特点：

- **不保证顺序**：元素的插入顺序和迭代顺序可能不同。
- **允许 null 值**：但只能包含一个 `null` 值。

```
java复制代码Set<String> hashSet = new HashSet<>();
hashSet.add("Apple");
hashSet.add("Banana");
hashSet.add("Orange");
System.out.println(hashSet);  // 输出顺序不确定，如 [Orange, Apple, Banana]
```

#### 4.2 **`LinkedHashSet`**

`LinkedHashSet` 是 `HashSet` 的子类，保留元素的插入顺序，适合需要有序集合的场景。

```
java复制代码Set<String> linkedHashSet = new LinkedHashSet<>();
linkedHashSet.add("Apple");
linkedHashSet.add("Banana");
linkedHashSet.add("Orange");
System.out.println(linkedHashSet);  // 输出: [Apple, Banana, Orange]
```

#### 4.3 **`TreeSet`**

`TreeSet` 是基于红黑树的实现，能够对元素进行排序：

- **自然排序**：元素会根据其 `Comparable` 接口进行排序。
- **自定义排序**：可以使用 `Comparator` 实现自定义排序规则。

```
java复制代码Set<Integer> treeSet = new TreeSet<>();
treeSet.add(3);
treeSet.add(1);
treeSet.add(2);
System.out.println(treeSet);  // 输出: [1, 2, 3]，自动排序

// 自定义排序
Set<String> treeSetWithComparator = new TreeSet<>(Comparator.reverseOrder());
treeSetWithComparator.add("Apple");
treeSetWithComparator.add("Banana");
treeSetWithComparator.add("Orange");
System.out.println(treeSetWithComparator);  // 输出: [Orange, Banana, Apple]
```

### 5. **Set 的高级操作**

#### 5.1 **集合操作**

`Set` 可以进行集合的数学操作，如**交集**、**并集**和**差集**。

- **并集**：两个集合的所有元素。

  ```
  java复制代码Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
  Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));
  set1.addAll(set2);  // 并集操作
  System.out.println(set1);  // 输出: [A, B, C, D]
  ```

- **交集**：两个集合共有的元素。

  ```
  java复制代码Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
  Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));
  set1.retainAll(set2);  // 交集操作
  System.out.println(set1);  // 输出: [B, C]
  ```

- **差集**：从一个集合中移除另一个集合中的所有元素。

  ```
  java复制代码Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
  Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));
  set1.removeAll(set2);  // 差集操作
  System.out.println(set1);  // 输出: [A]
  ```





4o