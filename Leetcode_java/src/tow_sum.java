import java.util.*;

class Node {
	public int idx;
	public int val;

	public Node() {
	};

	public Node(int i, int v) {
		idx = i;
		val = v;
	}
}

class Icomp implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		return n1.val - n2.val;
	}
}

class Solution {
	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		// create table (idx, val)
		List<Node> table = new ArrayList<Node>();
		int size = numbers.length;
		for (int i = 1; i <= size; ++i) {
			table.add(new Node(i, numbers[i-1]));
		}

		// sort by value
		Collections.sort(table, new Icomp());

		// two pts
		int v1 = 0, v2 = table.size() - 1;
		Node n1 = null, n2 = null;
		while (true) {
			n1 = table.get(v1);
			n2 = table.get(v2);
			int[] ret = new int[2];
			int value = n1.val + n2.val;
			if (value == target) {
				ret[0] = Math.min(n1.idx, n2.idx);
				ret[1] = Math.max(n1.idx, n2.idx);
				return ret;
			} else if (value > target) {
				v2--;
			} else {
				v1++;
			}
		}
	}
}


//---------------------------------------------------------------
// test
//---------------------------------------------------------------

public class tow_sum {
	public static void main(String[] args) {
		int[] a = {3,6,7,11,17,22,23,24,34};
		int target = 33;
		Solution s = new Solution();
		int[] r = s.twoSum(a, target);
		System.out.println("result: " + r[0] + " " + r[1]);
		System.out.println("Expecting: 4, 6 ");
	}
}
