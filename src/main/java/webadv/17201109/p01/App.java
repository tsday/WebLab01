import java.io.*;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

public class App {
    public static void main(String[] args) throws IOException{

        FileWriter fw = new FileWriter("login.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("17201109");
        bw.write("\n");
        bw.write(sha256hex("123456"));
        bw.close();
        fw.close();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName1 = sc.nextLine();
        System.out.println("请输入密码：");
        String passWord1 = sc.nextLine();

        FileReader fr = new FileReader("login.txt");
        BufferedReader br = new BufferedReader(fr);
        String user = br.readLine();
        String password = br.readLine();

        System.out.println("用户名："+user);
        System.out.println("密码："+password);

        if(userName1.equals(user) && passWord1.equals(passWord1)){
            System.out.println("登录成功！");
        } else{
            System.out.println("登录失败！");
        }
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
