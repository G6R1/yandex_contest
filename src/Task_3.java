import java.util.*;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodesNum = scanner.nextInt();
        int changesNum = scanner.nextInt();
        int[] changes = new int[changesNum];

        for (int i = 0; i < changesNum; i++) {
            changes[i] = scanner.nextInt();
        }

        Map<Integer, Node> nodes = new HashMap<>(); //value, neighbours
        int rootNode = 1;

        for (int i = 1; i <= nodesNum; i++) {
            nodes.put(i, new Node(i % 2 == 0 ? i / 2 : (i - 1) / 2,
                    i * 2 <= nodesNum ? i * 2 : null,
                    i * 2 + 1 <= nodesNum ? i * 2 + 1 : null));
            if (i == rootNode)
                nodes.get(rootNode).setRoot(null);
        }

        for (int i : changes) {

            Integer root = nodes.get(i).getRoot();
            if (root == null)
                continue;
            if (root == rootNode)
                rootNode = i;

            Integer a = nodes.get(root).getLeft();
            if (a != null && a == i) {
                leftChange(i, root, nodes);
            } else {
                rightChange(i, root, nodes);
            }

        }

        output(rootNode, nodes);
    }

    private static class Node {
        private Integer root;
        private Integer left;
        private Integer right;

        public Node(Integer root, Integer left, Integer right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }

        public Integer getRoot() {
            return root;
        }

        public void setRoot(Integer root) {
            this.root = root;
        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }

        public Integer getRight() {
            return right;
        }

        public void setRight(Integer right) {
            this.right = right;
        }
    }

    private static void output(int rootNode, Map<Integer, Node> nodes) {
        if (nodes.get(rootNode).getLeft() != null) {
            output(nodes.get(rootNode).getLeft(), nodes);
        }

        System.out.print(rootNode + " ");

        if (nodes.get(rootNode).getRight() != null) {
            output(nodes.get(rootNode).getRight(), nodes);
        }
    }

    private static void leftChange(int node, int root, Map<Integer, Node> nodes) {
        Integer rootsRoot = nodes.get(root).getRoot();
        Integer nodesLeft = nodes.get(node).getLeft();

        nodes.get(root).setRoot(node);
        nodes.get(root).setLeft(nodesLeft);
        nodes.get(node).setRoot(rootsRoot);
        nodes.get(node).setLeft(root);


        if (nodes.get(rootsRoot) != null) {
            Integer a = nodes.get(rootsRoot).getLeft();
            if (a != null && a == root) {
                nodes.get(rootsRoot).setLeft(node);
            } else {
                nodes.get(rootsRoot).setRight(node);
            }
        }

        if (nodes.get(nodesLeft) != null) {
            nodes.get(nodesLeft).setRoot(root);
        }

    }

    private static void rightChange(int node, int root, Map<Integer, Node> nodes) {
        Integer rootsRoot = nodes.get(root).getRoot();
        Integer nodesRight = nodes.get(node).getRight();

        nodes.get(root).setRoot(node);
        nodes.get(root).setRight(nodesRight);
        nodes.get(node).setRoot(rootsRoot);
        nodes.get(node).setRight(root);


        if (nodes.get(rootsRoot) != null) {
            Integer a = nodes.get(rootsRoot).getLeft();
            if (a != null && a == root) {
                nodes.get(rootsRoot).setLeft(node);
            } else {
                nodes.get(rootsRoot).setRight(node);
            }
        }

        if (nodes.get(nodesRight) != null) {
            nodes.get(nodesRight).setRoot(root);
        }

    }
}
