package binaryTree;

/*
 * Refer: https://youtu.be/Toe0UQMWhjM?si=WNgc3gij5U5Xu-qR
 */
public class DiameterOfBinaryTree {
	
	//Approach 1
	static int diameter1(Node root) {
		if(root == null)
			return 0;
		int ld = diameter1(root.left);
		int rd = diameter1(root.right);
		int cur = TreeOperations.height(root.left) + TreeOperations.height(root.right) + 1;
		return Math.max(cur, Math.max(ld, rd));
	}
	
	//Approach 2
	static int diameter = 0;
	static int diameter2(Node root) {
		if(root == null) return 0;
		int ld = diameter2(root.left);
		int rd = diameter2(root.right);
		diameter = Math.max(diameter, ld+rd+1);
		return 1 + Math.max(ld, rd);
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		System.out.println("Diameter 1: "+ diameter1(root));
		diameter2(root);
		System.out.println("Diameter 1: "+ diameter);
	}
}
