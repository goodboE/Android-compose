package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFF04352E))
    ) {

        Column(Modifier.weight(8f)) {
            BusinessCardTop(
                painterResource(R.drawable.android_logo),
                stringResource(R.string.card_name),
                stringResource(R.string.card_title)
            )
        }
        Column(Modifier.weight(2f)) {
            BusinessCardBottom()
        }
    }

}

@Composable
fun BusinessCardTop(
    imagePainter: Painter,
    cardName: String,
    cardTitle: String
) {
    Column(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {

        Image(
            painter = imagePainter, contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(120.dp)
        )

        Text(
            text = cardName,
            fontSize = 50.sp,
            color = Color.White
        )

        Text(
            text = cardTitle,
            Modifier.padding(top = 10.dp),
            color = Color(0xFF3ddc84)
        )
    }


}

@Composable
fun BusinessCardBottom() {

    Column(
        Modifier.fillMaxSize()
    ) {
        BottomIconAndText(
            painterResource(R.drawable.ic_baseline_call_24),
            stringResource(R.string.card_phone_number)
        )

        BottomIconAndText(
            painterResource(R.drawable.ic_baseline_device_hub_24),
            stringResource(R.string.card_position)
        )

        BottomIconAndText(
            painterResource(R.drawable.ic_baseline_email_24),
            stringResource(R.string.card_email)
        )

    }

}

@Composable
fun BottomIconAndText(imagePainter: Painter, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Icon(
            painter = imagePainter, contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier
                .padding(start = 40.dp),

        )

        Text(
            text = text,
            fontSize = 17.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardApp()
}