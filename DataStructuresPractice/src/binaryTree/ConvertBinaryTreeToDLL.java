package binaryTree;

public class ConvertBinaryTreeToDLL {
	
	static Node prev, head;
	
	static void convertToDLL(Node root) {
		if(root == null)
			return;
		convertToDLL(root.left);
		if(prev == null) {
			head = root;
		}
		else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		convertToDLL(root.right);
	}

	public static void main(String[] args) {
		Node root = BinaryTree.createTree();
		convertToDLL(root);
		
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.right;
		}
	}

}
