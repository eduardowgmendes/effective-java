package item002;

public class NutritionFacts3 {

    private final int servingsSize; // (ml) obrigatorio
    private final int servings; // (por embalagem) obrigatorio
    private final int calories; // opcional
    private final int fat; // (g) opcional
    private final int sodium; // (mg) opcional
    private final int carbohydrate; // (g) opcional

    public static class Builder {
        private final int servingsSize; // (ml) obrigatorio
        private final int servings; // (por embalagem) obrigatorio

        private int calories; // opcional
        private int fat; // (g) opcional
        private int sodium; // (mg) opcional
        private int carbohydrate; // (g) opcional

        public Builder(int servingsSize, int servings) {
            this.servingsSize = servingsSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts3 build() {
            return new NutritionFacts3(this);
        }

    }

    private NutritionFacts3(Builder builder) {
        servingsSize = builder.servingsSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public String toString() {
        return String.format("Servings Size: %d\n" +
                "Servings: %d\n" +
                "Calories: %d\n" +
                "Fat: %d\n" +
                "Sodium: %d\n" +
                "Carbohydrate: %d", servingsSize, servings, calories, fat, sodium, carbohydrate);
    }
}
