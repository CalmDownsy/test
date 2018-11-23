/**
 * 
 */
package datastructure;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Stack;

/**
 * @author Wendy
 *
 */
public class InToPost {
	private Stack theStack;
	private String input;
	private String output = "";

	
	//String input = "1+2*4/5-7+3/6";
	public InToPost(String in) {
		input = in;
		int stackSize = input.length();  //13
		theStack = new Stack(stackSize);  //13
	}

	
	//String input = "1+2*4/5-7+3/6";
	public String doTrans() {
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);//循环input的第0-12位的内容
			switch (ch) {
			case '+':
			case '-':
			    // 第二次 + 此时 top == -1 不走 while 循环  进push top = 0 stackArray[0] = +
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
			    //第四次 * 此时 top == 0 走 while 循环  进 pop 取出stackArray[0] = + 且top-1 = -1
                //prec2 = 1 < prec1 = 2 进 push top = 0 stackArray[0] = +
                //跳出循环 进push top = 1 stackArray = [+, *]

                //第六次 / 此时top == 1 走 while 循环 进 pop 取出stackArray[1] = * 且 top-1 = 0
                //prec2 = 2 = prec1 = 2 进 else output = 124*
                //循环第二次 pop 取出stackArray[0] = + 且 top-1 = -1
                //prec2 = 1 < prec1 = 2 进 push top = 0 stackArray[0] = +
                //跳出循环 进push top = 0 stackArray = [*]
				gotOper(ch, 2);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
			    // 第一次 1 output = 1
                //第三次 2 output = 12
                //第5次 4 output = 124
                //第7次 5 output = 124*5
				output = output + ch;
				break;
			}
		}
		while (!theStack.isEmpty()) {
			output = output + theStack.pop();
		}
		System.out.println(output);
		return output;
	}

	public void gotOper(char opThis, int prec1) {
		//非空为真的时候执行以下代码
        //初始化stack top为-1 char数组为13
		while (!theStack.isEmpty()) {   //为空的标准是 top == -1
			char opTop = theStack.pop();
			if (opTop == '(') {
				theStack.push(opTop);
				break;
			//为空的时候执行以下代码	
			} else {
				int prec2;
				//为+或为-时，prec2=1
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				//为+或为-时，prec2=2
				else
					prec2 = 2;
				
				//prec2小于传入的1/2时
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else
					output = output + opTop;
			}
		}
		theStack.push(opThis);
	}

	public void gotParen(char ch) {
		while (!theStack.isEmpty()) {
			char chx = theStack.pop();
			if (chx == '(')
				break;
			else
				output = output + chx;
		}
	}

	public static void main(String[] args) throws IOException {
		String input = "1+2*4/5-7+3/6";
		String output;
		InToPost theTrans = new InToPost(input);
		output = theTrans.doTrans();//到此处
		System.out.println("Postfix is " + output + '\n');
	}

	class Stack {
		private int maxSize;
		private char[] stackArray;
		private int top;

		public Stack(int max) {
			maxSize = max;
			stackArray = new char[maxSize];
			top = -1;
		}

		public void push(char j) {
			stackArray[++top] = j;
		}

		public char pop() {
			return stackArray[top--];
		}

		public char peek() {
			return stackArray[top];
		}

		public boolean isEmpty() {
			return (top == -1);
		}
	}
}