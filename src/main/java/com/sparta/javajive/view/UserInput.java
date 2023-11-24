package com.sparta.javajive.view;

import com.sparta.javajive.controller.DaoImpl;
import com.sparta.javajive.model.Employee;
import com.sparta.javajive.model.EmployeeStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {


    DaoImpl daoImpl = new DaoImpl(EmployeeStore.getEmployeeStore());

    public void empIDScanner() {
        Scanner empIdScanner = new Scanner(System.in);
        System.out.println("Please enter the employee ID: ");
        int empIdInput = empIdScanner.nextInt();
        System.out.println(daoImpl.getById(empIdInput));
    }

    public void lastNameScanner() {
        Scanner lastNameScanner = new Scanner(System.in);
        System.out.println("Please enter the Last Name");
        String lastNameInput = lastNameScanner.nextLine();
        if (daoImpl.getByLastName(lastNameInput).isEmpty()) {
            System.out.println("No employee with that last name was found.");
        } else {
            PrintArrayList.printArrayList(daoImpl.getByLastName(lastNameInput));
        }

    }

    public void dateRangeScanner() {
        Scanner dateRangeScanner = new Scanner(System.in);
        System.out.println("Please enter the first date in date range: (dd/MM/YYYY)");
        String dateRangeFirstInput = dateRangeScanner.nextLine();
        System.out.println("Please enter the second date in date range: (dd/MM/YYYY)");
        String dateRangeLastInput = dateRangeScanner.nextLine();
        if (daoImpl.getByDateRange(dateRangeFirstInput, dateRangeLastInput).isEmpty()) {
            System.out.println("No employee that joined the company within that date range was found.");
        } else {
            PrintArrayList.printArrayList(daoImpl.getByDateRange(dateRangeFirstInput, dateRangeLastInput));
        }

    }

    public void ageRangeScanner() {
        Scanner ageRangeScanner = new Scanner(System.in);
        System.out.println("Please enter the first age in age range: ");
        String ageRangeFirstInput = ageRangeScanner.nextLine();
        System.out.println("Please enter the second age in age range: ");
        String ageRangeLastInput = ageRangeScanner.nextLine();
        if (daoImpl.getByAgeRange(ageRangeFirstInput, ageRangeLastInput).isEmpty()) {
            System.out.println("No employee within that age range was found.");
        } else {
            PrintArrayList.printArrayList(daoImpl.getByAgeRange(ageRangeFirstInput, ageRangeLastInput));
        }
    }

}
