package com.santidev.contactslist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {

    List<Contact> contacts = new ArrayList<>();
    Context context;

    public ContactAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Contact getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, viewGroup, false);
        }

        ImageView imgPhoto = (ImageView) view.findViewById(R.id.imgPhoto);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvNumber = (TextView) view.findViewById(R.id.tvNumber);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvEmail);

        Contact currentContact = contacts.get(i);

        imgPhoto.setImageResource(currentContact.getPhoto());
        tvName.setText(currentContact.getName());
        tvNumber.setText(currentContact.getNumberPhone());
        tvEmail.setText(currentContact.getEmail());

        return view;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
        notifyDataSetChanged();
    }

    public void editContact(Contact contact, int position){
        this.contacts.set(position, contact);
        notifyDataSetChanged();
    }
}
