/**
 * Programa que pide al usuario un nombre, DNI, Edad, telefono y correo electronico
 * y comprueba con una expresion regular y excepciones si esta bien
 * @author Jorge
 * @version 1.0
 */
fun main() {
    val name: String
    val checkName = Regex ("[a-zA-Z-']{3,50}$")
    val dni: String
    val checkDni = Regex ("^[0-9]{7,8}\\-[A-Z]\$")
    val email : String
    val checkEmail = Regex("^[a-z0-9]{3,}@[a-z0-9.-]{2,}\\.[a-z]{2,3}$")
    /*
    try {
        println("Introduce tu nombre")
        name = readln()
        if (!name.contains(checkName)) {
            throw Exception("Nombre no valido")
        }
        println("El nombre $name es valido")
    }catch(e:Exception){
        println(e.message)
    }

    try {
        println("Introduce tu correo")
        email = readln()
        if (!email.contains(checkEmail)) {
            throw Exception("Email no valido")
        }
        println("El email $email es valido")
    }catch(e:Exception){
        println(e.message)

    }

     */
    try {
        println("Introduce tu dni")
        dni = readln()
        if (!dni.contains(checkDni)) {
            throw Exception("dni no valido")
        }
        println("El dni $dni es valido")
    }catch(e:Exception){
        println(e.message)
    }

}
