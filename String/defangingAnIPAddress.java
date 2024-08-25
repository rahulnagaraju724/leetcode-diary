class Solution {
    public String defangIPaddr(String address) {
        //1108. Defanging an IP Address
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                str.append("[.]");
                
            }else{
                str.append(address.charAt(i));
            }
        }

        return str.toString();
    }
}

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
    public String defangIPaddr(String address) {
        return String.join("[.]", address.split("\\."));
    }
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
    }