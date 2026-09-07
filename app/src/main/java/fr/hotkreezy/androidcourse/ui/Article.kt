package fr.hotkreezy.androidcourse.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.hotkreezy.androidcourse.R
import fr.hotkreezy.androidcourse.ui.theme.AndroidCourseTheme

@Composable
fun Article(
	modifier: Modifier = Modifier
) {
	val image = painterResource(R.drawable.bg_compose_background)

	Column(
		modifier = modifier,
	) {
		Image(painter = image, null)
		Text(
			text = stringResource(R.string.jetpack_compose_tutorial),
			fontSize = 24.sp,
			modifier = Modifier.padding(16.dp)
		)
		Text(
			text = stringResource(R.string.jetpack_compose_about),
			modifier = Modifier.padding(start = 16.dp, end = 16.dp),
			textAlign = TextAlign.Justify
		)
		Text(
			text = stringResource(R.string.jetpack_compose_article),
			modifier = Modifier.padding(16.dp),
			textAlign = TextAlign.Justify
		)
	}
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
	AndroidCourseTheme {
		Article()
	}
}