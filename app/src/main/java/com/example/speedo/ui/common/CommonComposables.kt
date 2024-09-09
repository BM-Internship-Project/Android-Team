package com.example.speedo.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.speedo.R
import com.example.speedo.ui.theme.appTypography

@Composable
fun InputField(
    fieldId:String,
    value: String,
    label: String,
    hint: String,
    onValueChanged: (String) -> Unit,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp)
) {
    Column {
        Text(text = label, modifier = modifier, style = appTypography.bodySmall)
        var isFocused by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = value,
            label = { if (value.isEmpty() && !isFocused) Text(text = hint) },
            onValueChange = { newValue ->
                onValueChanged(newValue)

            },

            readOnly = readOnly,
            modifier = modifier.onFocusChanged { isFocused = it.isFocused },
        )
    }
}




    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BottomSheet(
        modifier: Modifier = Modifier,
        showBottomSheet: Boolean,
        onDismiss: () -> Unit,
        clickAction: (String) -> Unit
    ) {
        val sheetState = rememberModalBottomSheetState()

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = onDismiss,
                sheetState = sheetState,
                modifier = modifier,
                containerColor = Color.White,
                windowInsets = WindowInsets.systemBars, // Adjust insets as needed
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight() // This makes the sheet cover the entire height
                        .padding(16.dp)
                ) {
                    Row(modifier = Modifier
                        .clickable { clickAction("Egypt"); onDismiss() }
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.egypt),
                            contentDescription = "Egypt flag"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Egypt")
                    }
                    Row(modifier = Modifier
                        .clickable { clickAction("United States"); onDismiss() }
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.united_states),
                            contentDescription = "United States flag"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "United States")
                    }
                }
            }
        }
    }