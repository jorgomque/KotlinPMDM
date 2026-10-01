

fun main() {
    println("Buenos dias ¿me podrias decir tu nombre?")
    val userName = readln()
    var menuOption : Int

    val contacts: MutableSet<MutableMap<String, String>> = mutableSetOf()
    do {
        menuOption = menu(userName)
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
                else {
                    contacts.clear()
                    println("Se ha borrado la agenda")
                }
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
fun showContacts(contacts: MutableSet<MutableMap<String, String>>){
    for (contact in contacts){
        println("Nombre: ${contact["nombre"]}, Apellidos ${contact["apellidos"]}, Email ${contact["email"]}")
    }

}

fun addContact(contacts: MutableSet<MutableMap<String, String>>, name: String, surname: String, email: String){
    val newContact = mutableMapOf(
        "nombre" to name,
        "apellidos" to surname,
        "email" to email,
    )
    if(contacts.add(newContact)) println("añadido con exito")
    else println("Ya existe un contacto identico, no se ha podido agregar")

}

fun searchContact(contacts: MutableSet<MutableMap<String, String>>, name: String){
    val filteredContacts = contacts.filter {
        it["nombre"].equals(name, ignoreCase = true)
    }
    if (filteredContacts.isEmpty()) {
        println("No hay ningun contacto con ese nombre")
        return
    }
    for (filteredContact in filteredContacts){
        println("Nombre: ${filteredContact["nombre"]}, Apellidos ${filteredContact["apellidos"]}, Email ${filteredContact["email"]}")
    }
}
fun deleteContact(contacts: MutableSet<MutableMap<String, String>>, name: String){
    val filteredContacts = contacts.filter {
        it["nombre"].equals(name, ignoreCase = true)
    }
    if (filteredContacts.isEmpty()) {
        println("No hay ningun contacto con ese nombre")
        return
    }
    if(filteredContacts.size == 1){
        contacts.remove(filteredContacts[0])
        println("Contacto eliminado")
    }
    else{
        println("Elige cual borrar (numero de la izquierda)")
        for (i in filteredContacts.indices){
            val filteredContact = filteredContacts[i]
            println("$i: Nombre: ${filteredContact["nombre"]}, Apellidos ${filteredContact["apellidos"]}, Email ${filteredContact["email"]}")
        }
        val removeContactNumber = readInt()
        if (removeContactNumber >= filteredContacts.size || removeContactNumber < 0){
            println("Numero no valido")
        }
        else{
            contacts.remove(filteredContacts[removeContactNumber])
            println("Contancto eliminado")

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
            if (!userEmail.matches(checkEmail)) {
                throw Exception("Email no valido")
            }
        }catch(e:Exception){
            println(e.message)
            emailIsValid = false
        }
    }while(!emailIsValid)
    return userEmail
}