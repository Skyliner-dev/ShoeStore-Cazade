package com.example.cazade.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cazade.ui.theme.CazadeTheme

@Composable
fun InstructionsPage(
    onClick:() -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp, top = 60.dp,end = 16.dp)
    ) {
        Text(
            text = "Instructions", fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Card(
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(modifier = Modifier.padding(4.dp)) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = null,
                            Modifier.size(30.dp))
                    }
                    Text(
                        text = "The Home Screen Consists of the shoe Collection",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        lineHeight = 40.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(modifier = Modifier.padding(4.dp)) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null,
                            Modifier.size(30.dp))
                    }
                    Text(
                        text = "You can Add one with just clicking On the FAB",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        lineHeight = 40.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null,
            modifier = Modifier.size(75.dp))
        Card(
            modifier = Modifier
        ){
            Text(
                text = "Wanna log Out?\nIts easy! Just click on the menu button then click Log out.",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        Button(onClick = onClick) {
            Text(text = "Next")
        }
    }
}
@Preview
@Composable
fun InstructionsPagePreview() {
    CazadeTheme(true) {
        Surface(modifier = Modifier.fillMaxSize()) {
            InstructionsPage({})
        }
    }
}