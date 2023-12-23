package com.app.oneplace.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.oneplace.R
import com.app.oneplace.common.ScreenState
import com.app.oneplace.ui.screens.auth.viewModels.ForgetPasswordViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordBottomSheet(
    // unit is like void in java
    onDismiss:()->Unit,
    // here =hiltViewModel means it returns the existing viewModel
    viewModel: ForgetPasswordViewModel= hiltViewModel()
){
    // rememberModalBottomSheetState is used to know the state of the sheet
    val modelBottomSheetState = rememberModalBottomSheetState()
    /*
    * by keyword is used in the context of delegation.
    * Delegation is a design pattern where an object hands over its responsibilities to another helper object
    * here we define the by keyword state which is State of viewModel is delegate result
    * to the viewModel.forgetPassword.observerAsState()
    * If you use = instead of by in the code you provided, it would change the behavior, and the automatic
    * recomposition that observeAsState() provides would not work as expected.
    * */
    val state by viewModel.forgetPassword.observeAsState()
    // when is like switch case from java it will give result based on the state
    when(state){
        is ScreenState.Loading -> {}
        is ScreenState.Success -> {onDismiss()}
        is ScreenState.Error -> {
            Error(message = (state as ScreenState.Error).message)
        }
        else -> {
            // does nothing
        }
    }
    /*
    * ModalBottomSheetLayout is specifically designed for creating modal bottom sheets in Jetpack Compose.
    * It allows you to create a modal bottom sheet that appears above your existing UI and can be dismissed by
    * swiping down or tapping outside the sheet.
    * Another option is to use the Bottom Sheet Scaffold but from the application pov we need to use
    * ModalBottom Sheet because either login or reset password page should be active not both
    * both of them being active is not good from app useCase point of view
    * BottomSheetScaffold is used to create a bottom sheet layout in your Compose app.
    * It provides a scaffold that can host a bottom sheet as well as other composable in the content area.
    * */
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modelBottomSheetState,
        dragHandle = {BottomSheetDefaults.DragHandle()},
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                // String resource is used to utilize the strings re-usability by not directly coding it
                text = stringResource(R.string.please_enter_the_email),
                style = MaterialTheme.typography.bodyMedium,
                modifier=Modifier.padding(bottom=8.dp)
            )
            var email by remember { mutableStateOf("")}
            OutlinedTextField(
                value = email,
                onValueChange = {email=it},
                label = { Text(text = stringResource(id = R.string.please_enter_the_email))},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    // it is used to show done or next in the confirm area of the keyboard of app
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                if(email.isNotEmpty()){
                    viewModel.forgotPassword(email=email)
                }else{
                    return@Button
                }
            },modifier=Modifier.fillMaxWidth(),
            ) {
                Text(text = stringResource(id = R.string.reset_password))
            }
        }
    }
}