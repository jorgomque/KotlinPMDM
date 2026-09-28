/**
 *  Programa que pide al usuario un número hata que introduzca 0
 *  luego muestra el mayor, el menor y el promedio
 *  @author Jorge Gómez
 * @version 1.0
 *
 */
fun main() {
    //No se usa un array ya que habria que predefinir el tamaño, y es indefinido porque depende del usuario
    var userInput= 0
    var userNumbersIntroduced = 0
    var totalValue = 0
    var minValue = 0
    var maxValue = 0

    do {
        try {
            println("Introduce un número")
            userInput = readln().toInt()
            if (userInput == 0) throw Exception("Número 0 introducido")
            //Se hace asi para actualizar por primera vez estos valores ya que no se esta usando un array
            if (userNumbersIntroduced == 0){
                minValue = userInput
                maxValue = userInput
            }
            if (userInput> maxValue) maxValue = userInput
            if (userInput< minValue) minValue = userInput
            totalValue += userInput
            userNumbersIntroduced ++
        } catch (e: NumberFormatException) {
            println("Se ha introducido algo distinto a un número")
        }
        catch (e: Exception){
            println(e.message)
        }
    }while (userInput != 0)

    if (userNumbersIntroduced != 0){
        println("""
            El número mas pequeño introducido es: $minValue
            El número mas grande introducido es: $maxValue
            "El promedio de los números introducidos es:${(totalValue/userNumbersIntroduced).toDouble()} "
        """.trimIndent())
    }
    else{
        println("No se han introducido números")
    }
}