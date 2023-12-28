import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 10825. 국영수
 *
 * 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
 * 1. 국어 점수가 감소하는 순서로
 * 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
 * 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 *
 * 입력 예
 * 12
 * Junkyu 50 60 100
 * Sangkeun 80 60 50
 * Sunyoung 80 70 100
 * Soong 50 60 90
 * Haebin 50 60 100
 * Kangsoo 60 80 100
 * Donghyuk 80 60 100
 * Sei 70 70 70
 * Wonseob 70 70 90
 * Sanghyun 70 70 80
 * nsj 80 80 80
 * Taewhan 50 60 90
 */

public class Main {

    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Student> infos = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        String name;
        int korean, english, math;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            name = st.nextToken(); //이름
            korean = Integer.parseInt(st.nextToken()); //국어
            english = Integer.parseInt(st.nextToken()); //영어
            math = Integer.parseInt(st.nextToken()); //수학

            infos.add(new Student(name, korean, english, math));
        }

        sorting(infos);
    }

    public static void sorting(List<Student> infos) {
        Comparator<Student> comparator = Comparator
                .comparing((Student std) -> std.korean, Comparator.reverseOrder()) //국어 기준 내림차순 정렬
                .thenComparing(std -> std.english) //영어 기준 오름차순 정렬
                .thenComparing(std -> std.math, Comparator.reverseOrder()) //수학 기준 내림차순 정렬
                .thenComparing(std -> std.name); //이름 기준 오름차순 정렬

        Collections.sort(infos, comparator);

        for (Student std : infos)
            System.out.println(std.name);
    }
}