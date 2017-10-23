package com.example.sem.tinkoffhw3;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondNumFragment extends Fragment {

    private EditText secondNumber;
    private Button goToOperations;
    private Button backToFirstNumber;
    private SecondNumberFragmentListener listener;
    private static SecondNumFragment instance;


    public static SecondNumFragment newInstance(){
        if (instance == null) instance = new SecondNumFragment();
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_num, container, false);

        secondNumber = (EditText) view.findViewById(R.id.second_number);
        goToOperations = (Button) view.findViewById(R.id.choose_operation);
        backToFirstNumber = (Button) view.findViewById(R.id.return_to_first_number);

        backToFirstNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getFirstFragment();
            }
        });

        goToOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number = Double.valueOf(secondNumber.getText().toString());
                listener.secondNumberCallback(number);
                ((MainActivity) getActivity()).getOperationFragment();
            }
        });

        return view;
    }

    public interface SecondNumberFragmentListener{
        void secondNumberCallback(double secondNumber);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof SecondNumberFragmentListener){
            listener = (SecondNumberFragmentListener) getActivity();
        }else{
            throw new  RuntimeException("Activity should implement FragmentListener");
        }
    }

}
