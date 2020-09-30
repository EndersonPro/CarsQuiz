package pro.enderson.carsquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterCar extends ArrayAdapter<Car> {

    private Context context;
    private ArrayList<Car> cars;
    private LayoutInflater inflater;

    public AdapterCar(@NonNull Context context, ArrayList<Car> cars) {
        super(context, 0, cars);
        this.context = context;
        this.cars = cars;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Nullable
    @Override
    public Car getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.car,null);
        }
        Car p = getItem(position);
        TextView placa = convertView.findViewById(R.id.placa);
        TextView marca = convertView.findViewById(R.id.marca);
        TextView modelo = convertView.findViewById(R.id.modelo);
        placa.setText("Placa: " + p.getPlaca());
        marca.setText("Marca: " + p.getMarca());
        modelo.setText("Modelo: " + p.getModelo());
        return convertView;
    }

}
