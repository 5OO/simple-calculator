package com.po.simplecalculator.controller;

import com.po.simplecalculator.model.ArithmeticOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithmeticOperationController {

    public ArithmeticOperation addNumbers(@RequestParam("first") int first,  @RequestParam("second") int second) {
        if (first < 0 || first > 100 || second < 0 || second > 100) {
            throw new IllegalArgumentException("Arvud peavad olema vahemikus 0 kuni 100");}
        int sum = first + second;
        return new ArithmeticOperation(first, second, sum);
    }
}
