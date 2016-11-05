package com.example.renren.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by renren on 16/10/19.
 */
public class EditTextViewWithDelete extends LinearLayout {

    private EditText editText;
    private ImageView delete;

    private OnDeleteListener deleteListener;

    public interface OnDeleteListener{
        void onDelete();
    }
    public void setDeleteListener(OnDeleteListener deleteListener) {
        this.deleteListener = deleteListener;
    }


    public EditTextViewWithDelete(Context context) {
        super(context);
        //LayoutInflater.from(context).inflate(R.layout.edit_with_delete, this, true);

        final LinearLayout view = (LinearLayout) LinearLayout.inflate(context, R.layout.edit_with_delete, this);
        editText = (EditText)view.findViewById(R.id.edit);
        delete = (ImageView)view.findViewById(R.id.delete);

        delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("hyf: ","delete点击监听触发");
                if (deleteListener != null){
                    deleteListener.onDelete();
                }
            }
        });

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    public String getText(){
          return editText.getText().toString();
    }

    public void showSoftInput(){
        editText.requestFocus();
        InputMethodManager inputManager =
                (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(editText, 0);
    }
}
