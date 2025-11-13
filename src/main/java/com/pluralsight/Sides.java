package com.pluralsight;

    abstract class Sides {
        protected String name;
        protected double price;

        public Sides(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    class GarlicKnots extends Sides {
        public GarlicKnots() {
            super("Garlic Knots", 4.00);
        }
    }

    class PotatoKnots extends Sides {
        public PotatoKnots() {
            super("Potato Knots", 4.50);
        }
    }

    class FreeSides extends Sides {
        public FreeSides(String name) {
            super(name, 0.00);
        }
    }

    class Drinks {
        private String name;
        private double price;

        public Drinks(String name) {
            this.name = name;
            this.price = 2.00;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
    }

}
