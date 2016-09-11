/**
 * 1. class Node {int level, int currLen, boolean isFile}
 * 2. split input by "\n" => {files/dirs}
 * 3. create Stack<Node> and maxPath = 0
 * 4. loop element in array:
 *      - create Node via element
 *      - while (stack non-empty && current.level <= stack.peek().level) => stack.pop() => to make the top of stack be the upper level of current node
 *      - update currentNode.currLen => empty stack -> s.length, non-empty stack -> s.length + lastNode.currLen - curr.level + 1
 *      - if isFile -> update maxPath
 *      - if not isFile -> stack.push(n)
 **/
public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0)
            return 0;
        String[] paths = input.split("\n");
        
        Stack<Node> dirs = new Stack<Node>();
        int maxPath = 0;
        
        for (int i = 0; i < paths.length; i++) {
            System.out.println(paths[i]);
            Node n = new Node(paths[i]);
            while (!dirs.empty() && n.level <= dirs.peek().level) {
                // make the top of stack to be the upper level of current node
                dirs.pop();
            }
            n.currLen = dirs.empty()? paths[i].length() : paths[i].length() - n.level + 1 + dirs.peek().currLen;
            if (n.isFile) {
                maxPath = Math.max(maxPath, n.currLen);
            } else {
                dirs.push(n);
            }
        }
        return maxPath;
    }
}

class Node {
    int level;
    int currLen;
    boolean isFile;
    public Node(String s) {
        // update level
        int t = 0;
        while (t < s.length() - 1 && s.substring(t, t + 1).equals("\t")) {
            level++;
            t++;
        }
        // isFile
        isFile = s.contains(".");
    }
}
