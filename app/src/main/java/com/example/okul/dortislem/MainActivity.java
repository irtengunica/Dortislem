package com.example.okul.dortislem;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    EditText txtSayi1, txtSayi2;
    Button btnTopla, btnCikar, btnCarp, btnBol;
    TextView lblSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSayi1 = (EditText) findViewById(R.id.txtSayi1);
        txtSayi2 = (EditText) findViewById(R.id.txtSayi2);
        btnTopla = (Button) findViewById(R.id.btnTopla);
        btnCikar = (Button) findViewById(R.id.btnCikar);
        btnCarp = (Button) findViewById(R.id.btnCarp);
        btnBol = (Button) findViewById(R.id.btnBol);
        lblSonuc = (TextView) findViewById(R.id.lblSonuc);
        btnBol.setOnClickListener(this);
        btnCarp.setOnClickListener(this);
        btnCikar.setOnClickListener(this);
        btnTopla.setOnClickListener(this);
        /*btnBol.setOnClickListener(this); this kullanabilmek için
        * public class MainActivity extends ActionBarActivity implements View.OnClickListener satýrýna
        * implements View.OnClickListener olay dinleyicisini eklemek gerekir */
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

    @Override
    public void onClick(View v) {
        try {


        int s1=Integer.parseInt(txtSayi1.getText().toString());
        int s2=Integer.parseInt(txtSayi2.getText().toString());
        if (v == btnBol) {
            //lblSonuc.setText("bol="+s1/s2);
            lblSonuc.setText(String.format("%d / %d = %d",s1,s2,s1/s2));
        }
        if (v == btnCarp) {
            lblSonuc.setText("carp="+s1*s2);
        }
        if (v == btnCikar) {
            lblSonuc.setText("cikar="+(s1-s2));
        }
        if (v == btnTopla) {
            lblSonuc.setText("topla="+(s1+s2));//kd yazýmý düzelt code/reformat
        }
        }
        catch (NumberFormatException ex)
        {
            Log.e("DortIslemMain", "Girilen formatHata Oldu" + ex.getMessage());

        }
        catch (Exception ex)
        {
            Log.e("DortIslemMain", "Hata Oldu" + ex.getMessage());

        }
    }
}
