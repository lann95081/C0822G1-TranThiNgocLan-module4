import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiaiThuat {
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        System.out.println("Nhap vao chieu cao cua tam giac: ");
////        int h;
////        h = Integer.parseInt(scanner.nextLine());
////        for (int i = 0; i < h; i++) {
////            for (int j = 0; j < h; j++) {
////                if (j == 0 || i == h - 1 || i == j) {
////                    System.out.print("*");
////                } else {
////                    System.out.print(" ");
////                }
////            }
////            System.out.println();
////        }
//
//        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        Arrays.stream(str).sorted();
//        String reverse = "";
//        for (int i = 0; i < str.length; i++) {
//            String strs = str[i];
//            String reverseWord = "";
//            for (int j = strs.length() - 1; j >= 0; j--) {
//                reverseWord = reverseWord + strs.charAt(j);
//            }
//            reverse = reverse + reverseWord + " ";
//        }
//        System.out.println(Arrays.toString(reverse.toCharArray()));
//    }

//    public static void main(String[] args) {
//        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        System.out.println(abc(str));
//    }
//
//    public static List<List<String>> abc(String[] a) {
//        List<List<String>> b = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            List<String> e = new ArrayList<>();
//            e.add(a[i]);
//            for (int j = i + 1; j < a.length - i; j++) {
//                char[] c = a[i].toCharArray();
//                char[] d = a[j].toCharArray();
//                Arrays.sort(c);
//                Arrays.sort(d);
//                if (Arrays.equals(c, d)) {
//                    e.add(a[j]);
//
//                }
//            }
//            b.add(e);
//        }
//        return b;
//    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("eat","tea","tan","ate","nat","bat", "atn", "atnn"));
        List<List<String>> result = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < strs.size(); i++) {
            result.add(new ArrayList<>());
            result.get(idx).add(strs.get(i));
            for(int j = i + 1; j < strs.size(); j++) {
                if(check(strs.get(i), strs.get(j))) {
                    result.get(idx).add(strs.remove(j));
                    j--;
                }
            }
            strs.remove(i);
            i--;
            idx++;
        }

        System.out.println(result);
    }

    public static boolean check(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    s1 = s1.substring(0,i) + s1.substring(i+1, s1.length());
                    s2 = s2.substring(0,j) + s2.substring(j+1, s2.length());
                    i--;
                    break;
                }
            }
        }
        if(s1.equals("") && s2.equals(""))
            return true;
        else
            return false;
    }
}
