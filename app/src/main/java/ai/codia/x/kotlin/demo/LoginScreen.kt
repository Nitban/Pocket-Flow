package com.example.myapp

import ai.codia.x.kotlin.demo.R
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(
                onLoginSuccess = {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                },
                onRegisterClick = {
                    val intent = Intent(this, RegisterScreen::class.java)
                    startActivity(intent)
                }
            )
        }
    }
}

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Fondo con gradiente
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.drawable_image_1),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 40.dp)
            )

            // Contenedor blanco con bordes redondeados
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 55.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp)
                ) {
                    Text(
                        text = "Inicio de Sesión",
                        fontSize = 43.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C2D44),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Inicia sesión para continuar",
                        fontSize = 14.sp,
                        color = Color(0xFF666666),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 24.dp)
                    )

                    Text(
                        text = "CORREO",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C2D44),
                        modifier = Modifier.padding(start = 32.dp, bottom = 4.dp)
                    )

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        placeholder = { Text("Ej: Ana Marmolejo") },
                        modifier = Modifier
                            .width(238.dp)
                            .height(47.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black,
                            backgroundColor = Color.Transparent,
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.LightGray
                        )
                    )

                    Text(
                        text = "CONTRASEÑA",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C2D44),
                        modifier = Modifier.padding(start = 32.dp, bottom = 4.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("******") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier
                            .width(238.dp)
                            .height(47.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black,
                            backgroundColor = Color.Transparent,
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.LightGray
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = {
                            if (username.isNotEmpty() && password.isNotEmpty()) {
                                Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                                onLoginSuccess()
                            } else {
                                Toast.makeText(context, "Completa los campos", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .width(210.dp)
                            .height(62.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 8.dp, bottom = 16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1B263A))
                    ) {
                        Text("Log in", fontSize = 20.sp, color = Color.White)
                    }

                    Text(
                        text = "¿No tienes una cuenta?",
                        fontSize = 14.sp,
                        color = Color(0xFF666666),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = "Regístrate",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF101C34),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 4.dp)
                            .clickable { onRegisterClick() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
