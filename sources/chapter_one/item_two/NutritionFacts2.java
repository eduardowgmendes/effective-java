package item002;

// Padrao JavaBeans - permite inconsistencia, demanda mutabilidade
public class NutritionFacts2 {

    // Parametros inicializados com valores padrao (se houver)
    private int servingsSize = -1; // (ml) obrigatorio: nao ha valor padrao
    private int servings = -1; // (por embalagem) obrigatorio: nao ha valor padrao
    private int calories = 0; // opcional
    private int fat = 0; // (g) opcional
    private int sodium = 0; // (mg) opcional
    private int carbohydrate = 0; // (g) opcional

    public NutritionFacts2() {
        //Construtor padrao vazio
    }

    // Setters
    public void setServingsSize(int servingsSize) {
        this.servingsSize = servingsSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
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
