## Especificación de la sintaxis del lenguaje de programación
Pablo Cageao Honduvilla, Pablo Heredero García, Jaime Romo González  

### Nombre del lenguaje
  Juan (extensión jn).  
  La idea es crear un lenguaje en el que solo Juan pueda expresarse. Juan somos todos. Todos somos Juan.

### Identificadores y ámbitos de definición
- Declaración de variables simples y de arrays de cualquier tipo, incluidos otros arrays  
  Juan es una persona muy poco original, y le encanta C++. Por ello, la declaración de identificadores y variables quiere hacerlas igual:
  ```tipo nombre_variable;```

- Bloques anidados
  Usaremos llaves {} para definir el contenido de cada bloque.
- Funciones
  Juan tiene una cabra. A Juan le encanta su cabra, y quiere que esté presente en su lenguaje de programación. Por ello, para definir cualquier función,     hay que escribir cabra:  
  ```
  cabra tipo nombre_fun (parámetros) {  
    cuerpo_fun  
  }  
  ```
  Los parámetros se podrán pasar por valor o referencia.
- Punteros
  Juan es un aburrido y define los punteros como en C++.
- Registros  
  Juan es un buen español, y como tal, todos los domingos come cocido. Le encanta el cocido. De hecho, siempre dice: "Un cocido es como un struct, puedes   echarle de todo". Por ello, para declarar un registro, se usará la siguiente sintaxis:
  ```
  cocido nombre_registro lleva {
    variables_registro;
  };
  ```
  Además, Juan es una persona tradicional, así que los registros solo podrán estar formados por variables (no le gusta añadir cosas raras al cocido). Para   acceder a un campo del registro, usaremos el operador . seguido del nombre de la variable correspondiente.    
  
### Tipos
- Tipos básicos predefinidos: enteros y booleanos  
  Igual que en C++. Los enteros con la palabra reservada int. Los booleanos con la palabra reservada bool.  
  
- Operadores infijos, con distintas prioridades y asociatividades para estos tipos
- Tipo array  
  Igual que en C++  
  ```
  tipo nombre_array[cantidad];
  ```
  Para acceder a los elementos de un array, usaremos el operador [], igual que en C++ (a juan le gusta mucho C++, por si no ha quedado claro).  
  
- Comprobación de tipos
### Conjunto de instrucciones del lenguaje
- Instrucción de asignación incluyendo elementos de arrays, condicional con una y dos ramas, y algún tipo de bucle
  Para asignaciones de variables y arrays, usaremos el operador :=  
  No lo hemos dicho, Juan es Gallego. Le encanta los pimientos del padrón. A veces pican, a veces no. SI pica, NO pica. Perfecto para un condicional. 
- Expresiones formadas por constantes, identificadores con y sin subíndices (para acceso a arrays), operadores infijos y llamadas a función
- Expresiones con punteros y nombres cualificados (notación “.” en presencia de clases o registros)
### Gestión de errores
- Indicación del tipo de error, fila y columna
- Parar la compilación
- Recuperación de errores
###Se valora
- Las funciones se pueden llamar opcionalmente como
    ```
    nombre_fun(arg) TE ELIJO A TI
    ```
    Sustituir ; por y
- operador España donde
    ```
    x España
    ```
  donde se aumenta una unidad x porque españa solo sale en arriva españa
