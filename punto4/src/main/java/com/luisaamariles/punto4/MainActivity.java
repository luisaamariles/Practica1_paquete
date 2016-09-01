package com.luisaamariles.punto4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    protected ArrayAdapter<CharSequence> adapter;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    EditText eLoggin, ePassword, eRPassword, eEmail;
    Button bAceptar;
    TextView textres;
    String loggin, password, repassword, email, sexo, fecha, selected, hobbie,hobbie2,hobbie3,hobbie1,hobbiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eLoggin = (EditText) findViewById(R.id.eLoggin);
        ePassword = (EditText) findViewById(R.id.ePassword);
        eRPassword = (EditText) findViewById(R.id.eRPassword);
        eEmail = (EditText) findViewById(R.id.eEmail);
        bAceptar = (Button) findViewById(R.id.bAceptar);
        textres = (TextView) findViewById(R.id.textres);

        Spinner spinner = (Spinner) findViewById(R.id.Lugar);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Lugar, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());
        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);


        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vacio1 = eLoggin.getText().toString();
                String vacio2 = ePassword.getText().toString();
                String vacio3 = eRPassword.getText().toString();
                String vacio4 = eEmail.getText().toString();
                if(hobbie==null && hobbie1==null && hobbie2==null && hobbie3==null){
                    hobbiet=null;
                }else {
                    hobbiet="0";
                }
                if (vacio1.equals("") || vacio2.equals("") || vacio3.equals("") || vacio4.equals("") || sexo == null || fecha == null || selected==null || hobbiet==null) {
                    textres.setText("Hay campos vacios!");
                } else {
                    loggin = eLoggin.getText().toString();
                    password = ePassword.getText().toString();
                    repassword = eRPassword.getText().toString();
                    email = eEmail.getText().toString();

                    if (password.toString().equalsIgnoreCase(repassword)) {
                        if(hobbie==null){
                            hobbie=" ";
                        }
                        if(hobbie1==null){
                            hobbie1=" ";
                        }
                        if(hobbie2==null){
                            hobbie2=" ";
                        }
                        if(hobbie3==null){
                            hobbie3=" ";
                        }
                        textres.setText("Loggin:" + loggin + Html.fromHtml("<br />")+"Password: Coinciden " +Html.fromHtml("<br />")+ "Email:" + email +Html.fromHtml("<br />")+ "Sexo:" + sexo +Html.fromHtml("<br />")+ "Fecha de nacimiento:" + fecha +Html.fromHtml("<br />")+ "Ciudad:" + selected +Html.fromHtml("<br />")+"Hobbie:"+hobbie+" "+hobbie1+" "+hobbie2+" "+hobbie3);
                        hobbie=null;
                        hobbie1=null;
                        hobbie2=null;
                        hobbie3=null;
                    } else {

                        textres.setText("Las contraseñas no coinciden");
                        ePassword.setText("");
                        eRPassword.setText("");
                    }
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        final boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.eFemenino:
                if (checked)
                    sexo = "Femenino";
                break;
            case R.id.eMasculino:
                if (checked)
                    sexo = "Masculino";
                break;
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.bailar:
                if (checked)
                 hobbie="Bailar";
                break;
            case R.id.cantar:
                if (checked)
                    hobbie1="Cantar";
                break;
            case R.id.deporte:
                if (checked)
                    hobbie2="Hacer ejercicio";
                break;
            case R.id.instrumento:
                if (checked)
                    hobbie3="Tocar un instrumento";
                break;

        }
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
        fecha = dateView.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public class SpinnerListener implements AdapterView.OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {

                   selected= parent.getItemAtPosition(pos).toString();
        }
        public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
        }
    }
}
