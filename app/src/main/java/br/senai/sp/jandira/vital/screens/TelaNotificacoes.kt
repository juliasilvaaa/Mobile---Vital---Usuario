package br.senai.sp.jandira.vital.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
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
           }
        }

    }
}