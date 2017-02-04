package mx.melyna.apptrabajo1;

import android.app.DatePickerDialog;
import java.util.Calendar;


import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

     public String nombre,fecha,telefono,email,descripcion;
     EditText miNombre,miFecha,miTelefono,miEmail,miDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Typeface miTypoComic=Typeface.createFromAsset(getAssets(),"comic_sans_ms.ttf");
        Typeface miTypoHateComic=Typeface.createFromAsset(getAssets(),"I hate Comic Sans.TTF");

        miNombre=(EditText)findViewById(R.id.etNombre);
        miFecha=(EditText)findViewById(R.id.etFecha);
        miTelefono=(EditText)findViewById(R.id.edTelefono);
        miEmail=(EditText)findViewById(R.id.etEmail);
        miDescripcion=(EditText)findViewById(R.id.etContactoNombre);

        Button miBtnSiguiete=(Button)findViewById(R.id.btSiguiente);

        miNombre.setTypeface(miTypoComic);
        miFecha.setTypeface(miTypoComic);
        miTelefono.setTypeface(miTypoComic);
        miEmail.setTypeface(miTypoComic);
        miDescripcion.setTypeface(miTypoComic);

        miBtnSiguiete.setTypeface(miTypoHateComic);



        final Calendar c = Calendar.getInstance();
        final int year =c.get(Calendar.YEAR);
        final int month =c.get(Calendar.MONTH);
        final int day =c.get(Calendar.DAY_OF_MONTH);
        final EditText tFecha=(EditText)findViewById(R.id.etFecha);

        Bundle b =getIntent().getExtras();
        if (b != null){
            nombre = (String) b.get("dnombre");
            fecha = (String) b.get("dfecha");
            telefono = (String) b.get("dtelefono");
            email = (String) b.get("demail");
            descripcion = (String) b.get("ddescripcion");
            miNombre.setText(nombre);
            miFecha.setText(fecha);
            miTelefono.setText(telefono);
            miEmail.setText(email);
            miDescripcion.setText(descripcion);



        }



        tFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatePickerDialog datepickter=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        tFecha.setText(day + " / " + (month+1) + " / " + year);
                    }
                },year,month,day);
                datepickter.show();



            }

        });

      //  Intent i = new Intent(this,Detalle_Registro.class);
        //Bundle b =getIntent().getExtras();
       // nombre=(String)b.get("dnombre");
       // miNombre.setText(nombre);
      /*  Bundle extra =getIntent().getExtras();
        nombre=(String)extra.get("dnombre");

*/
       // Intent i =getIntent();




    }




   public void  Ejecutar(View view){
      Intent i = new Intent(this, Detalle_Registro.class );
       String axNombre=miNombre.getText().toString();
       String axFecha=miFecha.getText().toString();
       String axTelefono=miTelefono.getText().toString();
       String axEmail=miEmail.getText().toString();
       String axDescripcion=miDescripcion.getText().toString();

       i.putExtra("nombre",axNombre);
       i.putExtra("fecha",axFecha);
       i.putExtra("telefono",axTelefono);
       i.putExtra("email",axEmail);
       i.putExtra("descripcion",axDescripcion);

       startActivity(i);
       finish();


    }



}
