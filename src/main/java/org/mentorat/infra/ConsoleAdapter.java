package org.mentorat.infra;

import org.mentorat.service.UserAdapter;

import java.util.Scanner;

public class ConsoleAdapter implements UserAdapter {


    @Override
    public void display(String valueToDisplay) {
        System.out.println(valueToDisplay);
    }

    @Override
    public String askSomething() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
