package com.derun.commnuication;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

//@Service
//@Scope("prototype")
public class ClearQuotas extends abstractCommnuication{
	
	public ClearQuotas(){
		command=ProtocolInfo.CLEARQUOTAREC;//����
		data=new byte[0];					//����
		respLength=3;						//��Ӧ����
		this.sendbuff=new byte[6];			//���ͻ�����
		this.recvbuff=new byte[6];			//���ջ�����
		delaycounter=20;
	}
	
	@Override
	public int analyRecvbuff(){
		if(recvbuff[0]==2){//�жϷ������ݳ���
			if(recvbuff[2]==ProtocolInfo.fnChecksumCalc(recvbuff,1,2))	//У���
				return 0;
		}
		return -1;
	}

}