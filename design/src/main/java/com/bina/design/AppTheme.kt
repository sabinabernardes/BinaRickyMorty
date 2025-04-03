import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable


@Composable
fun BinaAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(
            bodyLarge = TypographyTokens.body,
            titleLarge = TypographyTokens.heading,
            labelSmall = TypographyTokens.caption
        ),
        content = content
    )
}
