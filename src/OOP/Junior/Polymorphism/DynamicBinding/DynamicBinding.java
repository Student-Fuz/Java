package OOP.Junior.Polymorphism.DynamicBinding;

public class DynamicBinding {
    public static void main(String[] args){
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());

        C c = new D();
        System.out.println(c.sum());
        System.out.println(c.sum1());
    }
}

// 父类
class A {
    public int i = 10;
    public int sum(){
        return getI() +10;
    }
    public int sum1(){
        return i + 10;
    }
    public int getI(){
        return i;
    }
}

// 子类
class B extends A {
    public int i = 20;
    public int sum(){
        return i + 20;
    }
    public int getI() {
        return i;
    }
    public int sum1() {
    return i + 10;
    }
}

// 父类
class C {
    public int i = 10;
    public int sum(){
        return getI() +10;
    }
    public int sum1(){
        return i + 10;
    }
    public int getI(){
        return i;
    }
}

// 子类
class D extends C {
    public int i = 20;

    //public int sum(){
    //    return i + 20;
    //}

    public int getI() {
        return i;
    }

    //public int sum1() {
    //    return i + 10;
    //}
}