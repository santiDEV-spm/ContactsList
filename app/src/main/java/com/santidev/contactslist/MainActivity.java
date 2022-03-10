package com.santidev.contactslist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ContactAdapter contactAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactAdapter = new ContactAdapter(this);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(contactAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact tempContact = contactAdapter.getItem(i);
                ViewContactDialog viewContactDialog = new ViewContactDialog();
                viewContactDialog.sendContact(tempContact);
                viewContactDialog.show(getFragmentManager(),"");
            }
        });

        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(contactAdapter.getItem(info.position).getName());
        inflater.inflate(R.menu.menu_delete, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == R.id.item_delete){
            contactAdapter.contacts.remove(info.position);
            contactAdapter.notifyDataSetChanged();
        }

        if(item.getItemId() == R.id.item_edit){
            Contact contactEdit = contactAdapter.getItem(info.position);
            EditContactDialog editContactDialog = new EditContactDialog();
            editContactDialog.setPosition(info.position);
            editContactDialog.sendEditContact(contactEdit);
            editContactDialog.show(getFragmentManager(),"");
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_contact){
            Toast.makeText(getApplicationContext(), "Add Contact", Toast.LENGTH_SHORT).show();
            CreateContactDialog createContactDialog = new CreateContactDialog();
            createContactDialog.show(getFragmentManager(), "contact_create");
        }
        return super.onOptionsItemSelected(item);
    }

    public void createContact(Contact newContact){
        this.contactAdapter.addContact(newContact);
    }

    public void editContact(Contact editContact, int position){
        this.contactAdapter.editContact(editContact,position);
    }
}