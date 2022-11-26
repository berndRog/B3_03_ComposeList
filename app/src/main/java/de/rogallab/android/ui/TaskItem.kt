package de.rogallab.android.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.rogallab.android.application.utilities.LogComp
import de.rogallab.android.application.utilities.LogFun

@Composable
fun TaskItem(
   id: Int,                            // State ↓
   label: String,                      // State ↓
   onClose: (Int)-> Unit,              // Event ↑  IconButton
   onClicked: (Int) -> Unit            // Event ↑  TaskItem
) {

   val tag: String = "ok>TaskItem           ."
   LogComp(tag, "Task: $id $label")

   // import androidx.compose.runtime.getValue
   // import androidx.compose.runtime.setValue
   var checked: Boolean by rememberSaveable{ mutableStateOf(false) }

   Column() {

      Row(
         verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier
            .clickable { onClicked(id) }              // Event ↑
      ) {
         Text(
            text = label,                             // State ↓
            style = MaterialTheme.typography.h6,
            modifier = Modifier
               .padding(start = 16.dp)
               .weight(0.7f)
         )

         Checkbox(
            checked = checked ,                 // State ↓
            onCheckedChange = {                 // Event -> remember
               LogFun(tag, "Checkbox $id clicked: $it")
               checked = it
            },
            modifier = Modifier.weight(0.2f)
         )

         IconButton(
            onClick = {  onClose(id) },                // Event ↑
            modifier = Modifier
               .padding(end = 16.dp)
               .weight(0.1f)
         ) {
            Icon(
               imageVector = Icons.Filled.Close,
               contentDescription = "Delete item"
            )
         }
      }

      Divider()
   }
}