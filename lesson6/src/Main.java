public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Jason");
        Dog dog1 = new Dog("Rocky");
        System.out.println("run: " + cat1.run(100));
        System.out.println("swim: " + cat1.swim(1));
        System.out.println("jump: " + cat1.jump(1.5));
        System.out.println("run: " + dog1.run(400));
        System.out.println("swim: " + dog1.swim(2));
        System.out.println("jump: " + dog1.jump(2.5));
    }
}

abstract class Animal {
    Animal(String name) {
    }
    abstract boolean run (int distance);
    abstract boolean swim (int distance);
    abstract boolean jump (double height);
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    boolean run(int distance) {
        return distance <= 200;
    }

    @Override
    boolean swim(int distance) {
        return false;
    }

    @Override
    boolean jump(double height) {
        return height <= 2;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    boolean run(int distance) {
        return distance <= 500;
    }

    @Override
    boolean swim(int distance) {
        return distance <= 10;
    }

    @Override
    boolean jump(double height) {
        return height <= 0.5;
    }
}
