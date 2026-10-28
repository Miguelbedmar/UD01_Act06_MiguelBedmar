package main

import java.util.Locale
import java.util.Scanner
import controlador.*
import modelo.Usuario

val sc = Scanner(System.`in`).useLocale(Locale.US)
val usuario = Usuario()
val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m" // Reseteamos el color al terminar el mensaje de error
fun main() {

}

// Función responsable  de dar inicio al programa
fun empezarJuego() {

}

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
                return
            }
        } catch (e: NoSuchElementException) {
            print("${ROJO} ERROR!: Has salido fuera del fichero$RESET")
            salir = true
        } catch (e: IllegalAccessError) {
            print("${ROJO} ERROR! Valor introducido no válido$RESET")
        }
    }
}
