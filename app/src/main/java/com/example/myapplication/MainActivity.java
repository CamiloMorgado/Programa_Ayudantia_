package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    private EditText txtHoras, txtDias;
    private CheckBox chbxDcto, chbxpago;
    private RadioGroup rgRedondeo, rgPago;
    private RadioButton rbRedondeo, rbsinRedondeo;
    private Button btnLimpiar, btnCalcular;
    private TextView lbl_dcto, lbl_Pago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHoras = (EditText) findViewById(R.id.txtHoras);
        txtDias = (EditText) findViewById(R.id.txtDias);
        chbxpago = (CheckBox) findViewById(R.id.cbPago);
        chbxDcto = (CheckBox) findViewById(R.id.cbDesc);
        rgRedondeo = (RadioGroup) findViewById(R.id.rgRedondeo);
        rbRedondeo = (RadioButton) findViewById(R.id.rbRedondeo);
        rbsinRedondeo = (RadioButton) findViewById(R.id.rbsinRedondeo);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lbl_dcto = (TextView) findViewById(R.id.lblDesc);
        lbl_Pago = (TextView) findViewById(R.id.lblPago);
    }

    public void calcular(View view) {

        int horas = Integer.parseInt(txtHoras.getText().toString());
        int dias = Integer.parseInt(txtDias.getText().toString());
        int horas_mensuales = horas * dias;
        int pago = horas_mensuales * 10;
        double descuento = 0.00;
        double sueldo_base = 1000.00;


        if (chbxpago.isChecked() == true) {
            lbl_Pago.setText(String.valueOf(pago));
        }
        if (chbxDcto.isChecked() == true && pago > 1000) {
            lbl_Pago.setText(String.valueOf(pago));
        }
        if (rbRedondeo.isChecked() == true) {
            lbl_Pago.setText(String.valueOf((pago - pago % 10) + 10));
        }

        if (btnCalcular.isPressed()) {

            lbl_Pago.setText(String.valueOf(pago));
        }

    }

        public void limpiar (View view){

            if (btnLimpiar.isPressed() ==true) {

                txtDias.setText("");
                txtHoras.setText("");
            }
        }

}