
package org.techbooster.sample.javadocsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Javadocのためのサンプルクラス
 * 
 * @author TechBooster
 * @version 1.0
 */
public class JavadocSampleActivity extends Activity implements OnClickListener {

    /**
     * 1つ目の入力エリア
     */
    EditText mNumberTextView1;

    /**
     * 2つ目の入力エリア
     */
    EditText mNumberTextView2;

    /**
     * 結果を表示するTextView
     */
    TextView mResultTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mNumberTextView1 = (EditText) findViewById(R.id.editText1);
        mNumberTextView2 = (EditText) findViewById(R.id.editText2);
        mResultTextView = (TextView) findViewById(R.id.resultTextView);

        Button performButton = (Button) findViewById(R.id.performButton);
        performButton.setOnClickListener(this);
    }

    /**
     * 計算の実行
     * 
     * @since 1.0
     */
    private void performCalculations() {
        int number1 = Integer.valueOf(mNumberTextView1.getText().toString());
        int number2 = Integer.valueOf(mNumberTextView2.getText().toString());
        int result = add(number1, number2);

        mResultTextView.setText(String.valueOf(result));
    }

    /**
     * 2つの引数を足す
     * 
     * @param number1
     * @param number2
     * @return 計算結果
     * @since 1.0
     */
    private int add(int number1, int number2) {
        return number1 + number2;
    }

    /**
     * OnClickListenerのメソッド
     * 
     * @param v View
     */
    @Override
    public void onClick(View v) {
        performCalculations();
    }
}
