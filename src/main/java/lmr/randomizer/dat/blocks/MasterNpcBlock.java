package lmr.randomizer.dat.blocks;

import lmr.randomizer.dat.blocks.contents.BlockCmdSingle;
import lmr.randomizer.dat.blocks.contents.BlockStringData;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thezerothcat on 9/8/2019.
 */
public class MasterNpcBlock extends Block {
    private BlockCmdSingle textCard;
    private BlockCmdSingle background;
    private BlockCmdSingle npcCard;
    private BlockCmdSingle music;

    private BlockStringData npcName;

    public MasterNpcBlock(int blockNumber) {
        super(blockNumber);
    }

    public MasterNpcBlock(int textCard, int background, int npcCard, int music, BlockStringData npcName) {
        super();
        this.textCard = new BlockCmdSingle((short)textCard);
        this.background = new BlockCmdSingle((short)background);
        this.npcCard = new BlockCmdSingle((short)npcCard);
        this.music = new BlockCmdSingle((short)music);
        this.npcName = npcName;
    }

    public BlockCmdSingle getTextCard() {
        return textCard;
    }

    public void setTextCard(BlockCmdSingle textCard) {
        this.textCard = textCard;
    }

    public BlockCmdSingle getBackground() {
        return background;
    }

    public void setBackground(BlockCmdSingle background) {
        this.background = background;
    }

    public BlockCmdSingle getNpcCard() {
        return npcCard;
    }

    public void setNpcCard(BlockCmdSingle npcCard) {
        this.npcCard = npcCard;
    }

    public BlockCmdSingle getMusic() {
        return music;
    }

    public void setMusic(BlockCmdSingle music) {
        this.music = music;
    }

    public BlockStringData getNpcName() {
        return npcName;
    }

    public void setNpcName(BlockStringData npcName) {
        this.npcName = npcName;
    }

    @Override
    public int getBlockSize() {
        int size = textCard.getSize();
        size += background.getSize();
        size += npcCard.getSize();
        size += music.getSize();
        size += npcName.getSize();
        return size;
    }

    @Override
    public List<Short> getRawData() {
        List<Short> rawData = new ArrayList<>();
        rawData.add((short)getBlockSize());

        rawData.addAll(textCard.getRawData());
        rawData.addAll(background.getRawData());
        rawData.addAll(npcCard.getRawData());
        rawData.addAll(music.getRawData());

        rawData.addAll(npcName.getRawData());
        return rawData;
    }

    @Override
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(getBlockSize());

        textCard.writeBytes(dataOutputStream);
        background.writeBytes(dataOutputStream);
        npcCard.writeBytes(dataOutputStream);
        music.writeBytes(dataOutputStream);

        npcName.writeBytes(dataOutputStream);
    }
}
