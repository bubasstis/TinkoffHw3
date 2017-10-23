package com.example.sem.tinkoffhw3;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements FirstNumFragment.FirstNumberFragmentListener, SecondNumFragment.SecondNumberFragmentListener,OperationFragment.OperationFragmentListener {

    private FirstNumFragment firstNumFragment;
    private SecondNumFragment secondNumFragment;
    private OperationFragment operationFragment;
    private ResultFragment result;
    private double firstNumber;
    private double secondNumber;
    private String operation;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFirstFragment();
    }

    public void getFirstFragment(){
        firstNumFragment = FirstNumFragment.newInstance();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, firstNumFragment).commit();
    }



    public void getSecondFragment(){
        secondNumFragment = SecondNumFragment.newInstance();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, secondNumFragment).commit();
    }

    public void getOperationFragment(){
        operationFragment = OperationFragment.newInstance();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, operationFragment).commit();
    }

    public void getResultFragment(){
        if (operation.equals("plus")) {
            double res = firstNumber + secondNumber;
            result = ResultFragment.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }else if(operation.equals("minus")){
            double res = firstNumber - secondNumber;
            result = ResultFragment.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }else if (operation.equals("mult")){
            double res = firstNumber * secondNumber;
            result = ResultFragment.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }else if (operation.equals("div")){
            double res = firstNumber / secondNumber;
            result = ResultFragment.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }
    }

    @Override
    public void firstNumberCallback(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Override
    public void secondNumberCallback(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public void operationCallback(String operation) {
        this.operation = operation;
    }
}
