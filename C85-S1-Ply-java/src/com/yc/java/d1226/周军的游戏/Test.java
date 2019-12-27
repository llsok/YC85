package com.yc.java.d1226.周军的游戏;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    	Person p=new Person();
		p.name="周军";
		p.age=20;
		p.gender="男";
		p.show();
		职业 s=new 职业();
		s.liliang=20;
		s.minjie=20;
		s.zhili=10;
		s.naili=10;
		/**
		 * 转职区域
		 */
		Scanner h=new Scanner(System.in);
		while(true) {
		if(s.liliang>=10 && s.zhili>=10 && s.minjie>=10 && s.naili>=10) {
			 if(s.zhili>=16 && s.liliang>=16 && s.minjie>=16) {
				 System.out.println(p.name+"先生你符合转职法师，战士和游侠的条件请选泽：1 法师，2战士,3游侠！");
				 int a=h.nextInt();
				 if(a==1) {
					 法师 b=new 法师();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }if(a==2) {
					 战士 b=new 战士();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }if(a==3) {
					 游侠 b=new 游侠();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }
			}else if(s.liliang>=16 &&s.zhili>=16) {
				System.out.println(p.name+"先生你符合转职法师和战士的条件请选泽：1 法师，2战士！");
				int a=h.nextInt();
				 if(a==2) {
					 战士 b=new 战士();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }if(a==1) {
					 法师 b=new 法师();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p); 
					 break;
				 }
			}else if(s.liliang>=16 && s.minjie>=16 ) {
				System.out.println(p.name+"先生你符合转职游侠和战士的条件请选泽：1 游侠，2战士！");
				int a=h.nextInt();
				if(a==2) {
					 战士 b=new 战士();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }if(a==1) {
					 游侠 b=new 游侠();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }
			}else if(s.minjie>=16&&s.zhili>=16) {
				System.out.println(p.name+"先生你符合转职游侠和法师的条件请选泽：1 游侠，2法师！");
				int a=h.nextInt();
				if(a==2) {
					法师 b=new 法师();
					b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p); 
					 break;
				 }if(a==1) {
					 游侠 b=new 游侠();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }
			}else if(s.minjie>=16) {
				System.out.println(p.name+"先生你符合转职游侠条件请选泽：1 确定！");
				int a=h.nextInt();
				if(a==1) {
					 游侠 b=new 游侠();
					 b.liliang=s.liliang;
					 b.minjie=s.minjie;
					 b.zhili=s.zhili;
					 b.naili=s.naili;
					 b.choose(p);
					 break;
				 }
		}else if(s.liliang>=16) {
			System.out.println(p.name+"先生你符合转职战士条件请选泽：1 确定！");
			int a=h.nextInt();
			if(a==1) {
				 战士 b=new 战士();
				 b.liliang=s.liliang;
				 b.minjie=s.minjie;
				 b.zhili=s.zhili;
				 b.naili=s.naili;
				 b.choose(p);
				 break;
			 }
		}else if(s.zhili>=16) {
			System.out.println(p.name+"先生你符合转职法师条件请选泽：1 确定！");
			int a=h.nextInt();
			if(a==1) {
				法师 b=new 法师();
				b.liliang=s.liliang;
				 b.minjie=s.minjie;
				 b.zhili=s.zhili;
				 b.naili=s.naili;
				 b.choose(p); 
				 break;
			 }
		}	 
		}
		}
		/**
		 * 升级区域
		 */
		b:while(true) {
		System.out.println("选择区域：1升级区域，2第二次转职区域");
		int j=h.nextInt();
		if(j==1) {
		while(true) {
		System.out.println("请选择作战区域：1火焰山，2大泽，3竹林，4沙漠");
		int a=h.nextInt();
		System.out.println();
		while(true) {
		if(a==1) {
			System.out.println("你已进入火焰山！");
			System.out.println("前方出现火焰龟选择是否作战：5攻击，6逃跑");
		    int b=h.nextInt();
		    if(b==5) {
			    System.out.println("你已击杀火焰龟");
			    s.liliang+=2;s.zhili++;s.naili++;s.minjie++;
			    System.out.println("是否继续深入：1继续，2回城");
			    int c=h.nextInt();if(c==1) {
			    	for(int i=0;i<=9;i++) {
			    		System.out.println("前方出现火焰龟选择作战：5攻击");
			    		if(b==5) {
			    			System.out.println("你已击杀火焰龟");
						    s.liliang+=2;s.zhili++;s.naili++;s.minjie++;
			    		}
			    	}
			    	System.out.println("前方出现火焰龟王选择作战：5攻击");
			    	System.out.println("你已击杀火焰龟王");
				    s.liliang+=10;s.zhili+=3;s.naili+=3;s.minjie+=3;
				    continue b;
			    }if(c==2) {continue b;}
			    
			    
		 }if(b==6) {
			  System.out.println("逃跑成功！");
			  continue b;
		  }
		} if(a==2) {
			System.out.println("你已进入大泽山！");
			System.out.println("前方出现箭蛙选择是否作战：5攻击，6逃跑");
			int b=h.nextInt();
			  if(b==5) {
				  System.out.println("你已击杀箭蛙！");
				  s.liliang++;s.zhili+=2;s.naili++;s.minjie++;
				  System.out.println("是否继续深入：1继续，2回城");
				    int c=h.nextInt();if(c==1) {
				    	for(int i=0;i<=9;i++) {
				    		System.out.println("前方出现箭蛙选择作战：5攻击");
				    		if(b==5) {
				    			System.out.println("你已击杀箭蛙");
							    s.liliang++;s.zhili+=2;s.naili++;s.minjie++;
				    		}
				    	}
				    	System.out.println("前方出现箭蛙王选择作战：5攻击");
				    	System.out.println("你已击杀箭蛙王");
					    s.liliang+=3;s.zhili+=10;s.naili+=3;s.minjie+=3;
					    continue b;
				    }if(c==2) {continue b;}
			  }if(b==6) {
				  System.out.println("逃跑成功！");
				  continue b;
			  }
		} if(a==3) {
			System.out.println("你已进入竹林！");
			System.out.println("前方出现竹叶青选择是否作战：5攻击，6逃跑");
			int b=h.nextInt();
			  if(b==5) {
				  System.out.println("你已击杀竹叶青");
				  s.liliang++;s.zhili++;s.naili++;s.minjie+=2;
				  System.out.println("是否继续深入：1继续，2回城");
				    int c=h.nextInt();if(c==1) {
				    	for(int i=0;i<=9;i++) {
				    		System.out.println("前方出现竹叶青选择作战：5攻击");
				    		if(b==5) {
				    			System.out.println("你已击杀竹叶青");
							    s.liliang++;s.zhili++;s.naili++;s.minjie+=2;
				    		}
				    	}
				    	System.out.println("前方出现竹叶青王选择作战：5攻击");
				    	System.out.println("你已击杀竹叶青王");
					    s.liliang+=3;s.zhili+=3;s.naili+=3;s.minjie+=10;
					    continue b;
				    }if(c==2) {continue b;}
			  }if(b==6) {
				  System.out.println("逃跑成功！");
				  continue b;
			  }
		} if(a==4) {
			System.out.println("你已进入沙漠！");
			System.out.println("前方出现沙蝎选择是否作战：5攻击，6逃跑");
			int b=h.nextInt();
			  if(b==5) {
				  System.out.println("你已击杀沙蝎");
				  s.liliang++;s.zhili++;s.naili+=2;s.minjie++;
				  System.out.println("是否继续深入：1继续，2回城");
				    int c=h.nextInt();if(c==1) {
				    	for(int i=0;i<=9;i++) {
				    		System.out.println("前方出现沙蝎选择作战：5攻击");
				    		if(b==5) {
				    			System.out.println("你已击杀沙蝎");
							    s.liliang+=2;s.zhili++;s.naili++;s.minjie++;
				    		}
				    	}
				    	System.out.println("前方出现沙蝎王选择作战：5攻击");
				    	System.out.println("你已击杀沙蝎王");
					    s.liliang+=10;s.zhili+=3;s.naili+=3;s.minjie+=3;
					    continue b;
				    }if(c==2) {continue b;}
			  }if(b==6) {
				  System.out.println("逃跑成功！");
				  continue b;
			  }
		}}}
		}
		/**
		 * 第二次转职
		 */
		if(j==2) {
			System.out.println("你已进入第二次转职区域！");
			System.out.println("你的智力"+s.zhili);
		    System.out.println("你的力量"+s.liliang);
		    System.out.println("你的敏捷"+s.minjie);
		    System.out.println("你的耐力"+s.naili);
		    if(s.liliang>=24 && s.zhili>=24 && s.minjie>=24 && s.naili>=24) {
		    	if(s.liliang>50) {
		    		System.out.println("选择你的二转职业：1狂战士，2圣骑士，3剑圣");
		    		int g=h.nextInt();
		    		if(g==1) {
		    			狂战士 p1=new 狂战士();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}if(g==2) {
		    			圣骑士 p1=new 圣骑士();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}if(g==3) {
		    			剑圣 p1=new 剑圣();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}
		    	}else if(s.zhili>50) {
		    		System.out.println("选择你的二转职业：1召唤师，2牧师，3巫师");
		    		int g=h.nextInt();
		    		if(g==1) {
		    			召唤师 p1=new 召唤师();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}if(g==2) {
		    			牧师 p1=new 牧师();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}if(g==3) {
		    			巫师 p1=new 巫师();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}
		    		
		    	}else if(s.minjie>50) {
		    		System.out.println("选择你的二转职业：1盗贼，2神箭手，3武僧");
		    		int g=h.nextInt();
		    		if(g==1) {
		    			盗贼 p1=new 盗贼();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}if(g==2) {
		    			神箭手 p1=new 神箭手();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}if(g==3) {
		    			武僧 p1=new 武僧();
		    			p1.liliang=s.liliang;
						 p1.minjie=s.minjie;
						 p1.zhili=s.zhili;
						 p1.naili=s.naili;
						 p1.choose();
						 break;
		    		}
		    	}
		    }else {
		    	System.out.println("你没达到转职要求！");
		    	continue b;
		    }
		}
		
		}
		
    }
}

