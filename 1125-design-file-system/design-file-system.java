class Dir {
    Map<String, Dir> dirs = new HashMap<>();
    int value = 0;
}
class FileSystem {
    Dir root;
    public FileSystem() {
        root = new Dir();
    }
    
    public boolean createPath(String path, int value) {
        Dir curr = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length - 1; i++) {
            if (!curr.dirs.containsKey(d[i])) {
                return false;
            }
            curr = curr.dirs.get(d[i]);
        }
        if (curr.dirs.containsKey(d[d.length - 1])) return false;
        curr.dirs.put(d[d.length - 1], new Dir());
        curr = curr.dirs.get(d[d.length - 1]);
        curr.value = value;
        return true;
    }
    
    public int get(String path) {
        Dir curr = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!curr.dirs.containsKey(d[i])) {
                return -1;
            }
            curr = curr.dirs.get(d[i]);
        }
        return curr.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */