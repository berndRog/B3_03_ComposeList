package de.rogallab.android.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import de.rogallab.android.application.utilities.LogFun
import de.rogallab.android.model.Task

class MainViewModel(
): ViewModel() {

   // fields
   private val tag: String = "ok>MainViewModel      ."
   private var _number: Int = 0
   // properties
   val tasks: SnapshotStateList<Task>  = mutableStateListOf<Task>()


   init {
      for (i in 0..29) add()
   }

   fun get(id: Int): Task? =
      tasks.firstOrNull() { task -> task.id == id}

   fun add() {
      _number++
      val newTask = Task(id = _number, label = "Task # $_number")
      tasks.add(newTask)
      LogFun(tag,"Add $newTask")
   }

   fun update(task: Task) =
      get(task.id)?.let{ it: Task ->
         tasks.remove(it)
         tasks.add(it)
         LogFun(tag,"Update $it")
      }

   fun remove(id: Int) =
      get(id)?.let { it: Task ->
         tasks.remove(it)
         LogFun(tag,"Remove $it")
      }

}