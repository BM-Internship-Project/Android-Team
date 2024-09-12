package com.example.speedotransferapp.ui.signup

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import com.example.speedotransferapp.R
import com.example.speedotransferapp.constant.AppRoutes
import com.example.speedotransferapp.ui.common.BottomSheet
import com.example.speedotransferapp.ui.common.CommonComposableViewModel
import com.example.speedotransferapp.ui.common.InputField
import com.example.speedotransferapp.ui.common.SpeedoTransferText
import com.example.speedotransferapp.ui.theme.G0
import com.example.speedotransferapp.ui.theme.P20
import com.example.speedotransferapp.ui.theme.P300
import com.example.speedotransferapp.ui.theme.appTypography

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtraSignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = SignUpViewModel(),
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val name by viewModel.fullName.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val country by viewModel.country.collectAsState()
    val dateOfBirth by viewModel.dateOfBirth.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedLabel by remember { mutableStateOf("") }
    val view_model = remember { CommonComposableViewModel() }
    val snackbarHostState = remember { SnackbarHostState() }

    val token = viewModel.loadToken(context)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(G0, P20)
                )
            ),
        topBar = {
            TopAppBar(
                title = {

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                )
            )
        },
        containerColor = Color.Transparent,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            SpeedoTransferText()
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = "Welcome to Banque Misr", style = appTypography.headlineLarge)
            Spacer(modifier = Modifier.padding(8.dp))
            Text(text = "Let's Complete your Profile")
            Spacer(modifier = Modifier.padding(8.dp))
            InputField(
                viewModel = view_model,
                value = selectedLabel,
                label = "Country",
                fieldId = "country",
                hint = "Select your country",
                onValueChanged = { viewModel.setCountry(it) },
                isClickable = true,
                clickAction = {
                    showBottomSheet = true; viewModel.loadSignUpData(context)
                },  // Changed this line
                readOnly = true,
                trailingIcon = R.drawable.chevron_down,
            )
            BottomSheet(
                showBottomSheet = showBottomSheet,
                onDismiss = { showBottomSheet = false },
                clickAction = {
                    selectedLabel = it; viewModel.setCountry(it); showBottomSheet = false
                }
            )

            Spacer(modifier = Modifier.padding(8.dp))
            InputField(
                viewModel = view_model,
                value = selectedDate,
                fieldId = "dateOfBirth",
                label = "Date of Birth",
                hint = "DD/MM/YYYY",
                onValueChanged = { viewModel.setDateOfBirth(it) },
                isClickable = true,
                clickAction = { viewModel.showDatePicker(navController.context) },
                trailingIcon = R.drawable.date,
                keyboardType = KeyboardType.Uri
            )

            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = {
                    viewModel.signUp(context, name, email, password, country, dateOfBirth)
                    Log.d("ExtraSignUpScreen", "token: $token")

                        navController.navigate(AppRoutes.HOME_ROUTE)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = P300),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(16.dp),
                enabled = country.isNotBlank() && dateOfBirth.isNotBlank()
            ) {
                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        color = Color.White,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun SideScreen(onDismiss: () -> Unit) {
    Popup(alignment = Alignment.CenterEnd, onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(300.dp)
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column {
                Text(text = "Select an Option", style = MaterialTheme.typography.bodyMedium)
                // Add your list items here
                Button(onClick = onDismiss) {
                    Text(text = "Close")
                }
            }
        }
    }
}

@Preview
@Composable
private fun ExtraSignUpScreenPreview() {
    //ExtraSignUpScreen(viewModel = SignUpViewModel())
}