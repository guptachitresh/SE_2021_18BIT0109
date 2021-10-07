import java.util.*;
public class HitWicket {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[][] board=new String[5][5];
        
        int i,j,k;
        for(i=0;i<5;i++)
        Arrays.fill(board[i],"-");
        //player 1 inputs
        System.out.println("Enter player 1's inputs");
        for(i=0;i<5;i++){
            board[4][i]="A-"+sc.nextLine();
        }
        System.out.println("Board condition");
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        //player 2 inputs
        System.out.println("Enter player 2's inputs");
        for(i=0;i<5;i++){
            board[0][i]="B-"+sc.nextLine();
        }
        System.out.println("Board condition");
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        while(true){
            //player 1 turn
            System.out.println("Enter player 1's move");
            int flag=0;
            String s=sc.nextLine();
            String s1="A-"+s.substring(0, 2);
            char ch=s.charAt(3);
            for(i=0;i<5 && flag==0;i++){
                for(j=0;j<5;j++){
                    if(s1.equals(board[i][j])){
                        if(ch=='F'){
                                board[i][j]="-";
                                board[i-1][j]=s1;   
                        }if(ch=='B'){
                            board[i][j]="-";
                            board[i+1][j]=s1; 
                        }if(ch=='L'){
                            board[i][j]="-";
                            board[i][j-1]=s1; 
                        }if(ch=='R'){
                            board[i][j]="-";
                            board[i][j+1]=s1; 
                        }
                        flag=1;
                        break;
                    }
                }
                if(i==4&&flag==0){
                    System.out.println("Invalid player...pls try again");
                    s=sc.nextLine();
                    s1="A-"+s.substring(0, 2);
                    ch=s.charAt(3);
                    i=-1;
                }
            }
            if(checkwin(board)==1)
            break;
            System.out.println("Board condition:");
            for(i=0;i<5;i++){
                for(j=0;j<5;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            flag=0;
            //player 2 turn
            System.out.println("Enter player 2's move");
            s=sc.nextLine();
            s1="B-"+s.substring(0, 2);
            ch=s.charAt(3);
            for(i=0;i<5 && flag==0;i++){
                for(j=0;j<5;j++){
                    if(s1.equals(board[i][j])){
                        if(ch=='F'){
                            System.out.println(i+" "+j);
                                board[i][j]="-";
                                board[i+1][j]=s1;   
                        }if(ch=='B'){
                            board[i][j]="-";
                            board[i-1][j]=s1; 
                        }if(ch=='L'){
                            board[i][j]="-";
                            board[i][j-1]=s1; 
                        }if(ch=='R'){
                            board[i][j]="-";
                            board[i][j+1]=s1; 
                        }
                        flag=1;
                        break;
                    }   
                }
                if(i==4&&flag==0){
                    System.out.println("Invalid player...pls try again");
                    s=sc.nextLine();
                    s1="B-"+s.substring(0, 2);
                    ch=s.charAt(3);
                    i=-1;
                }
            }
            System.out.println("Board condition:");
            for(i=0;i<5;i++){
                for(j=0;j<5;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    private static int checkwin(String[][] board) {
        int a=0,b=0,i,j;
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                if(board[i][j].charAt(0)=='A')
                a++;
                if(board[i][j].charAt(0)=='B')
                b++;
                if(a>0&&b>0)
                return 0;
            }
        }
        if(a==0&&b!=0){
            System.out.println("A won!");
            return 1;
        }if(b==0&&a!=0){
            System.out.println("B won!");
            return 1;
        }
        return 0;
    }
}
