package com.nsu.cse373.spring2020.ID1620129;

import java.util.*;
import java.util.Map.Entry;

class Graphs {
	 private Map<String, List<String> > map = new HashMap<>(); 
	 private HashMap<String,Integer> temp = new HashMap<>();
	
	// This function adds a new vertex to the graph 
	    public void addVertex(String s) 
	    { 
	        map.put(s, new LinkedList<String>()); 
	    } 
	  
	    // This function adds the edge 
	    // between source to destination 
	    public void addEdge(String source,String destination) 
	    { 
	  
	        if (!map.containsKey(source)) 
	            addVertex(source); 
	  
	        if (!map.containsKey(destination)) 
	            addVertex(destination); 
	  
	        map.get(source).add(destination); 
	    
	    } 
	    
	
	    
	    public void hasEdge(String s,String d) 
	    { 
	        if (map.get(s).contains(d)) { 
	            System.out.println("The graph has an edge between "
	                               + s + " and " + d + "."); 
	        }
	        else { 
	            System.out.println("The graph has no edge between "
	                               + s + " and " + d + "."); 
	        } 
	    } 
	    
	  
	 public  void BFS(String s) 
	    { 
	        // Mark all the vertices as not visited(By default 
	        // set as false) 

	    	
	        boolean visited[] = new boolean[map.keySet().size()+1]; 
	  
	        // Create a queue for BFS 
	        LinkedList<String> queue = new LinkedList<String>(); 
	  
	        // Mark the current node as visited and enqueue it 
	      //  visited[s]=true; 
	        
	        int v = (int)temp.get(s);
	       
	        visited[v] = true;
	        queue.add(s); 
	  
	        while (queue.size() != 0) 
	        { 
	            // Dequeue a vertex from queue and print it 
	            s = queue.poll(); 
	            System.out.print(s+" "); 
	  
	            // Get all adjacent vertices of the dequeued vertex s 
	            // If a adjacent has not been visited, then mark it 
	            // visited and enqueue it 
	            Iterator i = map.entrySet().iterator(); 
	            while (i.hasNext()) 
	            { 
	                Map.Entry MapElement = (Map.Entry) i.next();
	                String n = (String) MapElement.getKey();
	                int v1 = (int) temp.get(n);
	                if(!visited[v1]) 
	                { 
	                    visited[v1] = true; 
	                    queue.add(n); 
	                } 
	            } 
	        } 
	    
	    
	    }   
	    
	    
	 
	 public  void DFS(String s) 
	    { 
	        // Mark all the vertices as not visited(By default 
	        // set as false) 

	    	
	        boolean visited[] = new boolean[map.keySet().size()+1]; 
	  
	        // Creating a Stack for DFS 
	        Stack<String> stack = new Stack<String>(); 
	  
	      // Mark the current node as visited and enqueue it 
	      //  visited[s]=true; 
	        
	        int v = (int)temp.get(s);
	        System.out.println("DFS "+v);
	        visited[v] = true;
	        stack.push(s); 
	  
	        while (stack.size() != 0) 
	        { 
	            // Dequeue a vertex from queue and print it 
	            s = stack.peek();
	            stack.pop();
	            System.out.print(s+" "); 
	  
	            // Get all adjacent vertices of the dequeued vertex s 
	            // If a adjacent has not been visited, then mark it 
	            // visited and enqueue it 
	            Iterator i = map.entrySet().iterator(); 
	            while (i.hasNext()) 
	            { 
	                Map.Entry MapElement = (Map.Entry) i.next();
	                String n = (String) MapElement.getKey();
	                int v1 = (int) temp.get(n);
	                if(!visited[v1]) 
	                { 
	                    visited[v1] = true; 
	                    stack.push(n);
	                } 
	            } 
	        } 
	    
	    
	    }   
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	    
	        public static <String, Integer> Set<String> getKeysByValue(HashMap<String, Integer> m, int value) {
	            Set<String> keys = new HashSet<String>();
	            for (Entry<String, Integer> entry : m.entrySet()) {
	                if (Objects.equals(value, entry.getValue())) {
	                    keys.add(entry.getKey());
	                }
	            }
	            return keys;
	        }
	    
	    

	        public void setTempHash(HashMap<String,Integer> m) {
	        	temp = m;
	        }
	    
	    
	
	    @Override
	    public String toString() 
	    { 
	        StringBuilder builder = new StringBuilder(); 
	  
	        for (String v : map.keySet()) { 
	            builder.append(v.toString() + ": "); 
	            for (String w : map.get(v)) { 
	                builder.append(w.toString() + " "); 
	            } 
	            builder.append("\n"); 
	        } 
	  
	        return (builder.toString()); 
	    } 
	 
	    
	    
	    
	    public void getVertexCount() 
	    { 
	        System.out.println("The graph has "+ map.keySet().size()+ " vertex"); 
	    } 
	
	
	    
	
	
	
	
	
}
