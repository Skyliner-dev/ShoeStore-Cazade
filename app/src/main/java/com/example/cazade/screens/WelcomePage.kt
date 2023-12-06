package com.example.cazade.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cazade.R
import com.example.cazade.ui.theme.CazadeTheme

@Composable
fun WelcomePage(
    onNextClicked:() -> Unit
) {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(
                start = 16.dp,
                end = 16.dp
            )
        ) {
            Box {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null,
                    Modifier.size(75.dp)
                )
            }
            Text(
                text = "Welcome to Cazade!",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.welcomeScreen),
                fontSize = 24.sp, fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                lineHeight = 50.sp,
            )
            Button(onClick = onNextClicked) {
                Text(text = "Next",
                    fontSize = 16.sp)
            }
        }
}

@Preview
@Composable
fun WelcomePagePreview() {
    CazadeTheme(true) {
        Surface(modifier = Modifier.fillMaxSize()) {
           WelcomePage({})
        }
    }
}