package MyPrograms.Chapter_6;

public class AllCombination_6_5Apl {
    public static void main(String[] args) {
        String[] newVal = {"A", "B", "C"};

        AllCombinations allCombinations = new AllCombinations();

        allCombinations.showTeams();
    }
}

class AllCombinations {
    private int size;
    private char[] arrChar;
    private int count;

    void showTeams() {
        String input = "ABCDF";
        size = input.length();
        arrChar = new char[size];
        count = 0;
        for(int j=0; j<size; j++)
            arrChar[j] = input.charAt(j);
        doAnagram(size);
    }

    void doAnagram(int newSize)
      {
      int limit;
      if(newSize == 1)
         return;

      for(int j=0; j<newSize; j++)
         {
         doAnagram(newSize-1);
         if(newSize==2)
            displayWord();
         rotate(newSize);
         }
      }

   void rotate(int newSize)
      {
      int j;
      int position = size - newSize;
      char temp = arrChar[position];
      for(j=position+1; j<size; j++)
         arrChar[j-1] = arrChar[j];
      arrChar[j-1] = temp;
      }

   void displayWord()
      {
      if(count < 99)
         System.out.print(" ");
      if(count < 9)
         System.out.print(" ");
      System.out.print(++count + " ");
      for(int j=0; j<size; j++)
         System.out.print( arrChar[j] );
      System.out.print("   ");
      System.out.flush();
      if(count%6 == 0)
         System.out.println("");
      }
}