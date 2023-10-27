package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(navController: NavHostController) {
    val context = LocalContext.current
    var firstName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var lastName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(text = stringResource(id = R.string.greetings),
            modifier= Modifier
                .height(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding()
                .fillMaxWidth()
                .background(Color(0XFF495E57)),
            fontSize = 23.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            )

        Text(
            text = stringResource(id = R.string.personal_info),
            fontSize = 18.sp, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(12.dp)
        )

        Text(text = "First name",
            modifier=Modifier.padding(start = 12.dp, end = 12.dp, top=16.dp),
        )
        TextField(
            value = firstName,
            onValueChange = { firstName = it},
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
        )

        Text(text = "Last name",
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top=16.dp))
        TextField(
            value = lastName,
            onValueChange = { lastName = it},
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
        )

        Text(text = "Email",modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top=16.dp)
            )
        TextField(
            value = email,
            onValueChange = { email = it},
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, bottom = 70.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),

        )
        Button(onClick = {
                         if(firstName.text == firstName.toString()
                             || lastName.text== lastName.toString()
                             || email.text == email.toString()
                             ){
                             Toast.makeText(context, "Registration successful",
                                 Toast.LENGTH_LONG).show()
                             navController.navigate(Home.route)
                         } else{
                             Toast.makeText(context, "Registration unsucceful./n Please enter all data",
                                 Toast.LENGTH_LONG).show()
                         }
        },
            colors = ButtonDefaults.buttonColors( Color(0XFFF4CE14)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp)
            ) {
            Text(
                text = "Register",
                color = Color(0xFFEDEFEE)
            )
        }

    }

}



