package com.brobox.materialmenudrawer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.brobox.materialmenudrawer.R;
import com.brobox.materialmenudrawer.activities.MainActivity;

import java.util.ArrayList;

/**
 * Created by Daniel on 09.11.2014.
 */
public class Preview_Fragment extends Fragment implements View.OnClickListener {

    ArrayList<String> dialogItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_preview, container, false);

        Button dialog = (Button) rootView.findViewById(R.id.buttonStand);
        Button singleDialog = (Button) rootView.findViewById(R.id.buttonSingle);
        Button persSingleDialog = (Button) rootView.findViewById(R.id.buttonPersSingle);
        Button multiDialog = (Button) rootView.findViewById(R.id.buttonMulti);

        dialog.setOnClickListener(this);
        singleDialog.setOnClickListener(this);
        persSingleDialog.setOnClickListener(this);
        multiDialog.setOnClickListener(this);

        dialogItems = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            dialogItems.add("Item No. "+i);
        }

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStand:
                MainActivity.showMyDialog("Dialog", "Test message.", "cancel", "ok");
                break;
            case R.id.buttonSingle:
                MainActivity.showMySingleDialog("Dialog", dialogItems, "cancel", "ok");
                break;
            case R.id.buttonPersSingle:
                MainActivity.showMyRadioDialog("Dialog", dialogItems, "cancel", "ok");
                break;
            case R.id.buttonMulti:
                MainActivity.showMyMultiDialog("Dialog", dialogItems, "cancel", "ok");
                break;
        }
    }
}
