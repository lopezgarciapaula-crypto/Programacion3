# Ejercicio 4 - Analisis del flujo de ejecucion

## Objetivo
Determinar que se ejecuta antes: la inicializacion de atributos en su
declaracion o el constructor.

## Codigo analizado
- Atributos con valores en la declaracion:
  - `nombre = "VALOR_DECLARACION"`
  - `altura = 9.99`
  - `peso = 999.0`
- Constructor que asigna otros valores:
  - `nombre = "VALOR_CONSTRUCTOR"`
  - `altura = 1.50`
  - `peso = 50.0`

## Breakpoints colocados
1. En el `main`, antes de `new Person()`.
2. En la declaracion `private String nombre = "VALOR_DECLARACION";`
3. En la linea `public Person() {`.

## Orden observado en Debug
1. `main` -> antes de `new Person()`
2. Se ejecuta la declaracion del atributo: `nombre` se inicializa a
   `"VALOR_DECLARACION"`.
3. Se ejecuta el constructor: empieza con `nombre = "VALOR_DECLARACION"`
   y lo cambia a `"VALOR_CONSTRUCTOR"`.
4. `main` -> despues de `new Person()`.

## Salida del programa