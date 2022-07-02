package lmr.randomizer.dat.blocks.contents;

import lmr.randomizer.util.BlockDataConstants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thezerothcat on 7/27/2017.
 */
public class BlockListData implements BlockContents {
    private short idData;
    private short listSize;
    private List<Short> data = new ArrayList<>();

    public BlockListData(short idData, short listSize) {
        this.idData = idData;
        this.listSize = listSize;
    }

    public BlockListData(BlockListData objectToCopy) {
        this.idData = objectToCopy.idData;
        this.listSize = objectToCopy.listSize;
        data = new ArrayList<>(objectToCopy.data);
    }

    public BlockListData(short listSize) {
        this.idData = BlockDataConstants.DataList;
        this.listSize = listSize;
    }

    public List<Short> getData() {
        return data;
    }

    @Override
    public int getSize() {
        return data.size() * 2 + 4; // CMD, list length, then the list itself
    }

    @Override
    public List<Short> getRawData() {
        List<Short> rawData = new ArrayList<>();
        rawData.add(idData);
        rawData.add(listSize);
        for(int i = 0; i < data.size(); i++) {
            rawData.add(data.get(i));
        }
        return rawData;
    }

    @Override
    public void writeBytes(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(idData);
        dataOutputStream.writeShort(listSize);
        for(int i = 0; i < data.size(); i++) {
            dataOutputStream.writeShort(data.get(i));
        }
    }
}
