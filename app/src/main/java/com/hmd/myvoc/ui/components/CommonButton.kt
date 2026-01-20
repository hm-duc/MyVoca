package com.hmd.myvoc.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hmd.myvoc.ui.theme.MyVocTheme

@Composable
fun VocButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(56.dp), // Typical standard height for main buttons
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MyVocTheme.customColors.brandBlue,
            contentColor = MyVocTheme.customColors.white
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppButtonPreview() {
    MyVocTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            VocButton(
                text = "Add New Vocabulary",
                icon = Icons.Default.Add,
                onClick = {}
            )
        }
    }
}