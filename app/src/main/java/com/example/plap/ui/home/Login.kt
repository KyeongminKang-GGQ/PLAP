package com.example.plap.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plap.R
import com.example.plap.TopAppBar
import com.example.plap.ui.theme.Kakao
import com.example.plap.ui.theme.PLAPTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PLAPTheme {
        Login(
            onBackPress = {}
        )
    }
}

@Composable
fun Login(
    onBackPress: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(onBackPress = onBackPress)

        Spacer(modifier = Modifier.size(80.dp))

        Text(
            text = "로그인",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Column(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(20.dp))

            InputForm(
                title = "이메일",
                hint = "example@example.com",
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {}
            )

            Spacer(modifier = Modifier.size(12.dp))

            InputForm(
                title = "비밀번호",
                hint = "8자 이상의 영문, 숫자",
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {}
            )

            Spacer(modifier = Modifier.size(12.dp))

            Text(
                text = "비밀번호를 잊으셨나요?"
            )

            Spacer(modifier = Modifier.size(40.dp))

            PlapButton(
                backgroundColor = androidx.compose.material.MaterialTheme.colors.primary,
                contentColor = Color.White,
                text = "이메일로 로그인",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(12.dp))

            PlapButton(
                iconPainter = painterResource(id = R.drawable.ic_kakao),
                backgroundColor = Kakao,
                contentColor = Color.Black,
                text = "카카오로 3초만에 시작하기",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun InputForm(
    title: String,
    hint: String,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
        )
        OutlinedTextField(
            value = "",
            placeholder = { Text(hint) },
            onValueChange = onValueChange,
        )
    }
}

@Composable
fun PlapButton(
    iconPainter: Painter? = null,
    backgroundColor: Color,
    contentColor: Color,
    text: String,
    modifier: Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        modifier = modifier
    ) {
        if (iconPainter != null) {
            Icon(painter = iconPainter, contentDescription = null)
        }
        Text(text = text)
    }
}