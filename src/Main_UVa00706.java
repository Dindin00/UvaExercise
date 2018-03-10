//  UVa題目網址：
//  https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=647
//  中文題目網址：
//  http://luckycat.kshs.kh.edu.tw/homework/q706.htm

import java.util.Scanner;

public class Main_UVa00706 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String datas = sc.next();
        while (length != 0){
            String[][] ans = {{""}, {""}, {""}, {""}, {""}};
            for (int i = 0; i < datas.length(); i++) {
                String current = datas.substring(i, i + 1);
                switch (current){
                    case "0":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += "|" + new String(new char[length]).replace("\0", " ") + "|";
                        ans[2][0] += new String(new char[length + 2]).replace("\0", " ");
                        ans[3][0] += "|" + new String(new char[length]).replace("\0", " ") + "|";
                        ans[4][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        break;
                    case "1":
                        ans[0][0] += new String(new char[length + 2]).replace("\0", " ");
                        ans[1][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[2][0] += new String(new char[length + 2]).replace("\0", " ");
                        ans[3][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[4][0] += new String(new char[length + 2]).replace("\0", " ");
                        break;
                    case "2":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[2][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[3][0] += "|" + new String(new char[length + 1]).replace("\0", " ");
                        ans[4][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        break;
                    case "3":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[2][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[3][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[4][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        break;
                    case "4":
                        ans[0][0] += new String(new char[length + 2]).replace("\0", " ");
                        ans[1][0] += "|" + new String(new char[length]).replace("\0", " ") + "|";
                        ans[2][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[3][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[4][0] += new String(new char[length + 2]).replace("\0", " ");
                        break;
                    case "5":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += "|" + new String(new char[length + 1]).replace("\0", " ");
                        ans[2][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[3][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[4][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        break;
                    case "6":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += "|" + new String(new char[length + 1]).replace("\0", " ");
                        ans[2][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[3][0] += "|" + new String(new char[length]).replace("\0", " ") + "|";
                        ans[4][0] +=  " " + new String(new char[length]).replace("\0", "-") + " ";
                        break;
                    case "7":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[2][0] += new String(new char[length + 2]).replace("\0", " ");
                        ans[3][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[4][0] += new String(new char[length + 2]).replace("\0", " ");
                        break;
                    case "8":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += "|" + new String(new char[length]).replace("\0", " ") + "|";
                        ans[2][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[3][0] += "|" + new String(new char[length]).replace("\0", " ") + "|";
                        ans[4][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        break;
                    case "9":
                        ans[0][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[1][0] += "|" + new String(new char[length]).replace("\0", " ") + "|";
                        ans[2][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        ans[3][0] += new String(new char[length + 1]).replace("\0", " ") + "|";
                        ans[4][0] += " " + new String(new char[length]).replace("\0", "-") + " ";
                        break;
                }
                if (!(i == datas.length() - 1)) {
                    for (int j = 0; j < 5; j++) {
                        ans[j][0] += " ";
                    }
                }
            }
            System.out.println(ans[0][0]);
            for (int j = 0; j < length; j++) {
                System.out.println(ans[1][0]);
            }
            System.out.println(ans[2][0]);
            for (int j = 0; j < length; j++) {
                System.out.println(ans[3][0]);
            }
            System.out.println(ans[4][0]);
            System.out.println();
            length = sc.nextInt();
            datas = sc.next();
        }
    }
}
