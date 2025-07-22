package BinaryTrees;

class PathSumIII {
    public static void main(String args[]) {
        TreeNode t = new TreeNode();
        System.out.println(pathSum(t.getTree(), 6));
    }

    static int result;
    static int target;

    public static int pathSum(TreeNode root, int targetSum) {
        result = 0;
        target=targetSum;
        preorder(root);
        return result;
    }

    public static void preorder(TreeNode root) {
        if(root==null) return;
        sumPath(root, 0);
        preorder(root.left);
        preorder(root.left);
    }

    public static void sumPath(TreeNode root, int sum) {
        if(root==null) {
            return;
        }
        sum+=root.val;
        if(sum==target) {
            System.out.println(sum+"---------------"+result);
            result++;
        }
        sumPath(root.left, sum);
        sumPath(root.right, sum);
    }
}
