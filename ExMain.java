// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, 
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
//  Если в каком-то элементе массива преобразование не удалось 
//  (например, в ячейке лежит символ или текст вместо числа), 
//  должно быть брошено исключение MyArrayDataException, 
//  с детализацией в какой именно ячейке лежат неверные данные.

// 3. В методе main() вызвать полученный метод, обработать возможные исключения
// MyArraySizeException и MyArrayDataException и вывести результат расчета 
// (сумму элементов, при условии что подали на вход корректный массив).

public class ExMain {

    public static void main(String[] args) {
        String [][] array = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
       System.out.println(arrayChek(array));
    }
    public static String arrayChek(String[][] array) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
                    if (array.length != array[i].length){
                        throw new MyArraySizeException();
                    }
                try {
                    int temp = Integer.parseInt(array[i][j]);
                    summ += temp;
                    }
                catch(NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return ("Сумма элементов в массиве равна: "+summ);
    }
    public static class MyArraySizeException extends RuntimeException {
        public MyArraySizeException() {
            super("Ошибка размерности массива");
        }
    }
    public static class MyArrayDataException extends RuntimeException {
        public MyArrayDataException(int i, int j) {
            super("Не удалось преобразовать элемент с индексами:"+i+"-"+j);
        }
    }
}
