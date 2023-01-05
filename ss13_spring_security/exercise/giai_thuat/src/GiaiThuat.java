import java.util.Scanner;

public class GiaiThuat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao chieu cao cua tam giac: ");
        int h;
        h = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (j == 0 || i == h - 1 || i == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
