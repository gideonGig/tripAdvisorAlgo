package joshua_bloch;

public class NyPizza extends Pizza {
    private Size size;

    ;
    NyPizza(NyBuilder builder) {
        super(builder);
    }

    public enum Size {Big, Small, Medium}

    public static class NyBuilder extends Pizza.Builder<NyBuilder> {
        public Size size;

        public NyBuilder(Size size) {
            this.size = size;
        }

        public void removeToppings(Topping topping) {
            if (super.toppings.contains(topping)) {
                toppings.remove(topping);
            }
        }

        @Override
        protected NyBuilder self() {
            return this;
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }
    }
}
