package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Profile(navController:NavHostController){

    var firstName = getSharedPreferenceValue("firstName");
    var lastName = getSharedPreferenceValue("lastName");
    var email = getSharedPreferenceValue("email");

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                )
            Text(
                text = stringResource(id = R.string.personal_info),
                fontSize = 18.sp, fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(12.dp),
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

            Text(text = "First name: $firstName.text")
            Text(text = "Last name: $lastName")
            Text(text = "Email: $email")
        }
    Button(onClick = {
        clearSharedPreference()
        navController.navigate(Home.route) },
        colors = ButtonDefaults.buttonColors( Color(0XFFF4CE14)),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp)
        ) {
        Text(
            text = "Logout",
            color = Color(0xFFEDEFEE)
        )
    }
}

fun clearSharedPreference() {
    TODO("Not yet implemented")
}


private fun <ColumnScope> ColumnScope.TextField(value: Unit,
                                                onValueChange: () -> Unit,
                                                modifier: Modifier, shape: RoundedCornerShape) {

}

fun getSharedPreferenceValue(s: String) {

}


