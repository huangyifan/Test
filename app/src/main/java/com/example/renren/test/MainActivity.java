package com.example.renren.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewGroup llButton;
    private TextView addView;
    private TextView removeView;
    private Button save;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llButton = (ViewGroup)findViewById(R.id.ll_button);
        addView = (TextView)findViewById(R.id.add_view);
        save = (Button)findViewById(R.id.save);

        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditTextViewWithDelete edit = new EditTextViewWithDelete(MainActivity.this);
                llButton.addView(edit,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                //addListener();
                edit.showSoftInput();

                edit.setDeleteListener(new EditTextViewWithDelete.OnDeleteListener() {
                    @Override
                    public void onDelete() {
                        llButton.removeView(edit);
                        if (llButton.getChildCount() < 5){
                            addView.setVisibility(View.VISIBLE);
                        }
                    }
                });

                if (llButton.getChildCount() >= 5){
                    addView.setVisibility(View.GONE);
                }

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final StringBuilder str = new StringBuilder();
                for (int i = 0; i < llButton.getChildCount(); i++){
                    EditTextViewWithDelete edit = (EditTextViewWithDelete) llButton.getChildAt(i);
                    str.append(edit.getText());
                }
                save.setText(str.toString());

            }
        });


    }

//    public  void addListener(){
//        for (int i = 0; i < llButton.getChildCount(); i++) {
//            EditTextViewWithDelete edit = (EditTextViewWithDelete) llButton.getChildAt(i);
//            final int finalI = i;
//            Log.d("hyf: ","初始化edit"+finalI);
//            edit.setDeleteListener(new EditTextViewWithDelete.OnDeleteListener() {
//                @Override
//                public void onDelete() {
//                    //llButton.removeViewAt(finalI);
//                    addListener();
//                }
//            });
//
//        }
//    }
}
