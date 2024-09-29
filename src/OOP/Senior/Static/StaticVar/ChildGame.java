package OOP.Senior.Static.StaticVar;

public class ChildGame {
    public static void main(String[] args){
        Child child1 = new Child("白骨精");
        Child child2 = new Child("虎先锋");
        Child child3 = new Child("黄风怪");

        child1.join();
        Child.count++;

        child2.join();
        Child.count++;

        child3.join();
        Child.count++;

        System.out.println("There are totally" + Child.count + "Children have joined.");
    }



}

class Child{
    String name;

    // JDK7及以前放在静态方法区 JDK8及以后放在堆里
    public static int count = 0;

    Child(String name){
        this.name = name;
    }

    public void join(){
        System.out.println("Child " + this.name + "has joined this game...");
    }
}