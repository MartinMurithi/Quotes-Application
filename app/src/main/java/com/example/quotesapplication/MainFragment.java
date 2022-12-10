package com.example.quotesapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ProgressBar progressBar;
    private CallApi callApi;
    private final String tag = "Tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView =view.findViewById(R.id.recyclerview);
        progressBar = view.findViewById(R.id.progressBar);

        getQuotes();
        return view;
    }

    private void setRecyclerView(List<Quote> quoteList) {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RecyclerViewAdapter(quoteList, getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void getQuotes() {
        progressBar.setVisibility(View.VISIBLE);
        callApi = RequestManager.getRetrofit().create(CallApi.class);
        Call<List<Quote>> listCall = callApi.callQuotesApi();
        listCall.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(@NonNull Call<List<Quote>> call, @NonNull Response<List<Quote>> response) {
                Log.e(tag, " " + response.body());
                setRecyclerView(response.body());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<List<Quote>> call, @NonNull Throwable t) {
                Log.e(tag, " " + t.getMessage());
            }
        });
    }

   /* private void copyQuoteObject(){
        QuoteListItem quoteListItem = new QuoteListItem();
        quoteListItem.copyQuoteButton();
    }*/

}