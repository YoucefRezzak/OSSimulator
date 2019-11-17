import java.util.*;
public abstract class File {
     ArrayList<Processus> file;
     Integer Q;
     public abstract void enfiler(Processus P);
     public abstract void defiler();
     public  String ecrire(){
         String s="";
         if(file.isEmpty()){
             return s;
         }
         for(int i=0;i<file.size();i++){
             s=s+file.get(i).identifiant+" ,";
         }
         return s;
     }
     
}
