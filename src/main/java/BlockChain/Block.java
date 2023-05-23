package BlockChain;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

class Block  {
    private int index;
    private String previousHash;
    private Date timestamp;
    private String data;
    private String hash;

    //Структура блока
    Block(int index, String previousHash, Date timestamp, String data, String hash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(String hash) {
        this.hash = hash;
    }

    /*//Хеш блока
    public String calculateHashOld (String index, String previousHash, Date timestamp, String data) {
        String temp = index + previousHash + timestamp + data;
        return temp;
    };*/

    //Хеш блока
    public String calculateHash (String index, String previousHash, Date timestamp, String data) throws NoSuchAlgorithmException {
        String str = index + previousHash + timestamp + data;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(str.getBytes(StandardCharsets.UTF_8));
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
        return sha256;
    };
}