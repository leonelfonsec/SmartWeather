package com.ux.smartweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class ConfiguracionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        // Referencia al slider
        val slider = findViewById<Slider>(R.id.material_slider)

        // Agregar el Listener para mostrar la etiqueta flotante con el valor
        slider.addOnChangeListener { _, value, _ ->
            slider.setLabelFormatter { "%.0f".format(value) } // Muestra el valor sin decimales
        }

        // Referencia a los botones
        val btnCancelar = findViewById<Button>(R.id.cancelar)
        val btnGuardar = findViewById<Button>(R.id.guardar)

        // Al hacer clic en "Cancelar" vuelve a la pantalla principal
        btnCancelar.setOnClickListener {
            finish() // Cierra esta actividad y vuelve atrás
        }

        // Al hacer clic en "Guardar" vuelve a la pantalla principal
        btnGuardar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Borra las actividades previas
            startActivity(intent)
            finish() // Cierra la actividad actual
        }
    }
}
