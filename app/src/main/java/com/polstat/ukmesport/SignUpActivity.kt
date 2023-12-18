package com.polstat.ukmesport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.polstat.ukmesport.ui.theme.Primary
import com.polstat.ukmesport.ui.theme.UkmEsportTheme
import com.polstat.ukmesport.viewmodel.AuthViewModel


//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(
    navController: NavController,
    viewModel: AuthViewModel
){
    val registeredName by viewModel.registeredName.collectAsStateWithLifecycle()
    var name by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
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
                    Text(text = "Nama")
                },
                placeholder = {
                    Text(text = "Masukkan Nama")
                },
                value = name,
                onValueChange = {
                                name = it
                },
                )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },
                placeholder = {
                    Text(text = "Masukkan EMail")
                },
                value = email,
                onValueChange = {
                    email = it
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Masukkan Password")
                },
                value = password,
                onValueChange = {
                                password = it
                },
                )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                          viewModel.register(name, email, password)
                    if (registeredName.isNotBlank())(
                        navController.navigate("login")
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                )
            ) {
                Text(text = "Sign Up")

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Have an account? login",
                modifier = Modifier.clickable { navController.navigate("login") })

        }
    }

}