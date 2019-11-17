import java.util.*;
public class Dynamique extends Memoire {
    ArrayList<TrancheMemoire> M;
    public Dynamique(Integer t){
        Taille=t;
        M=new ArrayList();
        M.add(new TrancheLibre(0,t));
    }
    @Override
    public boolean ajouter(Processus P) {
        int i=0; boolean a=false;
        while((i<M.size())&& (!a)){
            if(M.get(i).toString().equals("TrancheLibre")){
                if((M.get(i).taille>=P.taille)){
                    M.add(i,new TranchePrise(M.get(i).debut,P.taille,P.identifiant));
                    M.get(i+1).debut+=P.taille;
                    M.get(i+1).taille-=P.taille;
                    a=true;
                    
                }
            }
            i++;
        }
        return a;
    }

    @Override
    public void supprimer(Processus P) {
        int i=0; boolean a=false,b=true;
        Integer d,t;
        if(!M.isEmpty()){
            i=0;
            
            while(M.get(i).id!=P.identifiant&&(i<M.size())){
                i++;
            }
            if(!enfin(i)&&(M.get(i+1).toString().equals("TrancheLibre"))){
                M.get(i+1).debut=M.get(i).debut;
                M.get(i+1).taille+=M.get(i).taille;
                M.remove(i);
                a=true;
                
            }
            if(!debut(i)&&(M.get(i-1).toString().equals("TrancheLibre"))){
                M.get(i-1).taille+=M.get(i).taille;
                M.get(i-1).fin=M.get(i).fin;
                M.remove(i);
                a=true;
            }
            if(!a){
                if(!debut(i)&&!enfin(i)){
                    d=M.get(i).debut;
                    t=M.get(i).taille;
                    M.remove(i);
                    M.add(i,new TrancheLibre(d,t));
                }
            }
            if(debut(i)){
               if(!enfin(i)&&(M.get(i+1).toString().equals("TrancheLibre"))){
                M.get(i+1).debut=M.get(i).debut;
                M.get(i+1).taille+=M.get(i).taille;
                M.remove(i);
                }
               else{
                    d=M.get(i).debut;
                    t=M.get(i).taille;
                    M.remove(i);
                    M.add(i,new TrancheLibre(d,t)); 
               }
            }
            if(enfin(i)){
                if(!debut(i)&&(M.get(i-1).toString().equals("TrancheLibre"))){
                M.get(i-1).taille+=M.get(i).taille;
                M.get(i-1).fin=M.get(i).fin;
                M.remove(i);
                }
                else{
                    d=M.get(i).debut;
                    t=M.get(i).taille;
                    M.remove(i);
                    M.add(i,new TrancheLibre(d,t));
                }
            }
//        while((i<M.size())&& (!a)){
//            if(M.get(i).id==P.identifiant){
//                if((i!=0)&&(i<(M.size()-2))){
//                    if(M.get(i-1).toString().equals("TrancheLibre")){
//                        M.get(i-1).taille+=M.get(i).taille;
//                        M.get(i-1).fin=M.get(i-1).debut+M.get(i-1).taille;
//                        M.remove(i);
//                        
//                    }
//                
//                    if(M.get(i+1).toString().equals("TrancheLibre")){
//                        M.get(i+1).taille+=M.get(i).taille;
//                        M.get(i+1).debut=M.get(i).debut;
//                        M.get(i+1).fin=M.get(i+1).taille+M.get(i+1).debut;
//                        M.remove(i);
//                    }
//                    if(!(M.get(i-1).toString().equals("TrancheLibre"))&&!(M.get(i+1).toString().equals("TrancheLibre"))){
//                        d=M.get(i).debut;
//                        t=M.get(i).taille;
//                        M.remove(i);
//                        M.add(i,new TrancheLibre(d,t));
//                    }
//                }
//            
//               
//                if(i==0){
//                    if(!(M.get(i+1).toString().equals("TrancheLibre"))){
//                        d=M.get(i).debut;
//                        t=M.get(i).taille;
//                        M.remove(i);
//                        M.add(i,new TrancheLibre(d,t));
//                    }
//                    else{
//                        M.get(i+1).taille+=M.get(i).taille;
//                        M.get(i+1).debut=M.get(i).debut;
//                        M.get(i+1).fin=M.get(i+1).taille+M.get(i+1).debut;
//                        M.remove(i);
//                    }
//                }
//                if(i==(M.size()-1)){
//                    if(!(M.get(i-1).toString().equals("TrancheLibre"))){
//                        d=M.get(i).debut;
//                        t=M.get(i).taille;
//                        M.remove(i);
//                        M.add(i,new TrancheLibre(d,t));
//                    }
//                    else{
//                        M.get(i-1).taille+=M.get(i).taille;
//                        M.get(i-1).debut=M.get(i).debut;
//                        M.get(i-1).fin=M.get(i-1).taille+M.get(i-1).debut;
//                        M.remove(i);
//                    }
//                }
//                a=true;
//            }
//            for(i=0;i<M.size();i++){
//            if(west(i)){
//                if((M.get(i).toString().equals("TrancheLibre"))&&(M.get(i+1).toString().equals("TrancheLibre"))){
//                    d=M.get(i).debut;
//                    t=M.get(i+1).taille+M.get(i).taille;
//                    M.remove(i);
//                    M.remove(i+1);
//                    M.add(i,new TrancheLibre(d,t));
//                    b=false;
//                }
//            }
//            if(i==(M.size()-2)){
//                if(b){
//                if((M.get(i-1).toString().equals("TrancheLibre"))&&(M.get(i).toString().equals("TrancheLibre"))){
//                    d=M.get(i-1).debut;
//                    t=M.get(i).taille+M.get(i-1).taille;
//                    M.remove(i-1);
//                    M.remove(i);
//                    M.add(i-1,new TrancheLibre(d,t));
//                }
//                }
//                else{
//                   if((M.get(i-2).toString().equals("TrancheLibre"))&&(M.get(i-1).toString().equals("TrancheLibre"))){
//                    d=M.get(i-2).debut;
//                    t=M.get(i-1).taille+M.get(i-2).taille;
//                    M.remove(i-2);
//                    M.remove(i-1);
//                    M.add(i-2,new TrancheLibre(d,t));
//                } 
//                }
//            }
//            }
//            i++;
//        }
    }
    }
    @Override
    public String toString(){
        return "Dynamique";
    }
    @Override
    public String ecrire(){
        String s="";
        for(int i=0;i<M.size();i++){
            s=s+M.get(i).ecrire();
        }
        return s;
    }
    public boolean west(int i){
        return (i>0)&&(i<M.size()-1);
    }
    public boolean debut(int i){
        return (i==0);
    }
    public boolean enfin (int i){
        return(i==M.size()-1);
    }
//    @Override
//    public void vider(File f,Processus E,Processus P){
//        boolean a=false; int d,t;
//        for(int i=0;i<M.size();i++){
//            a=false;
//            for(int j=0;j<f.file.size();j++){
//                if(E!=null){
//                if((f.file.get(j).identifiant==M.get(i).id)||(M.get(i).id==E.identifiant)){
//                    a=true;
//                }
//                }
//                if(P!=null){
//                    if((f.file.get(j).identifiant==M.get(i).id)||(M.get(i).id==P.identifiant)){
//                        a=true;
//                    }
//                }
//            }
//            if(!a){
//                d=M.get(i).debut;
//                    t=M.get(i).taille;
//                    M.remove(i);
//                    M.add(i,new TrancheLibre(d,t));
//            }
//        }
//    }
}
