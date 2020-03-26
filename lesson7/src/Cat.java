class Cat {
    private String name;
    private int appetite;
    private boolean full;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            full = true;
        }
    }

    boolean isFull() {
        return full;
    }

    String getName() {
        return name;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    int getFood() {
        return this.food;
    }

    void setFood(int food) {
        if (food > 0) this.food = food;
    }

    void decreaseFood(int food) {
        this.food -= food;
    }

    void addFood(int food) {
        this.food += food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}