import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord)) {
            return result;
        }

        Map<String, Integer> distanceMap = new HashMap<>();
        bfs(beginWord, endWord, dict, distanceMap);

        if (distanceMap.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, dict, distanceMap, path, result);
        }

        return result;
    }

    // Step 1: BFS to find the shortest distance to each word
    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);

        boolean foundEnd = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();
                int currentDist = distanceMap.get(current);

                if (current.equals(endWord)) {
                    foundEnd = true;
                }

                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (dict.contains(nextWord)) {
                            if (!distanceMap.containsKey(nextWord)) {
                                distanceMap.put(nextWord, currentDist + 1);
                                queue.offer(nextWord);
                            }
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            if (foundEnd) break; // Reached endWord level; stop further depth expansion
        }
    }

    // Step 2: DFS to backtrack and reconstruct all shortest paths
    private void dfs(String current, String beginWord, Set<String> dict, 
                     Map<String, Integer> distanceMap, List<String> path, List<List<String>> result) {
        if (current.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            result.add(validPath);
            return;
        }

        int currentDist = distanceMap.get(current);
        char[] chars = current.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                chars[i] = c;
                String prevWord = new String(chars);

                // Step backward if neighbor distance is exactly currentDist - 1
                if (distanceMap.getOrDefault(prevWord, -1) == currentDist - 1) {
                    path.add(prevWord);
                    dfs(prevWord, beginWord, dict, distanceMap, path, result);
                    path.remove(path.size() - 1); // Backtrack
                }
            }
            chars[i] = originalChar;
        }
    }
}