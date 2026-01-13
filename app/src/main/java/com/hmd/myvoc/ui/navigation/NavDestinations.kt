package com.hmd.myvoc.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Dashboard : Screen()
    
    @Serializable
    data object AddVocabulary : Screen()
    
    @Serializable
    data object MyVocabulary : Screen()
}