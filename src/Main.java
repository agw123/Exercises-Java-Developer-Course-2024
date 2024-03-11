package src;

import src.floppydisk.FloppyDisk;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FloppyDisk floppyDisk = new FloppyDisk<>();

        floppyDisk.writeData("yeah");
        floppyDisk.writeData("12331");


        floppyDisk.writeData("lorem");
        floppyDisk.dataList.put(3, "456");
        floppyDisk.dataList.put(1, 456);

        floppyDisk.writeData('b');
        floppyDisk.writeData(981);
        floppyDisk.writeData("asda1221");
        Set keysList = floppyDisk.dataList.keySet();
        System.out.println(keysList);
        floppyDisk.formatFloppy();
        System.out.println(floppyDisk);
        floppyDisk.writeData(3213);
        floppyDisk.writeData(3213);

        System.out.println(floppyDisk);

    }
}
