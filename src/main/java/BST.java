import java.util.List;

public class BST {
    public class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int value) {
            this.value = value;
        }
    }
    public int findLesser(BSTNode root, int maxPrice) {
        int lowFound = -1;
        BSTNode node = root;
        while (node != null) {
            if (node.value > maxPrice) {
                node = node.left;
            } else if (node.value < maxPrice) {
                lowFound = node.value;
                node = node.right;
            } else if (node.value == maxPrice) {
                return node.value;
            }
        }
        return lowFound;
    }

    public BSTNode convertSortedArraytoBST(List<Integer> sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BSTNode root = new BSTNode(sortedArray.get(mid));
        root.left = convertSortedArraytoBST(sortedArray, start, mid - 1);
        root.right = convertSortedArraytoBST(sortedArray, mid + 1, end);
        return root;
    }

    public BSTNode deleteNode(BSTNode bstNode, int value) {
        if (bstNode == null) return null;

        if (bstNode.value > value) bstNode.left = deleteNode(bstNode.left, value);
        else if (bstNode.value < value) bstNode.right =  deleteNode(bstNode.right, value);
        else {
            if (bstNode.left == null) {
                return bstNode.right;
            } else if (bstNode.right == null) {
                return bstNode.left;
            } else {
                int minKey = minValue(bstNode.right);
                bstNode.value = minKey;
                bstNode.right = deleteNode(bstNode.right, bstNode.value);
            }
        }
        return bstNode;
    }

    public int minValue(BSTNode bstNode) {
        int minK = bstNode.value;
        while (bstNode.left != null) {
            minK = bstNode.left.value;
            bstNode = bstNode.left;
        }
        return minK;
    }
}
