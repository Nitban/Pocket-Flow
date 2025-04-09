package ai.codia.x.kotlin.demo

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * Base Activity para manejar configuraciones generales.
 */
open class BaseMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Quitar barra de título (opcional, si usas Toolbar personalizada)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Configurar color de la barra de estado
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)

        // Cargar directamente el layout principal que ahora es el de login
        setContentView(R.layout.activity_login)
    }
}