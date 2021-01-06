
class List
{
   int  value;
   List next;
}

public class HelpList
{
   /* =====================================================
      InsertList(h,e): write the algorithm in Java first !

      Compile with:  javac HelpList.java
      Run with:      java HelpList

      Correct output:
			List = 30
			List = 30 50
			List = 10 30 50
			List = 10 30 40 50
			List = 10 20 30 40 50
      ===================================================== */
   public static List insertList(List h, List e)
   {
         // Write a RECURSIVE InsertList( ) method in Java FIRST and 
	 // USE the Java code to help you write the assembler subroutine !!!
	List help = new List();

        if(h == null || e.value < h.value){
            help.value = e.value;
            help.next = h;
             e.next = null;
            return help;

        }
        else{
           
            help = insertList(h.next, e);
            h.next = help;
            e.next = null;
            return h;
        }


   }

   public static void main(String[] args)
   {
      int[] v = {30, 50, 10, 40, 20};
      List head = null;
      List elem;

      for ( int i = 0; i < v.length; i++ )
      {
         elem = new List(); 

         elem.value = v[i];
         elem.next  = elem;	// **** Put some junk in next

         head = insertList(head, elem);
         System.out.print("List = ");
         PrintList( head );
         System.out.println();
      }
   }

   public static void PrintList(List h)
   {
      if ( h == null )
         return;
      else
      {
	 System.out.print(h.value + " ");
	 PrintList(h.next);
      }
   }
}

