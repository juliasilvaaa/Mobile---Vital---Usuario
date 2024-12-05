package br.senai.sp.jandira.vital.model

data class Especialidade(
    // Atributos das especialidades
    var id_especialidade : Int = 0,
    var nome: String = "",
    var descricao: String = "",
    var imagem_url: String
)
