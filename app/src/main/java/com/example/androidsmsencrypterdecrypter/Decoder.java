package com.example.androidsmsencrypterdecrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class Decoder extends AppCompatActivity {
    EditText key,message_dt;
    TextView message;
    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);
        key=findViewById(R.id.dt_key);
        message_dt=findViewById(R.id.dtenc);
        message=findViewById(R.id.dectv);
        cpb=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void Decoder(View view) {
        try {
            String encrypted= AESCrypt.decrypt(key.getText().toString(),message_dt.getText().toString());
            ClipData clipData=ClipData.newPlainText("label",encrypted);
            cpb.setPrimaryClip(clipData);
            key.setText("");
            message_dt.setText("");
            message.setText(encrypted);
            Toast.makeText(this, "Your message was copied to Clipboard", Toast.LENGTH_SHORT).show();


        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }


}