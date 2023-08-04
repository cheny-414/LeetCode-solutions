class Solution {
    int BIT_LIMIT = 16;
    public int countPairs(int[] nums, int low, int high) {
        BinaryTree tree = new BinaryTree();
        int numPairs = 0;
        String highNum = getString(high);
        String lowNum = getString(low - 1);

        tree.add(getString(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            String currNum = getString(nums[i]);
            numPairs += tree.search(currNum, highNum);
            numPairs -= tree.search(currNum, lowNum);
            tree.add(currNum);
        }
        return numPairs;
    }

    private String getString(int num) {
        String string = Integer.toBinaryString(num);
        while (string.length() < BIT_LIMIT) {
            string = "0" + string;
        }
        return string;
    }

    class BinaryTree {
        Node root;
        public BinaryTree() {
            root = new Node();
        }

        public void add(String s) {
            Node curr = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    if (curr.left == null) curr.left = new Node();
                    curr = curr.left;
                } else {
                    if (curr.right == null) curr.right = new Node();
                    curr = curr.right;
                }
                curr.count++;
            }
        }

        public int search(String str, String limit) {
            int answer = 0;
            Node curr = root;
            for (int i = 0; i < str.length(); i++) {
                char s = str.charAt(i);
                char k = limit.charAt(i);
                if (curr == null) break;
                if (s == '0' && k == '0') {
                    curr = curr.left;
                    if (i == str.length() - 1) {
                        answer += curr == null ? 0 : curr.count;
                    }
                } else if (s == '0' && k == '1') {
                    answer += curr.left == null ? 0 : curr.left.count;
                    curr = curr.right;
                    if (i == str.length() - 1) {
                        answer += curr == null ? 0 : curr.count;
                    }
                } else if (s == '1' && k == '0') {
                    curr = curr.right;
                    if (i == str.length() - 1) {
                        answer += curr == null ? 0 : curr.count;
                    }
                } else {
                    answer += curr.right == null ? 0 : curr.right.count;
                    curr = curr.left;
                    if (i == str.length() - 1) {
                        answer += curr == null ? 0 : curr.count;
                    }
                }
            }
            return answer;
        }
    }

    class Node {
        int count;
        Node left;
        Node right;
        public Node() {
            count = 0;
            left = null;
            right = null;
        }
    }
 }