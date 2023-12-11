package com.app.oneplace.domain.usecase.category

import android.hardware.biometrics.BiometricManager.Strings
import com.app.oneplace.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    suspend operator fun invoke(): Flow<NetworkResponseState<List<String>>>
}