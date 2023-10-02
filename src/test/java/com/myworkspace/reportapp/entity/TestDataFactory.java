package com.myworkspace.reportapp.entity;

import com.myworkspace.reportapp.entity.customer.Customer;

public class TestDataFactory { //Wrzuć z dane z CSV - parametryzacja, zarzuć factory

    //FOR CUSTOMER
    public static Customer createSampleCustomer() {
        return new Customer("gmail@wp.pl",
                "669876222",
                "IT AG",
                "Jerozolimskie 100, 02-017, Warsaw, Poland");
    }
}
