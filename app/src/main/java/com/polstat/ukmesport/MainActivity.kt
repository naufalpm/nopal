package com.polstat.ukmesport

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.polstat.ukmesport.navigation.AppNavigation
import com.polstat.ukmesport.ui.theme.*
import com.polstat.ukmesport.ui.theme.UkmEsportTheme
import com.polstat.ukmesport.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavigation(navController = navController)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Login(
    navController: NavController =NavController(MainActivity()) ,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val token by viewModel.token.collectAsStateWithLifecycle()
    var email by remember{mutableStateOf("")}
    var password by remember{mutableStateOf("")}
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier

        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "" )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },
                placeholder = {
                    Text(text = "Masukkan Email")
                },
                value = email,
                onValueChange = {
                                email = it
                },

            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = KeyboardType.Password,
//                    imeAction = ImeAction.Done
//                ),
                label = {
                    Text(text = "Password")
                },
                value = password,
                onValueChange = {
                    password = it
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    Log.d("bebas",email)
                    Log.d("bebas",password)
                          viewModel.login(email, password)
                    if (token.isNotBlank())(
                        navController.navigate("home")
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                )
            ) {
                Text(text = "Login")
                
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Create an account",
                modifier = Modifier.clickable { navController.navigate("register") })

        }
    }
}