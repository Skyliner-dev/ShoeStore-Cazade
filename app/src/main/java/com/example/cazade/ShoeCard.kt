package com.example.cazade

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cazade.data.Shoe


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoeCard(shoe:Shoe,
             onClick:() -> Unit) {
    Card(
        onClick = onClick,modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween,
           modifier = Modifier.fillMaxWidth().padding(16.dp)
       ) {
           Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.Start
           ) {
               Text(text = shoe.shoeName, fontSize = 24.sp, fontWeight = FontWeight.Bold)
               Text(text = shoe.companyName, fontSize = 16.sp, fontWeight = FontWeight.Medium)
           }
            Box(
                modifier = Modifier.wrapContentWidth(align = Alignment.End)
            ){
                Image(painter = painterResource(id = shoe.image), contentDescription = null,
                    modifier = Modifier.size(75.dp))
            }

        }
    }
}