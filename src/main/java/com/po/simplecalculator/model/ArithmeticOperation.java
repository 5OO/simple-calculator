package com.po.simplecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArithmeticOperation {
    private int attributeFirst;
    private int attributeSecond;
    private int result;
}
