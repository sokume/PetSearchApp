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
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.PetSearchViewModel
import java.time.format.TextStyle

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

// Start building your app here!
@Composable
fun MyApp() {
    val petSearchViewModel = PetSearchViewModel()
    Surface(color = MaterialTheme.colors.background) {
        MessageList(
            petSearchViewModel.petList,
            Modifier)
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

@Composable
fun MessageList(
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
                PetListItem(
                    onClick = {
                              // Click処理
                    },
                    pet,
                    modifier
                )
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
            Button(
                onClick = onClick,
                modifier = squareModifier,

                ){

            }

        }
    }

}

@Composable
fun AnimalImage(drawableImageId: Int, modifier: Modifier) {
    val image: Painter = painterResource(id = drawableImageId)
    Image(image,"" , modifier = modifier, contentScale = ContentScale.Crop)
}


