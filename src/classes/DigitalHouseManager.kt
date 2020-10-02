package classes

class DigitalHouseManager {
    val listaDeCursos: MutableList<Curso> = mutableListOf()
    val listaDeProfessores: MutableList<Professor> = mutableListOf()
    val listaDeAlunos: MutableList<Aluno> = mutableListOf()
    val listaDeMatriculas: MutableList<Matricula> = mutableListOf()

    fun registrarCurso(nome: String, qtdMaximaDeAlunos: Int = 40) {
            listaDeCursos.add(Curso(nome, qtdMaximaDeAlunos))
    }

    fun excluirCurso(codigoCurso: Int) {
            listaDeCursos.forEach {
                if (it.codigo == codigoCurso) {
                    listaDeCursos.remove(it)
                    return
                }
            }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome:String, qtdDeHoras: Int) {
        if (qtdDeHoras <= 0) {
            println("O número de horas deve ser maior do que 0.")
        } else {
            listaDeProfessores.add(ProfessorAdjunto(nome, sobrenome, qtdDeHoras))
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome:String, especialidade: String) {
        listaDeProfessores.add(ProfessorTitular(nome, sobrenome, especialidade))
    }

    fun excluirProfessor(codigoProfessor: Int) {
          listaDeProfessores.forEach {
              if (it.codigo == codigoProfessor) {
                  listaDeProfessores.remove(it)
                  return
              }
          }
    }

    fun registrarAluno(nome: String, sobrenome: String) {
        listaDeAlunos.add(Aluno(nome, sobrenome))
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno: Aluno? = encontrarAlunoPorCodigo(codigoAluno)
        val curso: Curso? = encontrarCursoPorCodigo(codigoCurso)

        aluno?.let {
            curso?.let {
                if (curso.numDeAlunosMatriculados() < curso.qtdMaxAlunos) {
                    listaDeMatriculas.add(Matricula(aluno, curso))
                    println("Aluno(a) cadastrado(a) com sucesso.")
                } else {
                    println("Não há vagas para esse curso.")
                }
            } ?: println("Curso com o código especificado não encontrado.")
        } ?: println("Aluno com o código especificado não encontrado.")

    }

    fun alocarProfessores(codigoCurso: Int, codigoProfTitular: Int, codigoProfAdjunto: Int) {
        val curso: Curso? = encontrarCursoPorCodigo(codigoCurso)
        val profTitular: ProfessorTitular? = encontrarProfTitPorCodigo(codigoProfTitular)
        val profAdjunto: ProfessorAdjunto? = encontrarProfAdjPorCodigo(codigoProfAdjunto)

        curso?.let {
            profTitular?.let {
                profAdjunto?.let {
                    curso.definirProfTitular(profTitular)
                    curso.definirProfAdjunto(profAdjunto)
                } ?: println("Professor Adjunto com o código especificado não encontrado.")
            } ?: println("Professor titular com o código especificado não encontrado.")
        } ?: println("Curso com o código especificado não encontrado.")
    }

    private fun encontrarAlunoPorCodigo(codigoAluno: Int): Aluno? {
        listaDeAlunos.forEach {
            if (it.codigo == codigoAluno)
                return it
        }
        return null
    }

    private fun encontrarCursoPorCodigo(codigoCurso: Int): Curso? {
        listaDeCursos.forEach {
            if (it.codigo == codigoCurso)
                return it
        }
        return null
    }

    private fun encontrarProfTitPorCodigo(codigoProfessor: Int): ProfessorTitular? {
        listaDeProfessores.forEach {
            if (it.codigo == codigoProfessor && it is ProfessorTitular)
                return it
        }
        return null
    }

    private fun encontrarProfAdjPorCodigo(codigoProfessor: Int): ProfessorAdjunto? {
        listaDeProfessores.forEach {
            if (it.codigo == codigoProfessor && it is ProfessorAdjunto)
                return it
        }
        return null
    }

}

