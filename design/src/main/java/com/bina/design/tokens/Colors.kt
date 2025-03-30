import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.bina.design.tokens.ColorTokens

val LightColors = lightColorScheme(
    primary = ColorTokens.Primary,
    secondary = ColorTokens.Secondary,
    background = ColorTokens.Background,
    surface = ColorTokens.Surface,
    onPrimary = ColorTokens.OnPrimary,
    onSecondary = ColorTokens.OnSecondary,
    onBackground = ColorTokens.OnBackground,
    onSurface = ColorTokens.OnSurface,
    error = ColorTokens.Error,
)

val DarkColors = darkColorScheme(
    primary = ColorTokens.PrimaryDark,
    onPrimary = ColorTokens.OnPrimaryDark,
    secondary = ColorTokens.SecondaryDark,
    onSecondary = ColorTokens.OnSecondaryDark,
    background = ColorTokens.BackgroundDark,
    onBackground = ColorTokens.OnBackgroundDark,
    surface = ColorTokens.SurfaceDark,
    onSurface = ColorTokens.OnSurfaceDark,
    error = ColorTokens.ErrorDark,
    onError = ColorTokens.OnErrorDark
)
