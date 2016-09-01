package com.luisaamariles.punto3;
//https://examples.javacodegeeks.com/android/core/ui/radiogroup/android-radiogroup-example/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eBase,eAltura,eLado,eRadio;
    Button bCalcular;
    TextView  textResultado;
    int lado,resultado,base, altura, radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eBase = (EditText) findViewById(R.id.eBase);
        eAltura = (EditText) findViewById(R.id.eAltura);
        eLado = (EditText) findViewById(R.id.eLado);
        eRadio = (EditText) findViewById(R.id.eRadio);
        textResultado = (TextView) findViewById(R.id.textResultado);
        bCalcular = (Button) findViewById(R.id.bCalcular);
        //Invisibles
        eBase.setVisibility(View.VISIBLE);
        eBase.setEnabled(false);
        eAltura.setVisibility(View.VISIBLE);
        eAltura.setEnabled(false);
        eLado.setVisibility(View.VISIBLE);
        eLado.setEnabled(false);
        eRadio.setVisibility(View.VISIBLE);
        eRadio.setEnabled(false);
        eBase.setText("");
        eAltura.setText("");
        eLado.setText("");
        eRadio.setText("");

    }

    public void onRadioButtonClicked(View view) {
        final boolean checked = ((RadioButton) view).isChecked();
        eBase.setText("");
        eAltura.setText("");
        eLado.setText("");
        eRadio.setText("");
        switch (view.getId()) {
            case R.id.eCuadro:
                if (checked)

                    eLado.setVisibility(View.VISIBLE);
                    eLado.setEnabled(true);
                    eBase.setVisibility(View.INVISIBLE);
                    eAltura.setVisibility(View.INVISIBLE);
                    eRadio.setVisibility(View.INVISIBLE);

                    bCalcular.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String vacio1= eLado.getText().toString();

                            if (vacio1.equals("") ) {
                                lado=0;
                                resultado=0;
                                textResultado.setText("NOP");
                            } else {
                                lado=0;
                                lado = Integer.parseInt(eLado.getText().toString());
                                resultado = lado * lado;
                                textResultado.setText(Integer.toString(resultado));
                                eLado.setText("");
                            }
                        }
                    });

                break;
            case R.id.eTriangulo:

                if (checked)
                    eLado.setVisibility(View.INVISIBLE);
                    eBase.setVisibility(View.VISIBLE);
                    eBase.setEnabled(true);
                    eAltura.setVisibility(View.VISIBLE);
                    eAltura.setEnabled(true);
                    eRadio.setVisibility(View.INVISIBLE);
                    bCalcular.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String vacio1= eBase.getText().toString();
                            String vacio2= eAltura.getText().toString();
                            if (vacio1.equals("") || vacio2.equals("") ) {
                                base=0;
                                altura=0;
                                resultado=0;
                                textResultado.setText("NOP");
                            } else {
                                base=0;
                                altura=0;
                                base = Integer.parseInt(eBase.getText().toString());
                                altura = Integer.parseInt(eAltura.getText().toString());
                                resultado = (base * altura) / 2;
                                textResultado.setText(Integer.toString(resultado));
                                eBase.setText("");
                                eAltura.setText("");
                            }
                        }
                    });

                break;
            case R.id.eRectangulo:
                if (checked)
                    eLado.setVisibility(View.INVISIBLE);
                    eBase.setVisibility(View.VISIBLE);
                    eBase.setEnabled(true);
                    eAltura.setVisibility(View.VISIBLE);
                    eAltura.setEnabled(true);
                    eRadio.setVisibility(View.INVISIBLE);
                    bCalcular.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String vacio1= eBase.getText().toString();
                            String vacio2= eAltura.getText().toString();
                            if (vacio1.equals("") || vacio2.equals("") ) {
                                base=0;
                                altura=0;
                                resultado=0;
                                textResultado.setText("NOP");
                            } else {
                                base=0;
                                altura=0;
                                base = Integer.parseInt(eBase.getText().toString());
                                altura = Integer.parseInt(eAltura.getText().toString());
                                resultado = base * altura;
                                textResultado.setText(Integer.toString(resultado));
                                eBase.setText("");
                                eAltura.setText("");
                            }
                        }
                    });

                break;
            case R.id.eCirculo:
                if (checked)
                    eLado.setVisibility(View.INVISIBLE);
                    eBase.setVisibility(View.INVISIBLE);
                    eAltura.setVisibility(View.INVISIBLE);
                    eRadio.setVisibility(View.VISIBLE);
                    eRadio.setEnabled(true);
                    bCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String vacio1= eRadio.getText().toString();
                        if (vacio1.equals("")) {
                            radio=0;
                            resultado=0;
                            textResultado.setText("NOP");
                        } else {
                            double radio=0, resultado;
                            radio = Integer.parseInt(eRadio.getText().toString());
                            resultado = Math.PI * (int) Math.pow(radio, 2);
                            textResultado.setText(Double.toString(resultado));
                            eRadio.setText("");
                        }
                    }
                });
                break;

        }

    }
}

