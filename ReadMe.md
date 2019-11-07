分页框架:MyPager
	PageHelper

分页更简单，我们做到不需要程序员写一行，就很好的实现分页效果
需求：
	程序员
	class UserService{
		@pager
		public List<User> findAll(){}
	}	
	框架能够自动分页
		标注和AOP:写标注和切面来实现这个框架
	目标：
		让程序员只关注自己该做的事情，若想分页的话就加几个简单标注就行
		线程池	
	实现：
		分析：以结果为导向去分析，或者以程序员用例来分析		
	编写步骤：
		（1）编写自定义注解
			@MiniPager:至少应该有个表明属性
		（2）编写切面（核心框架代码）
			a.要在配置类中启动AOP的功能
				@EnableAspectJAutoProxy
			b.编写自定义切面
				util:PagerAspect
			c.自定义切面中的切点
				@Pointcut("execution(* service..*(..)")//--检测service包及子包下的所有方法
				public void selfPointcut() {}	
			d.自定义通知（AroundA）
			测试：只要是调用service包下的类的方法，都应该输出“111”
			e.编写通知体里面的核心代码（实现通用分页的核心代码）
				I.只有在加入@MinIPager标注的方法上实现拦截功能
					思路：拿到被调用的方法对象Method对象，然后判断该方法上有没有@MiniPager标注；若有就加入切面功能
				II.这里就可以实现真正的分页逻辑
					
总结：
	MiniPager标注   Pager类  PagerAspect类					
			