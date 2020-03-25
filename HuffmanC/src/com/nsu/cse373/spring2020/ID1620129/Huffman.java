package com.nsu.cse373.spring2020.ID1620129;
import java.util.PriorityQueue;

class Huffman {





	public static void priorityQueue(int[] frequencies,char[] charecter) {
		
		private Node root;
		
		PriorityQueue<Node> nodes = new PriorityQueue<Node>();
		for (int i=0;i<frequencies.length;i++) {	
			Node newNode = new Node();
//			newNode.character = frequencies[i];
//			newNode.frequency = frequencies.get(ch);
			nodes.add(newNode);
		}
		System.out.println("PriorityQueue: " + nodes.toString());
		while (nodes.size() > 1) {//reduce queue to node set last node to root
			Node smallest = nodes.remove();//remove the head of this queue
			Node nextSmallest = nodes.remove();
			Node newNode = new Node();
			newNode.frequency = smallest.frequency + nextSmallest.frequency;
			newNode.left = smallest;
			newNode.right = nextSmallest;
			System.out.println("    PriorityQueue" + nodes.toString());
			nodes.add(newNode);
			System.out.println("  PriorityQueue" + nodes.toString());
		}
		System.out.println("PriorityQueue = root =" + nodes.toString());
		root = nodes.remove();
	}



	
	
	public static void charOccurances(String s,char a[],int ocr[]) {
		
		String text=s;
		int index= 0;
		for(int i=0;i<s.length();i++)
		{
			int count=0;
			char ch=s.charAt(i);
			for(int k=0;k<index;k++){
				if(a[k]!=ch)
					count++;
			}
			if(count==index) //If present
			{
				
				a[index]=ch;
				ocr[index]=1;
				index++;
			}
			else          //If not present
			{
				int j;
				for( j=0;j<index;j++)
				{
					if(a[j]==ch)
						break;
				}
				ocr[j]++;
				
			}
			
		}

	}
	
	
	
	
	
	
	
}
