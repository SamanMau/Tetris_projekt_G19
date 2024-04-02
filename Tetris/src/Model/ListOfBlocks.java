package Model;
import java.awt.*;
import java.util.*;

public class ListOfBlocks  {
    private int[][] tBlock;
    private int[][] lBlock;
    private int[][] zBlock;
    private int[][] sBlock;
    private int[][] iBlock;
    private int[][] oBlock;
    private int[][] jBlock;
    private ArrayList<int[][]> listOfBlocks;
    private ArrayList<Color> listOfColors;


    public ListOfBlocks(){
        createBlock();
        listOfBlocks = new ArrayList<>();
        this.listOfColors = new ArrayList<>();
        addBlockToList();
        addColorsToList();
    }

    public void createBlock(){
        tBlock = new int[][]{{0, 1, 0}, {1, 1, 1}};
        lBlock = new int[][]{{1, 0}, {1, 0}, {1, 1}};
        zBlock = new int[][]{{1,1,0},{0,1,1}};
        sBlock = new int[][]{{0,1,1},{1,1,0}};
        iBlock = new int[][]{{1},{1},{1},{1}};
        jBlock = new int[][]{{0,1},{0,1},{1,1}};
        oBlock = new int[][]{{1,1}, {1,1}};

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

    public void addColorsToList(){
        listOfColors.add(Color.white);
        listOfColors.add(Color.orange);
        listOfColors.add(Color.green);
        listOfColors.add(Color.red);
        listOfColors.add(Color.cyan);
        listOfColors.add(Color.pink);
        listOfColors.add(Color.yellow);
    }
    public ArrayList<int[][]> getBlockList(){
        return listOfBlocks;
    }
    public ArrayList<Color> getListOfColors(){return listOfColors;}
}
