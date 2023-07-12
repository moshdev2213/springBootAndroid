package com.example.springbackend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatAction floatAction;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        recyclerView = findViewById(R.id.RvEmployee);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        floatingActionButton = findViewById(R.id.fbAddEmployee);
        loadEmployees();

        floatingActionButton.setOnClickListener(view->{
            startActivity(new Intent(this,MainActivity.class));
        });
    }
    private void loadEmployees(){
        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);
        employeeApi.getAllEmployees()
                .enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        Toast.makeText(EmployeeList.this,"Success Load",Toast.LENGTH_SHORT).show();
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Toast.makeText(EmployeeList.this,"Failed TO Load",Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void populateListView(List<Employee> employee){
        EmployeeViewHolder employeeAdapter = new EmployeeViewHolder(employee);
        recyclerView.setAdapter(employeeAdapter);
    }
}