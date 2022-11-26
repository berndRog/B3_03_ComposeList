package de.rogallab.android

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import de.rogallab.android.ui.LazyColumnTest
import de.rogallab.android.ui.MainScreen
import de.rogallab.android.ui.theme.AppTheme

class MainActivity : BaseActivity("ok>MainActivity       .") {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         AppTheme {
            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colors.background
            ) {
               Log.d("ok>ComposeView        .", "Composition")
            // LazyColumnTest()
               MainScreen()
            }
         }
      }
   }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   AppTheme {
//      Greeting("Android")
   }
}
*/