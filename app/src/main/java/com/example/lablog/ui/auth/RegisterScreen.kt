package com.example.lablog.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var konfirmasiPassword by remember { mutableStateOf("") }
    var pesanError by remember { mutableStateOf("") }
    var pesanSukses by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Buat Akun LabLog",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Daftar untuk mulai mencatat praktikum")

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Lengkap") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = konfirmasiPassword,
            onValueChange = { konfirmasiPassword = it },
            label = { Text("Konfirmasi Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                pesanError = ""
                pesanSukses = ""

                when {
                    nama.isBlank() -> {
                        pesanError = "Nama lengkap harus diisi"
                    }
                    email.isBlank() -> {
                        pesanError = "Email harus diisi"
                    }
                    !email.contains("@") -> {
                        pesanError = "Format email tidak valid"
                    }
                    password.isBlank() -> {
                        pesanError = "Password harus diisi"
                    }
                    konfirmasiPassword.isBlank() -> {
                        pesanError = "Konfirmasi password harus diisi"
                    }
                    password != konfirmasiPassword -> {
                        pesanError = "Password tidak cocok"
                    }
                    else -> {
                        pesanSukses = "Validasi berhasil! Data siap didaftarkan."
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Daftar")
        }

        if (pesanError.isNotEmpty()) {
            Text(
                text = pesanError,
                color = MaterialTheme.colorScheme.error
            )
        }

        if (pesanSukses.isNotEmpty()) {
            Text(
                text = pesanSukses,
                color = MaterialTheme.colorScheme.primary
            )
        }

        TextButton(onClick = onLoginClick) {
            Text("Sudah punya akun? Login")
        }
    }
}
