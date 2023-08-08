package com.gunder.basic_layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gunder.basic_layouts.ui.theme.BasiclayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasiclayoutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun UserProfile() {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Icon(
            imageVector = Icons.Default.Check, contentDescription = null,
            Modifier
                .size(8.dp)
                .align(
                    Alignment.TopEnd
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    BasiclayoutsTheme {
        UserProfile()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasiclayoutsTheme {
        Greeting("Android")
    }
}

@Composable
fun UserChat(name: String, msg: String) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = {})
    ) {
        Image(
            painter = painterResource(R.drawable.image_user),
            contentDescription = null,
            modifier = Modifier
                .padding(4.dp)
                .size(60.dp)
                .border(2.dp, Color.Blue, CircleShape)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = msg, modifier = Modifier.offset(x = 16.dp))
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserChatPreview() {
    BasiclayoutsTheme {
        UserChat(name = "Gun", msg = "Android Dev")
    }
}

@Composable
fun SlotBasedLayout() {
    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Like")
    }
}

@Preview
@Composable
fun SlotBasedLayoutPreview() {
    BasiclayoutsTheme {
        SlotBasedLayout()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldSample() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "My Scaffold") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Hello Compose!")
        }

    }
}

@Preview
@Composable
fun ScaffoldSamplePreview() {
    BasiclayoutsTheme {
        ScaffoldSample()
    }
}