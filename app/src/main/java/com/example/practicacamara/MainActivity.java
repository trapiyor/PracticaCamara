package com.example.practicacamara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declarar
    Button btnFoto;
    ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Capturar(v);
            }
        });
    }

    public void Capturar (View view)
    {
        Toast.makeText(this, "Comenzando camara", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    //Sobreescribiendo metodo lanzar la camara
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK)
        {
            Bundle ext = data.getExtras();
            Bitmap bmp = (Bitmap)data.getExtras().get("data");
            ivFoto.setImageBitmap(bmp);
        }
    }
}