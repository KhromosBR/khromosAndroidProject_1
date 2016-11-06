package khromostech.khromosandroidproject_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class RegisterActivity extends AppCompatActivity {

    EditText name, secondName, birthday, city;
    Spinner spinnerCountry;
    RadioButton male, female;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_register);

        name = (EditText)findViewById(R.id.editText_name);
        secondName = (EditText)findViewById(R.id.editText_secondname);
        birthday = (EditText)findViewById(R.id.EditText_birthday);
        city = (EditText)findViewById(R.id.editText_city);
        male = (RadioButton) findViewById(R.id.radio_male);
        female = (RadioButton) findViewById(R.id.radio_female);

        /*Spinners*/

        spinnerCountry = (Spinner)findViewById(R.id.spin_country);
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this, R.array.spin_country, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountry);

    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {

             parent.getItemAtPosition(pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public void addProfilePicture(View view){
        //TODO Second Part
    }

    public void btn_next(View view){

            Intent intent = new Intent(this, SecondRegisterActivity.class);
            Log.d("Error", "Error: ");
            startActivity(intent);
    }

    public void radioButtonChecked(View view){


        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){

            case R.id.radio_male:
                if (checked){

                }
            break;

            case R.id.radio_female:
                if (checked){

                }
            break;
        }
    }

}
