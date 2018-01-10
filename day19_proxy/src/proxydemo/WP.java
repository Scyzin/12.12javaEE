package proxydemo;
//这是一个代理的人

public class WP implements KindWomen{
	
	private KindWomen kw;
	
	public WP(KindWomen kw) {
		this.kw = kw;
	}
	

	@Override
	public void throwEye(double money) {
		kw.throwEye(money);
	}

	@Override
	public void doSomething(double money) {
		kw.doSomething(money);
	}
	
}
