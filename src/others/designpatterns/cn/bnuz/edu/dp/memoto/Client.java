package cn.bnuz.edu.dp.memoto;

public class Client {

	public static void main(String[] args) {
		//�����߱�������
		/*�������������ֱ༭����ͼ��༭��ÿ�β������ı��������ͼ������״̬���б�����
		 * Ȼ�������ڽ���Ctrl+z���˺�ctrl+yǰ��ʱӦ����θĽ������ؼ��ֵ��߼�
		 * 
		 */
		//1��������
		AlbumCarer ac = new  AlbumCarer();//����¼������
		NiuNiu nn = new NiuNiu(80,3,"2021-01-01",ac);
		//nn.growup();//״̬�仯
//		IMemoto memoto = nn.takePhoto();//n��ñ���
//		
//		ac.putMemoto(nn.getDesc(),memoto);	
		nn.growUp("2021-02-01");//״̬�仯
//		IMemoto memoto2 = nn.takePhoto();//n��ñ���
//		ac.putMemoto(nn.getDesc(),memoto);	
		nn.growUp("2021-03-01");//״̬�仯
		
		nn.growUp("2021-04-01");//״̬�仯
		//�����߻ָ�����
		IMemoto m1 = ac.getMemoto("2021-01-01");
		//m1.   ��Ϊ��ʶ�ӿڣ������Ҳ����κη������ı�ö����״̬����setter����
		nn.restore(m1);
		//NiuNiu.PhotoMemoto ph= nn.new PhotoMemoto(1,1);//�ڲ�˽����
		//nn.PhotoMemoto
		
	}

}
