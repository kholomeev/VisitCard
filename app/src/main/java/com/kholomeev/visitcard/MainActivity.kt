package com.kholomeev.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
                    VisitCard(
                        fullName = stringResource(R.string.full_name),
                        title = stringResource(R.string.title),
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
fun VisitCard(fullName: String, title: String, phone: String, handle: String, email: String, modifier: Modifier = Modifier) {
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
            text = fullName,
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
    Column(modifier = modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {
        SocialMediaHandle(modifier, phone, painterResource(R.drawable.phone))
        SocialMediaHandle(modifier, handle, painterResource(R.drawable.telegram))
        SocialMediaHandle(modifier, email, painterResource(R.drawable.email))
    }
}

@Composable
private fun SocialMediaHandle(modifier: Modifier, phone: String, image: Painter) {
    Row(
        modifier = modifier.fillMaxWidth().padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
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
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainInfoPreview() {
    VisitCardTheme {
        VisitCard(
            fullName = stringResource(R.string.full_name),
            title = stringResource(R.string.title),
            phone = stringResource(R.string.phone),
            handle = stringResource(R.string.handle),
            email = stringResource(R.string.email),
            modifier = Modifier
        )
    }
}