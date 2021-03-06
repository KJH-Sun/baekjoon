import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower {
	int num;
	int height;

	Tower(int num, int height) {
		this.height = height;
		this.num = num;
	}

}

public class BOJ_2493_탑 {
	static Stack<Tower> stack = new Stack<>();
	static Stack<Tower> stack2 = new Stack<>();
	static StringBuffer sb = new StringBuffer();
	static int[] res;
	static int N;

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	private static void laser() {
		for (int i = N - 1; i >= 0; i--) {
			stack2.push(stack.pop());
			if (stack.isEmpty()) {
				return;
			}
			while (stack.peek().height > stack2.peek().height) {
				res[stack2.pop().num] = i;
				if (stack2.isEmpty()) {
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		res = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stack.push(new Tower(i, stoi(st.nextToken())));
		}

		laser();
		for (int i : res) {
			sb.append(i + " ");
		}
		System.out.println(sb);

	}

}
