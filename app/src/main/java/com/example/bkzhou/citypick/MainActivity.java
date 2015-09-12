package com.example.bkzhou.citypick;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) this.findViewById(R.id.text);
        mButton = (Button) this.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int screenWidth = getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽（像素

                final Dialog dlg = new Dialog(MainActivity.this);
                dlg.show();
                dlg.getWindow().setGravity(Gravity.CENTER);
                dlg.getWindow().setLayout((int) (screenWidth * 0.8), android.view.WindowManager.LayoutParams.WRAP_CONTENT);
                dlg.getWindow().setContentView(R.layout.dialog_city_pick);
                final CityPicker add_city_picker = (CityPicker) dlg.findViewById(R.id.citypicker);
                TextView add_tag_dialg_no = (TextView) dlg.findViewById(R.id.add_tag_dialg_no);
                TextView add_tag_dialg_ok = (TextView) dlg.findViewById(R.id.add_tag_dialg_ok);

                add_tag_dialg_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.dismiss();
                    }
                });
                add_tag_dialg_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);

                        mTextView.setText( add_city_picker.getCity_string());
                        dlg.dismiss();
                    }
                });

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
