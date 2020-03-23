package com.nsu.cse373.spring2020.ID1620129;

class Huffman {





	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
