package com.example.sem.tinkoffhw3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    private TextView result;
    private Button backToFirstNumber;
    private Button backToSecondNumber;
    private Button backToOperations;
    private static ResultFragment instance;

    public static ResultFragment newInstance(double res){
     if (instance == null) instance = new ResultFragment();
        Bundle args = new Bundle();
        args.putDouble("result", res);
        instance.setArguments(args);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        result = (TextView) view.findViewById(R.id.result);
        backToFirstNumber = (Button) view.findViewById(R.id.return_to_first_number);
        backToSecondNumber = (Button) view.findViewById(R.id.return_to_second_number);
        backToOperations = (Button) view.findViewById(R.id.return_to_operations);

        backToFirstNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getFirstFragment();
            }
        });

        backToSecondNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getSecondFragment();
            }
        });

        backToOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getOperationFragment();
            }
        });

        double res = getArguments().getDouble("result");
        result.setText(String.valueOf(res));

        return view;
    }

}
