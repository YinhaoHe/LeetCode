# [LeetCode questions](./Notes/LeetCode_questions.md)

# Java tips

## String/StringBuilder:

- String.charAt();

- String.length();

- str.remove('a','b') 把str中的a都换成b

### split("分隔符的选择");

除撇号外，所有非字母数字的Java字符串拆分

```java
// 用除英文字符以外的所有符号 分割
words= Str.split("\\W+");
words = Str.split("[^\\w']+");
// 非特殊英文字符
words = Str.split("[^a-zA-Z0-9']+");
// 特殊英文字符 fiancée
words = Str.split("[^\\p{L}0-9']+");

```

### indexOf

```java
public int indexOf(String str)
public int indexOf(String str, int fromIndex) // 从index开始第一次出现的位置
public int indexOf(int char)
public int indexOf(int char, int fromIndex)
```

#### Parameter Values

| Parameter   | Description                                                  |
| :---------- | :----------------------------------------------------------- |
| *str*       | A `String` value, representing the string to search for      |
| *fromIndex* | An `int` value, representing the index position to start the search from |
| *char*      | An `int` value, representing a single character, e.g 'A', or a Unicode value |

#### Technical Details

| Returns: | An `int` value, representing the index of the first occurrence of the character in the string, or -1 if it never occurs |
| :------- | ------------------------------------------------------------ |
|          |                                                              |

### Java 数组转字符串 字符串转数组

#### 字符串转数组

使用Java split() 方法

split() 方法根据匹配给定的正则表达式来拆分字符串。

**注意：** . 、 | 和 * 等转义字符，必须得加 \\。多个分隔符，可以用 | 作为连字符。

```java
// 字符串转数组  java.lang.String
String str = "0,1,2,3,4,5";
String[] arr = str.split(","); // 用,分割
System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5]
```

#### 数组转字符串

- 方法一: 遍历

```java
String[] arr = { "0", "1", "2", "3", "4", "5" };
// 遍历
StringBuffer str5 = new StringBuffer();
for (String s : arr) {
    str5.append(s);
}
System.out.println(str5.toString()); // 012345
```

- 方法二: 使用StringUtils的join方法

```java
//数组转字符串 org.apache.commons.lang3.StringUtils
String str3 = StringUtils.join(arr); // 数组转字符串,其实使用的也是遍历
System.out.println(str3); // 012345
String str4 = StringUtils.join(arr, ","); // 数组转字符串(逗号分隔)(推荐)
System.out.println(str4); // 0,1,2,3,4,5
```

- 方法三: 使用ArrayUtils的toString方法

```java
// 数组转字符串 org.apache.commons.lang3.ArrayUtils
String str2 = ArrayUtils.toString(arr, ","); // 数组转字符串(逗号分隔,首尾加大括号)
System.out.println(str2); // {0,1,2,3,4,5}
```

## Integer parseInt vs valueOf

- 当我们需要的是一个基本类型** int **的时候我们需要使用`Integer.parseInt()`函数
- 当我们需要的是一个**Integer**对象类的时候我们就是用`Integer.valueOf()`函数

## Lambda expression

(a, b) -> a - b 

accept a and b, then return a-b

## CompareTo

Use ASCII to compare, bigger return possitive number, smaller return negetive number, equal return 0. 

## sort

(a, b) -> a[0] - b[0]	sort from small to big

(a, b) -> b[0] - a[0]	sort from big to small

## for

```java

public static void main(String args[]) {
		int[] integers = { 1, 2, 3, 4, 5 };
		for (int i : integers) {
			System.out.println(i);
		}
	}



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
```

## Iterator()

不管内部数据类型

```java
import java.util.*;
public class Muster {
 
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator it = list.iterator();
        while(it.hasNext()){
            String str = (String) it.next();
            System.out.println(str);
        }
    }
}
```

## valueOf()

删除头尾空字符 返回对应的结果

## Arrays.asList();

将数组转换成列表 可以直接System.out.println(list);

也可以list.get(1) list.remove(0) list.add(在末尾添加) 等等

list可以直接打印

## List

List.size();

## npm & yarn

```reStructuredText
npm install === yarn 
npm install taco --save === yarn add taco
npm uninstall taco --save === yarn remove taco
npm install taco --save-dev === yarn add taco --dev
npm update --save === yarn upgrade
```

```
npm i === yarn
npm i taco === yarn add taco
npm un taco === yarn remove taco
npm i -D taco === yarn add taco --dev
npm up === yarn upgrade
```

## Java generics 

Java 定义一个泛型类

```java
public class Box<T> {
   
  private T t;
 
  public void add(T t) {
    this.t = t;
  }
 
  public T get() {
    return t;
  }
 
  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<Integer>();
    Box<String> stringBox = new Box<String>();
 
    integerBox.add(new Integer(10));
    stringBox.add(new String("菜鸟教程"));
 
    System.out.printf("整型值为 :%d\n\n", integerBox.get());
    System.out.printf("字符串为 :%s\n", stringBox.get());
  }
}
```

Java 使用泛型方法

```java
public class GenericMethodTest
{
   // 泛型方法 printArray                         
   public static < E > void printArray( E[] inputArray )
   {
      // 输出数组元素            
         for ( E element : inputArray ){        
            System.out.printf( "%s ", element );
         }
         System.out.println();
    }
 
    public static void main( String args[] )
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
 
        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组
 
        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组
 
        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
    } 
}
```

# DS

## Hashmap(traversal):

```java
Hashmap<Integer,Integer> map=new HashMap<>()

for(Map.Entry<Integer, String> entry: map.entrySet()) {
  entry.getKey();
  entry.getValue();
}

  Map<String, String> map = new HashMap<String, String>();    
  map.put("key1", "value1");    
  map.put("key2", "value2");    
  map.put("key3", "value3");    
      
  //第一种：普遍使用，二次取值    
  System.out.println("通过Map.keySet遍历key和value：");    
  for (String key : map.keySet()) {    
   System.out.println("key= "+ key + " and value= " + map.get(key));    
  }    
      
  //第二种    
  System.out.println("通过Map.entrySet使用iterator遍历key和value：");    
  Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();    
  while (it.hasNext()) {    
   Map.Entry<String, String> entry = it.next();    
   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());    
  }    
      
 //第三种：推荐，尤其是容量大时</span>    
  System.out.println("通过Map.entrySet遍历key和value");    
  for (Map.Entry<String, String> entry : map.entrySet()) {    
   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());    
  }    
    
  //第四种    
  System.out.println("通过Map.values()遍历所有的value，但不能遍历key");    
  for (String v : map.values()) {    
   System.out.println("value= " + v);    
  }



```
## HashMap Get key according to Value

```java
// Approach1
public static Object getKey(Map map, Object value){
    List<Object> keyList = new ArrayList<>();
    for(Object key: map.keySet()){
        if(map.get(key).equals(value)){
            keyList.add(key);
        }
    }
    return keyList;
}

// Approach2
public static Object getKey(Map map, Object value){
    Set set = map.entrySet(); //通过entrySet()方法把map中的每个键值对变成对应成Set集合中的一个对象
    Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
    ArrayList<Object> arrayList = new ArrayList();
    while(iterator.hasNext()){
        //Map.Entry是一种类型，指向map中的一个键值对组成的对象
        Map.Entry<Object, Object> entry = iterator.next();
        if(entry.getValue().equals(value)){
            arrayList.add(entry.getKey());
        }
    }
    return arrayList;
}
```



## HashSet:

set.add(): 
Return Value: The function returns True if the element is not present in the HashSet otherwise False if the element is already present in the HashSet.

## Treemap:

A Red-Black tree based NavigableMap implementation. The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used. This implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.

```java
    class TreeCompare implements Comparator<String> 
    { 
        /* Compares keys based on the  
           last word's natural ordering */
        public int compare(String a, String b) 
        { 
            
            return a.compareToIgnoreCase(b); 
         
        } 
          
    }

    TreeMap<String, Double> tm = new TreeMap<>(new TreeCompare()); 

    tm.containsKey(Object key);
    tm.containsValue(Object value);
    tm.fistKey();//return the lowest key currently in map
    tm.lastKey();//get the last key in sorted map
    tm.remove(Object key);
    


```
## Queue:

```java
//add()和remove()方法在失败的时候会抛出异常(不推荐)
  Queue<String> queue = new LinkedList<String>();
//添加元素
  queue.offer("a");
```
- offer，add 区别：

    一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一     个 unchecked 异常，而只是得到由 offer() 返回的 false。

- poll，remove 区别：

    remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似， 但是新的 poll() 方法在用空集合调用时不是     抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。

- peek，element区别：
    element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
    
## PriorityQueue:

```java
//Default min heap, max heap is n2-n1
  PriorityQueue<Item> queue=new PriorityQueue<>((n1,n2)->{
            int count=n1.count-n2.count;
            return count;
            });


```

## Array:

```java
Arrays.fill(dp,0);


int[][]A={
    {4,3,4,5,3},
    {2,7,3,8,4},
    {1,7,6,5,2},
    {8,4,9,5,5}
        };
   

public static <T> T[] copyOfRange(T[] original,
                                  int from,
                                  int to)

System.out.println(Arrays.toString(arr));

```

## ArrayList:

```java
List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");

```

## Collection:

### [toArray](https://www.baeldung.com/java-collection-toarray-methods)

#### Collection.toArray()

The *toArray()* method allocates a new in-memory array with a length equal to the size of the collection. **Internally,** **it invokes the \*[Arrays.copyOf](https://www.baeldung.com/java-array-copy)\* on the underlying array backing the collection**. Therefore, the returned array has no references to it and is safe to use:

```java
Object[] naturalNumbersArray = naturalNumbers.toArray();
```

However, we cannot merely cast the result into an *Integer[].* Doing so will result in a [*ClassCastException*](https://www.baeldung.com/java-classcastexception).

#### Collection.toArray(T[] a)

Unlike the non-parameterized method, this one accepts a pre-allocated array as an argument. Additionally, the use of [Generics](https://www.baeldung.com/java-generics) in the method's definition mandates having the same type for the input and the returned array. This also solves the previously observed problem of iterating over an *Object[]*.

This variant works distinctively based on the size of the input array:

- If the length of the pre-allocated array is less than the collection's size, a new array of the required length and the same type is allocated: 
- `new Integer[0]`预定长度不够会重新分配

```java
Integer[] naturalNumbersArray = naturalNumbers.toArray(new Integer[0]);
```

- If the input array is large enough to contain the collection's elements, it's returned with those elements inside:
- `new Integer[naturalNumbers.size]`长度够则正好放进去

```java
Integer[] naturalNumbersArray = naturalNumbers.toArray(new Integer[naturalNumbers.size]);
```

```java
Collections.reverse(arraylist);
Collections.binarySearch(list,key);
Collections.singletonList(Obj);//return an immutable list containing only the specified object
Collections.sort(list,(p1, p2) -> p1.firstName.compareTo(p2.firstName));

```

## Union Find:

```java
  class UnionFind{
        public int parent[];
        int rank[];
        public UnionFind(int len){
            parent=new int[len];
            rank=new int[len];
            Arrays.fill(rank,0);
            for(int i=0;i<len;i++){
                parent[i]=i;
            }
        }
        public int Find(int index){//return the root index
            if(index==parent[index])return index;
            int parentIndex=Find(parent[index]);
            parent[index]=parentIndex;
            return parentIndex;
        }
        public void Union(int i1,int i2){
            int p1=Find(i1);
            int p2=Find(i2);
            if(p1==p2)return;
            if(rank[i1]==rank[i2]){
                parent[p2]=p1;
                rank[p1]++;
            }else if(rank[i1]>rank[i2]){
                parent[p2]=p1;
                rank[p1]++;
            }else if(rank[i1]<rank[i2]){
                parent[p1]=p2;
                rank[p2]++;
            }
        }       
}
```

复杂度:

Find( ): O(1)
Union( ): O(1)
Space: O(n)

## Quick Find:

**注意，quicksort这种partition的方法会打乱原来的relative order的顺序**


## BinaryTree:

### Inorder Traversal:

左->root->右


### Preorder Traversal:

root->左->右

### Postorder Traversal:

左->右->root

## Graph:

## BinaryOperations:

```
A XOR A = 0
```


## 常识：

## 闰年规则：

## IP地址规则：

for a segment:

1. less or equal to 255
2. the first character could be '0' only if the segment is equal to '0'

e.g. "010010" should not be interpreted as 01,00,1,0

## 打代码时候必须注意的坑：

1. 注意区分array中的index和value，别用混
2. 注意Integer和String这种Object比较时候用 .intValue() .equals()
3. binary search或者涉及到sliding window，two pointer 的题注意事先写好开闭区间
4. 涉及到Integer的问题一定注意Overflow的问题！如果可以的话用Long
5. 涉及到字符串的问题一定要考虑到有重复字母的testcase
6. Linkedlist 注意check null，fakehead必要时引入
7. Buy stock 问题是不用考虑底边长的，跟储水问题不一样
8. BFS DFS 注意成环问题,必要时用visited[]
9. StringBuilder 使用的时候记得每一层都用一个new
