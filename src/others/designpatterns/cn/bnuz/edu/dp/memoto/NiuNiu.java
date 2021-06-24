package cn.bnuz.edu.dp.memoto;

public class NiuNiu {
	private double height;
	private double weight;
	private String desc;
	private AlbumCarer ac;
	
	//���˷��������ձ���˳����з�����ָ����������������ؼ�����ζԱ���������ν�������ͷ��򵼺�
	public void undo() {
		
	}
	//ǰ�����������ձ���˳�����˳��ָ�������������
	public void redo() {
		
	}
	
	public NiuNiu(double height, double weight, String desc,AlbumCarer ac) {
		super();
		this.height = height;
		this.weight = weight;
		this.desc = desc;
		this.ac = ac;
		//�Գ�ʼ״̬���б���
				IMemoto memoto = takePhoto();//n��ñ���
				ac.putMemoto(desc,memoto);
	}
	

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void growUp(String key) {//������״̬�仯����Կ�ʼ�ٴα���
		this.height += 2;
		this.weight += 4;
		this.desc = key;
		//������ÿ��״̬�仯ʱ���б���
		IMemoto memoto = takePhoto();//n��ñ���
		ac.putMemoto(key,memoto);
	}

	public IMemoto takePhoto() {
		PhotoMemoto pm = new PhotoMemoto(height,weight);
		return pm;
	}

	public void restore(IMemoto m1) {
		PhotoMemoto pm = (PhotoMemoto)m1;
		//���κ�һ������¼�����������ת��Ϊ�ڲ���ʵ����ֻ����niuniu���п��Խ�������ǿ��ת��
		this.height = pm.getHeight();
		this.weight = pm.getWeight();
		
	}
	//�ڲ�˽���࣬ʵ�ֱ�ʶ�ӿ�IMemoto
	private class PhotoMemoto implements IMemoto{
		private double height;
		private double weight;
		public PhotoMemoto(double height, double weight) {
			super();
			this.height = height;
			this.weight = weight;
		}
		public double getHeight() {
			return height;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		
	}

}
