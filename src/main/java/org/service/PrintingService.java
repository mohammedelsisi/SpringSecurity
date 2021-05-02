package org.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


public class PrintingService {
    public String sayHi(){
        return "Hello From Service Bean";
    }
}
