package fr.hotkreezy.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
					GreetingImage(
						message = "Happy Birthday Sam!",
						from = "From Emma",
						modifier = Modifier.padding(innerPadding),
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
		modifier = modifier,
		verticalArrangement = Arrangement.Center,
	) {
		Text(
			text = message,
			fontSize = 100.sp,
			textAlign = TextAlign.Center,
			lineHeight = 116.sp,
		)
		Text(
			text = from,
			fontSize = 36.sp,
			modifier = Modifier
				.align(alignment = Alignment.End)
				.padding(16.dp),
		)
	}
}

@Composable
fun GreetingImage(
	message: String,
	from: String,
	modifier: Modifier = Modifier,
) {
	val image = painterResource(R.drawable.androidparty)
	Box(
		modifier = modifier,
	) {
		Image(painter = image, contentDescription = null)
		GreetingText(message, from, Modifier.fillMaxSize())
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	AndroidCourseTheme {
		GreetingImage(message = "Happy Birthday Sam!", from = "From Emma")
	}
}