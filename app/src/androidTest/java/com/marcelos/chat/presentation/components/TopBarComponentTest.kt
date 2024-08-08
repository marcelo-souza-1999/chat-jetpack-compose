package com.marcelos.chat.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TopBarComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTopBarDisplaysCorrectly() {
        composeTestRule.setContent {
            ShowTopBar(title = "Título de Teste")
        }

        composeTestRule.onNodeWithTag("topBarComponent").assertIsDisplayed()
        composeTestRule.onNodeWithText("Título de Teste").assertIsDisplayed()
    }
}