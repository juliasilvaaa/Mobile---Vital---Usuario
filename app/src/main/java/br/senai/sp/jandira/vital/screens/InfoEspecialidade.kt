//package br.senai.sp.jandira.vital.screens
//
//import android.util.Log
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import br.senai.sp.jandira.vital.R
//import br.senai.sp.jandira.vital.model.Medicos
//import br.senai.sp.jandira.vital.model.ResultadoMedico
//import br.senai.sp.jandira.vital.service.RetrofitFactory
//import br.senai.sp.jandira.vital.ui.theme.VitalTheme
//import coil.compose.AsyncImage
//import com.google.gson.GsonBuilder
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//@Composable
//fun InfoEspecialidade(
//    controleDeNavegacao: NavHostController,
//    idUsuario: Int
//) {
//
//
//    VitalTheme {
//        Surface {
//            Column {
//                Image(
//                    painter = painterResource(R.drawable.cardiologia),
//                    contentDescription = "Foto da Especialidade",
//                    modifier = Modifier
//                        .fillMaxSize()
//
//                )
//            }
//        }
//    }
//}
