package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter  extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private List<Child> childList;
    public RvAdapter(List<Child> childList) {
        this.childList = childList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Child child =  childList.get(position);
        holder.firstName.setText(child.getFirstName());
        holder.lastName.setText(child.getLastName());
        holder.fatherName.setText(child.getFatherName());
        holder.birthDay.setText(child.getBirthDay());
    }
    @Override
    public int getItemCount() {
        return childList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, lastName, fatherName, birthDay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.Name);
            lastName = itemView.findViewById(R.id.LastName);
            fatherName = itemView.findViewById(R.id.FatherName);
            birthDay = itemView.findViewById(R.id.BirthDay);
        }
    }
}
