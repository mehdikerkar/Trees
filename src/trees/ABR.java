package trees;

public class ABR {
	private Node racine;
	
	
	public ABR(Node r) {
		racine = r;
	}
	
	public void Insert(Node n) {
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
	
	
	public static Node Min(Node A) {
		if(A==null || A.getLeftC()==null)
			return A;
		else
			return Min(A.getLeftC());
	}
	
	public static Node Max(Node A) {
		if(A==null || A.getRightC()==null)
			return A;
		else
			return Max(A.getRightC());
	}

	public static Node Recherche(Node A, int val){
		if(A==null || A.getVal()==val)
			return A;
		else {
			if (A.getVal()<val)
				return Recherche(A.getRightC(), val);
			else 
				return Recherche(A.getLeftC(), val);
		}
		
	}

	public static Node Successeur(Node A) {
		Node y;
		if(A.getRightC()!=null)
			return Min(A.getRightC());
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
