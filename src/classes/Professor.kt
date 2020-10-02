package classes

abstract class Professor(nome: String, sobrenome: String) : Pessoa(nome, sobrenome) {
    var tempoDeCasa: Int = 0
    val codigo: Int

    // Componentes abaixo usados para gerar o
    // código dos professores automaticamente e
    // incrementalmente
    companion object {
        var geradorDeCodigo: Int = 0
    }

    init {
        codigo = geradorDeCodigo++
    }

}
