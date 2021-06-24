package cn.bnuz.edu.dp.memoto;

public class Client {

	public static void main(String[] args) {
		//发起者备忘过程
		/*考虑我们在文字编辑或者图像编辑的每次操作给文本对象或者图像对象的状态进行备忘，
		 * 然后我们在进行Ctrl+z后退和ctrl+y前进时应该如何改进备忘关键字的逻辑
		 * 
		 */
		//1、发起者
		AlbumCarer ac = new  AlbumCarer();//备忘录管理者
		NiuNiu nn = new NiuNiu(80,3,"2021-01-01",ac);
		//nn.growup();//状态变化
//		IMemoto memoto = nn.takePhoto();//n获得备忘
//		
//		ac.putMemoto(nn.getDesc(),memoto);	
		nn.growUp("2021-02-01");//状态变化
//		IMemoto memoto2 = nn.takePhoto();//n获得备忘
//		ac.putMemoto(nn.getDesc(),memoto);	
		nn.growUp("2021-03-01");//状态变化
		
		nn.growUp("2021-04-01");//状态变化
		//发起者恢复过程
		IMemoto m1 = ac.getMemoto("2021-01-01");
		//m1.   因为标识接口，所以找不到任何方法来改变该对象的状态，如setter方法
		nn.restore(m1);
		//NiuNiu.PhotoMemoto ph= nn.new PhotoMemoto(1,1);//内部私有类
		//nn.PhotoMemoto
		
	}

}
