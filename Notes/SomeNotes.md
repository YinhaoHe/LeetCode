### Lambda expression

(a, b) -> a - b 

accept a and b, then return a-b

### CompareTo

Use ASCII to compare, bigger return possitive number, smaller return negetive number, equal return 0. 

### sort

(a, b) -> a[0] - b[0]	sort from small to big

(a, b) -> b[0] - a[0]	sort from big to small

### for

1. public static void main(String args[]) {
2. ​		int[] integers = { 1, 2, 3, 4, 5 };
3. ​		for (int i : integers) {
4. ​			System.out.println(i);
5. ​		}
6. ​	}



public static void main(String args[]) {
		String[] strings = { "小马", "小刘", "小张", "小王" };
		Collection stringList = java.util.Arrays.asList(strings);
		for (Object i : stringList) {
			System.out.println(i);
		}
	}



public static void main(String args[]) {
		String[] strings = { "小马", "小刘", "小张", "小王" };
		Collection stringList = java.util.Arrays.asList(strings);
		Iterator itr2 = stringList.iterator();
		while (itr2.hasNext()) {
			Object str = itr2.next();
			System.out.println(str);
		}

	}
### valueOf()

删除头尾空字符 返回对应的结果

### Arrays.asList();

将数组转换成列表 可以直接System.out.println(list);

也可以list.get(1) list.remove(0) list.add(在末尾添加) 等等

list可以直接打印

### String

String.charAt();

String.length();

str.remove('a','b') 把str中的a都换成b

### List

List.size();

### Python string index

H E L L O

0 1 2 3 4

0 -4 -3 -2 -1

-1 Always stands for the last character in the string.