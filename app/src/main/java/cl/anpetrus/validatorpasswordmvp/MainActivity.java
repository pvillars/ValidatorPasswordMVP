package cl.anpetrus.validatorpasswordmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PasswordCallBack {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.inputEt);

        textView = (TextView) findViewById(R.id.validationTv);

        Button button = (Button) findViewById(R.id.resultBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                String value = editText.getText().toString();
                new PasswordValidator(MainActivity.this).validation(value);
            }
        });
    }

    @Override
    public void blankInput() {
        Toast.makeText(this, "Ingrese Password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void correct() {
        textView.setText("Password Valida");
    }

    @Override
    public void wrong() {
        Toast.makeText(this, "Password debe ser superior a 8 caracteres", Toast.LENGTH_SHORT).show();
    }
}
