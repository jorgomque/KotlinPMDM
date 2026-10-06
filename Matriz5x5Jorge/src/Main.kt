import java.util.Random
const val ROWS = 5
const val COLUMNS = 5
fun main(){

    println("Buenos dias ")
    var menuOption : Int
    var matrix = Array(ROWS) { Array(COLUMNS) {0} }
    var userNumber: Int
    do {
        menuOption = menu()
        when (menuOption) {
            0 -> println("Gracias por usar el programa :)")
            1 -> {
                fillMatrix(matrix)
                println("Se lleno con exito")
            }
            2 -> {
                if (matrix[0][0] != 0) showMatrix(matrix)
                else println("La matriz esta vacia, usa la opcion 1")

            }
            3 -> {
                if (matrix[0][0] != 0) {
                    do {
                        println("Que fila quieres obtener(del 1 al $ROWS)")
                        userNumber = readln().toInt()
                    }while (userNumber !in 1..ROWS)
                    userNumber--
                    println("La suma es: ${sumOfARow(matrix,userNumber)}")

                }
                else println("La matriz esta vacia, usa la opcion 1")
            }


            4 ->  {
                if (matrix[0][0] != 0) {
                    do {
                        println("Que fila quieres obtener(del 1 al $COLUMNS)")
                        userNumber = readln().toInt()
                    }while (userNumber !in 1..COLUMNS)
                    userNumber--
                    println("La suma es: ${sumOfACol(matrix,userNumber)}")

                }
                else println("La matriz esta vacia, usa la opcion 1")
            }


            5 -> {
                if (matrix[0][0] != 0) {

                }
                else println("La matriz esta vacia, usa la opcion 1")

            }
            6 -> {
                if (matrix[0][0] != 0) {
                    println("La media es: ${showAverage(matrix)}")

                }
                else println("La matriz esta vacia, usa la opcion 1")

            }
            7 -> {
                if (matrix[0][0] != 0) {

                }
                else println("La matriz esta vacia, usa la opcion 1")

            }
        }

    } while (menuOption != 0)


}

fun fillMatrix(matrix: Array<Array<Int>>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            matrix[i][j] = (1..50).random()
        }
    }
}

fun showMatrix(matrix: Array<Array<Int>>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }
}

fun sumOfARow(matrix: Array<Array<Int>>, userRow: Int): Int{
    var totalValue = 0
    for (i in matrix.indices) {
         totalValue += matrix[i][userRow]
    }
    return totalValue
}

fun sumOfACol(matrix: Array<Array<Int>>, userCol: Int): Int{
    var totalValue = 0
    for (i in matrix.indices) {
        totalValue += matrix[userCol][i]
    }
    return totalValue
}

fun searchForANumber(matrix: Array<Array<Int>>){

}

fun showAverage(matrix: Array<Array<Int>>): Int{
    var totalValue = 0
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            totalValue += matrix[i][j]
        }
    }
        val totalSize = COLUMNS * ROWS
        return totalValue/totalSize
}

fun showTraspuesta(matrix: Array<Array<Int>>){

}

fun menu(): Int{
    var userNumber = 0

    do {
        var numberIsValid = true
        println(
            """
            Elige una opción :
            0. Salir
            1. Rellenar la matriz con números del 1 al 50
            2. Mostrar matriz
            3. Mostrar el total de una fila
            4. Mostrar el total de una columna
            5. Buscar un número
            6. Mostrar la media aritmetica
            7. Mostrar la matriz traspuesta
        """.trimIndent()
        )
        try {
            userNumber = readInt()
            if (userNumber !in 0..7) {
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