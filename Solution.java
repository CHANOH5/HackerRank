package Hackker;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

//구하려고 하는 값은  배열 a 의 원소 값을 약수로 가지면서 ( 최소 공배수 )
//x = A {  1 2 3 } ex 6 의 배수  => 6 12
//
//그 값은   배열 b 의 모든 원소의 약수이다. ( 최대 공약수의 약수 )  
//y = B { 12 24 48 } ex 12의 약수   =>  1 2 3 4 6 12  
//
//   x && y = 6 , 12    => 2   
//
//배열 a 의 원소값들의 최소 공배수의 배수들을 구함
//배열 b 의 원소값들의 최대 공약수의 약수들을 구함
//
//최소 공배수의 배수와 최대 공약수의 약수들의 공통 값을 얻어냄
//x를 배열 a 의 원소값으로 나눈 나머지들이 0 이다.
//배열 b의 원소값을 y로 나눈 나머지들이 0 이다.
//이를 충족하는 x = {6 12 18 24 }   y = { 1 2 3 4 6 12 }
//
//*


	






//=============================================




//맵객체 생성, 입력받기, 최소공배수 구하기, 공통 약수들 구하기 - 둘이 비교해서 동일 값만 뽑아서 출력하기

//최대 공약수 = 두 자연수의 최대의 약수
//최소 공배수 = 두 자연수의 최소의 배수 
//
//두 수를 곱한 것에서 최대 공약수를 나누면 => 최소 공배수
//
//최대 공약수는 
//두 수를 나눈 나머지를 나눈 나머지를 나눈 나머지와 같은 형식으로 나누는 값이 0이 되기 이전까지 계산하여 그 때의 몫을 최대 공약수로 정한다. 
//
//약수는 나누어서 0이되는 수
//
//두수를 나누어서 나온 나머지를 이전 나머지에 다시 나눕니다. 그렇게 0 이 나올 때 까지 반복한후 중지 합니다.

//최소공배수 구하기, 공통 약수들 구하기 - 둘이 비교해서 동일 값만 뽑아서 출력하기


// 첫 번째 array들의 최소 공배수를 구함.

//static int lcm(int a, int b){ // 최소 공배수
//	// 0이 아닌 두 수의 곱 / 두 수의 최대공약수
//    return a * b / gcd(a,b);
//}
//
// 두 번째 array들의 최대 공약수를 구함
//유클리드 (a를 b로 나눈 나머지가 0보다 클 때 까지 반복)
static int gcd(int a, int b){ // 최대공약수
	while(b > 0){
		int r = a%b;
		a = b;
		b = r;
	}
	return a;
}
//
// 최소 공배수의 배수 ( 최소 공배수 * 1, 최소 공배수 * 2...)를 해서 최대 공약수를 나누었을 때 나머지가 0인 인수들을 체크

class Result {
	
	public static int gcd(int a, int b) {  // 최대공약수
	
		int r = 0;					// 첫번째 나눈 나머지 값
		int r1 = 0;					// 두번째 나눈 나머지 값
		int gcd;
		
		if( r == a % b) {			// 
			r1 = r % b;
			gcd = r % r1;			// 첫번째 나눈 나머지값과 두번째 나눈값이 떨어지면 최대공약수
		}
		
		return gcd;
		
	}
	
	public static int lcm(int a, int b){ // 최소 공배수

    return a * b / gcd(a,b);   // 0이 아닌 두 수의 곱 / 두 수의 최대공약수
    
	}
	
    public static int getTotalX(List<Integer> a, List<Integer> b) {
 
    	Integer gcd = a[0];
    	Integer lcm = b[0];
    	int sum; // 최소 공배수의 배수를 저장할 변수!
    
    
    	for(int i = 0; i < lcm; i++) {
    		
    		sum += lcm * i;
    		
    	} 
    	
    	
    	
    }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
