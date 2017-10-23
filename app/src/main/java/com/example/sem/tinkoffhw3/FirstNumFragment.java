package com.example.sem.tinkoffhw3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstNumFragment extends Fragment {

    private Button secondNumber;
    private EditText firstNumber;
    private FirstNumberFragmentListener listener;
    private static FirstNumFragment instance;

    public static FirstNumFragment newInstance() {
        if (instance == null) instance = new FirstNumFragment();
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_num, container, false);

        firstNumber = (EditText) view.findViewById(R.id.first_number);

        secondNumber = (Button) view.findViewById(R.id.next_number);
        secondNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number = Double.valueOf(firstNumber.getText().toString());
                listener.firstNumberCallback(number);
                ((MainActivity) getActivity()).getSecondFragment();
            }
        });

        return view;

    }

    public interface FirstNumberFragmentListener{
        void firstNumberCallback(double firstNumber);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FirstNumberFragmentListener){
            listener = (FirstNumberFragmentListener) getActivity();
        }else{
            throw new  RuntimeException("Activity should implement FragmentListener");
        }
    }

}
