package com.example.springbackend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeViewHolder extends RecyclerView.Adapter<EmployeeViewHolder.EmployeeView> {

    private List<Employee> employeeList;

    public EmployeeViewHolder(List<Employee> employeeList){
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_item,parent,false);
        return new EmployeeView(view);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeView holder, int position) {
        Employee employee = employeeList.get(position);
        holder.name.setText(employee.getName());
        holder.branch.setText(employee.getBranch());
        holder.location.setText(employee.getLocation());
    }

    public class EmployeeView extends RecyclerView.ViewHolder {
        TextView name,location,branch;
        EmployeeView(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            branch = itemView.findViewById(R.id.tvBranch);
            location = itemView.findViewById(R.id.tvLocation);
        }
    }
}
