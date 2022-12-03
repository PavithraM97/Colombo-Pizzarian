package com.example.colombopizzarian.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.colombopizzarian.Menu;
import com.example.colombopizzarian.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    Context context;
    ArrayList<Menu> menus;

    public  ProductAdapter(Context context,ArrayList<Menu>menus){
        this.context=context;
        this.menus=menus;
    }

    public ProductAdapter() {
        super();
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1=inflater.inflate(R.layout.custom_layout,viewGroup,false);

        TextView lblID=view1.findViewById(R.id.lblpid);
        TextView lblpname=view1.findViewById(R.id.lblpname);
        TextView lblprice=view1.findViewById(R.id.lblprice);
       ImageView imageView=view1.findViewById(R.id.imageView13);
        Button btnClick=view1.findViewById(R.id.btnClick);

        Menu menu = menus.get(i);
        lblID.setText(""+menu.getFid());
        lblpname.setText(""+menu.getFname());
        lblprice.setText(""+menu.getFprice());
        Bitmap bitmap= BitmapFactory.decodeByteArray(menu.getImage(),0,menu.getImage().length);
        imageView.setImageBitmap(bitmap);

        return view1;

    }
}
