package me.warriorg.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Optional;

@Execution(ExecutionMode.CONCURRENT)
public class Junit {


    @RepeatedTest(value = 10)
    @Test
    public void getName() {
        System.out.println("xxxx");
    }
}
