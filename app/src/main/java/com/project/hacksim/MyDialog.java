package com.project.hacksim;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.content.*;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Kerman on 11.6.2015.
 */
public class MyDialog extends DialogFragment{
    Communicator communicator;
    final CharSequence[] list = {"Disrupt", "Infect", "Bypass"};
    int selection;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose attack type").setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        selection = which + 1;
                        break;
                    case 1:
                        selection = which + 1;
                        break;
                    case 2:
                        selection = which + 1;
                        break;
                }
            }
        }).setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                communicator.onDialogMessage(selection);
                //Toast.makeText(getActivity(), "You selected " + selection + " attack", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    interface Communicator {
        public void onDialogMessage(int type);
    }

}
