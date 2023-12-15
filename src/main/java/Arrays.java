import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays {

    private static float n;

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 10};
        try {
            n = inputN(arr);
            todo(n, arr);
        } catch (PositiveException | NoAnswerException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Введено не число");
        }
    }

    public static float inputN(int[] arr) throws PositiveException, NoAnswerException {
        Scanner sc = new Scanner(System.in);
        float num = sc.nextFloat();
        if (num < 0) {
            throw new PositiveException();
        }
        if (num < arr[0]) {
            throw new NoAnswerException();
        }
        return num;
    }

    public static void todo(float n, int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (n < arr[i]) {
                System.out.println(arr[i - 1]);
                break;
            }
        }
        System.out.println(arr[arr.length - 1]);
    }
}
