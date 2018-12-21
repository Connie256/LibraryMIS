package edu.yangtzeu.lmis.model;

import java.lang.reflect.Method;

public class AbstractModel {
	public Object getFieldValue(Class<?> objectClass,String methodName)
			throws Exception{
		Method[] allMethods = objectClass.getDeclaredMethods();//��ȡ�����е����з���
		for (Method m : allMethods){
			String mname = m.getName();
			if(mname.equals(methodName)){
				return m.invoke(this,null);
			}
		}
		return null;
	}

}
