package modelo

class Usuario() {

    //ATRIBUTOS
    private var nombre = ""
    private var edad = 0
    private var cantidadAciertos = 0

    //Constructor
    constructor (
        nombre: String,
        edad: Int, cantidadAciertos: Int
    ) : this() { // con this  indicamos a kotlin que este constructor pertenece a la clase Usuario
        this.nombre = nombre
        this.edad = edad
        this.cantidadAciertos = cantidadAciertos
    }

    // METODOS GETTERS Y SETTES.

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre

    }

    fun getEdad(): Int {
        return edad
    }

    fun setEdad(edad: Int) {
        this.edad = edad
    }

    fun getCantidadAciertos(): Int {
        return cantidadAciertos
    }

    fun setCantidadAciertos(cantidadAciertos: Int) {
        this.cantidadAciertos = cantidadAciertos
    }


    // El metodo comprobar edad  validara si la edad del usuario es igual o superior a 18.
    fun mayorEdad(edad: Int): Boolean = edad >= 18



}