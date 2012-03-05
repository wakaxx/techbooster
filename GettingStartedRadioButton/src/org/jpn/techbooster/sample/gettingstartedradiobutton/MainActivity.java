package org.jpn.techbooster.sample.gettingstartedradiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener, OnClickListener {
    private RadioGroup mRadioGroupOs;
    private RadioGroup mRadioGroupCarrier;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // RadioGroupをメンバ変数に保存しておく
        mRadioGroupOs = (RadioGroup)findViewById(R.id.RadioGroupOs);
        mRadioGroupOs.setOnCheckedChangeListener(this);

        mRadioGroupCarrier = (RadioGroup)findViewById(R.id.RadioGroupCarrier);
        mRadioGroupCarrier.setOnCheckedChangeListener(this);
        
        // 項目を選択する
        mRadioGroupOs.check(R.id.RadioButtonAndroid);
        mRadioGroupCarrier.check(R.id.RadioButtonSoftBank);
        
        // リスナを登録する
        Button checkButtonOs = (Button)findViewById(R.id.checkButtonOs);
        checkButtonOs.setOnClickListener(this);
        Button checkButtonCarrier = (Button)findViewById(R.id.checkButtonCarrier);
        checkButtonCarrier.setOnClickListener(this);
        
        Button clearButtonOs =(Button)findViewById(R.id.clearButtonOs);
        clearButtonOs.setOnClickListener(this);
        Button clearButtonCarrier =(Button)findViewById(R.id.clearButtonCarrier);
        clearButtonCarrier.setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // どれも選択されていなければidには-1が入ってくる
        if (-1 == checkedId) {
            Toast.makeText(MainActivity.this,
                    "クリアされました",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this,
                    ((RadioButton)findViewById(checkedId)).getText()
                        + "が選択されました",
                    Toast.LENGTH_SHORT).show();
        }
   }

    @Override
    public void onClick(View view) {
        RadioGroup radioGroup = null;
        
        // OSかCarrierで処理を行うRadioGroupを分ける
        switch (view.getId()) {
        case R.id.checkButtonOs:
        case R.id.clearButtonOs:
            radioGroup = mRadioGroupOs;
            break;
        case R.id.checkButtonCarrier:
        case R.id.clearButtonCarrier:
            radioGroup = mRadioGroupCarrier;
            break;
        }
        
        // ClearボタンとCheckボタンで処理を分ける
        switch (view.getId()) {
        case R.id.clearButtonOs:
        case R.id.clearButtonCarrier:
            // クリアして何も選択されていない状態にする
            radioGroup.clearCheck();
            break;
        case R.id.checkButtonOs:
        case R.id.checkButtonCarrier:
            // 選択されているRadioButonのIDを取得する
            // どれも選択されていなければgetCheckedRadioButtonIdは-1が返ってくる
            // radioGroupは確認しようとしているRadioGroupクラス（RadioGroupOsかRadioGroupCarrier）
            int checkedId = radioGroup.getCheckedRadioButtonId();
            if (-1 != checkedId) {
                Toast.makeText(MainActivity.this,
                        ((RadioButton)findViewById(checkedId)).getText()
                            + "が選択されています",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "何も選択されていません",
                        Toast.LENGTH_SHORT).show();
            }   
            break;
        } 
    }
}