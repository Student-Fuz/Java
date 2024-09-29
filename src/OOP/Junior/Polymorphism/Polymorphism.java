package OOP.Junior.Polymorphism;

public class Polymorphism {
    public static void main(String[] args){
        Master me = new Master();
        Animal pet_0 = new Dog("Buddy");
        Animal pet_1 = new Cat("Mimi");

        // 此处体现Java语言的多态特性
        // 传入同一类的引用 却表现出不同类的属性、方法
        me.playWithPet(pet_0);
        me.playWithPet(pet_1);
    }
}

class Master{
    public void playWithPet(Animal pet){
        System.out.println("========================================");
        System.out.println("Playing with my pet " + pet.name + "......");
        System.out.println("After play, my pet behaves like:");

        // 正确 父类引用可以调用子类对象的重写方法
        pet.makeSound();

        // 错误 父类引用不能调用子类对象的新增属性、方法
        //pet.fetch();

        System.out.println("========================================");
    };
}

// 定义一个Animal类作为基类
class Animal {
    // 基类中的属性
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    // 基类中的方法
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}

// 定义一个Dog类，继承自Animal类
class Dog extends Animal {
    // 子类的构造方法
    public Dog(String name) {
        super(name);
    }

    // 子类中的方法
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching a ball...");
    }
}

// 定义一个Cat类，继承自Animal类
class Cat extends Animal {
    // 子类的构造方法
    public Cat(String name) {
        super(name); // 调用父类的构造方法
    }

    // 子类中的方法
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

}
