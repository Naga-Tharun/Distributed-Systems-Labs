package com.example.arithmetic;
import javax.xml.ws.Endpoint;

public class ArithmeticServicePublisher {
    public static void main(String[] args) {
        String address = "http://localhost:8080/arithmetic";
        ArithmeticService arithmeticService = new ArithmeticService();
        Endpoint.publish(address, arithmeticService);
        System.out.println("ArithmeticService is published at: " + address);
    }
}