package com.meidusa.amoeba.packet;

import java.nio.ByteBuffer;

/**
 * @author struct
 */
public class AbstractPacketBuffer implements PacketBuffer {

    protected int    length   = 0;

    protected int    position = 0;

    protected byte[] buffer   = null;

    public AbstractPacketBuffer(byte[] buf){
        buffer = new byte[buf.length + 1];
        System.arraycopy(buf, 0, buffer, 0, buf.length);
        setPacketLength(buffer.length);
        position = 0;
    }

    public AbstractPacketBuffer(int size){
        buffer = new byte[size];
        setPacketLength(buffer.length);
        position = 0;
    }

    /**
     * ����0����ǰλ�õ������ֽ�д�뵽ByteBuffer��,���ҽ�ByteBuffer.position���õ�0.
     */
    public ByteBuffer toByteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(getPacketLength());
        buffer.put(this.buffer, 0, getPacketLength());
        buffer.rewind();
        return buffer;
    }

    public int getPacketLength() {
        return length;
    }

    public void setPacketLength(int length) {
        this.length = length;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void writeByte(byte b) {
        ensureCapacity(1);
        buffer[position++] = b;
    }

    /**
     * ����buffer����
     */
    protected void ensureCapacity(int i) {
        if ((position + i) > getPacketLength()) {
            if ((position + i) < buffer.length) {
                setPacketLength(buffer.length);
            } else {
                int newLength = (int) (buffer.length * 1.25);

                if (newLength < (buffer.length + i)) {
                    newLength = buffer.length + (int) (i * 1.25);
                }

                byte[] newBytes = new byte[newLength];
                System.arraycopy(buffer, 0, newBytes, 0, buffer.length);
                buffer = newBytes;
                setPacketLength(buffer.length);
            }
        }
    }

}