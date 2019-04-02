package com.web.eran;

import java.util.Iterator;
import java.util.Stack;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class EranApplicationTests {
	
	Stack<Integer> stack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
    }
 
    public void pop() {
        stack.pop();
    }
 
    public int top() {
        return stack.peek();
    }
 
    public int min() {
        int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (min>tmp){
                min = tmp;
            }
        }
        return min;
    }
    
    
    public static void main(String[] args) {
    	EranApplicationTests t = new EranApplicationTests();
    	t.push(1);
    	t.push(2);
    	t.push(3);
    	t.push(0);
    	System.out.println(t.min());
	}
}
