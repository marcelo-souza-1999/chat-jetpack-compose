package com.marcelos.chat.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.marcelos.chat.R
import com.marcelos.chat.presentation.model.ChatViewData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ItemListComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testChatItemDisplaysCorrectly() {
        val chatData = ChatViewData(
            name = "Ellie Willians",
            message = "Não se esqueça de me chamar quando voltar da patrulha",
            image = R.drawable.ellie
        )

        composeTestRule.setContent {
            ChatItem(chatData = chatData)
        }

        composeTestRule.onNodeWithText("Ellie Willians").assertIsDisplayed()
        composeTestRule.onNodeWithText("Não se esqueça de me chamar quando voltar da patrulha").assertIsDisplayed()
    }

    @Test
    fun testChatItemButtonClick() {
        val chatData = ChatViewData(
            name = "Ellie Willians",
            message = "Não se esqueça de me chamar quando voltar da patrulha",
            image = R.drawable.ellie
        )

        composeTestRule.setContent {
            ChatItem(chatData = chatData)
        }

        composeTestRule.onNodeWithText("Ellie Willians").performClick()
    }
}