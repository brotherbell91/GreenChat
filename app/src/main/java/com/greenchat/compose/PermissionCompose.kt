package com.greenchat.compose

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.greenchat.R
import com.greenchat.data.PermissionData
import com.greenchat.navigation.Screen
import com.greenchat.ui.colorPrimary
import com.greenchat.ui.dark_gray
import com.greenchat.ui.ghost_white
import com.greenchat.ui.image_gray
import com.greenchat.viewmodel.MyViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun PermissionScreen(navController: NavController, viewModel: MyViewModel) {
    val context = LocalContext.current
    val permissionData by viewModel.permissionData.collectAsState()
    var showRationale by remember{ mutableStateOf(false) }

    val permissionsState = rememberMultiplePermissionsState(
        permissions = permissionData.map { it.permission }
    )

    permissionsState.permissions.forEach { permissionStateItem ->
        LaunchedEffect(permissionStateItem.status.isGranted) {
            if(permissionStateItem.status.isGranted){
                viewModel.updatePermissionState(permissionStateItem.permission)
            }
        }
    }

    LaunchedEffect(permissionsState.allPermissionsGranted) {
        if (permissionsState.allPermissionsGranted) {
            navController.navigate(Screen.Login.route)
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {CustomTopAppBar(false, onClose = {})},
            content = { paddingValues ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    color = colorPrimary) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = ghost_white),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(top = 30.dp, start = 30.dp, end = 30.dp)
                                .weight(1f),
                        ) {
                            val loginText = "Allow Required Permissions."
                            val loginWord = "Allow"
                            val loginAnnotatedString = buildAnnotatedString {
                                append(loginText)
                                addStyle(
                                    style = SpanStyle(
                                        color = dark_gray,
                                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                                    ),
                                    start = 0,
                                    end = loginText.length
                                )
                                addStyle(
                                    style = SpanStyle(
                                        color = colorPrimary,
                                        fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                                    ),
                                    start = 0,
                                    end = loginWord.length
                                )
                            }

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp, bottom = 20.dp),
                                text = loginAnnotatedString,
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                            )

                            PermissionItems(permissionData)
                        }

                        Column(
                            modifier = Modifier
                                .padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 15.dp)
                        ){
                            Button(
                                onClick = {
                                    if (permissionsState.shouldShowRationale) {
                                        showRationale = true
                                    } else {
                                        permissionsState.launchMultiplePermissionRequest()
                                    }
                                          },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(52.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(colorPrimary),
                            ) {
                                Text(
                                    modifier = Modifier.padding(top = 7.dp, bottom = 7.dp),
                                    text = "Allow All",
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleSmall
                                        .copy(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                )
                            }
                        }
                    }
                }
            },
        )
    }

    if (showRationale) {
        AlertDialog(
            onDismissRequest = { showRationale = false },
            title = { Text(stringResource(R.string.permission_alert_title)) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.greenchat_logo_icon),
                    contentDescription = "GreenChat Logo",
                    modifier = Modifier.size(96.dp)
                )
            },
            text = { Text(stringResource(R.string.permission_alert_description)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        showRationale = false
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    }
                ) {
                    Text(stringResource(R.string.permission_alert_open_settings), color = colorPrimary)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showRationale = false
                }) {
                    Text(stringResource(R.string.permission_alert_cancel), color = colorPrimary)
                }
            },
            containerColor = ghost_white,
            iconContentColor = colorPrimary,
        )
    }
}

@Composable
fun PermissionItems(permissions: List<PermissionData>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(permissions.count()) { index ->
            PermissionItem(permissions[index])
        }
    }
}

@Composable
fun PermissionItem(permission: PermissionData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = permission.name, style = MaterialTheme.typography.titleSmall)
                    Text(text = permission.description, style = MaterialTheme.typography.bodySmall)
                }
                Image(
                    modifier = Modifier.wrapContentWidth(),
                    painter = painterResource(id = R.drawable.baseline_check_24),
                    colorFilter = ColorFilter.tint(if (permission.state) colorPrimary else image_gray),
                    contentDescription = "header_view_flower_logo"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPermissionScreen() {
    PermissionScreen(navController = rememberNavController(), viewModel = viewModel())
}