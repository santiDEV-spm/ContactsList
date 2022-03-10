package com.santidev.contactslist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewContactDialog extends DialogFragment {

    private Contact contact;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.view_contact, null);

        ImageView imageContact = (ImageView) dialog.findViewById(R.id.imgContact);
        TextView tvNameContact = (TextView) dialog.findViewById(R.id.tvNameContact);
        TextView tvNumberContact = (TextView) dialog.findViewById(R.id.tvNumberContact);
        TextView tvEmailContact = (TextView) dialog.findViewById(R.id.tvEmailContact);
        Button btnOk = (Button) dialog.findViewById(R.id.btnOkView);

        imageContact.setImageResource(contact.getPhoto());
        tvNameContact.setText(contact.getName());
        tvNumberContact.setText(contact.getNumberPhone());
        tvEmailContact.setText(contact.getEmail());

        builder.setView(dialog).setMessage("Your contact:");

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return builder.create();
    }

    public void sendContact(Contact contactSelected){
        this.contact = contactSelected;
    }

}
