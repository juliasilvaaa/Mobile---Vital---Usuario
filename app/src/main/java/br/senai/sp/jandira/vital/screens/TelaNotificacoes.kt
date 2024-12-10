package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.vital.model.NavItem

@Composable
fun TelaNotificacoes(controleDeNavegacao: NavHostController, idUsuario: Int) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                val navItemList = listOf(
                    NavItem("Ínicio", Icons.Default.Home, "telaHome/$idUsuario"),
                    NavItem("Favoritos", Icons.Default.Star, "telaFavoritos/$idUsuario"),
                    NavItem("Notificações", Icons.Default.Notifications, "telaNotificacoes/$idUsuario")
                )

                var selectedIndex by rememberSaveable { mutableStateOf(2) }

                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            controleDeNavegacao.navigate(navItem.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.label) },
                        label = { Text(text = navItem.label) }
                    )
                }
            }
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding()) // Tirando o espaco antes do conteúdo
        ) {
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
                   Text(
                       "Notificações",
                       color = Color.White,
                       fontSize = 18.sp,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .align(Alignment.Center)
                   )

               }

               Column(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(16.dp)
                       .padding(top = 160.dp)
               ) {
                   Card(
                       modifier = Modifier.fillMaxWidth()
                   ) {
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(16.dp),
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           // Coluna com Box e Ícone
                           Column(
                               horizontalAlignment = Alignment.CenterHorizontally
                           ) {
                               Box(
                                   modifier = Modifier
                                       .size(50.dp) // Define o tamanho do Box
                                       .clip(CircleShape) // Deixa o Box redondo
                                       .background(Color(0xFFCC00FF)) // Cor de fundo do Box
                                       .align(Alignment.CenterHorizontally)
                               ) {
                                   Icon(
                                       imageVector = Icons.Filled.DateRange,
                                       contentDescription = "Ícone de Calendário",
                                       tint = Color.White, // Cor do ícone
                                       modifier = Modifier
                                           .align(Alignment.Center) // Centraliza o ícone no Box
                                           .size(24.dp) // Tamanho do ícone
                                   )
                               }
                           }

                           Spacer(modifier = Modifier.width(16.dp)) // Espaço entre o ícone e o texto

                           // Textos dentro do Row
                           Column {
                               Text(
                                   text = "Consulta Próxima",
                                   fontSize = 16.sp,
                                   fontWeight = FontWeight.Bold,
                                   color = Color(0xFF565454)
                               )
                               Spacer(modifier = Modifier.height(4.dp))
                               Text(
                                   text = "12/12/2024 às 09:30",
                                   fontSize = 14.sp,
                                   color = Color.Gray
                               )
                           }
                       }
                   }
                   Spacer(modifier = Modifier.height(10.dp))
//                   Pagamento Confirmado
                   Card(
                       modifier = Modifier.fillMaxWidth()
                   ) {
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(16.dp),
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           // Coluna com Box e Ícone
                           Column(
                               horizontalAlignment = Alignment.CenterHorizontally
                           ) {
                               Box(
                                   modifier = Modifier
                                       .size(50.dp) // Define o tamanho do Box
                                       .clip(CircleShape) // Deixa o Box redondo
                                       .background(Color(0xFF2954C7)) // Cor de fundo do Box
                                       .align(Alignment.CenterHorizontally)
                               ) {
                                   Icon(
                                       imageVector = Icons.Filled.Check,
                                       contentDescription = "Ícone de Calendário",
                                       tint = Color.White, // Cor do ícone
                                       modifier = Modifier
                                           .align(Alignment.Center) // Centraliza o ícone no Box
                                           .size(24.dp) // Tamanho do ícone
                                   )
                               }
                           }

                           Spacer(modifier = Modifier.width(16.dp)) // Espaço entre o ícone e o texto

                           // Textos dentro do Row
                           Column {
                               Text(
                                   text = "Pagamento Confirmado",
                                   fontSize = 16.sp,
                                   fontWeight = FontWeight.Bold,
                                   color = Color(0xFF565454)
                               )
                               Spacer(modifier = Modifier.height(4.dp))
                               Text(
                                   text = "Pagamento referente a consulta #00123 confirmado",
                                   fontSize = 14.sp,
                                   color = Color.Gray
                               )
                           }
                       }
                   }

                   Spacer(modifier = Modifier.height(10.dp))
//                   Consulta Cancelada
                   Card(
                       modifier = Modifier.fillMaxWidth()
                   ) {
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(16.dp),
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           // Coluna com Box e Ícone
                           Column(
                               horizontalAlignment = Alignment.CenterHorizontally
                           ) {
                               Box(
                                   modifier = Modifier
                                       .size(50.dp) // Define o tamanho do Box
                                       .clip(CircleShape) // Deixa o Box redondo
                                       .background(Color(0xFFFC4D4D)) // Cor de fundo do Box
                                       .align(Alignment.CenterHorizontally)
                               ) {
                                   Icon(
                                       imageVector = Icons.Filled.Close,
                                       contentDescription = "Ícone",
                                       tint = Color.White, // Cor do ícone
                                       modifier = Modifier
                                           .align(Alignment.Center) // Centraliza o ícone no Box
                                           .size(24.dp) // Tamanho do ícone
                                   )
                               }
                           }

                           Spacer(modifier = Modifier.width(16.dp)) // Espaço entre o ícone e o texto

                           // Textos dentro do Row
                           Column {
                               Text(
                                   text = "Consulta Cancelada",
                                   fontSize = 16.sp,
                                   fontWeight = FontWeight.Bold,
                                   color = Color(0xFF565454)
                               )
                               Spacer(modifier = Modifier.height(4.dp))
                               Text(
                                   text = "Infelizmente sua consulta foi cancelada. Acesse o app para mais informações",
                                   fontSize = 14.sp,
                                   color = Color.Gray
                               )
                           }
                       }
                   }
                   Spacer(modifier = Modifier.height(10.dp))

                   //                 Pagamento Cancelado
                   Card(
                       modifier = Modifier.fillMaxWidth()
                   ) {
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(16.dp),
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           // Coluna com Box e Ícone
                           Column(
                               horizontalAlignment = Alignment.CenterHorizontally
                           ) {
                               Box(
                                   modifier = Modifier
                                       .size(50.dp) // Define o tamanho do Box
                                       .clip(CircleShape) // Deixa o Box redondo
                                       .background(Color(0xFF0A91FF)) // Cor de fundo do Box
                                       .align(Alignment.CenterHorizontally)
                               ) {
                                   Icon(
                                       imageVector = Icons.Filled.ShoppingCart,
                                       contentDescription = "Ícone",
                                       tint = Color.White, // Cor do ícone
                                       modifier = Modifier
                                           .align(Alignment.Center) // Centraliza o ícone no Box
                                           .size(24.dp) // Tamanho do ícone
                                   )
                               }
                           }

                           Spacer(modifier = Modifier.width(16.dp)) // Espaço entre o ícone e o texto

                           // Textos dentro do Row
                           Column {
                               Text(
                                   text = "Falha no Pagamento",
                                   fontSize = 16.sp,
                                   fontWeight = FontWeight.Bold,
                                   color = Color(0xFF565454)
                               )
                               Spacer(modifier = Modifier.height(4.dp))
                               Text(
                                   text = "Algo deu errado na transação. Troque a forma de pagamento",
                                   fontSize = 14.sp,
                                   color = Color.Gray
                               )
                           }
                       }
                   }
               }

           }
        }

    }
}