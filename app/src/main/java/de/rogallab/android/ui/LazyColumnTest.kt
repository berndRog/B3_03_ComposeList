package de.rogallab.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun LazyColumnTest() {

   val people = remember {
      mutableStateListOf<Person>(
         Person(firstName="Achim",lastName="Arndt"),
         Person(firstName="Beate",lastName="Bauer"),
         Person(firstName="Christian",lastName="Conrad"),
         Person(firstName="Dorothee",lastName="Dietrichs")
      )
   }

   LazyColumn(
      state = rememberLazyListState(),
      contentPadding = PaddingValues(all = 8.dp),
   ){
      // LayList Scope block

      // Single item
      item {
         Divider()
         Text(
            text = "Single Item",

            modifier = Modifier
               .padding(vertical = 8.dp)
               .fillMaxWidth()
         )
         Divider()
      }

      // multiple items
      items(
         items = people,
         key = { person -> person.id }
      ) { person ->

//       val id = person.id.toString().subSequence(0,18)

         Column(
            modifier = Modifier.fillMaxWidth()
         ) {
            Text(
               text = "${person.id.toString()}",
               modifier = Modifier.padding(top = 8.dp)
            )
            Text(
               text = "${person.firstName} ${person.lastName}",
               modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider()

         }
      }
   }
}

data class Person(
   var id: UUID = UUID.randomUUID(),
   var firstName: String ="",
   var lastName: String = ""
)
