package com.example.sem.tinkoffhw3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationFragment extends Fragment {

    private static OperationFragment instance;
    private Button plus;
    private Button minus;
    private Button mult;
    private Button div;
    private Button backToFirstNumber;
    private Button backToSecondNumber;
    private OperationFragmentListener listener;

    public static OperationFragment newInstance(){
        if (instance == null) instance = new OperationFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operation, container, false);

        plus = (Button) view.findViewById(R.id.plus);
        minus = (Button) view.findViewById(R.id.minus);
        mult = (Button) view.findViewById(R.id.mult);
        div = (Button) view.findViewById(R.id.div);
        backToFirstNumber = (Button) view.findViewById(R.id.return_to_first_number);
        backToSecondNumber = (Button) view.findViewById(R.id.return_to_second_number);

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

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.operationCallback("plus");
                ((MainActivity)getActivity()).getResultFragment();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.operationCallback("minus");
                ((MainActivity)getActivity()).getResultFragment();
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.operationCallback("mult");
                ((MainActivity)getActivity()).getResultFragment();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.operationCallback("div");
                ((MainActivity)getActivity()).getResultFragment();
            }
        });

        return view;
    }

    public interface OperationFragmentListener{
        void operationCallback(String operation);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof OperationFragmentListener){
            listener = (OperationFragmentListener) getActivity();
        }else{
            throw new  RuntimeException("Activity should implement FragmentListener");
        }
    }
}
