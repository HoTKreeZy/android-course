package fr.hotkreezy.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
	val textState = rememberTextFieldState()
	val amount = textState.text.toString().toDoubleOrNull() ?: 0.0
	val tipState = rememberTextFieldState()
	val tipPercent = tipState.text.toString().toDoubleOrNull() ?: 0.0
	val tip = calculateTip(amount, tipPercent)

	Column(
		modifier = modifier
			.fillMaxSize()
			.safeGesturesPadding(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
	) {
		Text(
			text = stringResource(R.string.calculate_tip),
			modifier = Modifier
				.padding(bottom = 16.dp, top = 40.dp)
				.align(alignment = Alignment.Start)
		)
		EditNumberField(
			label = R.string.bill_amount,
			state = textState,
			keyboardOptions = KeyboardOptions.Default.copy(
				imeAction = ImeAction.Next
			),
			modifier = Modifier
				.padding(bottom = 32.dp)
				.fillMaxWidth()
		)
		EditNumberField(
			label = R.string.how_was_the_service,
			state = tipState,
			modifier = Modifier
				.padding(bottom = 32.dp)
				.fillMaxWidth(),
		)
		Text(
			text = stringResource(R.string.tip_amount, tip),
			style = MaterialTheme.typography.displaySmall
		)
		Spacer(modifier = Modifier.height(150.dp))
	}
}

@Composable
fun EditNumberField(
	@StringRes label: Int,
	state: TextFieldState,
	modifier: Modifier = Modifier,
	keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
	OutlinedTextField(
		state = state,
		modifier = modifier,
		label = { Text(stringResource(label)) },
		keyboardOptions = keyboardOptions.copy(
			keyboardType = KeyboardType.Number
		),
		lineLimits = TextFieldLineLimits.SingleLine,
	)
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