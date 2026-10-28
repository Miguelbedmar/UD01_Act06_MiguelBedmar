package main

import java.util.Locale
import java.util.Scanner
import controlador.tipoResultado
import  controlador.GeneratorNumero
import modelo.Usuario

val sc = Scanner(System.`in`).useLocale(Locale.US)
val usuario = Usuario()
val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m" // Reseteamos el color al terminar el mensaje de error
fun main() {
empezarJuego()
}

// Función responsable  de dar inicio al programa
fun empezarJuego() {
println("<====ADIVINAREITOR DEL SECRETO========>")
    creacionUsuario()
    if(!usuario.mayorEdad()) {
        println("${ROJO} Lo sentimos ${usuario.getNombre()} debes de tener al menos 18 años para poder jugar $RESET")
        return
    }
    println("!Bienvenido ${usuario.getNombre()}! Disfrute la experiencia")
    jugar(GeneratorNumero())
}

/**En esta función registraremos al usuario
 * pidiendole nombre y edad en bucles distintos
 * para tratar las excepciones por separado
 * **/
fun creacionUsuario() {
    var salir = false

    while (!salir) {
        try {
            print("Ingrese su nombre ")
            val nombre = sc.nextLine().trim()

            if (nombre.isEmpty()) { // Comprobamos si el nombre está vacio
                print("${ROJO}El nombre no debe de estar vacio$RESET")
            } else {
                usuario.setNombre(nombre) // Si el pasa las validaciones registramos el nombre de nuestro usuario.
                salir = true // Finalizamos el primer bucle para poder validar la edad al usuario
            }

        } catch (e: NoSuchElementException) {
            print("${ROJO} ERROR!: Has salido fuera del fichero$RESET")
            salir = true
        } catch (e: IllegalAccessError) {
            print("${ROJO} ERROR! Valor introducido no válido$RESET")
        }
    }
    while (salir) {
        try {

            println("Ingrese su edad")
            val edad = sc.nextLine().trim().toIntOrNull() // Leemos la edad como String para parsear a un entero

            if (edad == null || edad <= 0) { // Comprobamos si la edad que ha introducido el usuario es válida
                println("${ROJO}ERROR!:la edad introducida no es válida$RESET")
            } else {
                usuario.setEdad(edad)
                return
            }

        } catch (e: NoSuchElementException) {
            println("${ROJO} ERROR!: Has salido fuera del fichero$RESET")
            salir = true
        } catch (e: IllegalAccessError) {
            println("${ROJO} ERROR! Valor introducido no válido$RESET")

        }
    }
}
/**La función jugar controlara la partida principal
 * Es la encarga de solicitarle el numero al usuario y validarlo
 * para ello leo el número como un string , eliminos los posibles espacios y
 * despues lo convierto a entero con toIntOrNull()
 * **/
fun jugar(generatorNumero: GeneratorNumero) {
    var numeroAcertado = false

    while (!numeroAcertado) {
        print("Introduce un numero entre 1 y 100 ")
        val numero =
            sc.nextLine().trim().toIntOrNull() // Al leer el numero como string realizamos una converción a entero

        if (numero == null) {
            println("${ROJO}ERROR!debes introducir un numero válido$RESET ")
            continue
        }
        /** Con el numero validado , comparamos el numero ingresado con el numero generado.
         * compruebo la edad del usuario
         * si el numero se encuentra fuera de rango
         * si es mayor
         * si es menor
         * o si ha acertado el numero
         * si acierta el numero mostramos el nombre con el que se registro y la cantidad de intentos**/
        when (generatorNumero.comprobarNumero(usuario, numero)) {
            tipoResultado.NO_PERMITIDO -> {
                println("${ROJO}Se ha detectado que tu edad no cumple los requisios para jugar $RESET ")
                return
            }
            tipoResultado.FUERA_RANGO -> println("${ROJO} ERROR! te has salido del rango permitido $RESET ")
            tipoResultado.MAYOR -> println("El número secreto es menor ")
            tipoResultado.MENOR -> println("El número secreto es mayor ")
            tipoResultado.IGUAL -> {
                println("FELICIDAD! Has adivinado el número ")
                println("${usuario.getNombre()},has adivinado el número  ${usuario.getCantidadIntentos()} intentos")
                numeroAcertado = true
                print("Hasta la proxima ${usuario.getNombre()}")
            }
        }


    }


}




