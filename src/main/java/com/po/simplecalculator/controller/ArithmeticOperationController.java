package com.po.simplecalculator.controller;

import com.po.simplecalculator.model.ArithmeticOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class ArithmeticOperationController {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;


    private final List<ArithmeticOperation> operations = Collections.synchronizedList(new ArrayList<>());

    @GetMapping("/add")
    public ArithmeticOperation addNumbers(@RequestParam("first") int first,  @RequestParam("second") int second) {
        if (first < MIN_VALUE || first > MAX_VALUE) {
            throw new IllegalArgumentException("Vigane väärtus: " + first + ". Arvud peavad olema vahemikus 0 kuni 100");}
        if (second < MIN_VALUE || second > MAX_VALUE) {
            throw new IllegalArgumentException("Vigane väärtus: " + second + ". Arvud peavad olema vahemikus 0 kuni 100");}
                int sum = first + second;
        ArithmeticOperation arithmeticOperation = new ArithmeticOperation(first, second, sum);
        operations.add(arithmeticOperation);
        return arithmeticOperation;
    }

    @GetMapping("/search")
    public List<ArithmeticOperation> searchOperations(
            @RequestParam(value = "number", required = false) Integer number,
            @RequestParam(value = "order", defaultValue = "asc") String order) {
        if (number == null || number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Arvud peavad olema vahemikus 0 kuni 100");}
        List<ArithmeticOperation> filteredAndOrderedOperations = new ArrayList<>();
        for (ArithmeticOperation operation : operations) {
            int attribute1 = operation.getAttributeFirst();
            int attribute2 = operation.getAttributeSecond();
            int sum = operation.getResult();
            if (number == attribute1 || number == attribute2 || number == sum) {
                filteredAndOrderedOperations.add(operation);
            }
        }

        if (order.equals("desc")) {
            filteredAndOrderedOperations.sort(Comparator.comparingInt(ArithmeticOperation::getResult).reversed());
        } else{
            filteredAndOrderedOperations.sort(Comparator.comparingInt(ArithmeticOperation::getResult));}

        return filteredAndOrderedOperations;

    }


}
