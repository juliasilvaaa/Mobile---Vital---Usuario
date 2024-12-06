package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.R
import br.senai.sp.jandira.vital.ui.theme.VitalTheme


@Composable
fun ProcessoDoPagamento(
    controleDeNavegacao: NavHostController,
    idUsuario: Int
) {


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
            )  {

                // Icon clicável para voltar
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                )
                Text(
                    "Pagamento",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.Center) // Centraliza no meio
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 200.dp),
                contentAlignment = Alignment.Center
            ) {

                Row(
                    modifier = Modifier
                ) {

                    Column(
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                            .background(
                                color = Color(0xffD9D9D9),
                                shape = RoundedCornerShape(360.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(R.drawable.dinheiroca),
                            contentDescription = "",
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 5.dp)

                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Image(
                            painter = painterResource(R.drawable.line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .padding(top = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Column(
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                            .background(
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(360.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(R.drawable.carregando),
                            contentDescription = "",
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 5.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Column {
                        Image(
                            painter = painterResource(R.drawable.line),
                            contentDescription = "",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .padding(top = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Column(
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                            .background(
                                color = Color(0xFF2954C7),
                                shape = RoundedCornerShape(360.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(R.drawable.feito),
                            contentDescription = "",
                            modifier = Modifier
                                .width(45.dp)
                                .height(45.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 9.dp)
                        )
                    }
                }
            }


            Column(
                modifier = Modifier
                    .padding(top = 280.dp)
                    .fillMaxSize()
                    .border(
                        width = 6.dp, // Largura da borda
                        color = Color(0x80E3E3E3), // Cor da borda
                        shape = RoundedCornerShape(
                            topEnd = 20.dp,
                            topStart = 20.dp
                        ) // A mesma forma da borda
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)

                    )


            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 40.dp)
                        .width(247.dp)
                        .height(77.dp)
                        .background(color = Color(0xff2954C7), shape = RoundedCornerShape(20.dp))

                ) {
                    Text(
                        "Valor a ser pago",
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "R$ 90.00",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .padding(18.dp)
                        .fillMaxWidth()
                        .fillMaxSize()
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            "ID da transferência",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Text(
                            "00000123",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            "Status",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Text(
                            "Recebido",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            "Valor da Transferêrencia",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Text(
                            "R$ 90.00",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Data",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Text(
                            "10/12/24",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Forma de Pagamento",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                        Text(
                            "PIX",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                    }
                    Column (
                        modifier = Modifier
                            .padding(top = 200.dp)
                            .align(Alignment.CenterHorizontally)
                    ){
                        Button(
                            onClick = {
                                controleDeNavegacao.navigate("telaConfirmacao/$idUsuario")
                            },
                            modifier = Modifier
                                .height(58.dp)
                                .width(326.dp)
                                .align(Alignment.CenterHorizontally)
                                .background(
                                    color = Color(0xFF2954C7), // Cor de fundo
                                    shape = RoundedCornerShape(20.dp) // Cantos arredondados
                                )
                                .border(
                                    width = 2.dp, // Largura da borda
                                    color = Color(0xffE3E3E3), // Cor da borda
                                    shape = RoundedCornerShape(20.dp) // A mesma forma da borda
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent // Transparente para ver o fundo aplicado com .background
                            ),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(
                                "Feito",
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
fun ProcessoDoPagamentoPreview () {


    // Pre-visualizacao
    VitalTheme {

    }




}
