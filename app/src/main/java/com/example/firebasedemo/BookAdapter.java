package com.example.firebasedemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class BookAdapter extends FirestoreRecyclerAdapter <Book, BookAdapter.BookHolder>{

    public BookAdapter(@NonNull FirestoreRecyclerOptions<Book> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookHolder holder, int position, @NonNull Book model) {
        holder.textViewAuthor.setText(model.getAuthor());
        Log.d("Holder", "Model " + model.toString());
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewISBN.setText(model.getIsbn());
        holder.textViewPrice.setText(Integer.toString(model.getPrice()));
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new BookHolder(v);
    }

    class BookHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle;
        TextView textViewAuthor;
        TextView textViewISBN;
        TextView textViewPrice;

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.rec_title);
            textViewPrice = itemView.findViewById(R.id.rec_price);
            textViewAuthor = itemView.findViewById(R.id.rec_author);
            textViewISBN = itemView.findViewById(R.id.rec_isbn);
        }
    }
}
