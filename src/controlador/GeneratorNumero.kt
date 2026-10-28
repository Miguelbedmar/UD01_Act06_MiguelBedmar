package controlador

import modelo.Usuario

enum class tipoResultado { NO_PERMITIDO, FUERA_RANGO, MAYOR, MENOR, IGUAL }
class GeneratorNumero() {

    private val numeroSecreto = (1..100).random() // generamos un numero de un rango del 1 al 100

    /**
     * Con el metodo comprobarNumero hacemos que está clase se convierta en la responsable principal de  generar el numero
     * y de comprobar si el usuario a acertado que en ese caso aumentamos el contador o si el numero ha sido mayor , menor o igual
     * **/
    fun comprobarNumero(usuario: Usuario, numeroIntroducido: Int): tipoResultado {
        if (!usuario.mayorEdad()) return tipoResultado.NO_PERMITIDO //Evitamos que personas menores de edad  puedan ingresar al programa
        if (numeroIntroducido !in 1..100) return tipoResultado.FUERA_RANGO // Le indicamos al usuario que  se ha salido de rango.

        usuario.numeroIntentos() // Aumentamos contador

        return when { // Por medio de un when comprobamos los casos
            numeroIntroducido > numeroSecreto -> tipoResultado.MAYOR // En el caso de que el numero sea mayor
            numeroIntroducido < numeroSecreto -> tipoResultado.MENOR
            else -> tipoResultado.IGUAL
        }
    }


}