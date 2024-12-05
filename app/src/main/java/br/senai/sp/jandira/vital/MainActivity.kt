package br.senai.sp.jandira.vital

import Agendamento
//import GaleriaDeVideo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.senai.sp.jandira.vital.screens.GaleriaDeVideos
import br.senai.sp.jandira.vital.screens.HistoricoDeConsultas
import br.senai.sp.jandira.vital.screens.InfoEspecialidade
import br.senai.sp.jandira.vital.screens.InfoMedico
import br.senai.sp.jandira.vital.screens.MetodosDePagamento
import br.senai.sp.jandira.vital.screens.ProcessoDoPagamento
import br.senai.sp.jandira.vital.screens.TelaAdicionarCartao
import br.senai.sp.jandira.vital.screens.TelaAlterarSenha
import br.senai.sp.jandira.vital.screens.TelaCadastro
import br.senai.sp.jandira.vital.screens.TelaChamada
import br.senai.sp.jandira.vital.screens.TelaEspecialidadesFav
import br.senai.sp.jandira.vital.screens.TelaFavoritos
import br.senai.sp.jandira.vital.screens.TelaHome
import br.senai.sp.jandira.vital.screens.TelaInicial1
import br.senai.sp.jandira.vital.screens.TelaInicial2
import br.senai.sp.jandira.vital.screens.TelaInicial3
import br.senai.sp.jandira.vital.screens.TelaInicio
import br.senai.sp.jandira.vital.screens.TelaLogin
import br.senai.sp.jandira.vital.screens.TelaMedicos
import br.senai.sp.jandira.vital.screens.TelaPerfil
import br.senai.sp.jandira.vital.screens.TelaTelemedicina
import br.senai.sp.jandira.vital.ui.theme.VitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VitalTheme {
                // Vai lembrar da navegacao que esta fazendo para depois voltar
                val controleDeNavegacao = rememberNavController()

                // Chamar uma funcao NavHost
                NavHost(
                    navController = controleDeNavegacao,
                    // Quando eu abrir a aplicacao qual a tela que vai aparecer
                    startDestination = "telaInicial1" // essa palavra login é criada, mas esta referente a tela que queremos
                ) {
                    // Todas as telas tem que ficar aqui
                    composable(route = "telaInicial1") { TelaInicial1(controleDeNavegacao) }

                    composable(route = "telaInicial2") { TelaInicial2(controleDeNavegacao) }
                    composable(route = "telaInicial3") { TelaInicial3(controleDeNavegacao) }
                    composable(route = "telaLogin") { TelaLogin(controleDeNavegacao) }
                    composable(route = "telaCadastro") { TelaCadastro(controleDeNavegacao) }



                    composable(route = "telaProcesso") { ProcessoDoPagamento(controleDeNavegacao) }



                    composable(
                        route = "telaPerfil/{idUsuario}",
                        arguments = listOf(navArgument("idUsuario") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val idUsuario = backStackEntry.arguments?.getInt("idUsuario") ?: 0
                        TelaPerfil(controleDeNavegacao, idUsuario)
                    }

                    composable(
                        route = "telaMetodos/{horarioSelecionado}",
                        arguments = listOf(navArgument("horarioSelecionado") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val horarioSelecionado = backStackEntry.arguments?.getString("horarioSelecionado")
                        MetodosDePagamento(controleDeNavegacao, horarioSelecionado = horarioSelecionado)
                    }




                    composable(
                        route = "telaInicio/{idUsuario}",
                        arguments = listOf(navArgument("idUsuario") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val idUsuario = backStackEntry.arguments?.getInt("idUsuario") ?: 0
                        TelaInicio(controleDeNavegacao, idUsuario)
                    }

                    // Tela Home
                    composable(
                        route = "telaHome/{idUsuario}",
                        arguments = listOf(navArgument("idUsuario") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val idUsuario = backStackEntry.arguments?.getInt("idUsuario") ?: 0
                        TelaHome(controleDeNavegacao, idUsuario)
                    }



                    // Tela Favoritos
                    composable(
                        route = "telaFavoritos/{idUsuario}",
                        arguments = listOf(navArgument("idUsuario") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val idUsuario = backStackEntry.arguments?.getInt("idUsuario") ?: 0
                        TelaFavoritos(controleDeNavegacao, idUsuario)
                    }

                    composable(route = "telaEspecialidadeFav") { TelaEspecialidadesFav() }


                    // Tela Notificações
                    composable(route = "telaNotificacoes") {
                        TelaAdicionarCartao() // Substitua com a tela correta
                    }




                    // Agendamento

                    composable(
                        route = "telaAgendamento/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val idMedico = backStackEntry.arguments?.getString("id")
                        Agendamento(controleDeNavegacao, idMedico)
                    }


                    // Medicos
                    composable(
                        route = "infoMedico/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val idMedico = backStackEntry.arguments?.getString("id")
                        InfoMedico(controleDeNavegacao, idMedico)
                    }

                    composable(
                        route = "infoEspecialidade/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val idEspecialidade = backStackEntry.arguments?.getString("id")
                        InfoEspecialidade(controleDeNavegacao, idEspecialidade )
                    }



                    composable(
                        route = "telaMedicos/{idUsuario}",
                        arguments = listOf(navArgument("idUsuario") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val idUsuario = backStackEntry.arguments?.getInt("idUsuario") ?: 0
                        TelaMedicos(controleDeNavegacao, idUsuario)
                    }

                    composable(
                        route = "telaTelemedicina/{idUsuario}",
                        arguments = listOf(navArgument("idUsuario") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val idUsuario = backStackEntry.arguments?.getInt("idUsuario") ?: 0
                        TelaTelemedicina(controleDeNavegacao, idUsuario)
                    }
                    composable(
                        route = "telaHistorico/{idUsuario}",
                        arguments = listOf(navArgument("idUsuario") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val idUsuario = backStackEntry.arguments?.getInt("idUsuario") ?: 0
                        HistoricoDeConsultas(controleDeNavegacao, idUsuario)
                    }


                    composable(route = "telaAlterarSenha") { TelaAlterarSenha(controleDeNavegacao) }

                    composable(route = "telaChamada") { TelaChamada(controleDeNavegacao) }
                    composable(route = "telaAdicionarCartao") { TelaAdicionarCartao() }



                }
            }
        }
    }


}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VitalTheme {
        Greeting("Android")
    }
}