package com.example.madlab2;

import android.os.Bundle;

import android.content.Context;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {
    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }
    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View InputView = inflater.inflate(R.layout.fragment_input, container, false);
        EditText InputText = (EditText) InputView.findViewById(R.id.usrTextIn);
        Button SendText = (Button) InputView.findViewById(R.id.InputBtn);
        SendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputtext = InputText.getText().toString();
                fragmentSendDataListener.onSendData(outputtext);
            }
        });
        return InputView;
    }
}