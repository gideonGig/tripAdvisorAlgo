package joshua_bloch;

public class ChPizza extends Pizza {
    private int size;

    ChPizza(ChBuilder builder) {
        super(builder);
        this.size = builder.size;
    }

    public static class ChBuilder extends Pizza.Builder<ChBuilder> {
        private int size;

        public ChBuilder(int size) {
            this.size = size;
        }

        @Override
        protected ChBuilder self() {
            return this;
        }

        @Override
        ChPizza build() {
            return new ChPizza(this);
        }
    }
}
