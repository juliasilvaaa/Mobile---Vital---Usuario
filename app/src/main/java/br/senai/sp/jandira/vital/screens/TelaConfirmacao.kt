package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.model.Usuario
import br.senai.sp.jandira.vital.ui.theme.VitalTheme

@Composable
fun TelaConfirmacao(
    controleDeNavegacao: NavHostController,
    idUsuario: Int
) {

    VitalTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Pai que envolve a Box azul e o Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(650.dp)
                ) {
                    // Box azul com limite inferior
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(380.dp)
                            .background(
                                color = Color(0xFFC6E1FF),
                                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                            )
                    ) {
                        // Ícone de voltar no topo esquerdo
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(16.dp)
                                .padding(top = 40.dp)
                                .clickable {
                                    controleDeNavegacao.navigate("telaProcesso")
                                }
                        )

                        // Centraliza a imagem e textos
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center), // Centraliza verticalmente
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(R.drawable.confirmado),
                                contentDescription = "Imagem de confirmação",
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .padding(bottom = 16.dp)

                            )
                            Text(
                                text = "Consulta Confirmada",
                                style = androidx.compose.material3.MaterialTheme.typography.headlineSmall,
                                color = Color.Black
                            )
                            Text(
                                text = "Obrigado por nos escolher",
                                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 8.dp)
                            )

                            Spacer(modifier = Modifier.height(26.dp))
                        }
                    }


                    // Card sobreposto, metade dentro e metade fora da Box azul
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = 8.dp,
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = -1.dp) // Posiciona metade para fora da Box azul
                            .width(310.dp)
                            .height(370.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "ID: 123445",
                                color = Color.Black,
                                fontSize = 12.sp
                            )

                            Row(
                                modifier = Modifier.padding(top = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Foto do Médico
                                Image(
                                    painter = painterResource(R.drawable.marcel),
                                    contentDescription = "Foto do médico",
                                    modifier = Modifier
                                        .width(80.dp)
                                        .height(80.dp)
                                        .padding(end = 16.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                                Column {
                                    Text(
                                        "Dr. Marcel",
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        "Cardiologista",
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(28.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween // Posiciona os textos em cada ponta
                                ) {
                                    Text("Nome", color = Color.Black)
                                    Text("Vinicius", color = Color.Black)
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Data", color = Color.Black)
                                    Text("12/12/2024", color = Color.Black)
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Horário", color = Color.Black)
                                    Text("09:30", color = Color.Black)
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Forma de Pagamento", color = Color.Black)
                                    Text("PIX", color = Color.Black)
                                }
                            }
                        }
                    }

                }

                Column (
                    modifier = Modifier
                        .padding(top = 90.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    // Botão Feito no rodapé da tela
                    Button(
                        onClick = {
                            controleDeNavegacao.navigate("telaHistorico/$idUsuario")
                        },
                        modifier = Modifier
                            .height(50.dp)
                            .width(300.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF77B8FF), Color(0xFF0133D6))
                                ),
                                shape = RoundedCornerShape(30.dp) // Define o formato do botão
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent // Para garantir que o gradiente seja visível
                        ),
                        contentPadding = PaddingValues()
                    ) {
                        Text("Feito")
                    }
                }


            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaConfirmacaoPreview() {
   VitalTheme {

   }
}
