package com.example.android.miagenda;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    ArrayList<Contacto> listaDeContactos;
    EditText nombreEditText;
    EditText apellidoEditText;
    EditText telefonoEditText;
    TextView infoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIALIZAR VARIABLE GLOBAL;
        listaDeContactos = new ArrayList<Contacto>();

        //INICIALIZAR CONTROLES;
        //SE CASTEA, SE AMOLDA LA CLASE VIEW A EDIT TEXT =Class Cast;

        nombreEditText = (EditText) findViewById(R.id.nombreEditText);
        apellidoEditText = (EditText) findViewById(R.id.apellidoEditText);
        telefonoEditText = (EditText) findViewById(R.id.telefonoEditText2);
        //infoTextView = (TextView) findViewById(R.id.infoTextView)
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void agregarClick(View view) {
        String nombre = nombreEditText.getText().toString();
        String apellido = apellidoEditText.getText().toString();
        String telefono = telefonoEditText.getText().toString();

        Contacto contacto = new Contacto(nombre, apellido, telefono);

        this.listaDeContactos.add(contacto);

        this.limpiarCampos();

    }

    public void buscarClick(View view) {
        String nombreIngresado = nombreEditText.getText().toString();
        for (Contacto contactoEnLista : this.listaDeContactos) {
            if (contactoEnLista.getNombre().contains(nombreIngresado)) {
                nombreEditText.setText(contactoEnLista.getNombre());
                apellidoEditText.setText(contactoEnLista.getApellido());
                telefonoEditText.setText(contactoEnLista.getTelefono());

                infoTextView.setText(contactoEnLista.getNombre()
                        + "" + contactoEnLista.getApellido()
                        + "" + contactoEnLista.getTelefono());
            }
        }
    }

    public void limpiarClick(View view) {
        limpiarCampos();
    }

    private void limpiarCampos () {
        nombreEditText.setText("");
        apellidoEditText.setText("");
        telefonoEditText.setText("");

    }

    private boolean contactoExiste(String telefono){
        for (Contacto contactoEnLista :this.listaDeContactos) {
            //if ( contactoEnLista.getTelefono().contains(NombreIngresado);

        }
        return  false;
    }

    public void verListaclick (View view) {
        Intent intent = new Intent(getApplicationContext(), ListaDeContactosActivity.class);
        intent.putExtra("listaDeContactos",listaDeContactos);
        startActivity(intent);
    }

}

