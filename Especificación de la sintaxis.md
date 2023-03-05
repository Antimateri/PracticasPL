## Especificación de la sintaxis del lenguaje de programación
Pablo Cageao Honduvilla, Pablo Heredero García, Jaime Romo González   
#### Aclaración previa:
Como grupo de trabajo hemos decidido darle un toque divertido a nuestro lenguaje de programación, como se puede comprobar a continuación. Nuestra intención es que así nos lo pasemos mejor trabajando con él y resulte más ameno. Los detalles que hemos añadido en este aspecto se reducen fundamentalmente a los nombres de buena parte de los comandos. La estructura interna del lenguaje será prácticamente idéntica a la de C++, ya que es el lenguaje que más hemos utilizado y más conocemos. Nuestro compromiso con el trabajo es total, y el objetivo último es obtener una práctica final seria y ajustada a las exigencias de la entrega. En ningún caso estos cambios referidos suponen una falta de compromiso, seriedad o respeto ni hacia la asignatura ni el profesor.  
Aún con ello, estas directrices que a continuación detallamos están sujetas a cambio, y en caso de necesidad durante el desarrollo podrán modificarse buena parte de ellas.  

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
  Juan tiene una cabra. A Juan le encanta su cabra, y quiere que esté presente en su lenguaje de programación. Por ello, para definir cualquier función, hay que escribir "cabra" antes que nada:  
  ```
  cabra tipo_fun nombre_fun (parámetros) {  
    cuerpo_fun  
  }  
  ```
  Los parámetros se podrán pasar por valor o referencia. 
  La declaración de las funciones podrá hacerse antes de escribir el cuerpo de las mismas, y de hecho será recomendable hacerlo al principio del programa. 
- Punteros
  Juan es un aburrido y define los punteros como en C++:
  ```
  tipo_punt * nombre_punt;
  ``` 
- Registros  
  Juan es un buen español, y como tal, todos los domingos come cocido. Le encanta el cocido. De hecho, siempre dice: "Un cocido es como un struct, puedes   echarle de todo". Por ello, para declarar un registro, se usará la siguiente sintaxis:
  ```
  cocido nombre_registro lleva {
    variables_registro;
  };
  ```
  Además, Juan es una persona tradicional, así que los registros solo podrán estar formados por variables (no le gusta añadir cosas raras al cocido). Para acceder a un campo del registro, usaremos el operador . seguido del nombre de la variable correspondiente:
  ```
  nombre_registro.nombre_campo
  ```
  
### Tipos
- Tipos básicos predefinidos: enteros y booleanos  
  Igual que en C++. Los enteros con la palabra reservada int. Los booleanos con la palabra reservada bool.  
  
- Operadores infijos, con distintas prioridades y asociatividades para estos tipos: exactamente igual que en C++, con +,-,/,*,&,|,==, etc.
- Tipo array  
  Igual que en C++:
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
### Se valora
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
