package BlockChain;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        LinkedList<Block> blocks = new LinkedList<>();
        Block GenesisBlock = new Block();
        // Новый элемент-главный блок добавляется в нулевую позицию списка:
        blocks.addFirst(GenesisBlock.getGenesisBlock());

        //Консольное меню
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";
        String point ="";

        while (!point.equals("5")){
            System.out.println("\n1. Добавление нового блока");
            System.out.println("2. Вывод всех блоков");
            System.out.println("3. Вывод последнего добавленного блока");
            System.out.println("4. Добавить новый блок вручную (для проверки цепочки блока данных)");
            System.out.println("5. Завершение работы");
            System.out.print("\nВведите номер необходимого действия: ");
            point = scan.next();

            try {
                x = Integer.parseInt(point);
            } catch (NumberFormatException e){
                System.out.println("\nНеверный ввод\n");
            }

            switch (x){
                case 1:
                    System.out.print("\nВведите текст, который будет храниться в новом блоке: ");
                    s = scan.next();
                    Block temp = blocks.getFirst().generateNextBlock(blocks.getFirst(), s);
                    if (blocks.getFirst().isValidNewBlock(temp,blocks.getFirst())) {
                        blocks.addFirst(temp);
                        System.out.println("\nНовый блок добавлен в блокчейн");
                    }
                    break;
                case 2:
                    System.out.println(blocks);
                    break;
                case 3:
                    System.out.println("\nПоследний добавленный блок:" + blocks.getFirst());
                    break;
                case 4:
                    System.out.print("\nВведите индекс блока: ");
                    int index=0;
                    s = scan.next();
                    try {
                        index = Integer.parseInt(s);
                    } catch (NumberFormatException e){
                        System.out.println("\nНеверный ввод\n");
                    }
                    System.out.print("Введите хеш предыдущего блока: ");
                    String previousHash = scan.next();
                    System.out.print("Введите дату добавления блока: ");
                    String timestamp = scan.next();
                    System.out.print("Введите текст, который будет храниться в новом блоке: ");
                    String data = scan.next();
                    System.out.print("Введите хеш нового блока: ");
                    String hash = scan.next();
                    Block temp2 = new Block(index, previousHash, timestamp, data, hash);
                    if (blocks.getFirst().isValidNewBlock(temp2,blocks.getFirst())) {
                        blocks.addFirst(temp2);
                        System.out.println("\nНовый блок добавлен в блокчейн\n");
                    }
            }
        }
        System.out.println("\nРабота завершена");
    }
}


