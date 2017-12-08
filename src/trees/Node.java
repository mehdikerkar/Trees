package trees;

public class Node {
	
	private int val;
	private Object data;   
	private Node leftC;
	private Node rightC;
	private Node parent;
	
	 Node(int val) {
		   this.val=val;
		   this.leftC=null;
		   this.rightC=null;
		   this.parent=null;
		};
		
	static void ABR_Insert(Node A, Node n) {
		Node x = A;
		Node y = null;//y parent of x
	
			while(x!=null) {
				y=x;
				if(n.val<x.val) 
					x.leftC=n;
				else 
					x.rightC=n;
			}	
			n.parent=y; 
			if (y==null) 
				A=n;
			else {
				if (n.val<y.val)
					 y.leftC=n;
				 else
					 y.rightC=n;
			}
				 

		
	}
	
	
	static Node ABR_Min(Node A) {
		if(A==null || A.leftC==null)
			return A;
		else
			return ABR_Min(A.leftC);
	}
	
	static Node ABR_Max(Node A) {
		if(A==null || A.rightC==null)
			return A;
		else
			return ABR_Max(A.rightC);
	}

	static Node ABR_Recherche(Node A, int val){
		if(A==null || A.val==val)
			return A;
		else {
			if (A.val<val)
				return ABR_Recherche(A.leftC, val);
			else 
				return ABR_Recherche(A.rightC, val);
		}
		
	}

	static Node ABR_Successeur(Node A) {
		Node y;
		if(A.rightC!=null)
			return ABR_Min(A.rightC);
		y=A.parent;
		while(y!=null && A==y.rightC) {
			A=y;
			y=A.parent;
		}
		return y;
	}

	static void ABR_Print(Node A) {
		if (A!=null) {
			System.out.println("("+A.val+")");
			ABR_Print(A.rightC);
			ABR_Print(A.leftC);
		}
		else {System.out.println("( )");}
	}
	
	public static void main (String[] args) {
		Node tete = new Node(23);
		Node a = new Node(5);
		Node b = new Node(30);
		Node c = new Node(24);
		Node d = new Node(20);
		Node e = new Node(15);
		System.out.println("DEBUT");
		
		ABR_Insert(tete, a);
		ABR_Insert(tete, b);
		ABR_Insert(tete, c);
		ABR_Insert(tete, d);
		ABR_Insert(tete, e);
		System.out.println("FIN Insertion");
		ABR_Print(tete);
		System.out.println("FIN");
		
		
	}

	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
