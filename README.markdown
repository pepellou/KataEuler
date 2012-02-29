Kata Euler
==========

El propósito de esta kata es practicar refactors sobre código de carácter algorítmico.
Las katas de refactoring son muy útiles para permitir a programadores de todos los niveles dialogar y compartir formas de entender la programación sobre código existente.
La intención de esta kata no es enfocar el debate a ninguna cuestión en concreto, aunque el tipo de problema que se resuelve (problemas matemáticos de cierta complejidad computacional) se ha buscado intencionadamente como escenario típico donde el código pierde legibilidad y/o eficiencia, siendo estos dos temas mi sugerencia para centrar el debate. También se ha perseguido otra cuestión típica de refactoring, como es la reutilización de código, escogiendo como punto de partida un código que resuelve de forma separada varios problemas similares. 


Descripción de la Kata
----------------------

Por cuestiones en las que no vamos a profundizar, hemos recibido un golpe de iluminación vital y hemos decidido que debemos resolver todos los problemas de [Project Euler](http://projecteuler.net/) para estar en paz con nosotros mismos. Como sabemos que es un camino largo, empezamos por resolver algunos de los más sencillos, concretamente los problemas 1, 2 y 10 (véase tag [start-kata-here](https://github.com/pepellou/KataEuler/tree/start-kata-here)).

Es en este punto donde se nos plantea una nueva duda metafísica: ¿vamos por el buen camino? ¡Pues claro que no! Acabamos de resolver apenas 3 problemas y ya nos cuesta entender nuestro propio código. 
Si queremos resolver cientos de problemas necesitaremos refactorizar nuestro código para:

1. Ser capaces de entenderlo solo con leerlo
2. Reutilizar código para no reinventar la rueda a cada paso
3. Reutilizar cálculos para no tardar siglos en resolver los problemas


Pequeña introducción a la refactorización
-----------------------------------------

### Qué es refactorizar

Existen muchos caminos para llegar al mismo objetivo, y existen muchas formas de hacer el mismo código.
Refactorizar es transformar un código sin cambiar lo que hace, en base a determinadas reglas conocidas.
Es, por ejemplo, lo mismo que hacemos cuando escribimos 2/3 en lugar de 6/9: aplicamos una regla conocida para simplificar una expresión, sabiendo que su valor no cambia.

Es importante señalar que las reglas para refactorizar van en los dos sentidos. Hay veces que nos interesa la expresión 2/3 porque es más simple, y otras que nos interesará la forma 6/9 (si, por ejemplo queremos sumarla con otra fracción como 5/9). Del mismo modo, por ejemplo, estos dos códigos dan la misma funcionalidad:

    class NumeroEntero {

        private value;

        public NumeroEntero(int num) {
            this.value = num;
        }

        public int doble() {
            return this.value * 2;
        }

    }

y

    class Numero {

        protected value;

        public Numero(int num) {
            this.value = num;
        }

    }

    class NumeroEntero extends Numero {

        public int doble() {
            return this.value * 2;
        }

    }

El que decidamos que es más correcto usar uno u otro dependerá de la situación que rodee a este código. Por ejemplo, si tenemos que modelar números que no son enteros o no.
Un par de reglas interesantes cuando se diseña software son KISS (Keep It Simple Stupid) y YAGNI (You Ain't Gonna Need It), que aplicadas en este caso nos sugerirían utilizar el primer código (lo más simple que funciona) mientras no tengamos la necesidad de usar el segundo.


### Por qué refactorizar

Existen "bad smells" en el código que sugieren que dejándolo así va a ser complicado de mantener. Es recomendable refactorizar cuando se da alguno de estos malos olores:

* Dificultad para entender la lógica
* Incapacidad de añadir nuevas funcionalidades por miedo a introducir bugs
* Muchos ficheros con miles de líneas de código
* Código duplicado
* Código procedimental
* Método con demasiadas líneas
* Métodos con demasiados parámetros
* Uso de construcciones switch
* Muchos comentarios de una sola línea

### Ejemplos de refactoring

#### Duplicación de código

    class Cliente {
        ...
        public int getEdad() {
            return today.year() - this.birthday.year();
        }
        ...
    }

    class Vendedor {
        ...
        public int getEdad() {
            return today.year() - this.birthday.year();
        }
        ...
    }

Parece que tiene sentido una superclase con el método getEdad():

    class Persona {
        public int getEdad() {
            return today.year() - this.birthday.year();
        }
    }

    class Cliente extends Persona {
        ...
    }

    class Vendedor extends Persona {
        ...
    }

Probablemente habrá más cosas (como birthday) que se podrían incluir en la superclase.

#### Método con demasiadas líneas

Comparemos:

    public static boolean checkFormat(String pattern, String guess) {
        if (pattern.length() != guess.length())
            return false;
        for (int pos = 0; pos < pattern.length(); pos++) {
            char pattChar = pattern.charAt(pos);
            char guessChar = guess.charAt(pos);
            switch (pattChar) {
                case 'D':
                    if (guessChar < '0' || guessChar > '9') {
                        return false;
                    }
                    break;
                default:
                    if (guessChar != pattChar) {
                        return false;
                    }
            }
        }
        return true;
    }
 
Con:

    public static boolean checkFormat(String pattern, String guess) {
        if (notSameLength(pattern, guess))
            return false;
        for (int pos = 0; pos < pattern.length(); pos++) {
            char pattChar = pattern.charAt(pos);
            char guessChar = guess.charAt(pos);
            if (!checkFormatOfChar(pattChar, guessChar))
                return false;
        }
        return true;
    }
    
    private static boolean checkFormatOfChar(char pattChar, char guessChar) {
        switch (pattChar) {
            case 'D':
                return (!isDigit(guessChar));
            default:
                return (guessChar == pattChar);
        }
    }
    
    private static boolean isDigit(char guessChar) {
        return !(guessChar < '0' || guessChar > '9');
    }
    
    private static boolean notSameLength(String pattern, String guess) {
        return pattern.length() != guess.length();
    }

Aunque el código resultante es más extenso, las responsabilidades están divididas y por tanto es más mantenible y legible.
Lo que no podemos evitar es la _verbosity_ del lenguaje. Cosas como:

        for (int pos = 0; pos < pattern.length(); pos++) {
            char pattChar = pattern.charAt(pos);
            ...
        }

en otros lenguajes se pueden hacer generando un código más simple y legible; por ejemplo en Ruby:

        pattern.each_char { |pattChar|
            ...
        }
