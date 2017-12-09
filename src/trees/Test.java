package trees;

public class Test {
	public static void main (String[] args) {
		Node tete = new Node(23);
		Node a = new Node(5);
		Node b = new Node(30);
		Node c = new Node(3);
		Node d = new Node(20);
		Node e = new Node(15);
		System.out.println("DEBUT");
		ARN arn = new ARN(tete);
		arn.ABR_Insert(a);
		arn.ABR_Insert(b);
		arn.ABR_Insert(c);
		arn.ABR_Insert(d);
		System.out.println(arn.getRacine());
		arn.RD(tete);
		System.out.println(arn.getRacine());
		
		
	}
}
