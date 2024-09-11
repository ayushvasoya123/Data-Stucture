
public class binarySerchTree {
    public static void main(String[] args) {
       root = insertRecord(root, 40);
       insertRecord(root, 25);
       insertRecord(root, 65);
       insertRecord(root, 10);
       insertRecord(root, 30);
       insertRecord(root, 55);
       insertRecord(root, 70);
       insertRecord(root, 15);
       insertRecord(root, 50);
       insertRecord(root, 80);
       insertRecord(root, 75);


       

       preOrder(root);

       System.err.println("");

       inOrder(root);

       System.err.println("");

       postOrder(root);

       System.out.println();

      

       deleteRec(root, 25);
       

       System.err.println("-->-->-->-->-->-->-->-->-->");

       preOrder(root);
       System.err.println("");

       inOrder(root);

       System.err.println("");

       postOrder(root);
       
       System.err.println("");
       System.err.println("-->-->-->-->-->-->-->-->-->");

       System.err.println(check(19,root));
    }
    static class TreeNode {

        int key;
        TreeNode left, right;

        public TreeNode(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    static TreeNode root;

    // public class bst {

    //     TreeNode root;

    //     public bst() {
    //         root = null;
    //     }

    //     public static void insert(int root,int key) {
    //         root = insertRecord(root, key);
    //     }

    // }
    public static TreeNode insertRecord(TreeNode root, int key) {
        if(root == null) {
            root = new TreeNode(key);
            return root;
        }
        else if(key < root.key) {
            root.left = insertRecord(root.left, key);
        }
        else if(key> root.key){
            root.right = insertRecord(root.right, key);

        }
        return root;

    }
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.key+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);

        }

    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key+" ");

        }

    }
    public static boolean check(int target , TreeNode root){
        if (root == null){
            return false;
        }
        if(root.key == target){
            return true;
        }
        return check(target , root.left) || check(target,root.right);
    }
    static void deleteNode(int key) {
        root = deleteRec(root, key);
    }

  
    public static TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            
            if (root.left == null && root.right == null)
                return null;

           
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;


            else {
                TreeNode temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteRec(root.right, temp.key);
            }
        }
        return root;
    }
    static TreeNode minValueNode(TreeNode root) {
        TreeNode current = root;
        while (current.left != null)
            current = current.left;
   
        return current;
    }
    

}
