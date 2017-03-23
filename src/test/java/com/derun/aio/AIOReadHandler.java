package com.derun.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.ExecutionException;

public class AIOReadHandler implements CompletionHandler<Integer, ByteBuffer> {

	private AsynchronousSocketChannel socket; 
	 
    public AIOReadHandler(AsynchronousSocketChannel socket) { 
        this.socket = socket; 
    } 
 
    public void cancelled(ByteBuffer attachment) { 
        System.out.println("cancelled"); 
    } 
 
    private CharsetDecoder decoder = Charset.forName("GBK").newDecoder(); 
 
    public void completed(Integer i, ByteBuffer buf) { 
        if (i > 0) { 
            buf.flip(); 
            try { 
                System.out.println("�յ�" + socket.getRemoteAddress().toString() + "����Ϣ:" + decoder.decode(buf)); 
                buf.compact();
                Thread.sleep(1000);
                socket.write(ByteBuffer.wrap(("���񷵻�����......").getBytes())).get();
            } catch (CharacterCodingException e) { 
                e.printStackTrace(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            socket.read(buf, buf, this); 
        } else if (i == -1) { 
            try { 
                System.out.println("�ͻ��˶���:" + socket.getRemoteAddress().toString()); 
                buf = null; 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
 
    public void failed(Throwable exc, ByteBuffer buf) { 
        System.out.println(exc); 
    } 

}
