## Considere o uso de um objeto criador quando se deparar com muitos parâmetros de construção. 

Os métodos de fabricação estáticos compartilham uma limitação: eles não funcionam bem com grandes quantidades de parâmetros opcionais. Considere o caso de uma classe representando o rótulo Nutrition Facts (informações nutricionais) que aparece em alimentos empacotados. Esses rótulos têm alguns campos obrigatórios - tamanho da porção, porção por embalagem, gordura saturada, gordura trans, colesterol, sódio e assim por diante. A maioria dos produtos tem valores diferentes de zero em apenas alguns desses campos opcionais. 

Que tipo de construtores ou métodos de fabricação estáticos você pode criar para uma classe assim? Normalmente, os programadores usavam o padrão *construtor telescópico*, em que era fornecido um construtor apenas os parâmetros obrigatórios, outro com um único parâmetro opcional, um terceiro com dois parâmetros opcionais e assim por diante, culminando em um construtor com todos os parâmetros opcionais. Veja comi isso é feito na prática. A título de concisão, só quatro campos são mostrados: 

```java
// Construtores Teléscopicos - Não funcionam bem em grande escala!!!
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

    /* Construtor base com todos os parâmetros */
    public NutritionFacts(int servingsSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingsSize = servingsSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
```
