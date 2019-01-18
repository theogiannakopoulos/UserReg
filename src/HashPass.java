import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPass {
	
	
	public HashPass(){}
	
	public String hashing(String password){
		
		String hashed = "";
		
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			   
		for(int i=0;i<encodedhash.length;i++){
			hashed += encodedhash[i];
		}
		
		return hashed;
	}
	
}
