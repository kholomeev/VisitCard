package com.kholomeev.visitcard

import android.R.attr.fontWeight
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kholomeev.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainInfo(
                        full_name = stringResource(R.string.full_name),
                        title = stringResource(R.string.title),
                        modifier = Modifier
                    )
                    SocialMedia(
                        phone = stringResource(R.string.phone),
                        handle = stringResource(R.string.handle),
                        email = stringResource(R.string.email),
                        modifier = Modifier
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
        val image = painterResource(R.drawable.placeholder)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.None,
            modifier = modifier.fillMaxWidth()
        )
        Text(
            text = full_name,
            textAlign = TextAlign.Center,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.fillMaxWidth()
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SocialMedia(phone: String, handle: String, email: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            val image = painterResource(R.drawable.phone)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(50.dp)
            )
            Text(
                text = phone,
                color = Color.Green,
                fontSize = 20.sp,
                modifier = modifier
            )
        }
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            val image = painterResource(R.drawable.telegram)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(50.dp)
            )
            Text(
                text = handle,
                color = Color.Green,
                fontSize = 20.sp,
                modifier = modifier
            )
        }
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            val image = painterResource(R.drawable.email)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(50.dp)
            )
            Text(
                text = email,
                color = Color.Green,
                fontSize = 20.sp,
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainInfoPreview() {
    VisitCardTheme {
        MainInfo(stringResource(R.string.full_name),
            stringResource(R.string.title))
        SocialMedia(stringResource(R.string.phone),
            stringResource(R.string.handle),
            stringResource(R.string.email))
    }
}