import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nicatravel.R

class ShowScannedContentActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_scanned_content)

        // Establece la orientación de pantalla en vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)




        textView = findViewById(R.id.textView)

        // Verifica si el extra "scannedContent" existe.
        if (intent.hasExtra("scannedContent")) {
            // Obtiene el valor del extra "scannedContent".
            val scannedContent = intent.getStringExtra("scannedContent")

            // Muestra el contenido escaneado.
            textView.text = scannedContent
        } else {
            // El extra "scannedContent" no existe.
            textView.text = "No se ha escaneado ningún código QR."
        }
    }
}
