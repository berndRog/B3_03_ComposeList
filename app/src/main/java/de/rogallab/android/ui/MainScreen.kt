package de.rogallab.android.ui
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.rogallab.android.application.utilities.LogComp
import de.rogallab.android.application.utilities.LogFun
import de.rogallab.android.model.Task

@Composable
fun MainScreen(
   viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
   modifier: Modifier = Modifier
) {

   val tag: String = "ok>MainScreen         ."
   LogComp(tag, "Start")

   Column(modifier = modifier) {

      Button(
         onClick = { viewModel.add() },
         modifier = Modifier.fillMaxWidth()
      ) {
         Text(text="Add a Task")
      }

      TasksList(
         tasks = viewModel.tasks,
         onClicked = { id ->
            viewModel.get(id)?.let{ task: Task ->
               LogFun(tag,"TaskItem $id clicked -> DetailScreen")
            }
         },
         onClose = { id -> viewModel.remove(id) }
      )
   }
}