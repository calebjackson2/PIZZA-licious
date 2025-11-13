package com.pluralsight;

    public class RegularTopping extends Topping {
        public RegularTopping(String name) {
            super(name, 0);
        }
    }


    class MeatTopping extends Topping {
        public MeatTopping(String name) {
            super(name, 1.50);
        }
    }

    class CheeseTopping extends Topping {
        public CheeseTopping(String name) {
            super(name, 2.25);
        }
    }
