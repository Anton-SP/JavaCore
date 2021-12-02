package HomeWork1.lesson14;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.*;

import org.apache.logging.log4j.*;

public class CheckArrays {

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure("src/main/resources/logs/config/log4j.properties");
        CheckArrays checkArrays = new CheckArrays();
        checkArrays.checkBalance(new int[]{1, 2, 3, 4});
        checkArrays.shiftTwo(new int[]{1, 2, 3, 4},2);


    }

    public int sumEl(int arr[], int ind) {
        int sum = 0;//переменная для храения суммы, её и вернем как конечный результат
        for (int i = ind; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public boolean checkBalance(int arr[]) throws IOException {

        Logger loggerBalance = Logger.getLogger("balance");
        loggerBalance.info("Начало метода проверки баланса массива, логирование началось");

        int curLeft = arr[0];//берем первый элемент
        for (int i = 1; i < arr.length - 1; i++) {//циклом проходим от 2 элемента(с индексом 1) до предпоследнего элемента! надо же с чем то сумму сравнивать
            if (curLeft != sumEl(arr, i)) {//если текущая сумма элементов слева не равняется сумме элементов справа
                curLeft += arr[i];//сумме эл-тов слева плюсуем след элемент (текущий с индексом i т.к. i начали считать со второго элемента
            } else {
                loggerBalance.info("Найдена точка баланса возврат  результата и завершение работы");
                System.out.println("Наличие точки баланса в массиве" + Arrays.toString(arr));
                return true;
            } //если условие != не выполнилось значит нашли точку баланса можно отправить тру как результат проверки
        }
        loggerBalance.info("Точка баланса не найдена, возврат  результата и завершение работы");
        System.out.println("Наличие точки баланса в массиве" + Arrays.toString(arr));
        return false;//если дошли до конца массива, но условие так и выполняется, то значит точки баланса нет и возвращаем фолс как результат метода

    }

    public int[] shiftTwo(int[] arr, int n) {
        Logger shift = Logger.getLogger("shift");
        shift.info("Начало метода сдвига массива");
        System.out.println("Сдвиг массива " + Arrays.toString(arr));
        System.out.println("Сдвиг на " + n);

        float shiftFloat = n;
        shift.info("Вычисление сдвига");
        /*вычисляем куда надо сместить массив
        n может быть очень  большим числом, но нет смысла гонять ротацию 2500 раз
        берем заданное n и делим его на длину массива пока не останется либо 0 -> тогда длина массива кратна числу n и изменений мы не увидим
        либо в остатке будет число  (по модулю!) которое будет в диапазоне от 1 до длины массива не включая его
        и получается будет необходимо сдвинуть массив только на это значение (без примера на лекции наверно не додумался бы)
*/
        while ((shiftFloat % arr.length != 0) && (Math.abs(shiftFloat) > arr.length)) {//ищем остаток
            shiftFloat %= arr.length;
        }
        if (shiftFloat == 0) {//проверяем будет ли смещен массив
            shift.info("Сдвига нет, конец метода");
            System.out.println("N кратно длине массива поэтому массив останется без изменений");
            //  System.out.println("Массив после сдвига " +  Arrays.toString(arr));
            return arr;//после всех смещений массив останется прежним поэтому его и вернем
        } else {//смещение есть!
            shift.info("Размер сдвига определен");
            if (shiftFloat > 0) {//смещаем вправо
                shift.info("Начало сдвига вправо");
                System.out.println(Arrays.toString(arr));//выводим текущий масив для сравнения
                int curN = 0;
                while (curN < shiftFloat) {
                    int buf = arr[arr.length - 1];
                    for (int i = arr.length - 1; i > 0; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[0] = buf;
                    curN++;
                }
                System.out.println("Массив после сдвига " + Arrays.toString(arr));
                shift.info("Сдвиг вправо выполнен, конец метода");
                return arr;
            } else {//смещаем влево
                shift.info("Начало сдвига влево");
                System.out.println(Arrays.toString(arr));//выводим текущий масив для сравнения
                int curN = 0;
                while (curN > shiftFloat) {
                    int buf = arr[0];
                    for (int i = 0; i < (arr.length - 1); i++) {
                        arr[i] = arr[i + 1];
                    }
                    arr[arr.length - 1] = buf;
                    curN--;
                }
                System.out.println("Массив после сдвига " + Arrays.toString(arr));
                shift.info("Сдвиг влево выполнен, конец метода");
                return arr;
            }
        }
    }


}
