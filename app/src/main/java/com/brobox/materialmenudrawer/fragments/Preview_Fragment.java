package com.brobox.materialmenudrawer.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.brobox.materialmenudrawer.R;
import com.brobox.materialmenudrawer.activities.MainActivity;
import com.brobox.materialmenudrawer.dialog.Single_Dialog;
import com.brobox.materialmenudrawer.dialog.Standard_Dialog;

import java.util.ArrayList;

/**
 * Created by Daniel on 09.11.2014.
 */
public class Preview_Fragment extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    ArrayList<String> dialogItems;

    private SwipeRefreshLayout swipeLayout;

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

        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorScheme(R.color.accent_color,
                R.color.accent_color_light,
                R.color.accent_color_dark,
                R.color.accent_color_light);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStand:
                MainActivity.showMyDialog("Dialog", "Test message.", "cancel", "ok", new Standard_Dialog.MyDialogListener() {
                    @Override
                    public void onDialogPositiveClick(DialogFragment dialog) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onDialogNegativeClick(DialogFragment dialog) {
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.buttonSingle:
                MainActivity.showMySingleDialog("Dialog", dialogItems, "cancel", "ok", new Single_Dialog.MyDialogListener() {
                    @Override
                    public void onDialogPositiveClick(DialogFragment dialog) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onDialogNegativeClick(DialogFragment dialog) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onDialogItemClick(DialogFragment dialog, View view, int position) {

                    }
                });
                break;
            case R.id.buttonPersSingle:
                MainActivity.showMyRadioDialog("Dialog", dialogItems, "cancel", "ok");
                break;
            case R.id.buttonMulti:
                MainActivity.showMyMultiDialog("Dialog", dialogItems, "cancel", "ok");
                break;
        }
    }

    boolean isTaskRunning = true;

    @Override
    public void onRefresh() {

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isTaskRunning) {
                    swipeLayout.setRefreshing(false);
                } else {
                    handler.postDelayed(this, 1000);
                    isTaskRunning = false;
                }
            }
        }, 1000);

    }

}
