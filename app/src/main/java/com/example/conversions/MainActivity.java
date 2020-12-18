package com.example.conversions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import static androidx.core.view.accessibility.AccessibilityEventCompat.setAction;

public class MainActivity extends AppCompatActivity {
    RadioButton DtToEuro,EuroToDt;
    EditText entree;
    TextView sortie;
    Button convCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entree = (EditText) findViewById(R.id.monnaie);
        sortie = (TextView) findViewById(R.id.Resultat);
        convCalculer = (Button) findViewById(R.id.buttonConversion);
        EuroToDt = (RadioButton) findViewById(R.id.radioButton01);
        DtToEuro = (RadioButton) findViewById(R.id.radioButton02);
        convCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertir();
            }
        });
        EuroToDt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                view.showContextMenu();
                return true;
            }
        });
        EuroToDt.setOnCreateContextMenuListener(this);
        DtToEuro.setOnCreateContextMenuListener(this);
    }
    public void convertir(){
        if(TextUtils.isEmpty(entree.getText().toString())){
  Snackbar.make(findViewById(R.id.monnaieLayout), " veuilez saisir une somme",Snackbar.LENGTH_LONG)
          .setAction("Retry", new View.OnClickListener(){

                 public void onClick(View view){
                     //put ur logic here
                } })
            .show();

      }else{
            float valeurInitiale=Float.valueOf(entree.getText().toString());
            float resultat;
            if(EuroToDt.isChecked()){
                resultat=EuroToDt(valeurInitiale);
            }else {
                resultat=DtToEuro(valeurInitiale);
            }
            sortie.setText(String.valueOf(resultat));
        }
    }
    private  float EuroToDt(float valeurEuro){
        return (float)(valeurEuro * 3.24);
    }
    private  float DtToEuro(float valeurDinar){
        return  (float)(valeurDinar * 0.31);
    }
    private void onClickListener(){
    }
}