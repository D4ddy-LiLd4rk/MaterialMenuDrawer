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
import android.widget.TextView;

import com.brobox.materialmenudrawer.R;
import com.brobox.materialmenudrawer.adapter.Dialog_Multi_Adapter;

import java.util.ArrayList;


/**
 * Created by d4ddy-lild4rk on 12/12/14.
 */
public class Multi_Dialog extends DialogFragment implements View.OnClickListener, ListView.OnItemClickListener{

    private static final String KEY_TITLE = "title";
    private static final String KEY_LIST = "list";
    private static final String KEY_NEGATIVEBUTTON = "negativeButton";
    private static final String KEY_POSITIVEBUTTON = "positiveButton";

    private TextView dialogTitle;
    private ListView dialogList;
    private Button dialogNegativeButton;
    private Button dialogPositiveButton;

    public static Multi_Dialog newInstance(String title, ArrayList<String> dialogItems, String negativeButton, String positiveButton) {
        Multi_Dialog f = new Multi_Dialog();

        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        args.putStringArrayList(KEY_LIST, dialogItems);
        args.putString(KEY_NEGATIVEBUTTON, negativeButton);
        args.putString(KEY_POSITIVEBUTTON, positiveButton);
        f.setArguments(args);

        return f;
    }

    public Multi_Dialog() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_dialog_multi, null);

        dialogTitle = (TextView) dialogView.findViewById(R.id.dialogTitle);
        dialogList = (ListView) dialogView.findViewById(R.id.dialogContent);
        dialogNegativeButton = (Button) dialogView.findViewById(R.id.dialogButtonNegative);
        dialogPositiveButton = (Button) dialogView.findViewById(R.id.dialogButtonPositive);

        dialogTitle.setText(getArguments().getString(KEY_TITLE));
        dialogNegativeButton.setText(getArguments().getString(KEY_NEGATIVEBUTTON));
        dialogPositiveButton.setText(getArguments().getString(KEY_POSITIVEBUTTON));


        dialogList.setAdapter(new Dialog_Multi_Adapter(getActivity(), getArguments().getStringArrayList(KEY_LIST)));
        dialogList.setOnItemClickListener(this);

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