package p11279maxheap;

import java.io.*;

public class Main2 {
	private static int N;
	private static MaxHeap maxHeap;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/p11279maxheap/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		maxHeap = new MaxHeap(N);
		
		for (int i = 0; i < N; i++) {
			int query = Integer.parseInt(br.readLine());
			
			if (query == 0) {
				bw.write(String.valueOf(maxHeap.poll()));
				bw.newLine();
				continue;
			}
			
			maxHeap.add(query);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class MaxHeap {
	private int[] tree;
	private int size;
	
	public MaxHeap(int capacity) {
		this.tree = new int[capacity + 1];
	}
	
	public void add(int element) {
		int index = ++size;
		tree[index] = element;
		
		while (index / 2 > 0 && tree[index] > tree[index / 2]) {
			int temp = tree[index];
			tree[index] = tree[index / 2];
			tree[index / 2] = temp;
			index /= 2;
		}
	}
	
	public int poll() {
		if (size == 0) {
			return 0;
		}
		
		int index = 1;
		int ret = tree[index];
		tree[index] = tree[size--];
		
		while (2 * index <= size) {
			if (2 * index == size && tree[2 * index] > tree[index]) {
				int temp = tree[index];
				tree[index] = tree[2 * index];
				tree[2 * index] = temp;
				break;
			}
			
			if (2 * index < size && tree[2 * index] > tree[index] && tree[2 * index] >= tree[2 * index + 1]) {
				int temp = tree[index];
				tree[index] = tree[2 * index];
				tree[2 * index] = temp;
				index *= 2;
				continue;
			}
			
			if (2 * index < size && tree[2 * index + 1] > tree[index] && tree[2 * index + 1] > tree[2 * index]) {
				int temp = tree[index];
				tree[index] = tree[2 * index + 1];
				tree[2 * index + 1] = temp;
				index = 2 * index + 1;
				continue;
			}
			
			break;
		}
		
		return ret;
	}
}
