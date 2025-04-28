package com.pratice.quotesappusingjetpackcompose.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.pratice.quotesappusingjetpackcompose.model.Quotes
import com.pratice.quotesappusingjetpackcompose.screen.QuoteItemList

@Composable
fun QuoteList(data:Array<Quotes>,OnClick:(quotes:Quotes)-> Unit) {
    
    LazyColumn(content =
    {
        items(data){
            QuoteItemList(quotes = it,OnClick)
        }
    })
    
}