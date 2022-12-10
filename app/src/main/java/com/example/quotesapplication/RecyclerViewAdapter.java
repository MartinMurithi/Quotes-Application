package com.example.quotesapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class RecyclerViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    List<Quote> quoteList;
    Context context;

    public RecyclerViewAdapter(List<Quote> quoteList, Context context) {
        this.quoteList = quoteList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_quote, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Quote quote = quoteList.get(position);
        holder.quote.setText(quote.getQuote());
        holder.author.setText(quote.getAuthor());
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    public class RecyclerViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder{

        TextView quote, author;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            quote = itemView.findViewById(R.id.textview_quote);
            author = itemView.findViewById(R.id.textview_author);
        }
    }
}
