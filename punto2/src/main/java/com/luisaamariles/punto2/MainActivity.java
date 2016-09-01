package com.luisaamariles.punto2;
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

    EditText eDato1, eDato2, eResultado;
    Button bCalcular;
    TextView  textResultado;
    int dato1, dato2, resultado,dato22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eDato1 = (EditText) findViewById(R.id.eDato1);
        eDato2 = (EditText) findViewById(R.id.eDato2);
        textResultado = (TextView) findViewById(R.id.textResultado);

        bCalcular = (Button) findViewById(R.id.bCalcular);


    }
    public void onRadioButtonClicked(View view) {
        final boolean checked = ((RadioButton) view).isChecked();

                switch (view.getId()) {
                    case R.id.eSumar:
                        if (checked)

                               bCalcular.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View view) {
                                       String vacio1= eDato1.getText().toString();
                                       String vacio2= eDato2.getText().toString();
                                       if (vacio1.equals("") || vacio2.equals("")) {
                                           dato1=0;
                                           dato2=0;
                                           resultado=0;
                                           textResultado.setText("NOP");
                                       } else {
                                           dato1=0;
                                           dato2=0;
                                           dato1 = Integer.parseInt(eDato1.getText().toString());
                                           dato2 = Integer.parseInt(eDato2.getText().toString());
                                           resultado = dato1 + dato2;
                                           textResultado.setText(Integer.toString(resultado));
                                       }
                                   }
                               });

                        break;
                    case R.id.eRestar:

                        if (checked)
                            bCalcular.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String vacio1= eDato1.getText().toString();
                                    String vacio2= eDato2.getText().toString();
                                    if (vacio1.equals("") || vacio2.equals("")) {
                                        dato1=0;
                                        dato2=0;
                                        resultado=0;
                                        textResultado.setText("NOP");
                                    } else {
                                        dato1=0;
                                        dato2=0;
                                        dato1 = Integer.parseInt(eDato1.getText().toString());
                                        dato2 = Integer.parseInt(eDato2.getText().toString());
                                        resultado = dato1 - dato2;
                                        textResultado.setText(Integer.toString(resultado));
                                    }
                                }
                            });

                        break;
                    case R.id.eMult:
                        if (checked)
                            bCalcular.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     String vacio1= eDato1.getText().toString();
                                     String vacio2= eDato2.getText().toString();
                                     if (vacio1.equals("") || vacio2.equals("")) {
                                         dato1=0;
                                         dato2=0;
                                         resultado=0;
                                         textResultado.setText("NOP");
                                     } else {
                                         dato1=0;
                                         dato2=0;
                                         dato1 = Integer.parseInt(eDato1.getText().toString());
                                         dato2 = Integer.parseInt(eDato2.getText().toString());
                                         resultado = dato1 * dato2;
                                         textResultado.setText(Integer.toString(resultado));
                                     }
                                 }
                            });

                        break;
                    case R.id.eDiv:
                        if (checked)
                                bCalcular.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String vacio1= eDato1.getText().toString();
                                        String vacio2= eDato2.getText().toString();
                                        if (vacio1.equals("") || vacio2.equals("")) {
                                            dato1=0;
                                            dato2=0;
                                            resultado=0;
                                            textResultado.setText("NOP");
                                        } else {
                                            dato22 = eDato2.getText().toString().compareTo("0");
                                            dato1=0;
                                            dato2=0;
                                            if (dato22 == 0) {
                                                textResultado.setText("NOP");
                                            } else {
                                                dato1 = Integer.parseInt(eDato1.getText().toString());
                                                dato2 = Integer.parseInt(eDato2.getText().toString());
                                                resultado = dato1 / dato2;
                                                textResultado.setText(Integer.toString(resultado));

                                                //eResultado.setText("se puede operar");
                                            }
                                        }
                                    }
                                });

                        break;
                }

            }
}






