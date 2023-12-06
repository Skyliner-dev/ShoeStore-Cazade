package com.example.cazade

import androidx.lifecycle.ViewModel
import com.example.cazade.data.Shoe
import com.example.cazade.data.shoes
import com.example.cazade.model.ShoeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoeViewModel :ViewModel() {
    private val _uiState = MutableStateFlow(ShoeUiState(shoeList))
    val uiState:StateFlow<ShoeUiState> =  _uiState.asStateFlow()
    private val shoeList
        get() = shoes
   fun updateShoe(
       shoe:Shoe
   ) {
       _uiState.update {
           shoeList.add(shoe)
           it.copy(
               shoes = shoeList
           )
       }
   }
    fun resetContent() {
        _uiState.value = ShoeUiState(shoeList)
    }
}