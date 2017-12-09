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
		
	public Node getLeftC() {
		return leftC;
	}

	public void setLeftC(Node leftC) {
		this.leftC = leftC;
	}

	public Node getRightC() {
		return rightC;
	}

	public void setRightC(Node rightC) {
		this.rightC = rightC;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
	    if(rightC!=null) {
	        rightC.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
	    }
	    sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val).append("\n");
	    if(leftC!=null) {
	        leftC.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
	    }
	    return sb;
	}

	@Override
	public String toString() {
	    return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data){
		this.data = data;
	}

	public int getVal() {
		return val;
	}
	
}
