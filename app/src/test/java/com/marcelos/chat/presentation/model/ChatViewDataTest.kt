package com.marcelos.chat.presentation.model

import com.marcelos.chat.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ChatViewDataTest {

    @Test
    fun testChatViewDataCreation() {
        val chatData = ChatViewData(
            name = "Ellie Willians",
            message = "Não se esqueça de me chamar quando voltar da patrulha",
            image = R.drawable.ellie
        )

        assertEquals("Ellie Willians", chatData.name)
        assertEquals("Não se esqueça de me chamar quando voltar da patrulha", chatData.message)
        assertEquals(R.drawable.ellie, chatData.image)
    }

    @Test
    fun testChatViewDataEquality() {
        val chatData1 = ChatViewData(
            name = "Ellie Willians",
            message = "Não se esqueça de me chamar quando voltar da patrulha",
            image = R.drawable.ellie
        )
        val chatData2 = ChatViewData(
            name = "Ellie Willians",
            message = "Não se esqueça de me chamar quando voltar da patrulha",
            image = R.drawable.ellie
        )

        assertEquals(chatData1, chatData2)
    }

    @Test
    fun testChatViewDataInequality() {
        val chatData1 = ChatViewData(
            name = "Ellie Willians",
            message = "Não se esqueça de me chamar quando voltar da patrulha",
            image = R.drawable.ellie
        )
        val chatData2 = ChatViewData(
            name = "Joel Miller",
            message = "Precisamos conversar.",
            image = R.drawable.joel
        )

        assertNotEquals(chatData1, chatData2)
    }

    @Test
    fun testChatViewDataCopy() {
        val chatData1 = ChatViewData(
            name = "Ellie Willians",
            message = "Não se esqueça de me chamar quando voltar da patrulha",
            image = R.drawable.ellie
        )
        val chatData2 = chatData1.copy(name = "Joel Miller")

        assertEquals("Joel Miller", chatData2.name)
        assertEquals(chatData1.message, chatData2.message)
        assertEquals(chatData1.image, chatData2.image)
        assertNotEquals(chatData1, chatData2)
    }
}