package project1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class minheap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1.equals(o2)) {return 0;}
				return o1 < o2 ? -1 : 1; 
				
			}
		});
		
		int[] array = new int[]{11,2,4,7,4,8};
		for (int i = 0; i < array.length; i++) {
			minHeap.offer(array[i]);
		}
		System.out.println(minHeap.peek());
		minHeap.remove();
		System.out.println(minHeap.poll());
	}

}