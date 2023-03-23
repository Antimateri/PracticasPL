<div class=text-justify>
    
# Entrega 2

Juan, al darse cuenta de que podía hacer su propio lenguaje de programación, se emocionó. La adrenalina fue tal que corrió enseguida a enseñarlo a su profesor de compiladores, un programador de renombre. Cuando el profesor de Juan vio lo que había hecho, se quedó a cuadros. Le explicó que por mucho que quisiera a su cabra y sus raíces españolas, nadie iba a entender una línea de código. Era como si Juan se inventara un idioma e intentara comunicarse con el resto del mundo a través de ese idioma. El pobre Juan se derrumbó (quiere mucho a su cabra), pero después de meditarlo mientras devoraba un cocido, se dio cuenta de que tenía que aclarar más su lenguaje. Juan está triste.

## Cambios respecto a la entrega anterior

### Cambios sintácticos

- La palabra reservada para el bucle `ajo` se convierte en la palabra reservada `while`
    ```
    while (expresión booleana) {  
        cuerpo del bucle
    } 
    ```
- Para las expresiones condicionales de una rama, se sustituye la palabra reservada `pican` por `if`.
    ```
    if (expresión booleana){
        cuerpo del condicional
    }
    ```
- Para las expresiones condicionales de dos ramas, se sustituye la palabra reservada `si_pican` por `ifElse` y `no_pican` por `else`
    ```
    ifElse (expresión booleana){
        cuerpo_if
    }
    else{
        cuerpo_else
    }
    ```
    
- La palabra reservada para las funciones `cabra` se convierte en la palabra reservada `fun`. Para evaluar una función, se cambia la palabra `come` por `eval`.
    ```
    fun tipo_función nombre_función (parámetros){
        cuerpo de la función
    }
    ...
    nombre_fun eval (parámetros);   
    ```
    
- La estructura de los registros cambia, eliminando la palabra 'lleva', y cambiando la palabra reservada `cocido` por la palabra `struct`
    ```
    struct nombre_registro  {
      variables_registro;
    };
    
    ```

### Incorporaciones nuevas
- En vez de tener un tipo `void` para las funciones que no devuelvan nada, vamos a distinguirlas y a llamarlas procedimientos, usando la palabra `proc`. Para declarar un procedimiento, se usará una sintaxis muy parecida a la de las funciones, cambiando `eval` por `exec`:
    ```
    proc nombre_procedimiento (parámetros){
        cuerpo_procedimiento
    }
    ...
    nombre_proc exec (parámetros)
    ```


    
</div>
