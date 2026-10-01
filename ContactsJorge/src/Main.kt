import java.util.Locale
import java.util.Locale.getDefault

fun main() {
    println("Buenos dias ¿me podrias decir tu nombre?")
    val userName = readln()
    var menuOption : Int

    var contacts: MutableMap<String, MutableList<String>> = mutableMapOf<String, MutableList<String>>()
    var contacts2: MutableSet<Map<String, MutableList<String>>> = mutableSetOf()
    do {
        menuOption = menu(userName)
        if (menuOption == 2) {

        }

        when (menuOption) {
            0 -> println("Gracias por usar la agenda :)")
            1 -> {
                if (contacts.isEmpty()) println("La agenda esta vacia")
                else showContacts(contacts)
            }
            2 -> {

                println("Introduce el nombre del contacto a agregar")
                val newName = readln()
                println("Introduce el apellido del contacto a agregar")
                val newSurname = readln()
                println("Introduce el email del contacto a agregar")
                val newEmail = readEmail()
                addContact(contacts, newName, newSurname, newEmail)

            }
            3 -> {
                if (contacts.isEmpty()) println("La agenda esta vacia")
                else {
                    println("Introduce el nombre del contacto para buscar")
                    val searchName = readln()
                    searchContact(contacts, searchName)
                }
            }

            4 ->  if (contacts.isEmpty()) println("La agenda esta vacia")
                else {
                    println("Introduce el nombre del contacto para borrar")
                    val searchName = readln()
                    deleteContact(contacts, searchName)
                }

            5 -> {
                if (contacts.isEmpty()) println("La agenda esta vacia")
                else contacts.clear()
            }
        }
    } while (menuOption != 0)



}
fun menu(userName: String): Int{
    var userNumber = 0

    do {
        var numberIsValid = true
        println(
            """
            Elige una opción $userName:
            0. Salir
            1. Mostrar agenda
            2. Guardar contacto
            3. Buscar contacto
            4. Borrar contacto
            5. Borrar agenda
        """.trimIndent()
        )
        try {
            userNumber = readInt()
            if (userNumber !in 0..5) {
                throw Exception("Opcion fuera del rango del menu")
            }
        }
        catch (e: Exception){
            numberIsValid = false
            println(e.message)
        }
    }while (!numberIsValid)
    return userNumber
}
fun showContacts(contacts: MutableMap<String, MutableList<String>>){

    for ((key, value) in contacts){
        println("Nombre:  $key Apellido: ${value[0]} Email: ${value[1]}")
    }
}

fun addContact(contacts: MutableMap<String, MutableList<String>>, name: String, surname: String, email: String){
    contacts[name] = mutableListOf(surname, email)
}
fun searchContact(contacts: MutableMap<String, MutableList<String>>, name: String){
    val filteredContacts = contacts.filter { it.key.contains(name, ignoreCase = true) }
    for ((key, value) in filteredContacts){
        println("Nombre:  $key Apellido: ${value[0]} Email: ${value[1]}")
    }
}
fun deleteContact(contacts: MutableMap<String, MutableList<String>>, name: String){
    val filteredContacts = contacts.filter { it.key.contains(name, ignoreCase = true) }
    if(filteredContacts.size == 1){
        contacts.remove(name)
    }
    else{
        println("Elige cual borrar (numero de la izquierda)")
        for (i in filteredContacts){
            println("$i. Contato: ${i.value[0]} Email: ${i.value[1]}")
        }
        val removeContactNumber = readInt()
        if (removeContactNumber >= filteredContacts.size || removeContactNumber < 0){
            println("Numero no valido")
        }
        else{
            contacts.remove(name, value = filteredContacts.values.toList()[removeContactNumber])

        }
    }
}
fun readInt() : Int{
    var userNumber = 0
    do {
        var numberIsValid = true
        try {
            println("Introduce un número entero")
            userNumber = readln().toInt()


        } catch (e: NumberFormatException) {
            numberIsValid = false
            println("El número no es valido!!")
        }
    }while(!numberIsValid)
    return userNumber

}

fun readEmail() : String{
    val checkEmail = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    var userEmail = ""
    do {
        var emailIsValid = true
        try {
            userEmail = readln()
            if (!userEmail.contains(checkEmail)) {
                throw Exception("Email no valido")
            }
        }catch(e:Exception){
            println(e.message)
            emailIsValid = false
        }
    }while(!emailIsValid)
    return userEmail
}