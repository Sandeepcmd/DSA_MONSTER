class Solution {
    class Info {
        TreeNode node;
        int level;
        int hd;

        Info(TreeNode node, int level, int hd) {
            this.node = node;
            this.level = level;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Info> pq1 = new PriorityQueue<>(
            (a, b) -> a.level - b.level 
        );
        pq1.offer(new Info(root, 0, 0));

        PriorityQueue<Info> pq2 = new PriorityQueue<>((a, b) -> {
            if (a.hd != b.hd) return a.hd - b.hd;
            if (a.level != b.level) return a.level - b.level;
            return a.node.val - b.node.val;
        });

        while (!pq1.isEmpty()) {
            Info curr = pq1.poll();
            pq2.offer(curr);

            TreeNode node = curr.node;
            int level = curr.level;
            int hd = curr.hd;

            if (node.left != null) {
                pq1.offer(new Info(node.left, level + 1, hd - 1));
            }
            if (node.right != null) {
                pq1.offer(new Info(node.right, level + 1, hd + 1));
            }
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        while (!pq2.isEmpty()) {
            Info info = pq2.poll();
            map.computeIfAbsent(info.hd, k -> new ArrayList<>()).add(info.node.val);
        }

        return new ArrayList<>(map.values());
    }
}
