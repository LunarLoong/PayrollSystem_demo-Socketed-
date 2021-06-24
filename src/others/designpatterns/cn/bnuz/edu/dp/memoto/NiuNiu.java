package cn.bnuz.edu.dp.memoto;

public class NiuNiu {
	private double height;
	private double weight;
	private String desc;
	private AlbumCarer ac;
	
	//回退方法，按照备忘顺序进行反方向恢复，可连续操作，关键是如何对备忘集合如何进行正向和反向导航
	public void undo() {
		
	}
	//前进方法，按照备忘顺序进行顺序恢复，可连续操作
	public void redo() {
		
	}
	
	public NiuNiu(double height, double weight, String desc,AlbumCarer ac) {
		super();
		this.height = height;
		this.weight = weight;
		this.desc = desc;
		this.ac = ac;
		//对初始状态进行备忘
				IMemoto memoto = takePhoto();//n获得备忘
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

	public void growUp(String key) {//发起者状态变化后可以开始再次备忘
		this.height += 2;
		this.weight += 4;
		this.desc = key;
		//可以在每次状态变化时进行备忘
		IMemoto memoto = takePhoto();//n获得备忘
		ac.putMemoto(key,memoto);
	}

	public IMemoto takePhoto() {
		PhotoMemoto pm = new PhotoMemoto(height,weight);
		return pm;
	}

	public void restore(IMemoto m1) {
		PhotoMemoto pm = (PhotoMemoto)m1;
		//将任何一个备忘录对象进行类型转换为内部类实例，只有在niuniu类中可以进行类型强制转换
		this.height = pm.getHeight();
		this.weight = pm.getWeight();
		
	}
	//内部私有类，实现标识接口IMemoto
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
