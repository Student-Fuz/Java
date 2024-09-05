package OOP.Inheritance;
import java.util.Random;

// cltr + H查看继承关系
public class Inheritance {
    public static void main(String[] args){
        Dog myDog = new Dog("Buddy");
        Cat myCat = new Cat("Mimi");

        System.out.println("****************Basic demo***************");
        myDog.makeSound();
        myDog.fetch();
        myDog.displayInfo();

        myCat.makeSound();
        myCat.scratch();
        myCat.displayInfo();
    }
}

// 定义一个Animal类作为基类
class Animal {
    // 基类中的属性
    protected String name;
    private double height;

    // 基类的构造方法
    public Animal() {
        this.name = "no name";
        height = 0.5 * Math.random();
    }

    public Animal(String name) {
        this.name = name;
        height = 0.5 * Math.random();
    }

    // 基类中的方法
    public void makeSound() {
        System.out.println("动物发出声音");
    }

    public double getHeightPublic() {
         return height;
    }

    public double getHeightProtected() {
        return height;
    }

    // 基类中的方法
    public void displayInfo() {
        System.out.println("动物的名字是: " + name);
    }
}

// 定义一个Dog类，继承自Animal类
class Dog extends Animal {
    // 子类的构造方法
    public Dog(String name) {
        // 子类必须首先(在第一行)调用父类的构造器，完成父类的初始化

        // 错误
        //System.out.println("some operations");

        // 如果父类提供了无参构造函数，使用无参构造可省略
        //super();

        // 如果父类未提供无参构造函数，则须显式地指定一个含参构造函数
        super(name);
    }

    // 子类中的方法
    @Override
    public void makeSound() {
        System.out.println("子类Dog内调用父类Animal的MakeSound方法");
        super.makeSound();
        System.out.println("狗叫: 汪汪");
    }

    // 子类中特有的方法
    public void fetch() {
        System.out.println(name + " 正在捡球");
    }

    //
    public void display() {
        System.out.println("小狗的名字是: " + name);

        // 错误 子类不能访问父类的私有变量/方法
        //System.out.println("动物的身高是: " + super.height);

        // 正确 子类通过父类公共方法访问私有变量
        System.out.println("小狗的身高是: " + super.getHeightPublic());
        System.out.println("小狗的身高是: " + getHeightPublic());
        // 正确 子类通过父类保护方法访问私有变量
        System.out.println("小狗的身高是: " + super.getHeightProtected());
        System.out.println("小狗的身高是: " + getHeightProtected());

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
        System.out.println("猫叫: 喵喵");
    }

    // 子类中特有的方法
    public void scratch() {
        System.out.println(name + " 正在抓挠");
    }
}

