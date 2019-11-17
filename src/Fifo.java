import java.util.*;
public class Fifo extends File{
    
    public Fifo(){
        this.file=new ArrayList();
        Q=0;
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
        return "FIFO";
    }
}
