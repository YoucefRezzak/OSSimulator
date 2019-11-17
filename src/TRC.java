import java.util.*;
public class TRC extends File {
    public TRC(){
        this.file=new ArrayList();
        Q=0;
    }
    @Override
    public void enfiler(Processus P){
       boolean a=true;
        int i=0;
        while((a)&&(i<file.size())){
           if(this.file.get(i).tempsRestant()>P.tempsRestant()){
               this.file.add(i,P);
               a=false;
           }
           i++;
        }
        if(a){
            this.file.add(P);
        }
    }
    @Override
    public void defiler(){
       this.file.remove(0);
    }
    @Override
    public String toString(){
        return "TRC";
    }
}
