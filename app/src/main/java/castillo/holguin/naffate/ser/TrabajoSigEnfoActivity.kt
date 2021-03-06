package castillo.holguin.naffate.ser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_trabajo_sig_enfo.*
import kotlinx.android.synthetic.main.contenido.view.*


class TrabajoSigEnfoActivity : AppCompatActivity() {

    var adapter: TrabajoSigEnfoActivity.EjerciciosAdapter? = null
    var ejercicios = ArrayList<Contenido>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trabajo_sig_enfo)
        cargarEjercicios()
        adapter = TrabajoSigEnfoActivity.EjerciciosAdapter(ejercicios, this)
        gridviewTrabajoSigEnfo.adapter = adapter
    }

    fun cargarEjercicios() {
        ejercicios.add(Contenido("Trabajo Profundo", "45 minutos de trabajo intenso","45 min"))
        ejercicios.add(Contenido("Enfoque Abrasador","2 horas de trabajo intenso","120 min"))
    }

    class EjerciciosAdapter : BaseAdapter {
        var ejercicios = ArrayList<Contenido>()
        var context: Context? = null

        constructor(ejercicios: ArrayList<Contenido>, context: Context?) : super() {
            this.ejercicios = ejercicios
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var ejercicio = ejercicios[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.contenido, null)
            vista.txtTitulo.setText(ejercicio.titulo)
            vista.txtDetalle.setText(ejercicio.detalle)
            vista.txtMinutos.setText(ejercicio.minutos)
            return vista
        }

        override fun getItem(position: Int): Any {
            return ejercicios[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return ejercicios.size
        }
    }
}
