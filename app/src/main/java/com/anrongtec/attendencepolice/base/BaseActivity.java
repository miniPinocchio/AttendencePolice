package com.anrongtec.attendencepolice.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author Created by huiliu on 2019/1/18.
 * @email liu594545591@126.com
 * @introduce
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    public void showToast(int messageRes){
        Toast.makeText(getApplicationContext(),messageRes,Toast.LENGTH_LONG).show();
    }
}
