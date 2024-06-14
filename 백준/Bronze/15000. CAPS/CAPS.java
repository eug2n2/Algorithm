import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String input = bf.readLine(); // 소문자를 입력 받음
        String output = input.toUpperCase(); // 입력받은 소문자를 대문자로 변환
        System.out.println(output);
    }
}
