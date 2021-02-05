import java.util.HashMap;
import java.util.Map;

/**
 * @author: jixd
 * @date: 2021/1/28 8:48 上午
 */
public class Solution105 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    private Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }

    public TreeNode build(int[] preorder,int[] inorder,int pre_left,int pre_right,int in_left,int in_right){
        if(pre_left > pre_right) return null;
        int in_root = map.get(preorder[pre_left]);
        TreeNode root = new TreeNode(preorder[pre_left]);
        int left_tree_size = in_root - in_left;
        root.left =  build(preorder,inorder,pre_left + 1,pre_left + left_tree_size,in_left,in_root - 1);
        root.right = build(preorder,inorder,pre_left + left_tree_size + 1,pre_right,in_root + 1,in_right);
        return root;
    }


}
