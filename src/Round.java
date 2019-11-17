import java.util.*;
public class Round extends File {
    
    public Round(Integer Q){
        this.file=new ArrayList();
        this.Q=Q;
    }
    @Override
    public void enfiler(Processus P){
       this.file.add(P);
    }
    @Override
    public void defiler(){
       this.file.remove(0);
    }
    @Override
    public String toString(){
        return "RR";
    }
}
