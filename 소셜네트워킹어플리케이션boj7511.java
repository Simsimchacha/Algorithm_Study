import java.io.*;
import java.util.*;
public class baekjoon7511 {
	static int[] unf;
	static StringTokenizer st;
	public static int Find(int v){
		if(unf[v] == v) return v;
		else return unf[v] = Find(unf[v]);
	}
	public static void Union(int a,int b){
		int fa = Find(a);
		int fb = Find(b);
		if(fa!=fb) unf[fa] = fb;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test= Integer.parseInt(br.readLine());

		for(int i=0;i<test;i++){

			StringBuilder sb = new StringBuilder();
			sb.append(String.format("Scenario %d:\n",i+1));
			int n = Integer.parseInt(br.readLine()); //유저의 수(1<=n<=10^6)
			int k = Integer.parseInt(br.readLine()); //친구 관계의 수(1<=k<=10^5)
			unf = new int[n + 1];
			for (int j = 1; j <= n; j++) unf[j] = j; //초기화
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Union(a,b);
			}
			int m = Integer.parseInt(br.readLine());//미리 구할 쌍의 수(1<=m<=10^5)
			for(int j=0;j<m;j++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int fa = Find(a);
				int fb = Find(b);
				if(fa!=fb) sb.append(0).append("\n");
				else sb.append(1).append("\n");
			}
			bw.write(sb+"\n");

		}
		bw.flush();
		bw.close();
	}
}
