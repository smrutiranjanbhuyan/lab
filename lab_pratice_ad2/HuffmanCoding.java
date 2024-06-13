package lab_pratice_ad2;
import java.util.PriorityQueue;

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left, right;

    public HuffmanNode(int data, char c) {
        this.data = data;
        this.c = c;
        this.left = null;
        this.right = null;
    }
}

public class HuffmanCoding {

    public static void printCodes(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>((l, r) -> l.data - r.data);

        for (int i = 0; i < charArray.length; i++) {
            queue.add(new HuffmanNode(charFreq[i], charArray[i]));
        }

        while (queue.size() > 1) {
            HuffmanNode x = queue.poll();
            HuffmanNode y = queue.poll();

            HuffmanNode newNode = new HuffmanNode(x.data + y.data, '-');
            newNode.left = x;
            newNode.right = y;
            queue.add(newNode);
        }

        HuffmanNode root = queue.poll();
        printCodes(root, "");
    }
}
