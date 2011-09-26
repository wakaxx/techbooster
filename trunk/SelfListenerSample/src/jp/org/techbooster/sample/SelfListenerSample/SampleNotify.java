package jp.org.techbooster.sample.SelfListenerSample;

import android.widget.EditText;

public class SampleNotify {
    
    private EditText et = null;
    private SampleListenerInterface listener = null;
    
    public SampleNotify(EditText et) {
        this.et = et;
    }
    
    /**
     * EditTextにテキストが入力されているかどうかを判定する
     */
    public void checkText(){
        if(this.listener != null){
            if(this.et.getText().toString().equals("")){
                // テキストが入力されていない場合の通知を行う
                listener.noInputText();
            }else{
                // テキストが入力されている場合の通知を行う
                listener.inputText();
            }
        }
    }
    
    /**
     * リスナーを追加する
     * @param listener
     */
    public void setListener(SampleListenerInterface listener){
        this.listener = listener;
    }
    
    /**
     * リスナーを削除する
     */
    public void removeListener(){
        this.listener = null;
    }
}
