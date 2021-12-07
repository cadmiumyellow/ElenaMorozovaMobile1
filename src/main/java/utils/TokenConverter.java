package utils;

public class TokenConverter {
    public static String convertToken(String token){
        StringBuilder convertedToken = new StringBuilder();
        for(char c : token.toCharArray()) {
            if(c == '/') {
                convertedToken.append("%2F");
            }
            else if(c == '+') {
                convertedToken.append("%2B");
            } else {
                convertedToken.append(c);
            }
        }
        return convertedToken.toString();
    }
}
