
public class Statique extends Memoire {
    Integer TP;
    int t[];
    final int n_tranches;
    public Statique(Integer a,Integer n){
        n_tranches=n;
        Taille=a;
        TP=(int)Taille/n_tranches;
        this.t=new int[n_tranches];
        for(int i=0;i<n_tranches;i++){
            this.t[i]=-1;
        }
    }
//    @Override
//    public void vider(File f,Processus E,Processus P){
//        int i=0;
//    }
    @Override
    public boolean ajouter(Processus P) {
        boolean a=false;
        int i=0;
        if(P.taille>TP){
            return a;
        }
        else{
            while( !a &&i<this.n_tranches){
                if(t[i]==-1){
                    t[i]=P.identifiant;
                    a=true;
                }
                i++;
            }
        }
        return a;
    }

    @Override
    public void supprimer(Processus P) {
        for(int i=0;i<n_tranches;i++){
            if(t[i]==P.identifiant){
                t[i]=-1;
            }
        }
    }
    @Override
    public String ecrire(){
        String s="";
        int i=0;  boolean a=true;
        while(i<n_tranches){
            if(t[i]!=-1){
                s=s+"["+(i)*TP+";"+t[i]+";"+(i+1)*TP+"]";
                i++;
            }
            else{
                if((t[i]==-1)&&(i<n_tranches)){
                    s=s+"["+i*TP+";";
                }
                while((i<n_tranches)&&(t[i]==-1)){
                    i++;
                }
                s=s+(i)*TP+"]";
            }
        }
        return s;
    }
}
