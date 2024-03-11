package src.floppydisk;

import java.util.Map;
import java.util.TreeMap;

public class FloppyDisk<T> {

    public TreeMap<Integer, T> dataList;
    private final long maxCapacity = 1474560L;

    public FloppyDisk(){
        this.dataList = new TreeMap<>();
    };

    // TODO: gets the element at the index in inupt
    public T positionHead(Integer index){
        return this.dataList.get(index);
    }

    // TODO read data, through key and value
    public Map<Integer, T > readData(){
     return this.dataList;
    }

    public void writeData(T data){
        this.dataList.put(generateKey(),data);
    }

    // TODO read data, thorugh key and value
    public void formatFloppy(){
         this.dataList.clear();
    }

    // TODO: can't write and format
    public boolean activateNotepad(){
        return true;
    }

    // TODO: can write and format
    public boolean disactivateNotepad(){
        return false;
    }

    public Integer generateKey(){
        if (!dataList.isEmpty()){
            Integer lastKey = dataList.lastKey();
            return  lastKey +1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "FloppyDisk{" +
                "dataList=" + dataList +
                '}';
    }
}
