package com.nsu.cse373.spring2020.ID1620129;

class Node implements Comparable<Node> {
	public char character;
	public int frequency;
	public Node left;
	public Node right;

	public int compareTo(Node other) {
		return frequency - other.frequency;
	}


}