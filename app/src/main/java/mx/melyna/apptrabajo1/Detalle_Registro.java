package mx.melyna.apptrabajo1;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalle_Registro extends AppCompatActivity {
    TextView nombre, fecha, telefono,email,descripcion;
    public String dtNombre, dtFecha,dtTelefono,dtEmail,dtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__registro);

        Typeface miTypeFace=Typeface.createFromAsset(getAssets(),"comic_sans_ms.ttf");
        Typeface miTypoHateComic=Typeface.createFromAsset(getAssets(),"I hate Comic Sans.TTF");
        TextView miTitulo=(TextView)findViewById(R.id.dTitulo);
        nombre=(TextView)findViewById(R.id.dNombre);
        fecha=(TextView)findViewById(R.id.dFechaNacimiento);
        telefono=(TextView)findViewById(R.id.dTelefono);
        email=(TextView)findViewById(R.id.dEmail);
        descripcion=(TextView)findViewById(R.id.dDescripcion);
        Button miBtnEditar=(Button)findViewById(R.id.dEditarDatos);
        miTitulo.setTypeface(miTypoHateComic);
        nombre.setTypeface(miTypeFace);
        fecha.setTypeface(miTypeFace);
        telefono.setTypeface(miTypeFace);
        email.setTypeface(miTypeFace);
        descripcion.setTypeface(miTypeFace);
        miBtnEditar.setTypeface(miTypoHateComic);



        nombre= (TextView)findViewById(R.id.dNombre);
        fecha=(TextView)findViewById(R.id.dFechaNacimiento);
        telefono=(TextView)findViewById(R.id.dTelefono);
        email=(TextView)findViewById(R.id.dEmail);
        descripcion=(TextView)findViewById(R.id.dDescripcion);


        Bundle extra =getIntent().getExtras();
        dtNombre=(String)extra.get("nombre");


        dtFecha=(String)extra.get("fecha");
        dtTelefono=(String)extra.get("telefono");
         dtEmail=(String)extra.get("email");
         dtDescripcion=(String)extra.get("descripcion");

        nombre.setText(dtNombre);
        fecha.setText("Fecha Nacimiento: " + dtFecha);
        telefono.setText("Tel. "+ dtTelefono);
        email.setText("Email: "+dtEmail);
        descripcion.setText("Descripción: "+ dtDescripcion);
    }

    public void EditarDatos(View v){
        Intent i= new Intent(this,MainActivity.class);

        i.putExtra("dnombre",dtNombre);
        i.putExtra("dfecha",dtFecha);
        i.putExtra("dtelefono",dtTelefono);
        i.putExtra("demail",dtEmail);
        i.putExtra("ddescripcion",dtDescripcion);
        startActivity(i);
        finish();
    }
}
