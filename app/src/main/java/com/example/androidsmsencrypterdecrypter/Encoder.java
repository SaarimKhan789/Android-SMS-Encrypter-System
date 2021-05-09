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

import org.w3c.dom.Text;

import java.security.GeneralSecurityException;

public class Encoder extends AppCompatActivity {
        EditText key,message_et;
        TextView message;
        ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);
        key=findViewById(R.id.et_key);
        message_et=findViewById(R.id.etenc);
        message=findViewById(R.id.enctv);
        cpb=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);


    }

    static String encrypted=null;
    public void Encoder(View view) {
        try {
             encrypted= AESCrypt.encrypt(key.getText().toString(),message_et.getText().toString());
            key.setText("");
            message_et.setText("");
            message.setText(encrypted);
            
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
    public void cp2(View view){
        ClipData clipData=ClipData.newPlainText("label",encrypted);
            cpb.setPrimaryClip(clipData);
        Toast.makeText(this, "Your message was copied to Clipboard", Toast.LENGTH_SHORT).show();
    }


}