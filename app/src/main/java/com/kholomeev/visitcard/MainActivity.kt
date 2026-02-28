package com.kholomeev.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
//                    SocialMedia(
//                        modifier = Modifier.padding(innerPadding)
//                    )
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
        val image = painterResource(R.drawable.placeholder)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = full_name,
            textAlign = TextAlign.Center,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun SocialMedia(modifier: Modifier = Modifier) {
    Box(modifier) {
        Row {
            val image = painterResource(R.drawable.phone)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.None,
            )
            Text(
                text = "+7 (959) 269-88-64",
                modifier = modifier
            )
        }
        Row {
            val image = painterResource(R.drawable.telegram)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.None
            )
            Text(
                text = "@HolomeevKirill",
                modifier = modifier
            )
        }
        Row {
            val image = painterResource(R.drawable.email)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.None
            )
            Text(
                text = "holomeev2012@gmail.com",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainInfoPreview() {
    VisitCardTheme {
        MainInfo("Full Name", "Title")
        //SocialMedia()
    }
}