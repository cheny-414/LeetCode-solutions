class Dir {
    Map<String, Dir> dirs = new HashMap<>();
    Map<String, String> files = new HashMap<>();
}
class FileSystem {
    Dir root;
    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir curr = root;
        List<String> result = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length - 1; i++) {
                curr = curr.dirs.get(d[i]);
            }
            if (curr.files.containsKey(d[d.length - 1])) {
                result.add(d[d.length - 1]);
                return result;
            } else {
                curr = curr.dirs.get(d[d.length - 1]);
            }
        }
        result.addAll(new ArrayList<>(curr.dirs.keySet()));
        result.addAll(new ArrayList<>(curr.files.keySet()));
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        Dir curr = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            curr.dirs.putIfAbsent(d[i], new Dir());
            curr = curr.dirs.get(d[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir curr = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            curr = curr.dirs.get(d[i]);
        }
        curr.files.put(d[d.length - 1], curr.files.getOrDefault(d[d.length - 1], "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        Dir curr = root;
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            curr = curr.dirs.get(d[i]);
        }
        return curr.files.get(d[d.length - 1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */