class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        Arrays.sort(products); 
        
        int n = products.length;
        int low = 0;  
        int high = n - 1; 
        int len = searchWord.length();  
        
        for (int i = 0; i < len; i++){   
            while (low <= high && (products[low].length() <= i || products[low].charAt(i) != searchWord.charAt(i))){
                low++;
            }                      
            while (low <= high && (products[high].length() <= i || products[high].charAt(i) != searchWord.charAt(i))){
                high--;
            }
            
            int min = Math.min(low + 3, high + 1);
            List<String> list = new ArrayList<>();
            for (int j = low; j < min; j++){
                list.add(products[j]);
            }
            result.add(list);    
        }
        return result;
    }
}