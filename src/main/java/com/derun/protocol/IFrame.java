package com.derun.protocol;

public interface  IFrame {
	
	public void setFrameParam(int sendLength,int recvLength,byte command,int byterespLength,byte[] sendbuff,byte[] recvbuff);
	public void setCommParam(int gunID,int channelID,byte[] sendbuff);
	public void makeupSendbuff(byte[] sendbuff);
	public void analyRecvbuff(byte[] recvbuff);
	
}
