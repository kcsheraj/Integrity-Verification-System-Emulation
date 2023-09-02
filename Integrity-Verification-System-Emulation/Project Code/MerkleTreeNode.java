//TODO: Complete java docs and code in missing spots.
/**
 * This class is used to represent nodes in the Merkle Tree.
 * Task 1: You are required to develop the constructor and the set and get methods of all the instance variables of this class.
 * @author Sheraj KC
 */
public class MerkleTreeNode{
	   /**
	 * The parrent of this MerkelTreeNode.
	 */
    private MerkleTreeNode parent;
	   /**
	 * The left child of this MerkelTreeNode.
	 */
    private MerkleTreeNode left;
	   /**
	 * The right child of this MerkelTreeNode.
	*/
    private MerkleTreeNode right;
	   /**
	 * The hash value (if not leaf) or file string if leaf node.
	 */
    private String str;

	/**
	 * A default MerkleTreeNode constructor that initializes the instance variables to null.
	 */
	public MerkleTreeNode(){
		parent = null;
		left = null;
		right = null;
		str = null;
	}
	
	/**
	 * A MerkleTreeNode Constructor that initiates the object with the parent, left, and right MerkleTreeNode objects.
	 * @param parent the parrent of the created MerkelTreeNode.
	 * @param left the left child of the created MerkelTreeNode.
	 * @param right the right child of the created MerkelTreeNode.
	 * @param str the String value of the created MerkelTreeNode.
	 */
	public MerkleTreeNode(MerkleTreeNode parent,MerkleTreeNode left,MerkleTreeNode right,String str){
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.str = str;
	}

	/**
	 * Returns the Parrent of this node.
	 * @return Parrent of this node.
	 */
	public MerkleTreeNode getParent(){
		return this.parent;
	}
	/**
	 * Returns the left child of this node.
	 * @return left child of this node.
	 */
	public MerkleTreeNode getLeft(){
		return this.left;
	}
	/**
	 * Returns the right child of this node.
	 * @return right child of this node.
	 */
	public MerkleTreeNode getRight(){
		return this.right;
	}
	/**
	 * Returns the string value of this node.
	 * @return	the string value of the node.
	 */
	public String getStr(){
		return this.str;
	}
	/**
	 * Sets the parrent of this node.
	 * Throws IllegalArgument Exception of null and invalid parameters.
	 * @param parent the MerkelTreeNode to be set as parrent.
	 */
	public void setParent(MerkleTreeNode parent){
		//throw IllegalArgumentException for invalid parameters
		if(parent == null) throw new IllegalArgumentException();

		this.parent = parent;
	}
	/**
	 * Sets the left child of this node.
	 * Throws IllegalArgument Exception of null and invalid parameters.
	 * @param left the MerkelTreeNode to be set as the left child.
	 */
	public void setLeft(MerkleTreeNode left){
		//throw IllegalArgumentException for invalid parameters
		if(left==null) throw new IllegalArgumentException();
		
		this.left = left;
	}
	/**
	 * Sets the right child of this node.
	 * Throws IllegalArgument Exception of null and invalid parameters.
	 * @param right the MerkelTreeNode to be set as the right child.
	 */
	public void setRight(MerkleTreeNode right){
		//throw IllegalArgumentException for invalid parameters
		if(right==null) throw new IllegalArgumentException();
		
		this.right = right;
	}
	/**
	 * Sets the string value for the current MerkelTreeNode.
	 * @param str the String to be set for the MerkelTreeNode.
	 */
	public void setStr(String str){
		//throw IllegalArgumentException for invalid parameters
		if(str==null) throw new IllegalArgumentException();
		
		this.str = str;
	}        
        
}