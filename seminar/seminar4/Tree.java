package algorithms.seminar.seminar4;

class Tree{
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
    }
    @Override
    public String toString() {
        return " Node{Value: " + root.value + " Left: " 
        + root.left + " Right: " + root.right;
    }
    

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value){
        if(node == null){
            return null;
        }
        if(node.value == value){
            return node;
        }
        if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }

    public void insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
        }else {
            insert(root, value);
            //root = balance(root);
        }

        //root.color = BLACK;
    }

    public void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                    //node.right.color = RED;
                }else{
                    insert(node.right, value);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    //node.left.color = RED;
                }else{
                    insert(node.left, value);
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        for(int i=1; i<=5; i++){
            tree.insert(i);
        }
    }
}
