package trees;


public class ARN extends ABR{

	public ARN(Node r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	public void RG(Node x){
		Node y = x.getRightC();
		x.setRightC(y.getLeftC());
		if (y.getLeftC() != null)
			y.getLeftC().setParent(x);
		y.setParent(x.getParent());
		if (y.getParent() == null)
			this.setRacine(y);
		else {
			if (x==x.getParent().getLeftC())
				x.getParent().setLeftC(y);
			else x.getParent().setRightC(y);
		}
		y.setLeftC(x);
		x.setParent(y);
	}
	
	public void RD(Node x){
		Node y = x.getLeftC();
		x.setLeftC(y.getRightC());
		if (y.getRightC() != null)
			y.getRightC().setParent(x);
		y.setParent(x.getParent());
		if (y.getParent() == null)
			this.setRacine(y);
		else {
			if (x==x.getParent().getRightC())
				x.getParent().setRightC(y);
			else x.getParent().setLeftC(y);
		}
		y.setRightC(x);
		x.setParent(y);
	}
}

