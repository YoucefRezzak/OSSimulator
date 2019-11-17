
public class TranchePrise extends TrancheMemoire {
    
    public TranchePrise(Integer d,Integer t,int i){
        debut=d;
        taille=t;
        fin=debut+taille;
        id=i;
    }
    @Override
    public String toString(){
        return "TranchePrise";
    }

    @Override
    public String ecrire() {
        return "["+debut+";"+id+";"+fin+"]";
    }
}
