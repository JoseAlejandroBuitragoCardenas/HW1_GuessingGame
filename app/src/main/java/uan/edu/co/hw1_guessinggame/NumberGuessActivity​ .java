package uan.edu.co.hw1_guessinggame;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

class NumberGuessActivity​  extends AppCompatActivity implements View.OnClickListener {

    public static final int MAX_NUMBER =1000;
    public static final Random RANDOM = new Random();
    private TextView mensaje;
    private EditText editTextNumero;
    private Button buttonNumero;
    private int encontrar, intentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guess);

        mensaje = (TextView) findViewById(R.id.Titulo);
        editTextNumero = (EditText) findViewById(R.id.editTextNumero);
        buttonNumero = (Button) findViewById(R.id.buttonNumero);
        buttonNumero.setOnClickListener(this);

        nuevoJuego();
    }

    @Override
    public void onClick(View view){
        if (view == buttonNumero){
            buttonNumero();
        }
    }

    private void buttonNumero(){
        int a = Integer.parseInt(editTextNumero.getText().toString());
        intentos++;

        if (a == encontrar){
            Toast.makeText(this, "Felicitaciones, has ganado " + encontrar + " en" + intentos,  Toast.LENGTH_SHORT).show();

            nuevoJuego();
        }else if (a > encontrar){
            mensaje.setText(R.string.Demasiado_Alto);
        }else if (a < encontrar){
            mensaje.setText(R.string.Demasiado_Bajo);
        }
    }

    private void nuevoJuego (){
        encontrar = RANDOM.nextInt(MAX_NUMBER)+1;
        mensaje.setText(R.string.app_name);
        editTextNumero.setText(" ");
        intentos = 0;
    }
}
