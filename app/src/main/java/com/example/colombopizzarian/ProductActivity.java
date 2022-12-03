package com.example.colombopizzarian;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProductActivity extends AppCompatActivity {

    EditText txtpid,txtpname,txtprice;
    ImageView image;
    byte[] productImage;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        txtpid=findViewById(R.id.txtpid);
        txtpname=findViewById(R.id.txtpname);
        txtprice=findViewById(R.id.txtprice);
        image=findViewById(R.id.imgproduct);

        db= new DB_Operations(this);

    }

    public void getImage(View view){
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("crop","true");
        intent.putExtra("appectX","0");
        intent.putExtra("appectY","0");
        intent.putExtra("outputX","100");
        intent.putExtra("appectY","100");
        intent.putExtra("return-data","true");
        startActivityForResult(Intent.createChooser(intent,"Select product image"), 999);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999){
            if(data != null){
                Uri uri= data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                    ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG,0,arrayOutputStream);
                    productImage= arrayOutputStream.toByteArray();
                    image.setImageBitmap(bitmap);

                }catch (IOException ex){
                    Log.e("ERROR",ex.getMessage());
                }
            }
        }
    }

    public  void insert(View view){
        Menu menu= new Menu();
        menu.setFid(Integer.parseInt(txtpid.getText().toString()));
        menu.setFname(txtpname.getText().toString());
        menu.setFprice(Double.parseDouble(txtprice.getText().toString()));
        menu.setImage(productImage);

        if(db.insertmenu(menu)>0){
            Toast.makeText(this, "Product Record Inserted", Toast.LENGTH_SHORT).show();
        }


    }

    public void  productMenu (View view){
        startActivity(new Intent(ProductActivity.this, ViewMenuActivity.class));
    }
}