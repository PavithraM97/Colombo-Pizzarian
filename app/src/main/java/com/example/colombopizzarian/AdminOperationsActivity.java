package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminOperationsActivity extends AppCompatActivity {

    EditText txtID,txtName,txtPrice;
    Button Viewbtn;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_operations);

        db=new DB_Operations(this);

        txtID=findViewById(R.id.txtID);
        txtName=findViewById(R.id.txtName);
        txtPrice=findViewById(R.id.txtPrice);

    }
    public void insert(View view){
        Pizza pizza= new Pizza();
        pizza.setId(Integer.parseInt(txtID.getText().toString()));
        pizza.setName(txtName.getText().toString());
        pizza.setPrice(Integer.parseInt(txtPrice.getText().toString()));
        try{
            db.insert(pizza);
            Toast.makeText(this,"Record Inserted Sucessfully",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Error",ex.getMessage());
        }

    }

    public void  find(View view ){
        int id= Integer.parseInt(txtID.getText().toString());

        try{
            Pizza pizza = db.findPizza(id);
            if(pizza != null){
                txtName.setText(pizza.getName());
                txtPrice.setText(""+pizza.getPrice());
            }else{
                Toast.makeText(this," Record not found",Toast.LENGTH_SHORT).show();
            }
        }catch(Exception ex){
            Log.e("Error",ex.getMessage());
        }


    }

    public void update(View view){
        int id=Integer.parseInt(txtID.getText().toString());
        String name=txtName.getText().toString();
        int price=Integer.parseInt(txtPrice.getText().toString());
        Pizza pizza = new Pizza();

        try{
            pizza.setId(id);
            pizza.setName(name);
            pizza.setPrice(price);

            db.updatePizza(pizza);
            Toast.makeText(this,"Pizza record Updated",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Error",ex.getMessage());
        }
    }

    public void delete(View view){
        int id=Integer.parseInt(txtID.getText().toString());
        try {
            db.deletePizza(id);
            Toast.makeText(this,"Pizza record Deleted",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Error",ex.getMessage());
        }

    }
    public void clear(View view){
        txtID.setText(null);
        txtName.setText(null);
        txtPrice.setText(null);
        txtID.requestFocus();
    }

    public void viewAllPizza(View view){
        startActivity(new Intent(AdminOperationsActivity.this, ViewActivity.class));
    }

}