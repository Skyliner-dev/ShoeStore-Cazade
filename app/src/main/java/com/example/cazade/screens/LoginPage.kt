package com.example.cazade.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cazade.ui.theme.CazadeTheme
import com.example.cazade.R

const val rootPassword = "udacity"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCard(
    onButtonClick:() -> Unit
) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center)) {
            Button(onClick = onButtonClick,
                shape = RoundedCornerShape(20),
                modifier = Modifier.fillMaxWidth().wrapContentWidth().padding(16.dp)
            ) {
                Text(text = "Sign in with Google",
                    modifier = Modifier.padding(
                        start = 50.dp,
                        end = 50.dp
                    ))
            }
            Text(text = "OR",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 2.dp
                ))
            Card(
                modifier = Modifier,
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    TextField(value = email,
                        onValueChange = { email = it },
                        singleLine = true,
                        label = { Text(text = "Enter your email") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                        ),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.MailOutline, contentDescription = null)
                        })
                    Spacer(modifier = Modifier.padding(10.dp))
                    TextField(value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Enter your password") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        ),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.password),
                                contentDescription = null
                            )
                        })
                    Spacer(modifier = Modifier.padding(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        OutlinedButton(onClick = onButtonClick,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "new? Register Now!")
                        }
                        Spacer(modifier = Modifier.padding(16.dp))
                        Button(onClick = onButtonClick,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Login")
                        }
                    }
                }
            }
        }
}
@Preview
@Composable
fun LoginCardPreview() {
    CazadeTheme(true) {
        Surface(modifier = Modifier.fillMaxSize()) {
            LoginCard(onButtonClick = {})
        }
    }
}
