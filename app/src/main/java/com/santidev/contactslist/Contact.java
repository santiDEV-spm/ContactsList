package com.santidev.contactslist;

import android.graphics.drawable.Drawable;

public class Contact {

    private String name;
    private String numberPhone;
    private String email;
    private int photo;

    public Contact(String name, String numberPhone, String email, int photo) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
        this.photo = photo;
    }

    public Contact(String name, String numberPhone, String email) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
        this.photo = R.drawable.defaultphoto;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return this.numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoto() {
        return this.photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
