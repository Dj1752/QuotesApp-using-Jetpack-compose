package com.pratice.quotesappusingjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pratice.quotesappusingjetpackcompose.screen.QuoteItemList
import com.pratice.quotesappusingjetpackcompose.screen.QuotelistScreen
import com.pratice.quotesappusingjetpackcompose.ui.theme.QuotesAppUsingJetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     CoroutineScope(Dispatchers.IO).launch {
         Datamanager.loadAssetsFromFile(applicationContext)
     }
        setContent {
           App()
        }
    }
}

@Composable
fun App() {
    if (Datamanager.isDataLoaded.value){
        QuotelistScreen(data = Datamanager.data) {

        }
    }else{
        Box (modifier = Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center){
            Text(text = "Loading.....", style = MaterialTheme.typography.headlineLarge)

        }
    }
}
