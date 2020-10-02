package classes

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Matricula(var aluno: Aluno, var curso: Curso) {
    val dataMatricula: String

    init {
        val formataData = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        dataMatricula = LocalDate.now().format(formataData).toString()
    }
}
