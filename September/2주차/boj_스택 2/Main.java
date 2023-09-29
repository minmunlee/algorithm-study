import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine()); // 명령 개수 입력
            Stack<Integer> stack = new Stack<>(); // 쌓일 스택
            StringTokenizer str;
            StringBuilder sb = new StringBuilder(); // 결과값 저장할 곳
            
            
            for (int i = 0; i < n; i++) {
                str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());

                switch(a){
                    case 1:
                        if(str.hasMoreTokens()){
                            stack.push(Integer.parseInt(str.nextToken()));
                        }
                        break;
                    case 2:
                        if(stack.isEmpty()){
                            sb.append(-1).append("\n");
                        }else{
                            sb.append(stack.pop()).append("\n");
                        }
                        break;
                    case 3:
                        sb.append(stack.size()).append("\n");
                        break;
                    case 4:
                        if(stack.isEmpty()){
                            sb.append(1).append("\n");
                        }else{
                            sb.append(0).append("\n");
                        }
                        break;
                    case 5:
                        if(stack.isEmpty()){
                            sb.append(-1).append("\n");
                        }else{
                            sb.append(stack.peek()).append("\n");
                        }
                        break;
                        
                }
            }
            System.out.println(sb);
    }

        
        }
    
