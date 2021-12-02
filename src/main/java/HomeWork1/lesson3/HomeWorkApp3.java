package HomeWork1.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkApp3 {


    public static int[] arrBalance = new int[]

            {5, 10, 6, 4, 2, 3,};//массив где есть баланс да и по коду потом тетсировать удобнее есл иесть заготовки

    public static int[] arrDisBalance = new int[]

            {5, 10, 6, 4, 3, 3,};//и где баланса нет

    public static int[] arr1 = new int[] //и несколько массивов для теста
            {-2, 3, 10, 45, 13, 2,};

    public static int[] arr2 = new int[]
            {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {

//        zeroToOne();
//        fillArrayTo100();
//        dublearray();
//        matrix1();
//        System.out.print(Arrays.toString(createArray(3, 2)));
//        System.out.println();
//        maxMinElements();
//        System.out.println();
//        System.out.println(checkBalance(arrBalance));
//        System.out.println();
//        System.out.println(checkBalance(arrDisBalance));
//        System.out.println(checkBalance(arrBalance));
        //   shift(arrDisBalance, 3);
//        System.out.println();
        //  System.out.println(Arrays.toString(shiftTwo(arrBalance, 2357)));
        //    shiftTwo(arrBalance,-3);
        chooseAction();//меню
    }

    //метод замены 0 на 1 и наоборот
    private static void zeroToOne() {
        int[] myArr = new int[]{0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0}; //создаем массив
        System.out.println(Arrays.toString(myArr) + " изначальный массив");//выводим для удобства чтобы было с чем сравнивать
        for (int i = 0; i < myArr.length; i++) { //перебираем массив и меняем значения
            if (myArr[i] > 0) myArr[i] = 0;
            else {
                myArr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(myArr) + " конечный массив");//вывод изменненого массива
    }

    //метод заполнения массива от 1 до 100
    private static void fillArrayTo100() {
        int[] array1To100 = new int[100];
        for (int i = 0; i < array1To100.length; i++) {
            array1To100[i] = i + 1;
        }
        System.out.println(Arrays.toString(array1To100));
    }

    // метод увеличивающий эл массива на 2 если они меньше 6
    private static void dublearray() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr)+ " изначальный массив"); //выводим для сравнения
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println(Arrays.toString(arr)+ " конечный массив"); //выводим результирующий массив
    }

    //метод заполнения двумерного массива единицами по диагонали
    private static void matrix1() {//создаем двумерный массив
        int[][] matrix = new int[10][10];//и т.к. для int дефолтное значение 0 можно его не заполнять
        System.out.println();//а простов нужных местах поставть единицы
        for (int i = 0; i < matrix.length; i++) {//диагональ начинается с крйних позций и смещается на 1 при каждой итерации
            matrix[i][i] = 1;//т.е. первая единица в ряду будет всегда с двойным значяением [0,0] [1,1] и тд
            matrix[i][((matrix[i].length - 1) - i)] = 1;//а вторая единица в ряду будет зеркальной т.е с таким же отступом но с конца
            //берем длину строки вычетаем 1 (чтобы попасть в диапазон индексов массива) и вычитаем текущий индекс i
            // но тут есть 1 условие что данный метод действует только для квадрата,
        }//если будет прямоуголльник то произойдет выход за пределы массива и следовательно программа уйдет в ошибку
        for (int i = 0; i < matrix.length; i++) {//ну и вывод массива
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }


    //метод создания и возврата массива
    private static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    //6. метод поиска макс и мин эл массива
    private static void maxMinElements(int[] arr) {
        int max = arr[0];//переменным присваиваем занчение 1 элемента массива
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {//и поочередно сравниваем с условием
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Задан массив: "+Arrays.toString(arr));
        System.out.printf("Минимальный элемент массива %d, а максимальный  %d", min, max);
        System.out.println();
    }

    //метод для суммирования эл массива пробегается по элементам и суммирует значения
    //на вход получает массив и индекс с которого надо начать сумировать эл-ты
    private static int sumEl(int arr[], int ind) {
        int sum = 0;//переменная для храения суммы, её и вернем как конечный результат
        for (int i = ind; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //7. мтеод проверки есть ли в масиве точка баланса
    private static boolean checkBalance(int arr[]) {
        int curLeft = arr[0];//берем первый элемент
        for (int i = 1; i < arr.length - 1; i++) {//циклом проходимот 2 элемента(с индексом 1) до предпоследнего элемента! надо же с чем то сумму сравнивать
            if (curLeft != sumEl(arr, i)) {//если текущая слумма  элементов слева не равняется сумме элементов справа
                curLeft += arr[i];//сумме эл-тов слева плюсуем след элемент (текущий с индексом i т.к. i начали считать со второго элемента
            } else {
                System.out.println("Наличие точки баланса в массиве" + Arrays.toString(arr));
                return true;
            } //если условие != не выполнилось значит нашли точку баланса можно отправить тру как результат проверки
        }System.out.println("Наличие точки баланса в массиве" + Arrays.toString(arr));
        return false;//если дошли до конца маасива но условие так и выполняется то значит точки баланса нет и возвращаем фолс как результат метода
    }

/*не Осилил :(  первый вариан смещения
не n раз каждый раз смещать массив а пройтись по нем всгего 1 раз и прии смещении запомнитьэлемент и вставить его в след шаг n

    //мтеод для смещения массива  - возвращает массив
    private static int[] shift(int arr[], int n) {
        //нужны несколько переменных чтобы не потерять значения при смещении
        int bufCur;//
        int bufShifted;
        int current; //текущий элемент
        int shifted;//смещенный элемент

        float shiftFloat = n;/*вычисляем куда надо сместить массив
        n может быть очень  большим числом но нет смысла гонять ротацию 2500 раз
        берем заданное n и делим его на длину массива пока не останеся лобо 0 -> тогда длина массива кратна числу n и изменений мы не увидим
        либо в остатке будет число  (по модулю!) готорое будет в диапазоне от 1 до длины массива не включяе его
        и получается будет необходимо сдвинуть массив только на это значение (без примера на лекции наверно не додумался бы)

        while ((shiftFloat % arr.length != 0) && (Math.abs(shiftFloat) > arr.length)) {//ищем остаток
            shiftFloat %= arr.length;
//            System.out.println(arr.length); это для дебага
//            System.out.println(shiftFloat);
        }
        if (shiftFloat == 0) {//проверяем будет ли смещен массив
            System.out.println("N кратно длине массива поэтому массив останется без изменений");
            return arr;//после всех смещений массив останется прежним поэтому его и вернем
        } else {//смещение есть!
            System.out.println(Arrays.toString(arr));
            System.out.println(arr.length%n);
            for (int i = 0; i <(arr.length%n) ; i++) {//Здесь ошибка всё время возращает 0 а дожен остаток деления длины от шага по идее это должно опказывать количесвто подмножесвт чтобы покрыть весь наш маассив
            сам смысл смещения
            изначально я условыием ставил i<arr.length но попадал в ситуацию когда у меня в массиве из 6 элементов с шагом 3 менялись только
            первый и третий элементы. и я думал что это тупик НО можно разделить весь массив на такие связцки-множества
            и если намерено сделать цикл бесконечным while true а выйти из него по brake когда мы дойдем до повтора то можно отработать одну связку элементов
            потом перейти на втрую а затем если есть то и на третью
            для этого необходим остаток деления длины от шага

                System.out.println(i);
              current = i; //i менять нельзя оно нужно во внеш цикле
              bufCur = arr[current];//сохраняем текущий элемент

               if (shiftFloat > 0) {//проверяем в какую сторону + в право - влево. 0 уже исключили его в расчет не берем
                   //вывод изначального масива для сравнения

                   while (true) {
                       shifted = current + n;//ищем место куда сместить элемент
                       if (shifted >= arr.length) //если вышли за размер массива
                           shifted = shifted - arr.length;//находм его место в начале т.к.сдвиг цикличен эмпирически вроде проверил - расчет верный
                       if (shifted == i) //если сместились на изначальный элемент то значит ходим по кругу и нужно прервать while
                           break;
                       bufShifted= arr[shifted];
                       arr[shifted] = arr[current];
                       current = shifted;


                   }
                 }
               else { //ветка если двигамся вдругую сторону
                   System.out.println(" Смещаем влево на" + n + "элементов");
                   shifted =1;
                  }
              arr[shifted]=bufCur;
            } return arr;
        }

    }


    изначально у меня получался бесконечный цикл так как я проходил for до длины массив
    но если намерено сделать цикл бесконечным while true а выйти из него по brake то можно отработать одну связку элементов
    потом перейти на втрую а затем если есть то и на третью
    для этого необходим остаток деления длины от шага но он не работает и даже если подсатвить нужное значения я похоже запутался куда смещать

 */
    //поэтому родилась альтернатива!
    //не так красиво и думаю сильно затратно  так как надо будет перебирать массив n раз
    // но проще реализуемо

    private static int[] shiftTwo(int[] arr, int n) {
        float shiftFloat = n;/*вычисляем куда надо сместить массив
        n может быть очень  большим числом но нет смысла гонять ротацию 2500 раз
        берем заданное n и делим его на длину массива пока не останеся лобо 0 -> тогда длина массива кратна числу n и изменений мы не увидим
        либо в остатке будет число  (по модулю!) готорое будет в диапазоне от 1 до длины массива не включяе его
        и получается будет необходимо сдвинуть массив только на это значение (без примера на лекции наверно не додумался бы)
*/
        while ((shiftFloat % arr.length != 0) && (Math.abs(shiftFloat) > arr.length)) {//ищем остаток
            shiftFloat %= arr.length;
        }
        if (shiftFloat == 0) {//проверяем будет ли смещен массив
            System.out.println("N кратно длине массива поэтому массив останется без изменений");
            return arr;//после всех смещений массив останется прежним поэтому его и вернем
        } else {//смещение есть!
            if (shiftFloat > 0) {//смещаем вправо
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
                return arr;
            } else {//смещаем влево
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
                return arr;
            }
        }
    }
    private static void chooseAction() {
        //выводим меню
        System.out.println("Вы попали в меню выбора задачи, пожалуйста выберите из следующего списка:");
        System.out.println("1. Метод изменения значений 0 на 1 и наоборот");
        System.out.println("2. Метод заполнения массива до 100");
        System.out.println("3. Метод умножения элемнетов в 2  раза если они меньше 6");
        System.out.println("4. Метод заполнения квадрата единицами по диагонали");
        System.out.println("5. Метод возврата одномерного массива заданной длины и начальном значением");
        System.out.println("6. Метод поиска минимального и максимального элементов");
        System.out.println("7. Метод проверки точки баланса в массиве");
        System.out.println("8. Метод сдвига массива");
        System.out.println("9. Выход");
        //далее кусок из https://metanit.com/java/tutorial/2.9.php по пользовательскому вводу
        Scanner in = new Scanner(System.in); //польлзовательски ввод
        System.out.println("Выберите задачу");
        if (in.hasNextInt()) {  //роверка вводана число если true то выполняем меню
            int num = in.nextInt();
            //меню теперь через Switch
            switch (num) {
                case 1 -> {
                    zeroToOne();

                    chooseAction();
                }
                case 2 -> {
                    fillArrayTo100();

                    chooseAction();
                }
                case 3 -> {
                    dublearray();

                    chooseAction();
                }
                case 4 -> {
                    matrix1();

                    chooseAction();
                }
                case 5 -> {
                    System.out.print(Arrays.toString(createArray(3, 15)));
                    chooseAction();
                }
                case 6 -> {
                    maxMinElements(arr1);
                    chooseAction();
                }
                case 7 -> {
                    System.out.println(checkBalance(arrBalance));
                    System.out.println(checkBalance(arrDisBalance));
                    chooseAction();
                }
                case 8 -> {
                    System.out.println(Arrays.toString(shiftTwo(arr1,2452)));
                    System.out.println();
                    System.out.println(Arrays.toString(shiftTwo(arr1,-2452)));;
                    System.out.println();
                    chooseAction();
                }
                case 9 -> System.out.println("Хорошего Вам дня, до свидания");
                default -> {
                    System.out.println("Вы ввели неверное значение, пожалуста попробуйте снова");
                    chooseAction();
                } //закрыли default скобок много поэтому буду отмечать
            }//закрыли switch
        } else {System.out.println("Вы ввели не число, пожалуста попробуйте снова"); chooseAction();}//это есл ипользователь ввел не число
        in.close();
    }//закрыли метод


}
