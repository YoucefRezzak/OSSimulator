import java.util.*;
public class Processus {
    public ArrayList<Integer> Tranches;
    int tempsDariver;
    int i;
    int t;
    int identifiant;
    Integer taille;
    static int id=0;
    Integer tempsDeCalcule;
    Integer tempsEx;
    public Processus(Integer taillee,Integer temp){
        identifiant=id;
        this.tempsDariver=temp;
        id++;
        i=0;
        t=0;
        tempsEx=0;
        this.tempsDeCalcule=0;
        taille=taillee;
        this.Tranches= new ArrayList();
    }
    public void ajouter_tranche(Integer a){
        this.Tranches.add(a);
        this.tempsDeCalcule+=a;
    }
    public Integer tempsRestant(){
        Integer a=0;
        if((t>=Tranches.get(i))&&(i>=Tranches.size())){
            return 0;
        }
        for(int j=i;this.Tranches.size()>j;j++){
            if(i==j){
                a=a+this.Tranches.get(j)-t;
            }
            else{
                a+=this.Tranches.get(j);
            }
        }
        return a;
    }
    
}
