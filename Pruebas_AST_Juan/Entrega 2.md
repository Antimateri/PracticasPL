<div class=text-justify>
    
# Entrega 2

Juan, al darse cuenta de que podía hacer su propio lenguaje de programación, se emocionó. La adrenalina fue tal que corrió enseguida a enseñarlo a su profesor de compiladores, un programador de renombre. Cuando el profesor de Juan vio lo que había hecho, se quedó a cuadros. Le explicó que por mucho que quisiera a su cabra y sus raíces españolas, nadie iba a entender una línea de código. Era como si Juan se inventara un idioma e intentara comunicarse con el resto del mundo a través de ese idioma. El pobre Juan se derrumbó (quiere mucho a su cabra), pero después de meditarlo mientras devoraba un cocido, se dio cuenta de que tenía que aclarar más su lenguaje. Juan está triste.

## Cambios en la especificación de la sintaxis
- Para las instrucciones de lectura y escritura se usarán las palabras reservadas `read` y `print`, seguidas de la variable a leer o la expresión que escribir entre paréntesis.
    ```
    int input;    # declara un entero
    read(input);  # lee un entero y lo almacena en input
    print(input); # escribe el contenido de input
    ```
- Para declarar arrays estáticos se usará el operador `[num_elementos]` detrás del tipo del array. `int[4] array;  #declara un array de 4 enteros`. Para acceder a los elementos de un array también se usa `[]`, indicando en su interior la posición a la que se quiere acceder, empezando en 0.  `array[0];  #accede al primer elemento de array`. Se podrá inicializar un array indicando todos los elementos dentro de `[]`, separándolos por `,`:
    `int[5] array1 = [0, 1, 2, 3, 4]; #declara un array de 5 enteros`
    Para arrays multidimensionales se añadirán `[]` tantas veces como dimensiones se quieran, indicando la cantidad de elementos de cada dimensión. Para acceder a elementos en arrays de más de una dimensión se hará igual que en una dimensión, concatenando `[]` por cada dimensión, indicando la posición que se quiera en cada caso (todas indexadas en 0).
    ```
    bool[10] b;             # array de 10 booleanos
    
    int[5][5] mat;          # array bidimensional de enteros (5x5)
    mat[0][0]               # primer elemento de la matriz
    
    int[2][10][4] cuboid; # array tridimensional de enteros (2x10x4)
    cuboid[1][9][3];        # elemento en la posición 1,9,3
    ```
- La palabra reservada para el bucle `ajo` se convierte en la palabra reservada `while`
    ```
    while (expresión booleana) {  
        cuerpo del bucle
    } 
    ```
    No hemos añadido sintaxis para el bucle for, pero estamos considerando introducirlo en un futuro.
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
- La estructura de los registros cambia: la palabra 'lleva' se convierte en `has` y la palabra `cocido` en `struct`. La forma de declarar un struct es la siguiente:
    ```
    struct nombre_registro has {
      variables_registro;
    };
    ```
    Un struct puede contener variables o tipos definidos por el usuario además de funciones y procedimientos. Hay una forma alternativa de declarar un struct: `(variable_1, ... ,variable_n)`. Esta sintaxis funciona como un constructor por defecto de un registro. Para poder acceder a los distintos campos de un registro se usa el operador `.`:
    ```
    struct mi_struct has {
        int a;
        int b;
    }
    mi_struct s = (2, 3); # inicializa el registro
    s.a; #accede al campo a
    s.b; #accede al campo b
    ```
    
- La palabra reservada para las funciones `cabra` se convierte en la palabra reservada `fun`. Para evaluar una función, se cambia la palabra `come` por `eval`.
    ```
    fun tipo_función nombre_función (parámetros){
        cuerpo de la función
    }
    ...
    nombre_fun eval (parámetros);   
    ```
    Haremos una distinción para aquellas funciones que no devuelvan nada. En vez de imponer un tipo vacío, usaremos la palabra `proc`(procedimiento). Su sintaxis es similar a las funciones, cambiando `eval` por `exec`:
    ```
    proc nombre_procedimiento (parámetros){
        cuerpo_procedimiento
    }
    ...
    nombre_proc exec (parámetros);
    ```
    En el caso de que una función o procedimiento no tenga parámetros, para llamarlos no hará falta escribir `eval` ni `exec`.
    Como los registros tienen la misma sintaxis que los parámetros de funciones y procedimientos por el momento se tratan igual en el ast. Más adelante veremos si es necesario tratar los parámetros como un struct o no.
 - Para poder definir tipos se utiliza la palabra `typedef` seguida del nombre del tipo y el tipo: `typedef nombre_tipo declaración_tipo`. Por ejemplo, el siguiente código crearía los tipos `entero`, `fraction`, `pair_int`, `pair_bool`:
    ```
    typedef entero int;
    typedef fraction (int num, int den);
    typedef pair_int (int fst, int snd);
    typedef pair_bool (bool fst, bool snd);
    ```
    Es decir, para definir un tipo hay dos opciones: o bien "renombrar" un tipo ya definido, o bien utilizar un struct como nuevo tipo, usando los nombres de las variables del registro para acceder a los campos del nuevo tipo. Con esta notación estamos permitiendo crear tipos cuyos campos sean funciones. Por ejemplo, para declara un tipo vector2D podríamos hacer:
    ```
    typedef vector2D (int x, int y,
                      fun int norm2() { return x^2+y^2; });
    ```
 - Se pueden declarar tanto referencias como punteros a variables. Para las referencias se usa la palabra reservada `ref` seguida de la variable referenciada. Para los punteros se usa la palabra `pointer` seguida de la variable apuntada. Por ejemplo, el siguiente fragmento indica que `r` es una referencia a un entero y `p` un puntero a un booleano:
    ```
    ref int r;           #referencia
    pointer bool p;      #puntero
    ```
    Para poder acceder a la referencia de una variable se usará la sintaxis `pointer(variable)`, y para acceder al valor de un puntero se usará la sintaxis `ptrval(puntero)`.
    ```
    int num1 = 5;
    pointer int p = pointer(num1);  #puntero a num1
    int num2 = ptrval(p);           #valor apuntado por p 
    ```
    Por último, añadimos el valor `null` para punteros que no apunten a nada. Por ejemplo, para declarar un puntero vacío a un tipo definido por el usuario:
    ```
    typedef mi_tipo (int a, int b);
    pointer mi_tipo p = null;
    ```
 - Para definir una clase se usará la palabra `class` seguida del nombre de la clase y la definición de la clase. Una clase estará compuesta de 3 secciones: atributos, constructor y métodos. Primero habrá que declarar los atributos usando la palabra `atributtes`, luego el constructor usando la palabra `constructor` y por último los métodos usando la palabra `methods`. Los atributos de una clase son privados y no se podrá acceder a ellos desde fuera de la clase. Un atributo no puede ser una función o un procedimiento. Desde fuera de la clase sólo se podrá acceder a los métodos. Para declarar el constructor se usará una sintaxis similar a la de las funciones y procedimientos. Un esquema de cómo crear una clase sería el siguiente:
    ``` 
    class nombre_clase {
        atributes {
            atributos de la clase
        }
        constructor (atributos) {
            cuerpo_constructor
        }
        methods {
            funciones y procedimientos de la clase
        }
    }
    ```
    Para inicializar una clase se usará la palabra reservada `constructor` seguida del nombre de la clase y de los atributos que tiene su constructor. Para acceder a los métodos de una clase se usa el operador `.` seguido del nombre del método y los argumentos que necesite. El siguiente código declara y crea una clase:
    ```
    typeDef pair (int fst, int snd);
    class clase {
        atributes {
            int num;
            pointer pair ptr;
        }
        constructor (int _num, pointer pair _ptr) {
            num = _num;
            ptr = _ptr;
        }
        methods {
            fun int getNum(){
                return num;
            }
            proc print_pair(){
                print(ptrval(ptr).fst);
                print(ptrval(ptr).snd);
            }
        }
    }
    
    int a = 3;
    int b = 4;
    pair par = (a, b);
    
    :clase mi_clase = constructor clase(a, refval(par)); # crea la clase
    
    int c = mi_clase.getNum();   #llama a getNum de la clase
    mi_clase.print_pair();       #llama a print_pair de la clase
    ```
    
    
## Implementación
    
    
En primer lugar, hemos creado una primera versión del analizador léxico, con la mayoría de instrucciones que tendrá nuestra versión del lenguaje, pero no todas (por ejemplo, las clases no están declaradas todavía). También está creada la gramática que reconoce nuestro lenguaje.
    
Hemos empezado con la construcción del árbol ast. Al igual que con la parte léxica, no está todo lo que queremos añadir todavía. Hemos decidido que preferimos comprobar que lo que hacemos funciona poco a poco para poder detectar posibles fallos antes de tener todo construido. 
    
Cada token que está implementado en el ast tiene su correspondiente implementación en la parte gramatical (archivo ConstructorAST.cup).
    
Hemos probado distintos ejemplos con diferentes instrucciones para comprobar que el ast se genera correctamente. Estos ejemplos están junto al ćodigo (los .txt).
    
En cuanto a la gestión de errores, se detectan todos los errores de sintaxis y se indica en qué fila y columna del código se ha producido cada error (de hecho es la madre de Juan quien le riñe por no saber programar).
    
Por último, no hemos empezado la parte de generar código usando WebAssembly, y será lo primero que hagamos después de esta entrega.
</div>
