package pro.enderson.carsquiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Objects;

public class CarDialog extends AppCompatDialogFragment {
    private EditText editTextPlaca;
    private EditText editTextMarca;
    private EditText editTextModelo;
    private CarDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.add_card_dialog, null);

        builder.setView(view).setTitle("Añadir nuevo carro").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        }).setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String placa = editTextPlaca.getText().toString();
                String marca = editTextMarca.getText().toString();
                String modelo = editTextModelo.getText().toString();
                listener.applyTexts(placa, marca, modelo);
            }
        });

        editTextPlaca = view.findViewById(R.id.placa);
        editTextMarca = view.findViewById(R.id.marca);
        editTextModelo = view.findViewById(R.id.modelo);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (CarDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement CarDialogListener");
        }
    }

    public interface CarDialogListener {
        void applyTexts(String placa, String marca, String modelo);
    }
}
