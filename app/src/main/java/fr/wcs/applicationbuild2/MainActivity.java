package fr.wcs.applicationbuild2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkboxBecome;
    EditText prenomText;
    EditText nomText;
    Button valider;
    TextView felic;
    TextView felicNom;
    String edit1;
    String edit2;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkboxBecome = (CheckBox) findViewById(R.id.CheckBox_Become);
        checkboxBecome.setOnClickListener(this);
        prenomText = (EditText) findViewById(R.id.champ_prenom);
        nomText = (EditText) findViewById(R.id.champ_nom);
        valider = (Button) findViewById(R.id.send_button);
        valider.setOnClickListener(this);
        felic = (TextView) findViewById(R.id.message_felic);
        felic.setText(" ");
        felicNom = (TextView) findViewById(R.id.message_nom);
        felicNom.setText(" ");


        prenomText.setEnabled(false);
        nomText.setEnabled(false);
        valider.setEnabled(false);

    }

    @Override
    public void onClick(View view) {

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        switch (view.getId()) {
            case R.id.CheckBox_Become:

                if (checkboxBecome.isChecked()) {
                    prenomText.setEnabled(true);
                    prenomText.requestFocus();
                    nomText.setEnabled(true);
                    valider.setEnabled(true);

                } else {
                    prenomText.setEnabled(false);
                    nomText.setEnabled(false);
                    valider.setEnabled(false);
                }
                break;

        }

        switch (view.getId()) {
            case R.id.send_button:

                if (prenomText.getText().toString().trim().length() == 0 || nomText.getText().toString().trim().length() == 0) {
                    Toast.makeText(this, "Veuillez entrer un nom et prénom", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    edit1 = prenomText.getText().toString();
                    edit2 = nomText.getText().toString();
                    text = edit1 + " " + edit2;
                    felicNom.setText(String.valueOf(text));
                    felic.setText("Félicitations");
                }

        }

    }

}

// Autre solution mais sans déclarer variable avant
 /*   public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.CheckBox_Become:
                if (checked) {
                    EditText prenom = (EditText) findViewById(R.id.champ_prenom);
                    prenom.setEnabled(true);
                    EditText nom = (EditText) findViewById(R.id.champ_nom);
                    nom.setEnabled(true);
                } else {
                    EditText prenom = (EditText) findViewById(R.id.champ_prenom);
                    prenom.setEnabled(false);
                    EditText nom = (EditText) findViewById(R.id.champ_nom);
                    nom.setEnabled(false);
                }
                break;
        }


    }*/

