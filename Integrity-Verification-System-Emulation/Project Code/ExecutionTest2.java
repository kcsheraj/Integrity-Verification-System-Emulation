import java.util.*;
/**
 * This is testing methods.
 * @author Chris Hung
 */

public class ExecutionTest2{
	/**
	 * testing methods.
	 * @param args args
	 */
	public static void main(String[] args) {
		System.out.println("RUNING TESTSSSSSSS!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println();
        String[] files = {"Merkle Tree Authentication Project", "CS 310 Project 3", "CS 310", "Data Structures Project 3"};
		String root = null;
		ArrayList<String> list = new ArrayList<>();
		MerkleTree merkleTree = new MerkleTree();
		boolean flag = false;

		// Building the MerkleTree
		System.out.println("Testing the constructMerkleTree method");
		root = merkleTree.constructMerkleTree(files);
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The root value after constructing the MerkleTree is " + root);
		System.out.println("The root value expected after constructing the MerkleTree is F118EFF0E779DE1594122DE1D9A1B68F24F8C93D793EC5068EE74E5F84CCE942A72839BDF61054D91F7665DF9F22F0115088C5DB17121ECD801A91B032372378");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//testing verifyIntegrity
		flag = MerkleTree.verifyIntegrity(root, 2, "CS 310");
		if (flag == true){
			System.out.println("Yay1");
		}else{
			System.out.println("returned false, check your verifyIntegrity");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//testing swap
		root = merkleTree.swapFile(0, 3);
		System.out.println("The root value after swap is " + root);
		System.out.println("The root value expected after swap is 5F54709F1C9BE7DC9D76625123DECFA41FCD38DB348D8FC42DAB931681B794D9B5AC9FEBE29437C05242864ED9450C938AB0CCB546BF359F5D8775ADFE91A538");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		root = merkleTree.swapFile(0, 3);
		//testing convert
		list = MerkleTree.convertToDynamic();
		int index = 0;
        while(index < list.size()){
            String hash = list.get(index);
            System.out.println("The string inside at array index" + " " + index + " " + "is"+ " " + hash);
            index++;
        }
		System.out.println("The expected string inside at array index 0 is F118EFF0E779DE1594122DE1D9A1B68F24F8C93D793EC5068EE74E5F84CCE942A72839BDF61054D91F7665DF9F22F0115088C5DB17121ECD801A91B032372378");
		System.out.println("The expected string inside at array index 1 is A6FF2D3798C0E3341C88121EF513EB2C1AEB11949D8F19946E9C2840316A4CA98D4939D1939E53421BBF23A4B0966E9344D0DC2C95168F7AAA3E88216A1BA94A");
		System.out.println("The expected string inside at array index 2 is 552F524F5B3AD72C7379679448E8B9C25066C7457EBD45C2C8F7F33ACFE75F52ED8813727D613E3311D7888D43E7011B82D36A190E82CB481290470277A055D6");
		System.out.println("The expected string inside at array index 3 is Merkle Tree Authentication Project");
		System.out.println("The expected string inside at array index 4 is CS 310 Project 3");
		System.out.println("The expected string inside at array index 5 is CS 310");
		System.out.println("The expected string inside at array index 6 is Data Structures Project 3");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//testing verifyIntegrityDynamic
		flag = MerkleTree.verifyIntegrityDynamic(root, 2, "CS 310", list);
		if (flag == true){
			System.out.println("Yay2");
		}else{
			System.out.println("returned false, check your verifyIntegrityDynamic");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The number of file for this test is"+ " "+MerkleTree.numberOfFiles);
		System.out.println("The expected number of file is 4");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");









		/* 
		 * TestCase2.
		*/
		String[] testTwoFiles = {"One", "Two", "Three", "Four","Five","Six","Seven","Eight"};
		String root1 = null;
		ArrayList<String> list1 = new ArrayList<>();
		MerkleTree merkleTree1 = new MerkleTree();

		// Building the MerkleTree
		System.out.println("Testing the constructMerkleTree method");
		root1 = merkleTree1.constructMerkleTree(testTwoFiles);
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The root value after constructing the MerkleTree is " + root1);
		System.out.println("The root value expected after constructing the MerkleTree is 40DF532F5443B6C1DB96EB10E65CB77645E25C09943D02B71A85E428128B2D3F6BA8614F52F8057072AB6F9DC3EFF3DCFE8D4558804E25B6398F9AACA4013F69");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//testing verifyIntegrity
		flag = MerkleTree.verifyIntegrity(root1, 2, "Three");
		if (flag == true){
			System.out.println("Yay3");
		}else{
			System.out.println("returned false, check your verifyIntegrity");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//testing swap
		root1 = merkleTree1.swapFile(0, 3);
		System.out.println("The root value after swap is " + root1);
		System.out.println("The root value expected after swap is 029C750366E544DAC057C627EA936CE0B6DE3D1181A1648B4C52A0DF34E7741D85F9FA17D74BA0A6F0214C3024517F0EA7DB979CE6CE9158100B426829886318");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		root1 = merkleTree1.swapFile(0, 3);
		//testing convert
		list1 = MerkleTree.convertToDynamic();
		int index1 = 0;
        while (index1 < list1.size()) {
            String hash1 = list1.get(index1);
            System.out.println("The string inside at array index" + " " + index1 + " " + "is"+ " " + hash1);
            index1++;
        }
		System.out.println("The expected string inside at array index 0 is 40DF532F5443B6C1DB96EB10E65CB77645E25C09943D02B71A85E428128B2D3F6BA8614F52F8057072AB6F9DC3EFF3DCFE8D4558804E25B6398F9AACA4013F69");
		System.out.println("The expected string inside at array index 1 is 51C2511974A403BE0C267AA3620B0A7E1913FDE3B72013EA64994708241700B4131F2B623EEB9C089CE3AA85D3A8BAAAC7E358A1E453D77920D2A750728B25DA");
		System.out.println("The expected string inside at array index 2 is 22FE52E4739109F2350457CF2E213525E1C882697956D68F75212F73DB70FBF4FCCED1F967BBF18FAA3D0CE30506DB0A8B5180E5ADB5A5BF02D29D149AAAFE1F");
		System.out.println("The expected string inside at array index 3 is 43E31413AEAEE20FBA218D1447096FB3B7DAA255024685BD49A32BD0DF867E6B7B772B70A598655E2D7DFAF9EF4ADFD60D6A0E737ED6FD5E00A1B4672D92731B");
		System.out.println("The expected string inside at array index 4 is F7D580F0C9CCD300135472FFC85F6AC5252FEB4E8B8F7A054C44EDF7B1AB5FEA81790149C59E323943A0A348A2CDD45E6B4A8723840B694FBA6279E0C6B1EDD2");
		System.out.println("The expected string inside at array index 5 is 58AD7994D449429624F5BA12E5B46E0B6741D9310E4F4BA902B029BDA43AE3133EA2847B9FAE862921114ABED7ABB3B19E3CC5CA4B8F060849FF8F8145A50427");
		System.out.println("The expected string inside at array index 6 is C2F9F1769D86F90DFFD3BE1C3C60235DF04945D8AFFA889C452E4C9A87B1AF91F26602C6E213A0A688D4DE114D279369B2B27012F9654C484ED9D409C06F65D8");
		System.out.println("The expected string inside at array index 7 is One");
		System.out.println("The expected string inside at array index 8 is Two");
		System.out.println("The expected string inside at array index 9 is Three");
		System.out.println("The expected string inside at array index 10 is Four");
		System.out.println("The expected string inside at array index 11 is Five");
		System.out.println("The expected string inside at array index 12 is Six");
		System.out.println("The expected string inside at array index 13 is Seven");
		System.out.println("The expected string inside at array index 14 is Eight");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//testing verifyIntegrityDynamic
        //merkleTree.damageTree();
		flag = MerkleTree.verifyIntegrityDynamic(root1, 2, "Three", list1);
		if (flag == true){
			System.out.println("Yay4");
		}else{
			System.out.println("returned false, check your verifyIntegrityDynamic");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The number of file for this test is"+ " "+MerkleTree.numberOfFiles);
		System.out.println("The expected number of file is 8");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	
    
        String[] testThreeFiles = {"One"};
		String root3 = null;
		ArrayList<String> list3 = new ArrayList<>();
		MerkleTree merkleTree3 = new MerkleTree();

		// Building the MerkleTree
		System.out.println("Testing the constructMerkleTree method 3");
		root3 = merkleTree3.constructMerkleTree(testThreeFiles);
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The root value after constructing the MerkleTree is " + root1);

        System.out.println( "END OF TESTS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    
    }
}