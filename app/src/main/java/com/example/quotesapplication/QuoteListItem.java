package com.example.quotesapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

public class QuoteListItem extends AppCompatActivity {

    LayoutInflater layoutInflater = getLayoutInflater();
    ViewGroup viewGroup = (ViewGroup) getCurrentFocus();
    View view = layoutInflater.inflate(R.layout.item_list_quote, viewGroup);
    private ImageButton copyButton = view.findViewById(R.id.imageCopyBtn);
    public void copyQuoteButton() {
        Context context = getApplicationContext();
        Quote quote = new Quote();
        String copiedQuote = quote.getQuote();
        copyButton.setOnClickListener(v -> {
            //Gte handle to clipboard services
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            //Create a new text clip to put in the clipboard
            ClipData clipData = ClipData.newPlainText("Copied quote", copiedQuote);
            //set the clipboards primary clip
            clipboardManager.setPrimaryClip(clipData);
        });

    }
}
