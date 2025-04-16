package com.example.myapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class RegisterScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                RegisterScreen(onRegister = {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                })
            }
        }
    }
}

@Composable
fun RegisterScreen(onRegister: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }

    // Fondo degradado
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF5B86E5), // Azul degradado
                        Color(0xFF36D1DC)  // Celeste degradado
                    )
                )
            )
    ) {
        // Contenedor principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 55.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                )
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Crear Cuenta",
                fontSize = 43.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1C2D44),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campos de entrada
            InputField(label = "NOMBRE", value = name, onValueChange = { name = it }, hint = "Ej: Ana Marmolejo")
            InputField(label = "CORREO", value = email, onValueChange = { email = it }, hint = "anamarmolejo@hotmail.com")
            InputField(label = "CONTRASEÑA", value = password, onValueChange = { password = it }, isPassword = true, hint = "******")
            InputField(label = "CONFIRMAR CONTRASEÑA", value = confirmPassword, onValueChange = { confirmPassword = it }, isPassword = true, hint = "******")
            InputField(label = "FECHA DE NACIMIENTO", value = birthDate, onValueChange = { birthDate = it }, hint = "02 de Marzo")

            Spacer(modifier = Modifier.weight(1f))

            // Botón de registro
            Button(
                onClick = onRegister,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1B263A)),
                modifier = Modifier
                    .width(210.dp)
                    .height(62.dp)
            ) {
                Text("Registrar", fontSize = 20.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    hint: String = ""
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp) // Espaciado entre campos
    ) {
        // Etiqueta del campo
        Text(
            text = label,
            color = Color(0xFF1C2D44),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp, bottom = 4.dp)
        )

        // Campo de texto
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(hint) },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true, // Evita múltiples líneas en el campo de texto
            modifier = Modifier
                .fillMaxWidth() // Adapta al ancho disponible
                .padding(horizontal = 16.dp) // Márgenes laterales
                .height(47.dp) // Altura del campo
                .background(Color.White, RoundedCornerShape(8.dp))
        )
    }
}