package com.ggbbgdgh.health.guard.datastructure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
class UserQueueServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        assertTrue(true);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.stream().dropWhile(i -> i != 2).forEach(System.out::println);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }
    }
}