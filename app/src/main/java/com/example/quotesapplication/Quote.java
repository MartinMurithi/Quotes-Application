package com.example.quotesapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quote {

    private String text;
    private String author;

    @Override
    public String toString() {
        return "Quote{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getQuote() {
        return text;
    }

    public void setQuote(String quote) {
        this.text = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
