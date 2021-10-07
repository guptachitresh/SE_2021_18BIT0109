import java.util.*;
public class HitWicket_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[5][5];

        int i, j;
        for (i = 0; i < 5; i++)
            Arrays.fill(board[i], "-");
        // player 1 inputs
        System.out.println("Enter player 1's inputs");
        for (i = 0; i < 5; i++) {
            board[4][i] = "A-" + sc.nextLine();
        }
        System.out.println("Board condition");
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        // player 2 inputs
        System.out.println("Enter player 2's inputs");
        for (i = 0; i < 5; i++) {
            board[0][i] = "B-" + sc.nextLine();
        }
        System.out.println("Board condition");
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter Hero 1 location for P1");
        int a=sc.nextInt();
        int b=sc.nextInt();
        board[a-1][b-1]="A-H1";
        System.out.println("Enter Hero 2 location for P1");
        a=sc.nextInt();
        b=sc.nextInt();
        board[a-1][b-1]="A-H2";
        System.out.println("Enter Hero 1 location for P2");
        a=sc.nextInt();
        b=sc.nextInt();
        board[a-1][b-1]="B-H1";
        System.out.println("Enter Hero 2 location for P2");
        a=sc.nextInt();
        b=sc.nextInt();
        board[a-1][b-1]="B-H2";
        System.out.println("Board condition");
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        while (true) {
            // player 1 turn
            System.out.println("Enter player 1's move");
            int flag1 = 0,flag2=0;
            String s = sc.nextLine();
            String s1 = "A-" + s.substring(0, 2);
            char ch = s.charAt(3);
            for (i = 0; i < 5 && flag1 == 0; i++) {
                for (j = 0; j < 5; j++) {
                    flag2=0;
                    if (s1.equals(board[i][j])) {
                        if(s1.equals("A-H2")){
                            if(s.substring(3)=="FL"){
                                    if (issafe(i - 2, j-2, board,'A')) {
                                        board[i][j] = "-";
                                        board[i -2][j-2] = s1;
                                        board[i-1][j-1]="-";
                                    }else{
                                        flag2=1;
                                        break;
                                    }
                            }
                            if(s.substring(3)=="FR"){
                                if (issafe(i - 2, j+2, board,'A')) {
                                    board[i][j] = "-";
                                    board[i -2][j+2] = s1;
                                    board[i-1][j+1]="-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                        }
                        if(s.substring(3)=="BL"){
                            if (issafe(i + 2, j-2, board,'A')) {
                                board[i][j] = "-";
                                board[i +2][j-2] = s1;
                                board[i+1][j-1]="-";
                            }else{
                                flag2=1;
                                break;
                            }
                    }
                    if(s.substring(3)=="BR"){
                        if (issafe(i + 2, j+2, board,'A')) {
                            board[i][j] = "-";
                            board[i +2][j+2] = s1;
                            board[i+1][j+1]="-";
                        }else{
                            flag2=1;
                            break;
                        }
                }
                
                    }
                        if (ch == 'F') {
                            if(s1.equals("A-H1")){
                                if (issafe(i - 2, j, board,'A')) {
                                    board[i][j] = "-";
                                    board[i - 2][j] = s1;
                                    board[i-1][j]="-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                            else if (issafe(i - 1, j, board,'A')) {
                                board[i][j] = "-";
                                board[i - 1][j] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        if (ch == 'B') {
                            if(s1.equals("A-H1")){
                                if (issafe(i +2, j, board,'A')) {
                                    board[i][j] = "-";
                                    board[i +2][j] = s1;
                                    board[i+1][j] = "-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                           else if(issafe(i+1, j, board, 'A')){
                            board[i][j] = "-";
                            board[i + 1][j] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        if (ch == 'L') {
                            if(s1.equals("A-H1")){
                                if (issafe(i, j-2, board,'A')) {
                                    board[i][j] = "-";
                                    board[i][j-2] = s1;
                                    board[i][j-1] = "-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                            else if(issafe(i, j-1, board, 'A')){
                            board[i][j] = "-";
                            board[i][j - 1] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        if (ch == 'R') {
                            if(s1.equals("A-H1")){
                                if (issafe(i, j+2, board,'A')) {
                                    board[i][j] = "-";
                                    board[i][j+2] = s1;
                                    board[i][j+1] = "-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                            else if(issafe(i, j+1, board, 'A')){
                            board[i][j] = "-";
                            board[i][j + 1] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        flag1 = 1;
                        break;
                    }
                }
                if (i == 4 && flag1 == 0||flag2==1) {
                    System.out.println("Invalid player...pls try again");
                    s = sc.nextLine();
                    s1 = "A-" + s.substring(0, 2);
                    ch = s.charAt(3);
                    i = -1;
                }
            }
            if (checkwin(board) == 1)
                break;
            System.out.println("Board condition:");
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            flag1 = 0;
            // player 2 turn
            System.out.println("Enter player 2's move");
            s = sc.nextLine();
            s1 = "B-" + s.substring(0, 2);
            ch = s.charAt(3);
            for (i = 0; i < 5 && flag1 == 0; i++) {
                for (j = 0; j < 5; j++) {
                    if (s1.equals(board[i][j])) {
                        if(s1.equals("B-H2")){
                            if(s.substring(3)=="FL"){
                                    if (issafe(i + 2, j-2, board,'A')) {
                                        board[i][j] = "-";
                                        board[i +2][j-2] = s1;
                                        board[i+1][j-1]="-";
                                    }else{
                                        flag2=1;
                                        break;
                                    }
                            }
                            if(s.substring(3)=="FR"){
                                if (issafe(i + 2, j+2, board,'A')) {
                                    board[i][j] = "-";
                                    board[i +2][j+2] = s1;
                                    board[i+1][j+1]="-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                        }
                        if(s.substring(3)=="BL"){
                            if (issafe(i - 2, j-2, board,'A')) {
                                board[i][j] = "-";
                                board[i -2][j-2] = s1;
                                board[i-1][j-1]="-";
                            }else{
                                flag2=1;
                                break;
                            }
                    }
                    if(s.substring(3)=="BR"){
                        if (issafe(i - 2, j+2, board,'A')) {
                            board[i][j] = "-";
                            board[i -2][j+2] = s1;
                            board[i-1][j+1]="-";
                        }else{
                            flag2=1;
                            break;
                        }
                }
                
                    }
                        if (ch == 'F') {
                            if(s1.equals("B-H1")){
                                if (issafe(i+2, j, board,'B')) {
                                    board[i][j] = "-";
                                    board[i+2][j] = s1;
                                    board[i+1][j] = "-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                            else if(issafe(i+1, j, board, ch)){
                            board[i][j] = "-";
                            board[i + 1][j] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        if (ch == 'B') {
                            if(s1.equals("B-H1")){
                                if (issafe(i-2, j, board,'B')) {
                                    board[i][j] = "-";
                                    board[i-2][j] = s1;
                                    board[i-1][j] = "-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                            else if(issafe(i-1, j, board, ch)){
                            board[i][j] = "-";
                            board[i - 1][j] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        if (ch == 'L') {
                            if(s1.equals("B-H1")){
                                if (issafe(i, j-2, board,'B')) {
                                    board[i][j] = "-";
                                    board[i+2][j] = s1;
                                    board[i+1][j] = "-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                            else if(issafe(i, j-1, board, ch)){
                            board[i][j] = "-";
                            board[i][j - 1] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        if (ch == 'R') {
                            if(s1.equals("B-H1")){
                                if (issafe(i, j+2, board,'B')) {
                                    board[i][j] = "-";
                                    board[i][j+2] = s1;
                                    board[i][j+1] = "-";
                                }else{
                                    flag2=1;
                                    break;
                                }
                            }
                            else if(issafe(i, j+1, board, ch)){
                            board[i][j] = "-";
                            board[i][j + 1] = s1;
                            }else{
                                flag2=1;
                                break;
                            }
                        }
                        flag1 = 1;
                        break;
                    }
                }
                if (i == 4 && flag1 == 0||flag2==1) {
                    System.out.println("Invalid player...pls try again");
                    s = sc.nextLine();
                    s1 = "B-" + s.substring(0, 2);
                    ch = s.charAt(3);
                    i = -1;
                }
            }
            if (checkwin(board) == 1)
                break;
            System.out.println("Board condition:");
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static int checkwin(String[][] board) {
        int a = 0, b = 0, i, j;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (board[i][j].charAt(0) == 'A')
                    a++;
                if (board[i][j].charAt(0) == 'B')
                    b++;
                if (a > 0 && b > 0)
                    return 0;
            }
        }
        if (a == 0 && b != 0) {
            System.out.println("B won!");
            return 1;
        }
        if (b == 0 && a != 0) {
            System.out.println("A won!");
            return 1;
        }
        return 0;
    }

    private static boolean issafe(int i, int j, String[][] board, char ch) {
        if(ch=='A')
        return (i < 5 && j < 5 && i >= 0 && j >= 0 && board[i][j].charAt(0)!='A');
        if(ch=='B')
        return (i < 5 && j < 5 && i >= 0 && j >= 0 && board[i][j].charAt(0)!='B');
        return false;
    }
}
