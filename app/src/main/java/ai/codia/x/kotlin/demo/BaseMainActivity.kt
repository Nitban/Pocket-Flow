package ai.codia.x.kotlin.demo

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.myapp.LoginScreen

/**
 * Base Activity para manejar configuraciones generales.
 */
open class BaseMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Quitar barra de título (opcional, si usas Toolbar personalizada)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Configurar la barra de estado para usar un color específico
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)

        // Hace que el contenido se dibuje detrás de la barra de estado si es necesario
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Cargar el contenido principal con Jetpack Compose
        setContent {
            BaseMainScreen()
        }
    }
}

@Composable
fun BaseMainScreen() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Aquí puedes llamar tu pantalla principal, como LoginScreen
            LoginScreen(
                onLoginSuccess = {
                    // Manejar la lógica de inicio exitoso
                },
                onRegisterClick = {
                    // Manejar la navegación al registro
                }
            )
        }
    }
}