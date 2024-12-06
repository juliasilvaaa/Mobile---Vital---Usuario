package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.model.Medicos
import br.senai.sp.jandira.vital.ui.theme.VitalTheme


@Composable
fun MetodosDePagamento(controleDeNavegacao: NavHostController, horarioSelecionado: String?, idUsuario: Int) {

    var detalheMetodo by remember {
        mutableStateOf(false)
    }



    VitalTheme {
        Surface {
            Box(
                modifier = Modifier
                    .background(
                        Color(0xFF2954C7),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    )
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 50.dp)
            ) {
                var medic by remember { mutableStateOf<Medicos?>(null) }
                // Icon clicável para voltar
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                        .clickable {
                            controleDeNavegacao.navigate("telaAgendamento/${medic?.id_medico}")
                        }
                )
                Text(
                    "Pagamento",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 160.dp)
                    .padding(18.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        "Selecione a forma de pagamento",
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clickable {
                                detalheMetodo = !detalheMetodo
                            }
                    ) {
                        Row (
                            modifier = Modifier
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.pix),
                                contentDescription = "Dinheiro",
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(18.dp))
                            Text(
                                text ="PIX",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    if(detalheMetodo){
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .height(400.dp)
                                .fillMaxSize()
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.logopix),
                                    contentDescription = "Logo PIX",
                                    modifier = Modifier
                                        .width(64.dp)
                                        .height(23.dp)
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.qrcode),
                                    contentDescription = "QR CODE PIX",
                                    modifier = Modifier
                                        .size(130.dp)
                                )

                                Card (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFFE3E3E3)
                                    )
                                ){
                                    Column(
                                        modifier = Modifier
                                            .padding(8.dp),
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "Código copia e cola",
                                            fontSize = 10.sp
                                        )
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(text = "00023JDBHSK385095CVBVH62")
                                            // Icon copia e cola
                                            Image(
                                                painter = painterResource(id = R.drawable.copia),
                                                contentDescription = "Copiar",
                                                modifier = Modifier
                                                    .size(20.dp)
                                            )
                                        }
                                    }
                                }

                                Column {
                                    Text(
                                        text = "Instruções",
                                    )
                                    Text(
                                        text = "1- Copie o código PIX",
                                        fontSize = 14.sp
                                    )
                                    Text(
                                        text = "2- Abra o aplicativo do seu banco",
                                        fontSize = 14.sp
                                    )
                                    Text(
                                        text = "3- Entre na área Pix Copia e Cola",
                                        fontSize = 14.sp
                                    )
                                    Text(
                                        text = "4- Copie o código e finalize a transação",
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    }
                }

               Column{
                   Row (
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween
                   ){
                       Column {
                           Text(
                               "Total",
                               fontSize = 16.sp,
                               fontWeight = FontWeight.Bold
                           )

                           Text(
                               "R$ 90.00",
                               fontSize = 14.sp,
                               fontWeight = FontWeight.Medium
                           )
                       }


                       Button(
                           onClick = { controleDeNavegacao.navigate("telaProcesso/$idUsuario") },
                           modifier = Modifier
                               .height(42.dp)
                               .width(135.dp),
                           colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2954C7)),
                           shape = RoundedCornerShape(16.dp)
                       ) {
                           // Texto dentro do botao
                           Text(
                               text = "Pagar",
                               fontSize = 14.sp,
                               fontWeight = FontWeight.Bold,
                               color = Color.White

                           )

                       }
                   }
               }
            }
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun Preview () {

    // Pre-visualizacao
    VitalTheme {
    }

}