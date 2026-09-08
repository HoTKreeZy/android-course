package fr.hotkreezy.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					VisitCard(Modifier.padding(innerPadding))
				}
			}
		}
	}
}

@Composable
fun VisitCard(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.background(color = Color(0xFF378666))
			.fillMaxSize(),
	) {
		VisitCardHeader(Modifier.padding(top = 160.dp))
		Spacer(Modifier.weight(1f))
		VisitCardInfo()
	}
}

@Composable
fun VisitCardHeader(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		val logo = painterResource(R.drawable.android_logo)
		Image(
			painter = logo,
			contentDescription = "Logo",
			modifier = Modifier.size(176.dp),
		)
		Text(
			"HoTKreeZy",
			fontSize = 48.sp,
		)
		Text(
			"Android Developer",
			color = Color.Green,
		)
	}
}

@Composable
fun VisitCardInfo(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(16.dp)
	) {
		Text("+00 (00) 000 000")
		Text("fake@email.lol")
		Text("@fakeSocialNetworkName")
	}
}

@Preview(showBackground = true)
@Composable
fun VisitCardPreview() {
	AndroidCourseTheme {
		VisitCard()
	}
}