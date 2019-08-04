package trees;

public class Test {
	public static void main (String[] args) {
		Node tete = new Node(11);
		System.out.println("DEBUT");
		ARN arn = new ARN(tete);
		arn.Insert(new Node(14));
		arn.Insert(new Node(2));
		arn.Insert(new Node(15));
		arn.Insert(new Node(7));
		arn.Insert(new Node(1));
		arn.Insert(new Node(8));
		arn.Insert(new Node(5));
		arn.Insert(new Node(4));
		System.out.println(arn.getRacine());
		System.out.println(arn.sort_C());
		System.out.println(arn.sort_D());
		
	}
}
