package com.example.sems;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class SetValue extends AppCompatDialogFragment {

    private EditText setValues;
    private setValueListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.set_values_dialogue, null);

        builder.setView(view)
                .setTitle("Would you like to change the value?")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String value = setValues.getText().toString();
                        listener.applyText(value);
                    }
                });

        setValues = view.findViewById(R.id.editValues);

        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (setValueListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "you must enter a value!");
        }
    }

    public interface setValueListener{
        void applyText(String value);
    }
}

