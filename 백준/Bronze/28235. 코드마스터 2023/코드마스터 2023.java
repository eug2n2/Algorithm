import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine(); // 버퍼드리더를 사용하여 한 줄을 읽습니다.

        if (s.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
        } else if (s.equals("CODE")) {
            System.out.println("MASTER");
        } else if (s.equals("2023")) {
            System.out.println("0611");
        } else if (s.equals("ALGORITHM")) {
            System.out.println("CONTEST");
        }
    }
}
