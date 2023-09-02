import java.util.*;

public class ExecutionTest{
	public static void main(String[] args) {
		String[] files = {"Merkle Tree Authentication Project", "CS 310 Project 3", "CS 310", "Data Structures Project 3"};
		String root = null;

		MerkleTree merkleTree = new MerkleTree();

		// Building the MerkleTree
		System.out.println("Testing the constructMerkleTree method");
		root = merkleTree.constructMerkleTree(files);

		System.out.println("The root value after constructing the MerkleTree is " + root);
		System.out.println("The root value expected after constructing the MerkleTree is F118EFF0E779DE1594122DE1D9A1B68F24F8C93D793EC5068EE74E5F84CCE942A72839BDF61054D91F7665DF9F22F0115088C5DB17121ECD801A91B032372378");
		
		System.out.println();

		//DAMAGE TREE
		// merkleTree.damageTree();

		System.out.println("verrify integrity shoud return true:" + merkleTree.verifyIntegrity(
			"F118EFF0E779DE1594122DE1D9A1B68F24F8C93D793EC5068EE74E5F84CCE942A72839BDF61054D91F7665DF9F22F0115088C5DB17121ECD801A91B032372378",
			 3,
			 "Data Structures Project 3" ));


		System.out.println("convert to ArrList:");
		for(String x: merkleTree.convertToDynamic()){
			System.out.println(x);
		}
      
        System.out.println();
		System.out.println("Swap files:");
		System.out.println(merkleTree.swapFile(0, 2));
		System.out.println("re Swap");
		System.out.println(merkleTree.swapFile(0, 2));
        System.out.println("Swap files agian:");
		System.out.println(merkleTree.swapFile(0, 2));
        System.out.println("re Swap agian");
		System.out.println(merkleTree.swapFile(0, 2));


		System.out.println("verrify integrity shoud return true:" + merkleTree.verifyIntegrityDynamic(
			"F118EFF0E779DE1594122DE1D9A1B68F24F8C93D793EC5068EE74E5F84CCE942A72839BDF61054D91F7665DF9F22F0115088C5DB17121ECD801A91B032372378",
			 0,
			 "Merkle Tree Authentication Project", merkleTree.convertToDynamic()));


	}
}
