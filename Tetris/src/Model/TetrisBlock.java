package Model;
import java.util.*;

public class TetrisBlock  {
   private int[][] tBlock;
    private int[][] lBlock;
    private int[][] zBlock;
    private int[][] sBlock;
    private int[][] iBlock;
    private int[][] oBlock;
    private int[][] jBlock;



   private ArrayList<int[][]> listOfBlocks;
   public TetrisBlock(){
       createBlock();
       listOfBlocks = new ArrayList<>();
       addBlockToList();
   }

   public void createBlock(){
       tBlock = new int[][]{{0, 1, 0}, {1, 1, 1}};
       lBlock = new int[][]{{1, 0}, {1, 0}, {1, 1}};
       zBlock = new int[][]{{1,1,0},{0,1,1}};
       sBlock = new int[][]{{0,1,1},{1,1,0}};
       iBlock = new int[][]{{1},{1},{1},{1}};
       jBlock = new int[][]{{0,1},{0,1},{1,1}};
       oBlock = new int[][]{{1,1},{1,1}};
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

   public ArrayList<int[][]> getBlockList(){
      return listOfBlocks;
   }
}
