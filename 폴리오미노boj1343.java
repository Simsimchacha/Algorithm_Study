import java.util.*;
public class baekjoon1343 {
	public String solution(String input){
		String answer;
	
		answer = input.replace("XXXX","AAAA");
		answer = answer.replace("XX","BB");

		for(char c : answer.toCharArray()){
			if(c=='X') answer = "-1";
		}
		return answer;
	}
	public static void main(String args[]){
		baekjoon1343 T = new baekjoon1343();
		Scanner kb = new Scanner(System.in);
		String input ;
		input = kb.next();
		if(T.solution(input)=="-1") System.out.println(-1);
		else System.out.println(T.solution(input));
	}
}
