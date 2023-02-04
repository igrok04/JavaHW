// 4. К калькулятору из предыдущего дз добавить логирование.
// ================================================================================================================
package JavaHW2;

import java.util.logging.*;
import java.util.Scanner;

public class hw2_task3 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Logger LOG = Logger.getLogger(hw2_task3.class.getName());
        LOG.setLevel(Level.INFO);
        ConsoleHandler ch = new ConsoleHandler();
        LOG.addHandler(ch);
        SimpleFormatter sf = new SimpleFormatter();
        ch.setFormatter(sf);

            char operation;
            Scanner n1 = new Scanner(System.in);
            do {
                System.out.println("Введите первое число:");
                int num1 = n1.nextInt();
                LOG.info("Пользователь ввёл число: " + num1);
                               
                System.out.println("Введите второе число:");
                int num2 = n1.nextInt();
                LOG.info("Пользователь ввёл число: " + num2);

                System.out.println("Введите операцию:");
                operation = scanner.next().charAt(0);
                LOG.info("Пользователь ввёл операцию: " + operation);

                int result = 0;
                switch (operation){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case 's':
                        LOG.info("Пользователь остановил программу");
                        break;
                    }
                System.out.println("Результат операции: " + result);
             } while(operation!='s'); // символ остановки
                  
        
        n1.close();
    }   
}