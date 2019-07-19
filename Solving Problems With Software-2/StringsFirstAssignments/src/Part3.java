public class Part3 {
  public boolean twoOccurrences(String stringa,String stringb)
  {
      int count = 0;
      if(stringb.indexOf(stringa)==-1)
          return false;
      else if(stringb.indexOf(stringa,stringb.indexOf(stringa)+1)==-1)
          return false;
      return true;
  }
  public String lastPart(String stringa,String stringb)
  {
      int firstIdx = stringb.indexOf(stringa);
      if(firstIdx==-1)
          return stringb;
      return stringb.substring(firstIdx+stringa.length());
  }
  public void testing()
  {
      String as[] = {"by","a","atg"};
      String bs[] = {"A story by Abby Long","banana","ctgtatgta"};
      for(int i=0;i<as.length;i++)
      {
          boolean res = twoOccurrences(as[i],bs[i]);
          System.out.println(as[i]+" "+bs[i]+" "+res);
      }
      String as1[] = {"an","zoo"};
      String bs1[] = {"banana","forest"};
      for(int i=0;i<as1.length;i++)
          System.out.println(as1[i]+"  "+bs1[i]+"  "+lastPart(as1[i],bs1[i]));
  }
  public static void main(String args[])
  {
      Part3 obj = new Part3();
      obj.testing();
  }
}
