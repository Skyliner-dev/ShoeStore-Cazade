package com.example.cazade.common

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cazade.ShoeViewModel
import com.example.cazade.data.Shoe
import com.example.cazade.data.shoes
import com.example.cazade.model.ShoeUiState
import com.example.cazade.ui.theme.CazadeTheme
import java.time.format.TextStyle


@Composable
fun ShoePage(
    shoe:Shoe,
    onBackClick:() -> Unit,
) {
    BackHandler {
        onBackClick()
    }
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ){
        item {
            DetailsTopBar(onBackClick = onBackClick, shoe = shoe)
        }
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Row {
                            Box {
                                Image(
                                    painter = painterResource(id = shoe.image),
                                    contentDescription = null,
                                    modifier = Modifier.size(120.dp)
                                )
                            }
                            Spacer(modifier = Modifier.padding(10.dp))
                            Surface(
                                border = BorderStroke(1.dp, Color.Black),
                                shape = RoundedCornerShape(10.dp),
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.Start,
                                    modifier = Modifier.padding(24.dp)
                                ) {
                                    Text(
                                        text = "Size: ${shoe.size}",
                                        fontSize = 24.sp
                                    )
                                    Spacer(modifier = Modifier.padding(12.dp))
                                    Text(
                                        text = "Company: ${shoe.companyName}",
                                        fontSize = 24.sp
                                    )
                                }
                            }
                        }

                        Text(
                            text = shoe.shoeName, fontSize = 36.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = shoe.description,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Justify,
                            lineHeight = 40.sp,
                            modifier = Modifier

                        )
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBackClick: () -> Unit,
    shoe: Shoe,
    modifier:Modifier = Modifier
) {
    TopAppBar(title = { Text(text = shoe.shoeName)}, navigationIcon = {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick =onBackClick) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back_Button")
            }
        }
    })

}
@Preview
@Composable
fun ShoePagePreview() {
    CazadeTheme(true) {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
              ShoePage(shoe = shoes.first()) {}
        }
    }
}