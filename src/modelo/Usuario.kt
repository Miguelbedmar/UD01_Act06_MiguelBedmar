package modelo

class Usuario() {

    //ATRIBUTOS
    private var nombre = ""
    private var edad = 0
    private var cantidadIntentos = 0

    //Constructor
    constructor (
        nombre: String,
        edad: Int, cantidadIntentos: Int
    ) : this() { // con this  indicamos a kotlin que este constructor pertenece a la clase Usuario
        this.nombre = nombre
        this.edad = edad
        this.cantidadIntentos = cantidadIntentos
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

    fun getCantidadIntentos(): Int {
        return cantidadIntentos
    }

    fun setCantidadIntentos(cantidadIntentos: Int) {
        this.cantidadIntentos = cantidadIntentos
    }


    // El metodo comprobar edad  validara si la edad del usuario es igual o superior a 18.
    fun mayorEdad(): Boolean = edad >= 18

    //Por cada acierto el contador subira
    fun numeroIntentos() {
        cantidadIntentos++
    }

    override fun toString(): String {
        return "Usuario(nombre='$nombre', Edad=$edad), cantidadIntentos=$cantidadIntentos"
    }



}