package com.pluralsight;

 abstract class Topping {
    protected String name;
    protected double price;

    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

    class RegularTopping extends Topping {
        public RegularTopping(String name) {
            super(name, 0.75);
        }
    }

    abstract class ExtraTopping extends Topping {
        public ExtraTopping(String name, double price) {
            super(name, price);
        }
    }

    class MeatTopping extends ExtraTopping {
        public MeatTopping(String name) {
            super(name, 1.50);
        }
    }

    class CheeseTopping extends ExtraTopping {
        public CheeseTopping(String name) {
            super(name, 1.25);
        }
    }

}
