package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.ui.theme.VitalTheme

@Composable
fun HistoricoDeConsultas(controleDeNavegacao: NavHostController, idUsuario: Int) {
    // Estados para os cards adicionais
    val isCardProximaVisible = remember { mutableStateOf(false) }
    val isCardConcluidaVisible = remember { mutableStateOf(false) }
    val isCardCanceladaVisible = remember { mutableStateOf(false) }

    VitalTheme {
        Surface {
            Box(
                modifier = Modifier
                    .background(
                        Color(0xFF2954C7),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    )
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(top = 20.dp)
            ) {
                // Icon clicável para voltar
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                        .clickable {
                            controleDeNavegacao.navigate("telaInicio/$idUsuario")
                        }
                )
                Text(
                    "Consultas",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.align(Alignment.Center)
                )

                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .align(Alignment.Center)
                        .offset(y = 40.dp)
                        .width(90.dp)
                        .fillMaxWidth()
                        .background(Color(0xFFC6E1FF), shape = RoundedCornerShape(20.dp))
                        .zIndex(1f)
                ) {
                    Text(
                        text = "Histórico",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF565454),
                        modifier = Modifier
                            .align(Alignment.Center)
                    )

                }

            }
                Column(
                    modifier = Modifier
                        .padding(top = 200.dp)
                        .padding(16.dp)
                ) {

                }

                // Conteúdo rolável
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 250.dp, start = 16.dp, end = 16.dp)
                        .fillMaxSize()
                ) {
                    // Próximas Consultas
                    item {
                        Text(
                            text = "Próximas",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Especialidade: Ginecologia",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Icon(
                                        imageVector = Icons.Filled.MoreVert,
                                        contentDescription = "Info",
                                        tint = Color.Black,
                                        modifier = Modifier.clickable {
                                            isCardProximaVisible.value = !isCardProximaVisible.value
                                        }
                                    )
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "Médico : Pietra Volpato", color = Color(0xFF0073DE))
                                Text(text = "Data: 28/08/24", fontWeight = FontWeight.Bold)
                            }
                        }

                        // Detalhes do card Próxima Consulta
                        if (isCardProximaVisible.value) {
                            DetalhesCard(
                                titulo = "Detalhes da Próxima Consulta",
                                descricao = "Informações específicas sobre a consulta futura.",
                                onClose = { isCardProximaVisible.value = false }
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))
                    }

                    // Consultas Concluídas
                    item {
                        Text(
                            text = "Concluídas",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Especialidade: Cardiologia",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Icon(
                                        imageVector = Icons.Filled.MoreVert,
                                        contentDescription = "Info",
                                        tint = Color.Black,
                                        modifier = Modifier.clickable {
                                            isCardConcluidaVisible.value = !isCardConcluidaVisible.value
                                        }
                                    )
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "Médico : Dr. João Silva", color = Color(0xFF0073DE))
                                Text(text = "Data: 20/07/24", fontWeight = FontWeight.Bold)
                            }
                        }

                        // Detalhes do card Consulta Concluída
                        if (isCardConcluidaVisible.value) {
                            DetalhesCard(
                                titulo = "Consulta Concluída",
                                descricao = "Esta consulta foi concluída com sucesso. O paciente realizou exames de rotina, incluindo eletrocardiograma e ecocardiograma, que apresentaram resultados normais. Orientações foram dadas para manter hábitos saudáveis, como dieta equilibrada e prática de exercícios regulares. Retorno agendado para acompanhamento em 6 meses.",
                                onClose = { isCardConcluidaVisible.value = false }
                            )

                        }

                        Spacer(modifier = Modifier.height(18.dp))
                    }

                    // Consultas Canceladas
                    item {
                        Text(
                            text = "Canceladas",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Especialidade: Pediatria",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Icon(
                                        imageVector = Icons.Filled.MoreVert,
                                        contentDescription = "Info",
                                        tint = Color.Black,
                                        modifier = Modifier.clickable {
                                            isCardCanceladaVisible.value = !isCardCanceladaVisible.value
                                        }
                                    )
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "Médico : Dra. Ana Costa", color = Color(0xFF0073DE))
                                Text(text = "Data: 15/06/24", fontWeight = FontWeight.Bold)
                            }
                        }

                        // Detalhes do card Consulta Cancelada
                        if (isCardCanceladaVisible.value) {
                            DetalhesCard(
                                titulo = "Detalhes da Consulta Cancelada",
                                descricao = "Motivo do cancelamento: indisponibilidade do médico.",
                                onClose = { isCardCanceladaVisible.value = false }
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))
                    }
                }

        }
    }
}

@Composable
fun DetalhesCard(titulo: String, descricao: String, onClose: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(text = titulo, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = descricao, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onClose() }) {
                Text("Fechar")
            }
        }
    }
}