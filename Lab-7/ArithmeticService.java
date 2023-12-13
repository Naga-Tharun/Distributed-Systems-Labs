package com.example.arithmetic;

import javax.jws.WebService;
@WebService(endpointInterface = "com.example.arithmetic.ArithmeticPortType")

public class ArithmeticService implements ArithmeticPortType {
    @Override
    public AddResponse add(AddRequest parameters) {
        int result = parameters.getA() + parameters.getB();
        AddResponse response = new AddResponse();
        response.setResult(result);
        return response;
    }

    @Override
    public SubtractResponse subtract(SubtractRequest parameters) {
        int result = parameters.getA() - parameters.getB();
        SubtractResponse response = new SubtractResponse();
        response.setResult(result);
        return response;
    }
}