class Solution {
    public String validIPAddress(String queryIP) {
        //468. Validate IP Address
        String[] splitQueryIP=queryIP.split("\\.");
        //System.out.println(Arrays.toString(splitQueryIP));
        if(splitQueryIP.length==1){
            //Possible IPv6 
            int colonCount = 0;
            for (int i = 0; i < queryIP.length(); i++) {
                if (queryIP.charAt(i) == ':') {
                    colonCount++;
                }
            }
            if(colonCount!=7){
                return "Neither";
            }
            splitQueryIP=queryIP.split(":");
            //System.out.println(Arrays.toString(splitQueryIP));
            if(splitQueryIP.length!=8){
                return "Neither";
            }
            for(int i=0;i<splitQueryIP.length;i++){
                int size=splitQueryIP[i].length();
                if(size>4 || size==0){
                    return "Neither";
                }
                for(int j=0;j<size;j++){
                    int ascii=((int)splitQueryIP[i].charAt(j));
                    //a=97,f=102, A=65, F=70
                    if(!((ascii>=97 && ascii<=102) || (ascii>=65 && ascii<=70) || (ascii>=48 && ascii<=57))){
                        return "Neither";
                    }

                }

            }            
            return "IPv6";
        }
        else if (splitQueryIP.length>1){
            //Possible IPv4
            int dotCount = 0;
            for (int i = 0; i < queryIP.length(); i++) {
                if (queryIP.charAt(i) == '.') {
                    dotCount++;
                }
            }
            if(dotCount!=3){
                return "Neither";
            }
            if(splitQueryIP.length!=4){
                return "Neither";
            }
            for(int i=0;i<splitQueryIP.length;i++){
                int size=splitQueryIP[i].length();
                if(size>3 || size==0){
                    return "Neither";
                }
                for(int j=0;j<size;j++){
                    //if(splitQueryIP[i].charAt(j)=='0' && j<size-1){
                    if(splitQueryIP[i].charAt(j)=='0'){
                        if((size==3 && j==0) || (size==2 && j==0)){
                            System.out.println("Leading zero");
                            return "Neither";
                        }

                    }
                    int ascii=((int)splitQueryIP[i].charAt(j));
                    if(ascii<48 || ascii>57){
                        return "Neither";
                    }

                }
                if(Integer.parseInt(splitQueryIP[i])>255){
                    return "Neither";
                }

            }
            return "IPv4";
        }
        return "Neither";
    }
}


// More readable solution, Better approach

public String validIPAddress(String IP) {
	if(isValidIPv4(IP)) return "IPv4";
	else if(isValidIPv6(IP)) return "IPv6";
	else return "Neither";
}

public boolean isValidIPv4(String ip) {
	if(ip.length()<7) return false;
	if(ip.charAt(0)=='.') return false;
	if(ip.charAt(ip.length()-1)=='.') return false;
	String[] tokens = ip.split("\\.");
	if(tokens.length!=4) return false;
	for(String token:tokens) {
		if(!isValidIPv4Token(token)) return false;
	}
	return true;
}
public boolean isValidIPv4Token(String token) {
	if(token.startsWith("0") && token.length()>1) return false;
	try {
		int parsedInt = Integer.parseInt(token);
		if(parsedInt<0 || parsedInt>255) return false;
		if(parsedInt==0 && token.charAt(0)!='0') return false;
	} catch(NumberFormatException nfe) {
		return false;
	}
	return true;
}
	
public boolean isValidIPv6(String ip) {
	if(ip.length()<15) return false;
	if(ip.charAt(0)==':') return false;
	if(ip.charAt(ip.length()-1)==':') return false;
	String[] tokens = ip.split(":");
	if(tokens.length!=8) return false;
	for(String token: tokens) {
		if(!isValidIPv6Token(token)) return false;
	}
	return true;
}
public boolean isValidIPv6Token(String token) {
	if(token.length()>4 || token.length()==0) return false;
	char[] chars = token.toCharArray();
	for(char c:chars) {
		boolean isDigit = c>=48 && c<=57;
		boolean isUppercaseAF = c>=65 && c<=70;
		boolean isLowerCaseAF = c>=97 && c<=102;
		if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
			return false;
	}
	return true;
}