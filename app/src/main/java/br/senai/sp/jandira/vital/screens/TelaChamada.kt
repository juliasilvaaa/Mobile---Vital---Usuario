package br.senai.sp.jandira.vital.screens



import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import br.senai.sp.jandira.vital.service.RetrofitFactory
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun TelaChamada(controleDeNavegacao: NavHostController) {
    val context = LocalContext.current
    val url = remember { mutableStateOf<String?>(null) }
    val isLoading = remember { mutableStateOf(true) }
    val progress = remember { mutableStateOf(0f) } // Progresso entre 0f e 1f

    // Simular progresso
    LaunchedEffect(Unit) {
        while (progress.value < 1f && isLoading.value) {
            progress.value += 0.1f // Incrementa o progresso
            delay(300) // Simula o delay entre incrementos
        }
    }

    // Chamar a API para gerar a URL da reunião Jitsi
    LaunchedEffect(Unit) {
        try {
            val response = RetrofitFactory().getApiService().generateMeeting()
            url.value = response.url
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            isLoading.value = false
        }
    }

    if (isLoading.value) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Carregando chamada...")
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = progress.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .progressSemantics()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("${(progress.value * 100).toInt()}% concluído")
        }
    } else if (url.value == null) {
        Text("Erro ao iniciar a chamada. Tente novamente.")
    } else {
        // Abrir a URL no navegador
        LaunchedEffect(url.value) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url.value))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}
