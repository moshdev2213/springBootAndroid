package com.example.springbackend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews(){
        EditText inputEditLocation = findViewById(R.id.etLocation);
        EditText inputEditBranch = findViewById(R.id.etBranch);
        EditText inputEditName = findViewById(R.id.etName);
        Button btn = findViewById(R.id.btnSubmit);

        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

        btn.setOnClickListener(view->{
            String name = String.valueOf((inputEditName.getText()));
            String branch = String.valueOf((inputEditBranch.getText()));
            String location = String.valueOf((inputEditLocation.getText()));

            Employee employee = new Employee();
            employee.setName(name);
            employee.setBranch(branch);
            employee.setLocation(location);

            employeeApi.save(employee).enqueue(
                    new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Toast.makeText(MainActivity.this,"Saved Succesfully",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(MainActivity.this,"Saved UnSuccesfully",Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,"Error",t);
                        }
                    }
            );
        });
    }
}