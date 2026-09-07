package fr.hotkreezy.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
					GreetingText(
						message = "Happy Birthday Sam!",
						from = "From Emma",
						modifier = Modifier.padding(innerPadding)
					)
				}
			}
		}
	}
}

@Composable
fun GreetingText(
	message: String,
	from: String,
	modifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center
	) {
		Text(
			text = message,
			fontSize = 100.sp,
			textAlign = TextAlign.Center,
			lineHeight = 116.sp
		)
		Text(
			text = from,
			fontSize = 36.sp,
			modifier = Modifier
				.align(alignment = Alignment.End)
				.padding(16.dp)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	AndroidCourseTheme {
		GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
	}
}