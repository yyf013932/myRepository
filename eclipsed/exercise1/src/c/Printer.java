package c;

public interface Printer {

//	��������ַ������е������������������Ϊ��
//	���롰abcde���������edcba�������롰1234���������4321����
	void print1(String s);
	
//	��������ַ������е������������������Ϊ��
//	���롰abcde�������    c
//									  bcd
//									 abcde 
//	���롰1234�������    23
//									1234
//	�������״Ϊ��������
	void print2(String s);
	
//	����һ������ĸ��ɵ��ַ������硰vxKjhAeSXdfa����������ĸ˳�򣬴�ӡ��
//	��ǰ�����ĸ����������ĸ����������ַ���Ϊ������ӡ����a x����
//	�������ĸ��Сд������
	void print3(String s);
	
//	����һ�����֣��ı���ʽ���������֡�
//	��������Ϊ��First Middle Last�������Ϊ��Last, First M.��
//	MΪmiddle name�ĵ�һ����ĸ
	void print4(String s);
}
