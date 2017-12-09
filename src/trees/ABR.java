package trees;

public class ABR {
	private Node racine;
	
	
	public ABR(Node r) {
		racine = r;
	}
	
	public void ABR_Insert(Node n) {
		Node x = racine;
		Node y = null;//y parent of x
	
			while(x!=null) {
				y=x;
				if(n.getVal()<x.getVal()) 
					x=x.getLeftC();
				else 
					x=x.getRightC();
			}
			n.setParent(y);
			if (y==null) 
				racine=n;
			else {
				if (n.getVal()<y.getVal())
					 y.setLeftC(n);
				 else
					 y.setRightC(n);
			}
				 

		
	}
	
	
	public static Node ABR_Min(Node A) {
		if(A==null || A.getLeftC()==null)
			return A;
		else
			return ABR_Min(A.getLeftC());
	}
	
	public static Node ABR_Max(Node A) {
		if(A==null || A.getRightC()==null)
			return A;
		else
			return ABR_Max(A.getRightC());
	}

	public static Node ABR_Recherche(Node A, int val){
		if(A==null || A.getVal()==val)
			return A;
		else {
			if (A.getVal()<val)
				return ABR_Recherche(A.getRightC(), val);
			else 
				return ABR_Recherche(A.getLeftC(), val);
		}
		
	}

	public static Node ABR_Successeur(Node A) {
		Node y;
		if(A.getRightC()!=null)
			return ABR_Min(A.getRightC());
		y=A.getParent();
		while(y!=null && A==y.getRightC()) {
			A=y;
			y=A.getParent();
		}
		return y;
	}

	public Node getRacine() {
		return racine;
	}

	public void setRacine(Node racine) {
		this.racine = racine;
	}
	
}
