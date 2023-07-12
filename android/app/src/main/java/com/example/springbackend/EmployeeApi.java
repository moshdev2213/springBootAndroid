package com.example.springbackend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeApi {
    @GET("/employee/getAll")
    Call<List<Employee>> getAllEmployees();

    @POST("/employee/save")
    Call<Employee> save(@Body Employee employee);
}
