package fr.hotkreezy.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hotkreezy.androidcourse.ui.theme.AndroidCourseTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			AndroidCourseTheme {
				Scaffold(
					modifier = Modifier.fillMaxSize()
				) { innerPadding ->
					TipCalculatorLayout(modifier = Modifier.padding(innerPadding))
				}
			}
		}
	}
}

@Composable
fun TipCalculatorLayout(
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.safeGesturesPadding(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
	) {
		Text(
			text = "Calculate Tip",
			modifier = Modifier
				.padding(bottom = 16.dp, top = 40.dp)
				.align(alignment = Alignment.Start)
		)
		Text(
			text = "Tip Amount: $0.00",
			style = MaterialTheme.typography.displaySmall
		)
		Spacer(modifier = Modifier.height(150.dp))
	}
}

@Preview(showBackground = true)
@Composable
private fun TipCalculatorPreview() {
	AndroidCourseTheme {
		TipCalculatorLayout()
	}
}

/**
 * Calculates the tip based on the user input and format the tip amount
 * according to the local currency.
 * Example would be "$10.00".
 */
private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
	val tip = tipPercent / 100 * amount
	return NumberFormat.getCurrencyInstance().format(tip)
}