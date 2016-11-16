/**
 * Created by BB on 2016-11-16.
 */
public class TvModel implements Comparable<TvModel> {
    private String name;
    private String size;
    private int rtV4M;

    public TvModel(String name, String size, int rtV4M) {
        this.name = name;
        this.size = size;
        this.rtV4M = rtV4M;
    }

    public String toString(){
        return name + " - " + size +" diagonal (" + rtV4M +")";
    }

    @Override
    public int compareTo(TvModel o) {
        if (this.rtV4M > o.rtV4M) {
            return 1;
        } else if (this.rtV4M == o.rtV4M){
            return 0;
        } else {
            return -1;
        }
    }

}
