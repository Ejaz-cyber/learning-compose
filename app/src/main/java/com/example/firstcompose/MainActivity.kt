package com.example.firstcompose

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstcompose.quotesapp.DataManager
import com.example.firstcompose.quotesapp.screens.QuoteDetails
import com.example.firstcompose.quotesapp.screens.QuoteListItem
import com.example.firstcompose.quotesapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.loadData(applicationContext)
        }
        setContent {
//            com.example.firstcompose.Preview()
//            QuotesApp()
//            SimpleCard()
//            KeyboardComposable()
            Greeting()

        }
    }
}



//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyScaffoldExample() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("My App") },
//                backgroundColor = Color.Gray
//            )
//        },
//        bottomBar = {
//            BottomAppBar {
//                // Add buttons or other content here
//                Text("Bottom Bar")
//            }
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { /* Do something */ }) {
//                Icon(Icons.Filled.Add, contentDescription = "Add")
//            }
//        },
//        drawerContent = {
//            // Add items for the navigation drawer here
//            Text("Drawer Item 1")
//            Text("Drawer Item 2")
//        }
//    ) { innerPadding ->
//        // This is where the main content of the screen goes
//        // The innerPadding parameter provides padding to accommodate system UI elements
//        Text("Main Content", modifier = Modifier.padding(innerPadding))
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun PreviewMyScaffoldExample() {
//    MyScaffoldExample()
//}



@Composable
fun SimpleCard(){
    val title = "this is an android logo image"
    val contentDescription = "this is an android logo image"
    val painter = painterResource(id = R.drawable.ic_launcher_foreground)
    ImageCard(painter, title, contentDescription, Modifier)

    val context = LocalContext.current
    DisposableEffect(key1 = Unit){

        onDispose {

        }
    }

    
    LaunchedEffect(key1 = Unit){

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeyboardComposable() {

    TextField(value = "", onValueChange = {})

    val view = LocalView.current
    DisposableEffect(key1 = Unit){
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisibile = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("MAIN", "isKeyboardVisible $isKeyboardVisibile")
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    title: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp),
        shape = RoundedCornerShape(6.dp),
    ) {
        Image(
            painter = painter, contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)

        )
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                    ),
                    alpha = 0.5f
                )
                .fillMaxWidth()
                .padding(4.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
        }
    }
}


@Composable
fun QuotesApp() {

    if (DataManager.isLoaded.value) {
        if (DataManager.currentPage.value == DataManager.Pages.LIST) {
            QuoteListScreen(quotes = DataManager.quotes) {
                DataManager.switchPage(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading... delay in coroutine")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Greeting(name: String = "ejaz") {
    Column {
        Text(
            text = "Hello $name!",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 34.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Gray, RectangleShape)
                .fillMaxWidth()
        )

        Column {
            listViewItem()
            listViewItem()
            listViewItem()
        }
    }


//    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
//        contentDescription = "dummy iamge",
//        colorFilter = ColorFilter.tint(Color.Gray),
//        contentScale = ContentScale.Crop
//        )

//    Button(onClick = {  },
//        colors = ButtonDefaults.buttonColors(
//            contentColor = Color.Gray,
//            containerColor = Color.Black
//        )
//    ) {
//        Text(text = "abc")
//    }

//    val state = remember{ mutableStateOf("") }
//    TextField(value = state.value, onValueChange = {
//        state.value = it
//    },
//        label = { Text(text = "enter")}
//    )


}

@Composable
fun listViewItem() {
    Row(Modifier.padding(4.dp)) {
        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "person logo",
            Modifier.size(40.dp)
        )

        Column {
            Text(text = "Ejaz Mahmood", fontWeight = FontWeight.Bold)
            Text(text = "Software developer", fontSize = 14.sp)
        }

    }
}