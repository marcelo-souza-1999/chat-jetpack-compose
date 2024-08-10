package com.marcelos.chat.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marcelos.chat.R
import com.marcelos.chat.presentation.components.ChatItem
import com.marcelos.chat.presentation.components.ShowTopBar
import com.marcelos.chat.presentation.model.ChatViewData
import com.marcelos.chat.presentation.theme.ChatTheme
import com.marcelos.chat.presentation.theme.GreenDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = GreenDark.toArgb()
            )
        )
        setContent {
            ChatTheme {
                Scaffold(topBar = {
                    ShowTopBar(title = getString(R.string.title_top_bar))
                }) { innerPadding ->
                    ChatScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun ChatScreen(modifier: Modifier = Modifier) {
    val listChats = getChatList()
    LazyColumn(
        modifier.fillMaxSize()
    ) {
        items(listChats) { chatData ->
            AnimatedChatItem(chatData = chatData)
        }
    }
}

@Composable
private fun AnimatedChatItem(chatData: ChatViewData) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .clickable { isExpanded = !isExpanded }
    ) {
        ChatItem(chatData = chatData)

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Conteúdo expandido para ${chatData.name}")
            }
        }
    }
}

@Composable
private fun getChatList(): List<ChatViewData> {
    val context = LocalContext.current
    return remember {
        listOf(
            ChatViewData(
                name = context.getString(R.string.name_ellie),
                message = context.getString(R.string.message_ellie),
                image = R.drawable.ellie
            ), ChatViewData(
                name = context.getString(R.string.joel_name),
                message = context.getString(R.string.message_joel),
                image = R.drawable.joel
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}
