## Especificación de la sintaxis del lenguaje de programación
Pablo Cageao Honduvilla, Pablo Heredero García, Jaime Romo González  

### Identificadores y ámbitos de definición
- Declaración de variables simples y de arrays de cualquier tipo, incluidos otros arrays
tipo_variable nombre = declaración
- Bloques anidados
{...  
  {...  
  }  
}
- Funciones
tipo_funcion nombre_funcion (tipo_arg1 nombre_arg1, ...){  
...  
}
- Punteros
- Registros
struct nombre{  
  tipo1 nombre_campo1;  
  ...  
}
### Tipos
- Declaración explícita del tipo de las variables
- Tipos básicos predefinidos: enteros y booleanos
- Operadores infijos, con distintas prioridades y asociatividades para estos tipos
- Tipo array
- Comprobación de tipos
### Conjunto de instrucciones del lenguaje
- Instrucción de asignación incluyendo elementos de arrays, condicional con una y dos ramas, y algún tipo de bucle
- Expresiones formadas por constantes, identificadores con y sin subíndices (para acceso a arrays), operadores infijos y llamadas a función
- Expresiones con punteros y nombres cualificados (notación “.” en presencia de clases o registros)
### Gestión de errores
- Indicación del tipo de error, fila y columna
- Parar la compilación
- Recuperación de errores
