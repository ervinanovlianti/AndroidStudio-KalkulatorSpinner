package stmik.profesional.kalkulatorspinner;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //deklarasi variable
    double nilai_a;
    double nilai_b;
    double nilai_c;
    String operator;
    double hasilhitung = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] opr = {"Pilih Operator","+","-","*","/"};
        EditText nilaiA = (EditText) findViewById(R.id.NilaiA);
        EditText nilaiB = (EditText) findViewById(R.id.NilaiB);
        EditText nilaiC = (EditText) findViewById(R.id.NilaiC);
        Spinner operatorspinner = (Spinner) findViewById(R.id.NilaiO);
        EditText hasil = (EditText) findViewById(R.id.hasil);
        Button bproses = (Button) findViewById(R.id.proses);

        
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opr);
        operatorspinner.setAdapter(adapterSpinner);
        operatorspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                operator = adapterSpinner.getItem(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        bproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai_a = Double.valueOf(nilaiA.getText().toString());
                nilai_b = Double.valueOf(nilaiB.getText().toString());
                nilai_c = Double.valueOf(nilaiC.getText().toString());
                operator = operatorspinner.getSelectedItem().toString();

                switch (operator){
                    case "+":
                        hasilhitung = nilai_a + nilai_b + nilai_c;
                        break;
                    case "-":
                        hasilhitung = nilai_a - nilai_b - nilai_c;
                        break;
                    case "*":
                        hasilhitung = (nilai_a + nilai_b) * nilai_c;
                        break;
                    case "/" :
                        hasilhitung = (nilai_a + nilai_b) / nilai_c;
                        break;
                }
                hasil.setText("Nilai A = "+nilai_a+"\n Nilai B = "+nilai_b+"\n Nilai C = "+nilai_c+"\n Hasil = "+hasilhitung);
            }
        });

    }
}