//TODO: Complete java docs and code in missing spots.

import java.util.*;

/**
 * This is the class representing the complete MerkleTree.
 * 
 * @author Sheraj KC
 */
public class MerkleTree {
	/**
	 * represents the root MerkelTreeNode.
	 */
	public static MerkleTreeNode root;
	/**
	 * represents the number of files or leaf nodes in the tree.
	 */
	public static int numberOfFiles;
	/**
	 * reprsents the leaves in the tree.
	 */
	public static ArrayList<MerkleTreeNode> leaves;

	/**
	 * This method creates a MerkelTree. It first creates a empty tree then assigns
	 * values.
	 * 
	 * @param files the files to be stored in the leaf nodes of the MerkelTree. It
	 *              will always be a power of 2.
	 * @return the string hash of the root node of the MerkelTree.
	 */
	public String constructMerkleTree(String[] files) {
		// throw IllegalArgumentException for invalid parameters
		if (files.length <= 0 || files == null)
			throw new IllegalArgumentException();

		// Task 2: You are required to develop the code for the constructMerkleTree
		// method.
		// Running time complexity of this method: O(n) where n is the number of files
		// (size of the files array)
		// You can assume that the size of the files will be given as 2^n
		// throw IllegalArgumentException for invalid parameters
		// It returns the value of the root node of the Merkle Tree str (0,0)

		// Set number of files = # roots
		numberOfFiles = files.length;

		// Instanciate leaves ArrayList
		leaves = new ArrayList<MerkleTreeNode>();

		// construct tree;
		int totalNodes = (numberOfFiles * 2) - 1;
		root = createCompleteBinaryTree(totalNodes);// O(n)

		// set values in tree
		setValues(root, files, 0);// post order: L,R,Root// O(n)

		return root.getStr();
	}

	/**
	 * Helper method creates a empty complete binary tree given the total number of
	 * nodes.
	 * 
	 * @param n represents the total number of nodes.
	 * @return the root MerkelTreeNode
	 */
	private MerkleTreeNode createCompleteBinaryTree(int n) {// n = total # nodes
		if (n == 0) {// no node to create
			return null;
		}
		MerkleTreeNode root = new MerkleTreeNode();// create new node

		MerkleTreeNode sl = createCompleteBinaryTree(n / 2);// create left subtree recursivly
		if (sl != null) {// If the left subtree is not null, set it as the left child of the root node.
			root.setLeft(sl);
		}
		// n - (n / 2) - 1: totalNodes - nodes in leftSubtree - 1 for root node = #
		// nodes in right sub tree
		MerkleTreeNode sr = createCompleteBinaryTree(n - (n / 2) - 1);// create right subtree recursivly
		if (sr != null) {// If the right subtree is not null, set it as the right child of the root node.
			root.setRight(sr);
		}
		// Set the parent node of the left and right subtrees to be the root node.
		if (root.getLeft() != null) {
			root.getLeft().setParent(root);
		}
		if (root.getRight() != null) {
			root.getRight().setParent(root);
		}
		return root;
	}

	/**
	 * Helper method sets the file and hashValues of the MerkelTree.
	 * 
	 * @param node  the root node of the MerkelTree.
	 * @param files the files to be stored in the leaf nodes of the MerkelTree.
	 * @param index the index to be accessed from files to set the value when
	 *              traverseing using recursion.
	 * @return the index to use durring the next recursion.
	 */
	private int setValues(MerkleTreeNode node, String[] files, int index) {// L,R,Root
		if (node.getLeft() == null && node.getRight() == null) {// is leaf node
			node.setStr(files[index]);
			leaves.add(node);// Add leaves to leaves ArrayList<>
			index++;
			return index;
		}
		index = setValues(node.getLeft(), files, index);// L
		index = setValues(node.getRight(), files, index);// R
		node.setStr(Hashing.cryptHash(node.getLeft().getStr() + node.getRight().getStr()));// Root(node that is not
																							// leaf)

		return index;
	}

	/**
	 * Verifies the integrity of a given file in the MerkelTree by checking its
	 * ancestor nodes.
	 * 
	 * @param rootValue the hashValue the root of the tree should be.
	 * @param fileIndex the index of the file you want to verrify. Index based on
	 *                  the leaf arrayList
	 * @param file      the string value of the file you want to verrify.
	 * @return true if integrity is perserved.
	 */
	public static boolean verifyIntegrity(String rootValue, int fileIndex, String file) {// you have access to parrents
																							// and leaves arraylist
		// Task 3: You are required to develop the code for the verifyIntegrity method
		// Running time complexity of this method: O(n)
			// throw IllegalArgumentException for invalid parameters
			if (rootValue == null || fileIndex < 0 || fileIndex > leaves.size() - 1 || file == null) {
				throw new IllegalArgumentException();
			}

			// Check that the value of the Root of the Merkle Tree stored previously equals
			// to the value of the received root
			if (!root.getStr().equals(rootValue)) {
				return false;
			}

			MerkleTreeNode traverser = leaves.get(fileIndex);

			leaves.get(2).setStr("damage");
			// check ancestor path up from leaf to root
			while (traverser != root) {
				traverser = traverser.getParent();
				String checkHash = Hashing.cryptHash(traverser.getLeft().getStr() + traverser.getRight().getStr());
				if (!checkHash.equals(traverser.getStr())) {
					return false;
				}
			}

			// check that file is equal to str at fileIndex
			if (!leaves.get(fileIndex).getStr().equals(file)) {
				return false;
			}

			return true;

	}

	/**
	 * Swaps the str value of two nodes in the MerkelTree. The method rehashes after
	 * the swap.
	 * 
	 * @param fileIndex1 the index of first file you want to swap.
	 * @param fileIndex2 the index of the second file you want to swap.
	 * @return the string hash value of the root node after the swap.
	 */
	public String swapFile(int fileIndex1, int fileIndex2) {
		// Task 4: You are required to develop the code for the swapFile method.
		// Running time complexity of this method: O(n)

		// throw IllegalArgumentException for invalid parameters
		if (fileIndex1 < 0 || fileIndex1 > numberOfFiles - 1 || fileIndex2 < 0 || fileIndex2 > numberOfFiles - 1) {
			throw new IllegalArgumentException();
		}

		MerkleTreeNode fileIndex1Node = leaves.get(fileIndex1);
		MerkleTreeNode fileIndex2Node = leaves.get(fileIndex2);
		// preform string file swap
		String temp = fileIndex1Node.getStr();// store index 1 str
		fileIndex1Node.setStr(fileIndex2Node.getStr());// set node1 str to node2 str
		fileIndex2Node.setStr(temp);// set node2 str to prev node1 srt

		// rehash tree
		while (fileIndex1Node != root) {// rehash fileIndex1Node ancestor path
			fileIndex1Node = fileIndex1Node.getParent();
			String newHash = Hashing.cryptHash(fileIndex1Node.getLeft().getStr() + fileIndex1Node.getRight().getStr());
			fileIndex1Node.setStr(newHash);
		}
		while (fileIndex2Node != root) {// rehash fileIndex2Node ancestor path
			fileIndex2Node = fileIndex2Node.getParent();
			String newHash = Hashing.cryptHash(fileIndex2Node.getLeft().getStr() + fileIndex2Node.getRight().getStr());
			fileIndex2Node.setStr(newHash);
		}

		return root.getStr();
	}

	/**
	 * Turns the MerkelTree into a dynamic array.
	 * 
	 * @return an ArrayList of the hashes and file values of the MerkelTree
	 *         represented as a dynamic array
	 */
	public static ArrayList<String> convertToDynamic() {
		// Task 5: You are required to develop the code for the convertToDynamic method.
		// Running time complexity of this method: O(n)

		// breath first traversal
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<MerkleTreeNode> queue = new ArrayList<MerkleTreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			MerkleTreeNode pop = queue.remove(0);
			result.add(pop.getStr());
			if (pop.getLeft() != null && pop.getRight() != null) {
				queue.add(pop.getLeft());
				queue.add(pop.getRight());
			}
		}

		return result;
	}

	/**
	 * Verifies the integrity of a given file in the MerkelTree by checking its
	 * ancestor nodes.
	 * Uses parrent child relationship of a complete binary tree represented as an
	 * array.
	 * 
	 * @param rootValue     the hashValue the root of the tree should be.
	 * @param fileIndex     the index of the file you want to verrify. Index based
	 *                      on the leaf arrayList
	 * @param file          the string value of the file you want to verrify.
	 * @param dynamicMerkle the string values of the MerkelTree represented as an
	 *                      array List.
	 * @return true if integrity is perserved.
	 */
	public static boolean verifyIntegrityDynamic(String rootValue, int fileIndex, String file,
			ArrayList<String> dynamicMerkle) {
		// Task 6: You are required to develop the code for the verifyIntegrityDynamic
		// method.
		// Running time complexity of this method: O(n)

		if (rootValue == null || fileIndex < 0 || fileIndex > numberOfFiles - 1 || file == null
				|| dynamicMerkle == null) {
			throw new IllegalArgumentException();
		}

		// return false if root does not match.
		if (!root.getStr().equals(rootValue)) {
			return false;
		}

		// check ancestor path up from leaf to root
		int fileIndexInLargeArray = (dynamicMerkle.size() - numberOfFiles) + fileIndex;
		int traverseFileIndex = fileIndexInLargeArray;
		while (traverseFileIndex > 0) {// check from leaf to root
			traverseFileIndex = (traverseFileIndex - 1) / 2;// move to parrent
			String leftStr = dynamicMerkle.get((2 * traverseFileIndex) + 1);// get leftChild str
			String rightStr = dynamicMerkle.get((2 * traverseFileIndex) + 2);// get rightChild str
			String calculateHash = Hashing.cryptHash(leftStr + rightStr);// calculate hash
			if (!dynamicMerkle.get(traverseFileIndex).equals(calculateHash)) {// check hash
				return false;
			}
		}

		// check that file is equal to str at fileIndex
		if (!leaves.get(fileIndex).getStr().equals(file)) {
			return false;
		}

		return true;
	}

}
