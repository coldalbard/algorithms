package algorithms.homework.homework4;

class Tree{
    Node root;
    private enum Color{
        RED, BLACK
    }

    class Node{
        private Color color;
        private int value;
        private Node left;
        private Node right;

        @Override
        public String toString() {
            return "{Value: " + value + " Color: " + color
            + " Left: " + left + " Right: " + right + "}";
        }
    }

    private void colorSwap(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap(Node node){
        Node leftChild = node.left;
        Node child = leftChild.right;
        leftChild.right = node;
        node.left = child;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;   
    }

    private Node rightSwap(Node node){
        Node rightChild = node.right;
        Node child = rightChild.left;
        rightChild.left = node;
        node.right = child;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild; 
    }

    private Node reBalancing(Node node){
        Node result = node;
        boolean reBalance;
        do {
            reBalance = false;
            if (result.right != null && result.right.color == Color.RED &&
            (result.left == null || result.left.color == Color.BLACK)) {
                reBalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
            result.left.left != null && result.left.left.color == Color.RED) {
                reBalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
            result.right != null && result.right.color == Color.RED) {
                reBalance = true;
                colorSwap(result);
            }
        } while (reBalance);
        return result;
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

    public boolean insert(int value){
        if (root != null) {
            boolean result = insert(root, value);
            root = reBalancing(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    public boolean insert(Node node, int value){
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = insert(node.left, value);
                    node.left = reBalancing(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            }
            else{
                if (node.right != null) {
                    boolean result = insert(node.right, value);
                    node.right = reBalancing(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        for(int i=1; i<=5; i++){
            tree.insert(i);
            System.out.println(tree.root);
        }
    }
}
