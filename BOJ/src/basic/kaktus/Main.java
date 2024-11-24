package basic.kaktus;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/basic/kaktus/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(br.readLine());
		bw.flush();
		bw.close();
		br.close();
	}
}
