package com.kholomeev.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kholomeev.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainInfo(
                        full_name = "Full Name",
                        title = "Title",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainInfo(full_name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
//        Image(
//            painter = null,
//            contentDescription = null,
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.None
//        )
        Text(
            text = full_name,
            modifier = modifier
        )
        Text(
            text = title,
            modifier = modifier
        )
    }
}

@Composable
fun SocialMedia() {

}

@Preview(showBackground = true)
@Composable
fun MainInfoPreview() {
    VisitCardTheme {
        MainInfo("Full Name", "Title")
    }
}