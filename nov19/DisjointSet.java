package nov19;

import java.util.*;

public class DisjointSet {
    class Nd{
        int data;
        Nd parent;
        int rank;
    }

    private HashMap<Integer, Nd> map = new HashMap<>();

    public void createSet(int v){
        Nd nn = new Nd();
        nn.data = v;
        nn.parent = nn;
        nn.rank = 0;
        map.put(v, nn);
    }

    public int find(int v){
        Nd nn = map.get(v);
        return find(nn).data;
    }

    // private Nd find(Nd nn){
    //     if(nn.parent == nn){
    //         return nn;
    //     }
    //     return find(nn.parent);
    // }

    // With path compression
    private Nd find(Nd nn){
        if(nn.parent == nn){
            return nn;
        }
        Nd n = find(nn.parent);
        nn.parent = n;
        return n;
    }
    
    

    public void Union(int v1, int v2){
        Nd nn1 = map.get(v1);
        Nd nn2 = map.get(v2);

        Nd rn1 = find(nn1);
        Nd rn2 = find(nn2);

        if(rn1.rank == rn2.rank){
            rn1.parent = rn2;
            rn2.rank++;
        }
        else if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
        }
        else{
            rn1.parent = rn2;
        }
    }
}
