package com.example.pennotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteModelAdapter extends RecyclerView.Adapter<NoteModelAdapter.ViewModel> {

    ArrayList<NoteModel> noteModelArrayList = new ArrayList<>();
    Context context;
    public NoteModelAdapter(ArrayList<NoteModel> noteModelArrayList, Context context) {
        this.noteModelArrayList = noteModelArrayList;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.note_model,null,false);
        return new ViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
          holder.title.setText(noteModelArrayList.get(position).getTitle());
          holder.description.setText(noteModelArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return noteModelArrayList.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView imageView;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            imageView=itemView.findViewById(R.id.delete);
        }
    }
}
