package BlockChain;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

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

    //Структура блока
    Block() {
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
    public String calculateHash (int index, String previousHash, Date timestamp, String data) throws NoSuchAlgorithmException {
        String str = index + previousHash + timestamp + data;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(str.getBytes(StandardCharsets.UTF_8));
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
        return sha256;
    };

    //Генерация блока
    public Block generateNextBlock (Block block, String blockData) throws NoSuchAlgorithmException {
        int nextIndex = this.index + 1;
        Date nextTimestamp = new Date();
        String nextHash = calculateHash(nextIndex, block.hash, nextTimestamp, blockData);
        return new Block(nextIndex, block.hash, nextTimestamp, blockData, nextHash);
    };

    //Хранение блоков
    public Block getGenesisBlock(){
        return new Block(0, "0", new Date(), "Главный блок", "c5541a4decd096682d13f4ea9c77b94320dec0e331f4d31564166a23529a27bd");
    };

    //Подтверждение целостности блоков
    public boolean isValidNewBlock (Block newBlock, Block previousBlock) throws NoSuchAlgorithmException {
        if (previousBlock.index + 1 != newBlock.index) {
            System.out.println("неверный индекс");
            return false;
        } else if (!previousBlock.hash.equals(newBlock.previousHash)) {
            System.out.println("неверный хеш предыдущего блока");
            return false;
        } else if (!calculateHash(newBlock.index,newBlock.previousHash,newBlock.timestamp,newBlock.data).equals(newBlock.hash)) {
            System.out.println("неверный хеш: " + calculateHash(newBlock.index,newBlock.previousHash,newBlock.timestamp,newBlock.data) + ' ' + newBlock.hash);
            return false;
        }
        return true;
    };

    // переопределение метода toString()
    @Override
    public String toString() {
        return "\n Индекс=" + this.index
                + "\n Хеш предыдущего блока=" + this.previousHash
                + "\n Дата создания=" + this.timestamp
                + "\n Информация=" + this.data
                + "\n Хеш текущего блока=" + this.hash + "\n";
    }
}