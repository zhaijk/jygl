package com.derun.commnuication;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//@Service
//@Scope("prototype")
public class setOnOffLineComm extends abstractCommnuication{

	public setOnOffLineComm(){
		command=protocolInfo.ONLINE;		//����
		data=new byte[0];					//����
		respLength=3;						//��Ӧ����
		this.sendbuff=new byte[6];			//���ͻ�����
		this.recvbuff=new byte[6];			//���ջ�����
	}
	
	public int  setOnLineStatus(){	
		//System.out.println("��������");
		return super.query(protocolInfo.ONLINE);
	}
	
	public int  setOffLineStatus(){
		return super.query(protocolInfo.OFFLINE);
	}	
	
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==2){//�жϷ������ݳ���
			if(recvbuff[2]==protocolInfo.fnChecksumCalc(recvbuff,1,2))	//У���
				return 0;
		}
		return -1;
	}

}
