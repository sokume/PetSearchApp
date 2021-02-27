/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.PetSearchViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}


val petSearchViewModel = PetSearchViewModel()

// Start building your app here!
@Composable
fun MyApp() {
    val selectedPet = petSearchViewModel.selectedPet
    Surface(color = MaterialTheme.colors.background) {
        // List
        PetList(
            petList = petSearchViewModel.petList
        )
        // Detail
        selectedPet?.let{
            PetDetailBase(
                pet = it
            )
        }
    }
}

@Composable
fun PetDetailBase(
    pet: Pet,
    modifier: Modifier = Modifier ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        elevation = 8.dp
    ) {
        PetDetailContent(pet,modifier)
        PetDetailAction(modifier)
    }
}

@Composable
fun PetDetailAction(modifier: Modifier) {

    val buttonModifier = Modifier
        .width(75.dp)
        .height(75.dp)
        .padding(8.dp)

    Box (
        modifier = buttonModifier,
        contentAlignment = Alignment.TopEnd,
    ){
        IconButton(onClick = {
            petSearchViewModel.setPet(null)
        },
        ) {
            Icon(Icons.Filled.Close, "" ,modifier)
        }
    }

    Box (
        modifier = buttonModifier,
        contentAlignment = Alignment.BottomEnd
    ){
        IconButton(onClick = {
            petSearchViewModel.checkCountUp()
        }) {
            Icon(Icons.Filled.DoneOutline, "" ,modifier)
        }
    }
}

@Composable
fun PetDetailContent(pet: Pet, modifier: Modifier) {

    Column {
        Row(modifier = Modifier.weight(2.0f, true)) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ){
                AnimalImage(
                    pet.drawableImageId,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(shape = RoundedCornerShape(4.dp))
                )
            }
        }
        Row(modifier = Modifier.weight(1.0f, true)) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp),
            ) {
                Text(
                    text = "Name is ${pet.name} / ${pet.type} \nbirthplace : ${pet.origin} \nbirthday : ${pet.birthday}",
                    style = MaterialTheme.typography.h4,
                )
            }
        }
        Row(modifier = Modifier.weight(1.0f, true)) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp),
            ){
                Text(text = petSearchViewModel.petDetailNote,
                    style = MaterialTheme.typography.h4,
                )
            }
        }
        Row(modifier = Modifier.weight(0.5f, true)) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ){
                StampArea(pet,modifier)
            }
        }
    }
}

@Composable
fun StampArea(pet: Pet, modifier: Modifier) {
    val checkColor = Red
    val notCheck = LightGray
    val petCheckedCount = petSearchViewModel.petCheckedCount

    fun checkColor(index : Int) : Color {
        return if (petCheckedCount > index) checkColor else notCheck
    }

    Row(modifier = Modifier.padding(horizontal = 8.dp)) {
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Send, "" ,modifier, tint = checkColor(10))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(9))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(8))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(7))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(6))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(5))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(4))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(3))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(2))
        }
        Column(modifier = Modifier.weight(1.0f, true)) {
            Icon(Icons.Filled.Check, "" ,modifier, tint = checkColor(1))
        }
    }
}

@Composable
fun PetList(
    petList: List<Pet>,
    modifier: Modifier = Modifier
)
{
    Box(modifier = modifier){
        LazyColumn(
            modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),

            ) {
            items(petList) { pet ->
                Card(elevation = 2.dp) {
                    PetListItem(
                        onClick = {
                            // Click処理
                            petSearchViewModel.setPet(pet)
                        },
                        pet,
                        modifier
                    )
                }
            }
        }
    }
}

@Composable
fun PetListItem(
    onClick: () -> Unit,
    pet: Pet,
    modifier: Modifier
) {
    val squareModifier = Modifier
        .width(75.dp)
        .height(75.dp)

    Box(modifier = modifier.fillMaxWidth()){
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            AnimalImage(
                pet.drawableImageId,
                modifier = squareModifier
                    .clip(shape = RoundedCornerShape(4.dp))
            )

            Text(
                text = pet.name,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .height(75.dp)
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                onClick = onClick,
                modifier = squareModifier,
            ){
                Icon(Icons.Filled.Favorite, "" ,modifier, tint = Red)
            }
        }
    }

}

@Composable
fun AnimalImage(drawableImageId: Int, modifier: Modifier) {
    val image: Painter = painterResource(id = drawableImageId)
    Image(image,"" , modifier = modifier, contentScale = ContentScale.Crop)
}


