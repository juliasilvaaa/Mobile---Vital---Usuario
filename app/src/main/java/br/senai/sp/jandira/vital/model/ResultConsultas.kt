package br.senai.sp.jandira.vital.model

data class ResultConsultas(
    val medico: List<Consultas>,
    val status_code: Int
)