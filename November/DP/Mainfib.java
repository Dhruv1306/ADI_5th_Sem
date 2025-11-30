// this is a Dynamic Programming code of fibonacci numbers
public class Mainfib {

    // int fib(int num){
    // if(num == 0) return 0;
    // if(num == 1) return 1;
    // return fib(num - 1) + fib(num - 2);
    // //this is a divide and conquer code of the fibonacci number
    // }

    // Memoization Dynamic Programming (Top Down DP)
    // static int[] arr = new int[15]; // Array to store the result of the function call

    // // fill the array for the initial data
    // static {
    //     Arrays.fill(arr, -1); // in static block
    // }

    // static int fib(int num) {
    //     if (num == 0){
    //         arr[0] = 0;
    //         return 0;
    //     }
    //     if (num == 1){
    //         arr[1] = 1;
    //         return 1;
    //     }
    //     int res = 0; //before processing any function call we check and find it in data structure

    //     if (arr[num] != -1) {
    //         return arr[num]; //here we return the value stored here when found
    //     } else {
    //         res = fib(num - 1) + fib(num - 2); //here recursion call takes place
    //         arr[num] = res; //here we store the calculated value
    //     }

    //     return res;
    //     // this is a divide and conquer code of the fibonacci number
    // }

    //Tabulation Dynamic Programming

    static int fib(int num) {
        int[] dp = new int[num + 1];

        //base condition as we know this value
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        //formula derived from recursion is used here where array previous values is used instead of function calling
        }

        return dp[num];
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}