package com.example.cazade

import android.widget.Toast
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cazade.data.Shoe
import kotlin.math.exp



@Composable
fun HomeScreen(
    shoes: List<Shoe>,
    onBackIconClicked: () -> Unit,
    onFABClick:() -> Unit,
    onLogOutClicked: () -> Unit
) {
    Scaffold(
        topBar = {HomeScreenTopBar(onBackIconClicked = onBackIconClicked,onLogOutClicked = onLogOutClicked)},
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FABShoe(onClick = onFABClick)
        },
    ) {
       LazyColumn(contentPadding = it) {
           items(shoes, key = {shoe -> shoe.shoeName}) {
               shoe ->
               ShoeCard(shoe = shoe,{})
           }
       }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreenTopBar(
    onBackIconClicked:() -> Unit,
    onLogOutClicked: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
   androidx.compose.material3.TopAppBar(title = {
        Text(text = "Shoes")
        },
        actions = {
            IconButton(onClick = {
            expanded = true
            }) {
                Icon(Icons.Default.MoreVert,null)
            }
        }, navigationIcon = {
            IconButton(onClick = onBackIconClicked) {
                Icon(Icons.Default.ArrowBack,null)
            }
        })
    val sheetState = rememberModalBottomSheetState()
    if (expanded) {
        ModalBottomSheet(sheetState = sheetState, onDismissRequest = { expanded = false}) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(
                        top = 0.dp, bottom = 60.dp,
                    )
            ) {
                Icon(Icons.Default.ExitToApp,null,
                        modifier = Modifier.size(75.dp))
                Spacer(modifier = Modifier.padding(16.dp))
                Button(onClick = onLogOutClicked,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = "Log Out",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Composable
fun FABShoe(
    onClick:() ->Unit
) {
    FloatingActionButton(onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = MaterialTheme.colorScheme.tertiaryContainer
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add_shoe")
    }
}