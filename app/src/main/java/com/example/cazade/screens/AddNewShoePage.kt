package com.example.cazade.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cazade.R
import com.example.cazade.ShoeViewModel
import com.example.cazade.data.Shoe
import com.example.cazade.model.ShoeUiState
import com.example.cazade.ui.theme.CazadeTheme



@Composable
fun AddNewShoePage(
    onSaveButtonClicked:(Shoe) -> Unit,
    onCancelButtonClicked:() -> Unit,
    onBackButtonClicked:() -> Unit,
) {
    BackHandler {
        onBackButtonClicked()
        onCancelButtonClicked()
    }
    var nameText by rememberSaveable {
        mutableStateOf("")
    }
    var companyString by rememberSaveable {
        mutableStateOf("")
    }
    var sizeText by rememberSaveable {
        mutableStateOf("")
    }
    var descText by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
        ,modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Add A New Shoe!", fontSize = 36.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally))
         Column{
            Text(text = "Name",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(value = nameText, onValueChange = {nameText = it},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Enter Shoe Name")})
        }
        Column{
            Text(text = "Company",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            OutlinedTextField(value = companyString, onValueChange ={companyString = it},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text(text = "Enter Company Name")})
        }
        Column {
            Text(text = "Size",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            OutlinedTextField(value = sizeText, onValueChange ={sizeText = it},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Enter Shoe Size")})
        }
        Column {
            Text(text = "Description",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            OutlinedTextField(value = descText, onValueChange ={descText = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Enter the shoe description")},
                leadingIcon = {
                    Icon(imageVector = Icons.TwoTone.AddCircle, contentDescription =null )
                },
                supportingText = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(imageVector = Icons.Default.Warning, contentDescription = null,
                            modifier = Modifier.size(15.dp))
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = "Not More than 120 Words")
                    }
                })
        }
        Column {
            Button(
                onClick = { onSaveButtonClicked(Shoe(R.drawable.shoe_lightblue,nameText,companyString,sizeText.toDouble(),descText)) },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Save")
            }
            OutlinedButton(
                onClick = onCancelButtonClicked,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Cancel")
            }
        }
    }
}
@Preview
@Composable
fun AddPagePreview() {
    CazadeTheme(false) {
        Surface(modifier = Modifier.fillMaxSize()) {
            AddNewShoePage({},{},{})
        }
    }
}