package com.meidusa.amoeba.oracle.packet;

import java.io.UnsupportedEncodingException;

import com.meidusa.amoeba.packet.AbstractPacketBuffer;

/**
 * ���ݿ�汾��Ϣ���ݰ�
 * 
 * @author hexianmao
 * @version 2008-8-14 ����07:32:33
 */
public class T4C7OversionDataPacket extends T4CTTIMsgDataPacket {

    @Override
    protected void init(AbstractPacketBuffer buffer) {
        super.init(buffer);
    }

    @Override
    protected void write2Buffer(AbstractPacketBuffer buffer) throws UnsupportedEncodingException {
        super.write2Buffer(buffer);
    }

    @Override
	protected Class<? extends AbstractPacketBuffer> getBufferClass() {
		return T4CPacketBuffer.class;
	}
}