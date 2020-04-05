package item002;

// Construtores Telescopicos - Nao funcionam bem em grande escala!!!
public class NutritionFacts {

    private final int servingsSize; // (ml) obrigatorio
    private final int servings; // (por embalagem) obrigatorio
    private final int calories; // opcional
    private final int fat; // (g) opcional
    private final int sodium; // (mg) opcional
    private final int carbohydrate; // (g) opcional

    public NutritionFacts(int servingsSize, int servings) {
        this(servingsSize, servings, 0, 0, 0, 0);
    }

    public NutritionFacts(int servingsSize, int servings, int calories) {
        this(servingsSize, servings, calories, 0, 0, 0);
    }

    public NutritionFacts(int servingsSize, int servings, int calories, int fat) {
        this(servingsSize, servings, calories, fat, 0, 0);
    }

    public NutritionFacts(int servingsSize, int servings, int calories, int fat, int sodium) {
        this(servingsSize, servings, calories, fat, sodium, 0);
    }

    /* Construtor base com todos os parametros */
    public NutritionFacts(int servingsSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingsSize = servingsSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
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
