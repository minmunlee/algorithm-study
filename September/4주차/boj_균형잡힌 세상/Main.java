import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        while(!str.equals(".")) {
            Stack<String> stack = new Stack<>();
            boolean isGood = true;

            for(String s : str.split("")) {
                if(s.equals(".")) break;

                if(s.equals("(") || s.equals("[")) {
                    stack.add(s);
                }
                else if(s.equals(")")) {
                    if(stack.isEmpty() || !stack.pop().equals("(")) { // 매칭
                        isGood = false;
                        break;
                    }
                }
                else if(s.equals("]")) {
                    if(stack.isEmpty() || !stack.pop().equals("[")) { // 매칭
                        isGood = false;
                        break;
                    }
                }
            }

            sb.append(stack.isEmpty() && isGood ? "yes" : "no").append("\n");

            str = br.readLine();
        }

        System.out.print(sb);
    }
}