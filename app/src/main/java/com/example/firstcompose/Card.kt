package com.example.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
//    Column (Modifier.size(500.dp) ,Modifier.scrollable(rememberScrollState())) {
//        getCategoryList().map { item ->
//            BlogCategory(item.name, item.title)
//        }
//    }

    LazyColumn(content = {
        items(getCategoryList()){item ->
            BlogCategory(name = item.name, title = item.title)
        }
    })
}
@Composable
fun BlogCategory(name: String, title: String) {
    Card (
        modifier = Modifier.padding(8.dp),
    ) {
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Description(name, title, Modifier.weight(0.8f))
        }
    }
}

@Composable
private fun Description(name: String,title: String, modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.baseline_person_24),
        contentDescription = "a",
        modifier = Modifier
            .size(48.dp)
            .padding(8.dp)
    )
    Column(modifier) {
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

data class Category(val name: String, val title: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category("Ejaz", "Mobile developer"))
    list.add(Category("Sultan", "web developer"))
    list.add(Category("Rohit", "Backend developer"))
    list.add(Category("Ariz", "Backend developer, Node JS"))
    list.add(Category("Rahman", "Frontend developer, React, Angular"))
    list.add(Category("Sunio", "Manual tester"))
    list.add(Category("Giyan", "Automation tester, Selenium"))

    list.add(Category("Ejaz", "Mobile developer"))
    list.add(Category("Sultan", "web developer"))
    list.add(Category("Rohit", "Backend developer"))
    list.add(Category("Ariz", "Backend developer, Node JS"))
    list.add(Category("Rahman", "Frontend developer, React, Angular"))
    list.add(Category("Sunio", "Manual tester"))
    list.add(Category("Giyan", "Automation tester, Selenium"))
    list.add(Category("Ejaz", "Mobile developer"))
    list.add(Category("Sultan", "web developer"))
    list.add(Category("Rohit", "Backend developer"))
    list.add(Category("Ariz", "Backend developer, Node JS"))
    list.add(Category("Rahman", "Frontend developer, React, Angular"))
    list.add(Category("Sunio", "Manual tester"))
    list.add(Category("Giyan", "Automation tester, Selenium"))
    list.add(Category("Ejaz", "Mobile developer"))
    list.add(Category("Sultan", "web developer"))
    list.add(Category("Rohit", "Backend developer"))
    list.add(Category("Ariz", "Backend developer, Node JS"))
    list.add(Category("Rahman", "Frontend developer, React, Angular"))
    list.add(Category("Sunio", "Manual tester"))
    list.add(Category("Giyan", "Automation tester, Selenium"))

    return list
}