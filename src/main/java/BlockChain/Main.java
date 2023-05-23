package BlockChain;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        LinkedList<Block> blocks = new LinkedList<>();
        Block GenesisBlock = new Block();
        // Новый элемент-главный блок добавляется в нулевую позицию списка:
        blocks.addFirst(GenesisBlock.getGenesisBlock());

        //Добавление нового блока в нулевую позицию списка
        if (true){
            Block temp = blocks.getFirst().generateNextBlock(blocks.getFirst(), "Второй тестовый блок (надо что-то с клавиатуры вводить)");
            if (blocks.getFirst().isValidNewBlock(temp,blocks.getFirst())) {
                blocks.addFirst(temp);
                System.out.println("\nНовый блок добавлен в блокчейн\n");
            }
        }

        //Вывод всех блоков
        if (true){
            System.out.println(blocks);
        }

        //Вывод последнего добавленного блока
        if (true){
            System.out.println("\nПоследний добавленный блок:" + blocks.getFirst());
        }
    }
}


