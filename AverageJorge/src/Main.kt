/**
 *  Programa que pide al usuario la nota de 5 examenes
 *  y calcula la nota total y la media sin recorrerlo con un bucle
 *  @author Jorge Gómez
 * @version 1.0
 *
 */
fun main() {
    val grades = DoubleArray(5)

    for (i in  0 .. 4){
        println("Introduce la nota ${i +1}")
        val userNumber = readln().toDouble()
        grades[i] = userNumber
    }
    //Se calcula posicion por posicion para no usar un bucle ya que sabemos que solo va  a haber 5 valores
    val totalGrades = grades[0] + grades[1] + grades[2] +grades[3] +grades[4]
    val averageGrade = totalGrades/grades.size

    println("La nota total es de: $totalGrades")
    println("La nota promedio es de: $averageGrade")

}