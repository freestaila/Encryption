public class Vigener {

  private  String message;
  private String keyword;
  private String encrypted;
  private int[][] coder;
  private int[] messageAr;
  private int[] keywordAr;

  public Vigener(String message, String keyword){
        this.message = message;
        this.keyword = keyword;
      coderAr();
      messageArray();
      keywordArray();
      toString();
  }


  public int[][] coderAr(){
      int [][] coder = new int[26][26];
    int counter=65;
    int step=0;
    for(int i=0; i<26; i ++){
        for(int j =0; j< 26; j ++){
            if(counter>=91){
              //  coder[i][j]=counter;
                counter =65;
            } //jakis problem
            coder[i][j]=counter;
            counter++;
        }
        counter =65;
        step++;
        counter+=step;
        }
        /*
 for(int i=0; i<26; i ++){
          for(int j =0; j< 26; j ++){
              System.out.print((char)coder[i][j]);
          }
          System.out.println();
          }*/
        return this.coder = coder;
    }
    //Pobieranie stringa i ustawienie na duze litery dodatkowo usuwam spacje i kropki
    // Litery na inty by stworzyc z tego tablice dwuwymiarowa i przypisywac komorka komorki tablicy klucz
    public String getMessage(String message, String keyword){
      this.keyword= keyword.replaceAll("[^a-zA-Z]", "").toUpperCase();
       return this.message = message.replaceAll("[^a-zA-Z]", "").toUpperCase(); //zapisuje w klasie wiadomosc bez znakow i uppercase

    }
    //wstawienie wiadomosci do tablicy intow
    public int[] messageArray(){
       int[] messageArray = new int[this.message.length()];
        for(int i= 0; i< messageArray.length; i++){
            messageArray[i]=(int) message.charAt(i);
        }
        return this.messageAr= messageArray;
    }
    public int[] keywordArray(){
        int[] keywordArray = new int[this.keyword.length()];
        for(int i= 0; i< keywordArray.length; i++){
            keywordArray[i]=(int) keyword.charAt(i);
        }
        return this.keywordAr=keywordArray;
    }

    //szukanie po tablicy
    public String toString(){
      String encrypted= "";
      char holder;
      int messageInt;
      int keywordInt;
      int y=0;
        for(int i=0; i< messageAr.length; i++){
           if(y>=keywordAr.length)
            {
                y=0;
            }
                    messageInt = messageAr[i];
                    keywordInt = keywordAr[y];

                    holder = (char) (coder[messageInt-65][keywordInt-65]); //messageInt-65
                    encrypted += holder;
                    y++;
               }

        System.out.println("Message:" +this.message);
        System.out.println("Keyword:" +this.keyword);
        System.out.println("Your message is:" +encrypted);
        return this.encrypted=encrypted;
            }

}

