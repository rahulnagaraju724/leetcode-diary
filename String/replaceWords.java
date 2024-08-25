class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // System.out.println(dictionary.toString());
        Collections.sort(dictionary);

        String[] splited = sentence.split("\\s+");
        StringBuilder str=new StringBuilder("");

        for(String word:splited){

            boolean added=false;

            for(int i=0;i<dictionary.size();i++){
                String root=dictionary.get(i);
                if(Character.compare(root.charAt(0), word.charAt(0) ) > 0 ){
                    break; // can't go further as there can be no further roots; Ex:['axa','gan',zar'], 'an'
                }
                int j=0;
                while(j<word.length() && j<root.length()){
                    if(root.charAt(j)!=word.charAt(j)){
                        break;
                    }
                    j++;
                }
                if(j==root.length()){
                    str.append(root).append(" ");
                    added=true;
                    break;// bcz if added, other root next are more size
                }
            }

            if(!added){
                str.append(word).append(" ");
            }

        }


        if(str.charAt(str.length()-1)==' '){ // remove extra space which is added in while loop
            str.setLength(Math.max(str.length() - 1, 0));
        }
        return str.toString();
    }
}