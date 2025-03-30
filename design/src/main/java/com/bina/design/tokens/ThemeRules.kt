import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bina.design.tokens.ColorTokens


object SpacingTokens {
    val spacing2 = 2.dp
    val spacing4 = 4.dp
    val spacing8 = 8.dp
    val spacing16 = 16.dp
    val spacing24 = 24.dp
    val spacing32 = 32.dp
    val spacing54 = 54.dp
}

object TypographyTokens {
    val heading = androidx.compose.ui.text.TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = ColorTokens.OnBackground
    )

    val body = androidx.compose.ui.text.TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = ColorTokens.OnBackground
    )

    val caption = androidx.compose.ui.text.TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        color = ColorTokens.OnBackground
    )
}