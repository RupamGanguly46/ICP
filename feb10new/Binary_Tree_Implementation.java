import java.util.*;
public class Binary_Tree_Implementation {
    
    public static Scanner sc = new Scanner(System.in);
    
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    static class Tree{
        Node root;

        Tree(int val){
            root = new Node(val);
        }

        public void populate(){
            populate(this.root);
        }

        private void populate(Node n){
            System.out.println("Want to add to left of " + n.val);
            boolean left = sc.nextBoolean();
            if(left){
                System.out.println("Enter value: ");
                n.left = new Node(sc.nextInt());
                populate(n.left);
            }
            System.out.println("Want to add to right of " + n.val);
            boolean right = sc.nextBoolean();
            if(right){
                System.out.println("Enter value: ");  
                n.right = new Node(sc.nextInt());;
                populate(n.right);
            }
        }
        
        public void display(){
            display(this.root, "");
        }
    
        private void display(Node n, String indent){
            if(n == null) return;
            System.out.println(n.val + indent);
            display(n.left, indent+"\t");
            display(n.right, indent+"\t");
        }

        public void prettyDisplay(){
            prettyDisplay(this.root, 0);
        }

        private void prettyDisplay(Node n, int lvl){
            if(n == null) return;
            prettyDisplay(n.right, lvl+1);
            if(lvl != 0){
                for(int i=0; i<lvl-1; i++){
                    System.out.print("|\t");
                }
                System.out.println("|------>" + n.val);
            }
            else{
                System.out.println(n.val);
            }
            prettyDisplay(n.left, lvl+1);
        }

    }

    public static void main(String[] args) {
        Tree t = new Tree(0);
        t.populate();
        // t.display();
        t.prettyDisplay();
    }
}
