package march30new;

import java.util.*;


public class LC_637_Average_of_Levels_in_Binary_Tree {
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty()){
                int levelsize = q.size();
                double avg = 0;
                for(int i=0; i<levelsize; i++){
                    TreeNode rm = q.poll();
                    avg += rm.val;

                    if(rm.left != null) q.offer(rm.left);
                    if(rm.right != null) q.offer(rm.right);
                }
                ans.add(avg/levelsize);
            }

            return ans;

        }
    }
}
