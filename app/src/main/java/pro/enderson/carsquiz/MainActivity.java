package pro.enderson.carsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CarDialog.CarDialogListener {

    ArrayList<Car> cars = new ArrayList<Car>();
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        CarDialog addCarDialog = new CarDialog();
        addCarDialog.show(getSupportFragmentManager(), "Añadir Carro");
    }

    @Override
    public void applyTexts(String placa, String marca, String modelo) {
        AdapterCar adapterCar = new AdapterCar(this, cars);
        ListView list = findViewById(R.id.lstcarros);
        Car car = new Car(placa, marca, modelo);
        cars.add(car);
        Toast.makeText(getApplicationContext(), "Carro agregado con exito", Toast.LENGTH_LONG).show();
        list.setAdapter(adapterCar);
    }
}