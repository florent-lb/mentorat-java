package org.mentorat.service;

import org.mentorat.infra.ConsoleAdapter;
import org.mentorat.infra.shop.JsonStockDataAdapter;
import org.mentorat.service.calculator.Calculator;
import org.mentorat.service.shop.Shop;
import org.mentorat.service.shop.StockDataPort;

public class MenuService {

    private static final String MENU = """
            ##########################
            ##  WELCOME ###############
            ##  Choose on option (input your choice and enter   ##
            ##  1 - Calculator   ##
            ##  1 - Shop   ##
            ##  0 - Exit     ##
            """;
    private static final String ASKING = "Votre choix -> ";

    public void start() {
        UserAdapter userAdapter = new ConsoleAdapter();

        boolean stay = true;
        userAdapter.display(MENU);
        do {
            userAdapter.display(ASKING);
            var choice = userAdapter.askSomething();
            switch (choice) {
                case "1" -> new Calculator(userAdapter).start();//calculate
                case "2" -> {
                    StockDataPort sdp = new JsonStockDataAdapter();
                    new Shop(sdp);//calculate
                }
                case "0" -> stay = false;
            }

        } while (stay);
    }

}
