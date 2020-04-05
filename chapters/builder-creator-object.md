## Considere o uso de um objeto criador quando se deparar com muitos parâmetros de construção. 

Os métodos de fabricação estáticos compartilham uma limitação: eles não funcionam bem com grandes quantidades de parâmetros opcionais. Considere o caso de uma classe representando o rótulo *Nutrition Facts* (informações nutricionais) que aparece em alimentos empacotados. Esses rótulos têm alguns campos obrigatórios - tamanho da porção, porção por embalagem, gordura saturada, gordura trans, colesterol, sódio e assim por diante. A maioria dos produtos tem valores diferentes de zero em apenas alguns desses campos opcionais. 

Que tipo de construtores ou métodos de fabricação estáticos você pode criar para uma classe assim? Normalmente, os programadores usavam o padrão ***construtor telescópico***, em que era fornecido um construtor apenas os parâmetros obrigatórios, outro com um único parâmetro opcional, um terceiro com dois parâmetros opcionais e assim por diante, culminando em um construtor com todos os parâmetros opcionais. Veja como isso é feito na prática. A título de concisão, só quatro campos são mostrados: 

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

Quando quiser criar uma instância, use o construtor com a lista de parâmetros curta contendo todos os parâmetros que você deseja definir: 

```java
NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);
```
Normalmente esta chamada de construtor precisaria de muitos parâmetros que você não deseja configurar, mas mesmo assim é preciso passar um valor para eles. Neste caso, passamos um valor igual a 0 para `fat`. Com "apenas" seis parâmetros, esse código pode não parecer tão ruim, mas ele sai rapidamente de controle conforme a quantidade de parâmetros aumenta.
Resumindo, **o padrão de construtor telescópico funciona, mas é difícil de escrever um código cliente quando há muitos parâmetros, e ler é mais difícil ainda.** O leitor fica tentado a entender o que significam todos esses valores e deve contar cuidadosamente os parâmetros para descobrir. Longas sequências de parâmetros digitados igualmente podem causar erros sutis. Se o cliente acidentalmente inverter dois desses parâmetros, o compilador não reclamará, mas o programa não funcionará corretamente no tempo de execução.

## JavaBeans
Uma alternativa quando vocẽ se deparar com muitos parâmetros de construção é o padrão `JavaBeans` em que chamamos um construtor sem parâmetros para criar o objeto, em seguida, chamamos métodos *setter* para configurar cada parâmetro obrigatório e cada parâmetro opcional de interesse: 

```java
// Padrao JavaBeans - permite inconsistência, demanda mutabilidade
public class NutritionFacts2 {

    // Parametros inicializados com valores padrão (se houver)
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
```
Esse padrão não apresenta nenhuma das desvantagens do padrão de construtor telescópico. É fácil de criar instâncias com ele, mesmo sendo um pouco mais verboso, e fácil de ler o código resultante: 

```java
// Padrao JavaBeans
        NutritionFacts2 cocaCola2 = new NutritionFacts2();
        cocaCola2.setServingsSize(240);
        cocaCola2.setServings(8);
        cocaCola2.setCalories(100);
        cocaCola2.setSodium(35);
        cocaCola2.setCarbohydrate(27);
```

### Exemplos de código completos
* [`NutritionFacts.java` - Padrão Construtor Teléscópico](https://github.com/eduardowgmendes/effective-java/blob/master/sources/chapter_one/item_two/NutritionFacts.java#L1)
* [`NutritionFacts2.java` - Padrão JavaBeans](https://github.com/eduardowgmendes/effective-java/blob/master/sources/chapter_one/item_two/NutritionFacts2.java#L4)
* [`NutritionFacts3.java` - Padrão Builder](https://github.com/eduardowgmendes/effective-java/blob/master/sources/chapter_one/item_two/NutritionFacts3.java#L3)
