package item002;

public class NutritionFactsTest {

    public static void main(String[] args) {
        // Construtor Telescopico
        NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);

        // Padrao JavaBeans
        NutritionFacts2 cocaCola2 = new NutritionFacts2();
        cocaCola2.setServingsSize(240);
        cocaCola2.setServings(8);
        cocaCola2.setCalories(100);
        cocaCola2.setSodium(35);
        cocaCola2.setCarbohydrate(27);

        NutritionFacts3 cocaCola3 = new NutritionFacts3.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        printDetailsFrom(cocaCola3);

    }

    /**
     * Se o objeto nao sobrescrever o metodo toString() de Object
     * a impressao no console sera composta pelo nome da classe seguido de uma
     * arroba @ e da representacao do codigo de hash em hexadecimal sem sinal.
     */
    private static void printDetailsFrom(Object obj) {
        System.out.println(obj);
    }
}
