import java.io.IOException;

class Lesson7 {

    public static void main(String[] args) throws IOException {

        Cat cat = new Cat("Cat1", 40);
        Cat cat1 = new Cat("Cat2", 20);
        Cat cat2 = new Cat("Cat3", 30);
        Cat cat3 = new Cat("Cat4", 120);
        Cat cat4 = new Cat("Cat5", 100);
        Cat[] catsArray = {cat1, cat2, cat3, cat4, cat};

        Plate plate = new Plate(500);
        cat.eat(plate);

        for (Cat c : catsArray) {
            c.eat(plate);
        }

        for (Cat c : catsArray) {
            System.out.println(c.getName() + " " + c.isFull());
        }

        GameWindow gameWindow = new GameWindow();
    }
}

