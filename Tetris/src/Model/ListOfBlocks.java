package Model;
import java.awt.*;
import java.util.*;

public class ListOfBlocks  {
    private TetrisBlock tBlock;
    private TetrisBlock lBlock;
    private TetrisBlock zBlock;
    private TetrisBlock sBlock;
    private TetrisBlock iBlock;
    private TetrisBlock oBlock;
    private TetrisBlock jBlock;
    private ArrayList<TetrisBlock> listOfBlocks;

    public ListOfBlocks(){
        createBlock();
        listOfBlocks = new ArrayList<>();
        addBlockToList();
    }

    public void createBlock(){
        tBlock = new TetrisBlock(new int[][]{{0, 1, 0}, {1, 1, 1}}, Color.white);
        lBlock = new TetrisBlock(new int[][]{{1, 0}, {1, 0}, {1, 1}}, Color.orange);
        zBlock = new TetrisBlock(new int[][]{{1,1,0},{0,1,1}}, Color.green);
        sBlock = new TetrisBlock(new int[][]{{0,1,1},{1,1,0}}, Color.red);
        iBlock = new TetrisBlock(new int[][]{{1},{1},{1},{1}}, Color.cyan);
        oBlock = new TetrisBlock(new int[][]{{1,1},{1,1}}, Color.yellow);
        jBlock = new TetrisBlock(new int[][]{{0,1},{0,1},{1,1}}, Color.pink);

    }

    public void addBlockToList(){
        listOfBlocks.add(tBlock);
        listOfBlocks.add(lBlock);
        listOfBlocks.add(zBlock);
        listOfBlocks.add(sBlock);
        listOfBlocks.add(iBlock);
        listOfBlocks.add(oBlock);
        listOfBlocks.add(jBlock);
    }

    public ArrayList<TetrisBlock> getBlockList(){
        return listOfBlocks;
    }
}
