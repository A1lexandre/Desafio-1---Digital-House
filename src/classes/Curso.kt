package classes

class Curso(var cursoNome: String, var qtdMaxAlunos: Int) {

    var profTitular: ProfessorTitular? = null
    var profAdjunto: ProfessorAdjunto? = null

    // Alunos matriculados no curso
    var listaDeAlunos: MutableList<Aluno> = mutableListOf()

    fun adicionarAluno(aluno: Aluno): Boolean {
            if (listaDeAlunos.size < qtdMaxAlunos) {
                listaDeAlunos.add(aluno)
                return true
            }
        return false
    }

    fun excluirAluno(aluno: Aluno): Boolean {
        return listaDeAlunos.remove(aluno)
    }

    fun numDeAlunosMatriculados(): Int {
        return listaDeAlunos.size
    }

    fun definirProfTitular(prof: ProfessorTitular) {
        profTitular = prof
    }

    fun definirProfAdjunto(prof: ProfessorAdjunto) {
        profAdjunto = prof
    }

    // Componentes abaixo usados para gerar o
    // código automaticamente e incrementalmente
    var codigo: Int = 0

    companion object {
        var geradorDeCodigo: Int = 0
    }

    init {
        codigo = geradorDeCodigo++
    }
}
