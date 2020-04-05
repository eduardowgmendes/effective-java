## Considere o uso de métodos de fabricação estáticos em vez de construtores
A maneira comum de uma classe permitir que um cliente obtenha uma instância de si próprio é fornecendo um construtor público. Há outra técnica que deve fazer parte do kit de ferramentas de qualquer programador. A classe pode fornecer um *método de fabricação estático público*, que é simplesmente um método estático que retorna uma instância da classe. Aqui está um exemplo com a classe `Boolean` (a classe primitiva encaixotada referente ao tipo primitivo `boolean`). Esse método converte um valor primitivo `boolean` em um objeto de referência `Boolean`: 

```java 
public static Boolean valueOf(boolean b){
    return b ? Boolean.TRUE : Boolean.FALSE;
}
```


 
