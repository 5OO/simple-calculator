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
            @RequestParam(value = "number", required = false) Integer number,
            @RequestParam(value = "order", defaultValue = "asc") String order) {
        if (number == null || number < 0 || number > 100) {
            throw new IllegalArgumentException("Arvud peavad olema vahemikus 0 kuni 100");}
        List<ArithmeticOperation> filteredAndOrderedOperations = new ArrayList<>();
        for (int i = 0; i < operations.size(); i++) {
            int attribute1 = operations.get(i).getAttributeFirst();
            int attribute2 =operations.get(i).getAttributeSecond();
            int sum = operations.get(i).getResult();
            if (number == attribute1 || number == attribute2 || number == sum) {
                filteredAndOrderedOperations.add(operations.get(i));
            }
        }


        return filteredAndOrderedOperations;

    }


}
