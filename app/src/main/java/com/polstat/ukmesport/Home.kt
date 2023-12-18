package com.polstat.ukmesport

import android.graphics.fonts.FontFamily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.polstat.ukmesport.ui.theme.PoppinsFontFamily
import com.polstat.ukmesport.ui.theme.Primary
import com.polstat.ukmesport.ui.theme.UkmEsportTheme
import com.polstat.ukmesport.viewmodel.MainViewModel


@Preview(showBackground = true)
@Composable
fun Home(
    navController: NavController = NavController(LocalContext.current),
    viewModel: MainViewModel = hiltViewModel()
 ){
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.background),
                    contentScale = ContentScale.FillHeight
                )
        ){

        }
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier.verticalScroll(ScrollState(0))
            ) {
                Spacer(modifier = Modifier.height(400.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "List Event Mendatang",
                        style = TextStyle(
                            fontFamily = PoppinsFontFamily,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Justify,
                            color = Color.White
                        )
                    )
                }
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .height(1000.dp)
                        .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                        .background(color = Color.White)
                        .padding(20.dp)


                ){
                    ElevatedCard (
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 10.dp)
                            .shadow(20.dp)

                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                        ){

                            Text(
                                text = "OPTK 2022",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                            Text(
                                text = "12-12-2022",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                        }

                    }
                    ElevatedCard (
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 10.dp)
                            .shadow(20.dp)

                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                        ){

                            Text(
                                text = "Find-It UGM",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                            Text(
                                text = "19-12-2022",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                        }

                    }
                    ElevatedCard (
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 10.dp)
                            .shadow(20.dp)

                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                        ){

                            Text(
                                text = "ASN Esport",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                            Text(
                                text = "16-10-2023",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                        }

                    }
                    ElevatedCard (
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 10.dp)
                            .shadow(20.dp)

                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                        ){

                            Text(
                                text = "Olistis",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                            Text(
                                text = "16-11-2023",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                        }

                    }
                    ElevatedCard (
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 10.dp)
                            .shadow(20.dp)

                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                        ){

                            Text(
                                text = "Korpri Esport",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                            Text(
                                text = "19-12-2023",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                        }

                    }
                    ElevatedCard (
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 10.dp)
                            .shadow(20.dp)

                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                        ){

                            Text(
                                text = "tes",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                            Text(
                                text = "tes",
                                style = TextStyle(
                                    fontFamily = PoppinsFontFamily,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
//                                modifier = Modifier.padding(top = 10.dp)
                                    textAlign = TextAlign.Justify

                                )
                            )
                        }

                    }

                }

            }

        }
        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            color = Color.Transparent

        ){
            Box(
                modifier = Modifier
                    .height(1000.dp)
            ) {
                Text(
                    text = "Hi User!",
                    style = TextStyle(
                        fontFamily = PoppinsFontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                )
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(70.dp)
                        .clickable { navController.navigate("profile") }
                        .align(Alignment.TopEnd)
                        .padding(16.dp)                )
            }

        }




    }
}