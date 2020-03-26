import java.awt.*;

class Cat {
    public int xRect;
    public int yRect;
    private String name;
    private int appetite;
    private boolean full;

    Cat(String name, int appetite, int xRect, int yRect) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
        this.xRect = xRect;
        this.yRect = yRect;
    }

    void eat(Plate plate) {
        if (plate.getFood() >= appetite*10) {
            plate.decreaseFood(appetite);
            full = true;
        }
    }

    void paint (Graphics g) {
        if (full) {
            g.setColor(Color.green);
            g.fillRect(xRect, yRect, getAppetite()*10, 20);
        }
    }

    public int getAppetite() {
        return appetite;
    }

    boolean isFull() {
        return full;
    }

    void resetAppetite() {
        full = false;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    void paint (Graphics g) {
        g.setColor(Color.black);
        g.fillOval(394-food/2, 289-food/2, food, food);
    }

    int getFood() {
        return this.food;
    }

    void setFood(int food) {
        if (food > 0) this.food = food;
    }

    void increaseFood() {
        food += 5;
    }

    void decreaseFood(int food) {
        this.food -= food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}