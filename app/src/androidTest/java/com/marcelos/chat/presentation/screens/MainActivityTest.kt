package com.marcelos.chat.presentation.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.marcelos.chat.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testTopBarIsDisplayed() {
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.title_top_bar)
        ).assertIsDisplayed()
    }

    @Test
    fun testChatItemsAreDisplayed() {
        val context = composeTestRule.activity
        composeTestRule.onNodeWithText(context.getString(R.string.name_ellie)).assertIsDisplayed()
        composeTestRule.onNodeWithText(context.getString(R.string.message_ellie)).assertIsDisplayed()
        composeTestRule.onNodeWithText(context.getString(R.string.joel_name)).assertIsDisplayed()
        composeTestRule.onNodeWithText(context.getString(R.string.message_joel)).assertIsDisplayed()
    }
}