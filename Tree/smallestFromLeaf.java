class Solution {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return "";
        char ch = (char) (root.val + 'a');
        String leftMin = smallestFromLeaf(root.left);
        String rightMin = smallestFromLeaf(root.right);


        int res = (leftMin+ch).compareTo(rightMin+ch);
        // System.out.println("left: " + leftMin);
        // System.out.println("right: " + rightMin);
        // System.out.println("left<right: " + res);

        // System.out.println();

        if (leftMin.compareTo("") == 0)
            return rightMin+ch ;
        if (rightMin.compareTo("") == 0)
            return leftMin+ch ;

        if (res < 0)
            return leftMin+ch;
        else
            return rightMin+ch;

    }

}