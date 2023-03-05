## Especificación de la sintaxis del lenguaje de programación
Pablo Cageao Honduvilla, Pablo Heredero García, Jaime Romo González   
#### Aclaración previa:
Como grupo de trabajo hemos decidido darle un toque divertido a nuestro lenguaje de programación, como se puede comprobar a continuación. Nuestra intención es que así nos lo pasemos mejor trabajando con él y resulte más ameno. Los detalles que hemos añadido en este aspecto se reducen fundamentalmente a los nombres de buena parte de los comandos. La estructura interna del lenguaje será prácticamente idéntica a la de C++, ya que es el lenguaje que más hemos utilizado y más conocemos. Nuestro compromiso con el trabajo es total, y el objetivo último es obtener una práctica final seria y ajustada a las exigencias de la entrega. En ningún caso estos cambios referidos suponen una falta de compromiso, seriedad o respeto ni hacia la asignatura ni el profesor.  
Aún con ello, estas directrices que a continuación detallamos están sujetas a cambio, y en caso de necesidad durante el desarrollo podrán modificarse buena parte de ellas.  

### Nombre del lenguaje
  Juan (extensión jn).  
  La idea es crear un lenguaje en el que solo Juan pueda expresarse. Juan somos todos. Todos somos Juan.

### Identificadores y ámbitos de definición
- Declaración de variables simples y de arrays de cualquier tipo, incluidos otros arrays:  
  Juan es una persona muy poco original, y le encanta C++. Por ello, la declaración de identificadores y variables quiere hacerlas igual:  
  ```tipo nombre_variable;```

- Bloques anidados:  
  Usaremos llaves {} para definir el contenido de cada bloque.  
- Funciones:
  Juan tiene una cabra. A Juan le encanta su cabra, y quiere que esté presente en su lenguaje de programación. Por ello, para definir cualquier función, hay que escribir "cabra" antes que nada:  
  ```
  cabra tipo_fun nombre_fun (parámetros) {  
    cuerpo_fun  
  }  
  ```
  Los parámetros se podrán pasar por valor o referencia.  
  La declaración de las funciones podrá hacerse antes de escribir el cuerpo de las mismas, y de hecho será recomendable hacerlo al principio del programa.  
- Punteros:  
  Juan es un aburrido y define los punteros como en C++:  
  ```
  tipo_punt * nombre_punt;  
  ``` 
- Registros:  
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
- Tipos básicos predefinidos: enteros y booleanos:  
  Igual que en C++. Los enteros con la palabra reservada int. Los booleanos con la palabra reservada bool. En el caso de los booleanos, podrán tomar los valores "true" o "false" (con minúscula).   
  
- Operadores infijos, con distintas prioridades y asociatividades para estos tipos: exactamente igual que en C++, con +,-,/,*,&,|,==,!=, etc.  
- Tipo array: 
  Igual que en C++:
  ```
  tipo nombre_array[cantidad];
  ```
  
- Comprobación de tipos  
### Conjunto de instrucciones del lenguaje
- Instrucción de asignación incluyendo elementos de arrays:  
  Para asignaciones de variables y arrays, usaremos el operador =, con la misma estructura que en C++.
  A parte a Juan le gustaria que hubiera un operador := que copiara elemento a elemento arrays y structs, pero Juan esta muy ocupado recibiendo regañinas de su madre como para hacerlo si es muy complicado.
  
- Condicional con una y dos ramas: 
  No lo hemos dicho, pero Juan es Gallego. Le encantan los pimientos del Padrón. A veces pican, a veces no. Perfecto para un condicional. De esta forma, introduciremos, para la sintaxis del condicional con una rama, lo siguiente:  
  ```
  pican(expresion_booleana){
    cuerpo_if;
  }
  ```  
  Por otro lado, y siguiendo en la misma línea, para el condicional con dos ramas, haremos lo siguiente:  
  ```
  si_pican(expresion_booleana){
    cuerpo_if;
  }
  no_pican{
    cuerpo_else;
  }
  ```  
- Algún tipo de bucle:  
  Introduciremos en nuestro lenguaje una expresión de tipo While para poder manejar bucles. La estructura será, como viene siendo habitual, igual que la de C++. Sin embargo, a Juan no le gusta la palabra while. Sin embargo lo que sí que le gustan son los ajos. El único problema que tienen es que cuando los comes, se repiten. Es por ello que nuestra sintaxis para el bucle while será la siguiente: 
  ```
  ajo(expresion_booleana){
    cuerpo_bucle;
  }
  ```
- Expresiones formadas por constantes, operadores infijos y identificadores sin subindices:
  Como aburrido que es Juan, lo hará como en C++
- identificadores con subíndices (para acceso a arrays):
  Para acceder a los elementos de un array, usaremos el operador [], igual que en C++ (a Juan le gusta mucho C++, por si no ha quedado claro).  
  Juan odia modernezes como python, matlab o julia, pero le parece que una indexacion como la de python [:] le ahorraria tiempo que podria pasar con sus cabras, así que si no es muy dificil a lo mejor introducirá esa indexacion en su lenguaje:
  ```
  nombre_array[n:m]
  ```
  sería quivalente a 
  ```
  [nombre_array[n],...,nombre_array[m-1]]
  ```
- llamadas a función:   
  Las funciones son como las cabras de Juan, tu les das de comer hierba (o argumentos) y las cabras te dan queso a cambio (o lo que sea, dios sabe lo que lleva la comida de las cabras) con lo cual Juan ha decidico que la sintaxis para llamar a una función va a ser la siguiente
  ```
  nombre_fun come (parámetros) 
  ```
  Si no fuera muy complicado, Juan se habia planteado que sus cabras coman cocidos, y de igual forma, sus funciones puedan recibir estructuras con forma de sus argumentos (identificados por nombres o orden)
  Por ejemplo
  ```
  cabra int peter(int a, int b);
  cocido macarrones lleva{
      int a;
      int b;
  }
  peter come instancia_macarrones
  ```
- Expresiones con punteros y nombres cualificados (notación “.” en presencia de clases o registros):   
  Juan es un aburrido y trata los punteros y los nombre cualificadores come en C++.
### Gestión de errores
- Indicación del tipo de error, fila y columna
- Parar la compilación
- Recuperación de errores
Por el momento no sabemos con precisión cómo vamos a desarrollar esos aspectos, lo iremos decidiendo según lo veamos en teoría con mayor profundidad. Lo único que Juan tiene claro es que una madre siempre está ahi para corregir a su hijo y avisarle de sus errores para poder mejorar. Así la madre de Juan, Juana, avisará a su hijo si hay algún error en el código con el siguiente mensaje:  
```
Muy mal Juan, tienes un error (tipo_error) en la linea __, columna __.
```
