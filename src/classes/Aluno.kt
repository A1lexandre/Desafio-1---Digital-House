package classes

class Aluno(nome: String, sobrenome: String) : Pessoa(nome, sobrenome) {
    val codigo: Int

    // Componentes abaixo usados para gerar o
    // código automaticamente e incrementalmente
    companion object {
        var geradorDeCodigo: Int = 0
    }

    init {
        codigo = geradorDeCodigo++
    }
}
