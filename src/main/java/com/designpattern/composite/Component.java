package com.designpattern.composite;

//抽象组件
public interface Component {
	void operation();
}
//叶子组件
interface Leaf extends Component{

	
}
//容器组件
interface Composite extends Component{
	void addcompent(Component com);
	void delcompent(Component com);
	Component getComponent(int index);
}