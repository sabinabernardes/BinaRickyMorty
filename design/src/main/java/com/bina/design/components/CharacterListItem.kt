package com.bina.design.components

import BinaAppTheme
import SpacingTokens
import TypographyTokens
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.bina.design.tokens.ColorTokens

@Composable
fun CharacterListItem(
    painter: Painter,
    name: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(SpacingTokens.spacing16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painter,
            contentDescription = name,
            modifier = Modifier
                .size(SpacingTokens.spacing54)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(SpacingTokens.spacing16))
        Text(
            text = name,
            style = TypographyTokens.body,
            color = ColorTokens.Primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListItemPreview() {
    BinaAppTheme {
        CharacterListItem(
            painter = ColorPainter(Color.LightGray),
            name = "Rick Sanchez"
        )
    }
}
