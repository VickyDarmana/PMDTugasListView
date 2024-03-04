package edu.uph.tugaslistview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.uph.tugaslistview.Model.Produk;
import edu.uph.tugaslistview.R;

public class ProdukAdapter extends ArrayAdapter<Produk> {

    private ArrayList<Produk> produkArrayList;
    Context context;

    public ProdukAdapter(ArrayList<Produk> produkArrayList, Context context) {
        super(context, R.layout.activity_list_produk,produkArrayList);
        this.produkArrayList = produkArrayList;
        this.context = context;
    }

    private static class MyViewFolder{
        ImageView imageProduk;
        TextView txtNamaProduk;
        TextView txtHargaProduk;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Produk produk = getItem(position);
        final View result;

        MyViewFolder myViewFolder;

        if(convertView==null) {
            myViewFolder = new MyViewFolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_list_produk, parent, false);

            myViewFolder.imageProduk = (ImageView) convertView.findViewById(R.id.imageProduk);
            myViewFolder.txtNamaProduk = (TextView) convertView.findViewById(R.id.txtNamaProduk);
            myViewFolder.txtHargaProduk = (TextView) convertView.findViewById(R.id.txtHargaProduk);

            convertView.setTag(myViewFolder);
        }
        else {
            myViewFolder = (MyViewFolder) convertView.getTag();
        }
        result = convertView;
        myViewFolder.imageProduk.setImageResource(produk.getGambarProduk());
        myViewFolder.txtHargaProduk.setText("IDR. "+ produk.getHargaProduk());
        myViewFolder.txtNamaProduk.setText(produk.getNamaProduk());
        return result;
    }
}