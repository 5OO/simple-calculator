package com.po.simplecalculator.controller;

import com.po.simplecalculator.model.ArithmeticOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ArithmeticOperationController {

    private final List<ArithmeticOperation> operations = Collections.synchronizedList(new ArrayList<>());

    @GetMapping("/add")
    public ArithmeticOperation addNumbers(@RequestParam("first") int first,  @RequestParam("second") int second) {
        if (first < 0 || first > 100 || second < 0 || second > 100) {
            throw new IllegalArgumentException("Arvud peavad olema vahemikus 0 kuni 100");}
        int sum = first + second;
        ArithmeticOperation arithmeticOperation = new ArithmeticOperation(first, second, sum);
        operations.add(arithmeticOperation);
        return arithmeticOperation;
    }

    @GetMapping("/search")
    public List<ArithmeticOperation> searchOperations(
            @RequestParam(required = false) Integer number,
            @RequestParam("order") String order) {

        // TODO  lisada otsimise  loogika


        List<ArithmeticOperation> filteredAndOrderedOperations = null;
        return filteredAndOrderedOperations;
    }

}
