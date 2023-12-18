package com.polstat.ukmesport

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.polstat.ukmesport.ui.theme.PoppinsFontFamily
import com.polstat.ukmesport.ui.theme.Primary
import com.polstat.ukmesport.ui.theme.Putih

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun create(){
    var nama by remember{ mutableStateOf("") }
    var tanggal by remember{ mutableStateOf("") }
    Surface(

        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.background),
                    contentScale = ContentScale.FillHeight
                )

        ){
            Text(
                text = "Input Event Mendatang",
                style = TextStyle(
                    fontFamily = PoppinsFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Justify,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White
                ),
                label = {
                    Text(text = "Nama Event")
                },
                placeholder = {
                    Text(text = "Masukkan Nama Event")
                },
                value = nama,
                onValueChange = {
                    nama = it
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White
                ),
                label = {
                    Text(text = "Tanggal Event")
                },
                placeholder = {
                    Text(text = "Masukkan Tanggal Event")
                },
                value = tanggal,
                onValueChange = {
                    tanggal = it
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Putih
                )
            ) {
                Text(
                    color = Color.Black,
                    text = "Input"
                )
            }
//            Text(text = "Lihat List Event",
//                modifier = Modifier.clickable { navController.navigate("register") })
//

        }


    }

}

