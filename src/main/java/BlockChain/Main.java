package BlockChain;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Block block = new Block();
        Block first = block.getGenesisBlock();
        System.out.println(first);
        Block second = block.generateNextBlock(first, "Второй тестовый блок");
        if (block.isValidNewBlock(second,first)) {
            System.out.println(second);
        }
    }
}


