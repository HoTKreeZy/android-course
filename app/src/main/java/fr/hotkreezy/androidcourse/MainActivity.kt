package fr.hotkreezy.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import fr.hotkreezy.androidcourse.ui.Article
import fr.hotkreezy.androidcourse.ui.theme.AndroidCourseTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			AndroidCourseTheme {
				Scaffold(
					modifier = Modifier.fillMaxSize(),
				) { innerPadding ->
					// GreetingImage(
					// 	message = stringResource(R.string.happy_birthday_text),
					// 	from = stringResource(R.string.signature_text),
					// 	modifier = Modifier.padding(innerPadding),
					// )
					Article(Modifier.padding(innerPadding))
				}
			}
		}
	}
}

