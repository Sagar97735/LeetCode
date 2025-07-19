class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> arr = new ArrayList<>();
        for(int i =0; i< folder.length; i++){
            String s = folder[i];
            if(arr.isEmpty() || ! s.startsWith(arr.get(arr.size()-1) + "/")){
                    arr.add(s);
            }
        }
        return arr;
    }
}