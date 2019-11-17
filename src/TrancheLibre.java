
public class TrancheLibre extends TrancheMemoire {
    public TrancheLibre(Integer d,Integer t){
        debut=d;
        taille=t;
        fin=debut+taille;
        id=-1;
    }
    @Override
    public String toString(){
        return "TrancheLibre";
    }
    @Override
    public String ecrire(){
        return "["+debut+";"+fin+"]";
    }
}
