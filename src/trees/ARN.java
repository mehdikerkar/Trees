package trees;

import java.util.ArrayList;

public class ARN extends ABR{

	
	public ARN(Node r) {
		super(r);
		this.getRacine().setColor(Color.black);
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

	@Override
	public void Insert(Node x) {
		// TODO Auto-generated method stub
		super.Insert(x);
		x.setColor(Color.red);
		while (x!=this.getRacine() && x.getParent().getColor() == Color.red) {
			if(x.getParent() == x.getParent().getParent().getLeftC()) {
				Node y = x.getParent().getParent().getRightC();
				if(y.getColor() == Color.red) {
					x.getParent().setColor(Color.black);
					y.setColor(Color.black);
					x.getParent().getParent().setColor(Color.red);
					x = x.getParent().getParent();
				}else { if (x == x.getParent().getRightC()) {
					x = x.getParent();
					this.RG(x);
				}
				x.getParent().setColor(Color.black);
				x.getParent().getParent().setColor(Color.red);
				this.RD(x.getParent().getParent());
				}
			}else {
				Node y = x.getParent().getParent().getLeftC();
				if(y.getColor() == Color.red) {
					x.getParent().setColor(Color.black);
					y.setColor(Color.black);
					x.getParent().getParent().setColor(Color.red);
					x = x.getParent().getParent();
				}else { if (x == x.getParent().getLeftC()) {
					x = x.getParent();
					this.RD(x);
				}
				x.getParent().setColor(Color.black);
				x.getParent().getParent().setColor(Color.red);
				this.RG(x.getParent().getParent());
				}
			}
		}
		this.getRacine().setColor(Color.black);
	}
	
	public ARN toABR(ArrayList<Integer> l) {
		if(l.isEmpty()) {
			return null;
		}else {
			ARN A = new ARN(new Node(l.get(0)));
			for(int i = 1; i<l.size() ; i++)
				A.Insert(new Node(l.get(i)));
			return A;
		}
			
	}
}

