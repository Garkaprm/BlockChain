package BlockChain;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Date dt = new Date(2023,4,23);
        Block test = new Block(1234, "qwer123rew", dt, "testFirst", "987tre9");
        System.out.println(test.calculateHash(test.getHash(),test.getPreviousHash(),test.getTimestamp(),test.getData()));
    }
}


