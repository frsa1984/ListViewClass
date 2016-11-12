package com.example.frankie.clase6android;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Frankie on 11/11/2016.
 */

public class ContactAdapter extends BaseAdapter {

    Activity activity;
    List<Contact> contacts;
    private static LayoutInflater inflater=null;

    public ContactAdapter (Activity activity, List<Contact> contacts){
        this.activity = activity;
        this.contacts = contacts;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class ViewHolderRowContact{
        public TextView textViewIdx;
        public TextView textViewName;
        public TextView textViewEdad;
    }
    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ViewHolderRowContact holder;
        if(convertView==null){
            vi = inflater.inflate(R.layout.fragment_contact_adapter,null);
            holder = new ViewHolderRowContact();
            holder.textViewIdx=(TextView)vi.findViewById(R.id.textViewIdx);
            holder.textViewName=(TextView)vi.findViewById(R.id.textViewName);
            holder.textViewEdad=(TextView)vi.findViewById(R.id.textViewEdad);
            vi.setTag(holder);

        }else
        holder=(ViewHolderRowContact) vi.getTag();
        holder.textViewIdx.setText(""+contacts.get(position).getIdx());
        holder.textViewName.setText(""+contacts.get(position).getName());
        holder.textViewEdad.setText(""+contacts.get(position).getEdad());
        return vi;
    }
}
