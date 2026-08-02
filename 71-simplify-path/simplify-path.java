import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        
        // Split path by single or multiple slashes
        String[] components = path.split("/");
        
        for (String dir : components) {
            // Ignore empty strings and current directory indicator "."
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            
            // Go to parent directory if possible
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                // Valid directory or file name
                stack.addLast(dir);
            }
        }
        
        // Reconstruct canonical path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
}