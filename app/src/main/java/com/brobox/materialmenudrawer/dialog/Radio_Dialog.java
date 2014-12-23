package com.brobox.materialmenudrawer.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.brobox.materialmenudrawer.R;

import java.util.ArrayList;


/**
 * Created by d4ddy-lild4rk on 12/12/14.
 */
public class Radio_Dialog extends DialogFragment implements View.OnClickListener, ListView.OnItemClickListener{

    private static final String KEY_TITLE = "title";
    private static final String KEY_LIST = "list";
    private static final String KEY_NEGATIVEBUTTON = "negativeButton";
    private static final String KEY_POSITIVEBUTTON = "positiveButton";

    private TextView dialogTitle;
    private RadioGroup dialogRadioGroup;
    private Button dialogNegativeButton;
    private Button dialogPositiveButton;

    private ArrayList<String> radioItems;

    public static Radio_Dialog newInstance(String title, ArrayList<String> radioItems, String negativeButton, String positiveButton) {
        Radio_Dialog f = new Radio_Dialog();

        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        args.putStringArrayList(KEY_LIST, radioItems);
        args.putString(KEY_NEGATIVEBUTTON, negativeButton);
        args.putString(KEY_POSITIVEBUTTON, positiveButton);
        f.setArguments(args);

        return f;
    }

    public Radio_Dialog() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_dialog_radio, null);

        dialogTitle = (TextView) dialogView.findViewById(R.id.dialogTitle);
        dialogRadioGroup = (RadioGroup) dialogView.findViewById(R.id.dialogContent);
        dialogNegativeButton = (Button) dialogView.findViewById(R.id.dialogButtonNegative);
        dialogPositiveButton = (Button) dialogView.findViewById(R.id.dialogButtonPositive);

        dialogTitle.setText(getArguments().getString(KEY_TITLE));
        dialogNegativeButton.setText(getArguments().getString(KEY_NEGATIVEBUTTON));
        dialogPositiveButton.setText(getArguments().getString(KEY_POSITIVEBUTTON));

        radioItems = getArguments().getStringArrayList(KEY_LIST);
        RadioGroup.LayoutParams params;

        for(int i = 0; i < radioItems.size(); i++){
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setText(radioItems.get(i));
            params= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            dialogRadioGroup.addView(radioButton, params);
        }

        dialogNegativeButton.setOnClickListener(this);
        dialogPositiveButton.setOnClickListener(this);

        builder.setView(dialogView);

        return builder.create();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.dialogButtonNegative) {
            dismiss();
        }
        if (v.getId() == R.id.dialogButtonPositive) {
            dismiss();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}