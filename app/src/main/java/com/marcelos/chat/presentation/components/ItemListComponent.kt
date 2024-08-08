package com.marcelos.chat.presentation.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.marcelos.chat.R
import com.marcelos.chat.presentation.model.ChatViewData
import com.marcelos.chat.presentation.theme.GrayDivider
import com.marcelos.chat.presentation.theme.TypographyMessage
import com.marcelos.chat.presentation.theme.TypographyName
import com.marcelos.chat.presentation.theme.White

@Composable
fun ChatItem(
    chatData: ChatViewData
) {
    val context = LocalContext.current
    val margin8 = dimensionResource(id = R.dimen.size_8)
    val margin16 = dimensionResource(id = R.dimen.size_16)
    val margin20 = dimensionResource(id = R.dimen.size_20)
    val imageSize = dimensionResource(id = R.dimen.size_80)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(margin8)
    ) {
        val (txtName, imgProfile, txtMessage, divider) = createRefs()

        Image(
            painter = painterResource(id = chatData.image),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .constrainAs(imgProfile) {
                    top.linkTo(parent.top, margin8)
                    start.linkTo(parent.start, margin16)
                },
            contentScale = ContentScale.Crop
        )

        TextButton(
            onClick = {
                Toast.makeText(
                    context,
                    chatData.name,
                    Toast.LENGTH_SHORT
                ).show()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = White
            ),
            modifier = Modifier
                .constrainAs(txtName) {
                    start.linkTo(imgProfile.end, margin8)
                    top.linkTo(parent.top, margin8)
                    end.linkTo(parent.end, margin8)
                }
        ) {
            Text(
                text = chatData.name,
                style = TypographyName.bodyLarge
            )
        }

        Text(
            text = chatData.message,
            style = TypographyMessage.bodyLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(txtMessage) {
                    top.linkTo(txtName.bottom, margin8)
                    start.linkTo(imgProfile.end, margin8)
                    end.linkTo(parent.end, margin8)
                    width = Dimension.fillToConstraints
                }
        )

        HorizontalDivider(
            color = GrayDivider,
            modifier = Modifier
                .constrainAs(divider) {
                    start.linkTo(parent.start, margin8)
                    end.linkTo(parent.end, margin8)
                    top.linkTo(txtMessage.bottom, margin20)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatItem() {
    val sampleChat = ChatViewData(
        name = "Ellie Willians",
        message = "Não se esqueça de me chamar quando voltar da patrulha",
        image = R.drawable.ellie
    )
    ChatItem(chatData = sampleChat)
}
