class SQL {
    Map<String, Map<Integer, List<String>>> tables;
    Map<String, Integer> maxIDs;
    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();
        maxIDs = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            Map<Integer, List<String>> table = new HashMap<>();
            tables.put(names.get(i), table);
        }
    }
    
    public void insertRow(String name, List<String> row) {
        var table = tables.get(name);
        int maxID = maxIDs.getOrDefault(name, 0) + 1;
        table.put(maxID, row);
        maxIDs.put(name, maxID);
    }
    
    public void deleteRow(String name, int rowId) {
        var table = tables.get(name);
        table.remove(rowId);
    }
    
    public String selectCell(String name, int rowId, int columnId) {
        var table = tables.get(name);
        var row = table.get(rowId);
        String cell = row.get(columnId - 1);
        return cell;
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */