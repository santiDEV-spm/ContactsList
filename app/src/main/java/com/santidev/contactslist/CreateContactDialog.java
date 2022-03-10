package com.santidev.contactslist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateContactDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.create_contact, null);

        EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        EditText editTextEmail = (EditText) dialogView.findViewById(R.id.editTextEmail);
        EditText editTextPhone = (EditText) dialogView.findViewById(R.id.editTextPhone);

        RadioButton rbPhotoMale = (RadioButton) dialogView.findViewById(R.id.rbPhotoMale);
        RadioButton rbPhotoFemale = (RadioButton) dialogView.findViewById(R.id.rbPhotoFemale);

        Button btnOk = (Button) dialogView.findViewById(R.id.btnOk);
        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);

        builder.setView(dialogView).setMessage("Create new contact");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact newContact;

                String name = editTextName.getText().toString();
                String number = editTextPhone.getText().toString();
                String email = editTextEmail.getText().toString();
                int photo = R.drawable.defaultphoto;

                if (rbPhotoMale.isChecked()){
                    photo = R.drawable.photomale;
                }
                if(rbPhotoFemale.isChecked()){
                    photo = R.drawable.photofemale;
                }

                newContact = new Contact(name, number, email, photo);

                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.createContact(newContact);
                dismiss();
            }
        });

        return builder.create();
    }
}
