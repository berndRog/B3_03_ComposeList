package de.rogallab.android.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.rogallab.android.application.utilities.LogComp
import de.rogallab.android.model.Task

@Composable
fun TasksList(
   tasks: List<Task>,             // State ↓
   onClicked: (Int) -> Unit,      // Event ↑
   onClose: (Int) -> Unit,        // Event ↑
   modifier: Modifier = Modifier,
) {

   val tag: String = "ok>TaskList           ."
   LogComp(tag, "Start")

   LazyColumn(
      modifier = modifier,
      state = rememberLazyListState()
   ) {
      items(
         items = tasks,                        // List<Task>
         key = { task -> task.id }
      ) { task: Task ->
         TaskItem(
            id = task.id,                       // State ↓  task.ld: Int
            label = task.label,                 // State ↓  task.label: String
            onClose   = { it -> onClose(it)  }, // Event ↑  IconButton(task.id)
            onClicked = { it -> onClicked(it) } // Event ↑  Row(task.id)
         )
      }
   }
}