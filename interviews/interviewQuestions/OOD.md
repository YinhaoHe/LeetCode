# OOD

- [OOD](#ood)
  * [ReferenceManager](#referencemanager)
  * [Getter与Setter](#getter-setter)
  * [形状工厂](#Shape-Factory)
  * [发布订阅模式](#pub-sub)
  * [友谊服务](#Follower followering)
  * [单例](#Singleton)
  * [设计kindle OO Design](#kindle-oo-design)
  * [自动咖啡机OOD](#coffee machine ood)
  * [Google File System](#google-file-system)
  * [银行系统设计](#Bank System Design)
  * [二十一点 OO Design](#21-oo-design)
  * [设计餐厅 OO Design](#restaurant-oo-design)
  * [Design tic tac toe](#design-tic-tac-toe)
  * [Design a parking lot](#design-a-parking-lot)
  * [自动售货机 OO Design](#Vending Machine OO Design)
  * [电梯系统 OO Design](#Elevator System OOD)

## ReferenceManager

### Description

Implement the class ReferenceManager. Include the following two methods:

1. `copyValue(Node obj)`. This would just copy the value from parameter *obj* to the public attribute *node*. But *obj* and *node* are still two difference instances / objects.
2. `copyReference(Node obj)`. This would copy the reference from *obj* to *node*. So that both *node* and *obj* are point to the same object.

### Example

ReferenceManager ref = ReferenceManager();
Node obj = new Node(0);
ref.copyValue(obj);
ref.node.val; // will be 0
ref.node; // will be different with obj.

```java
Node obj2 = new Node(1);
ref.copyReference(obj2);
ref.node.val; // will be 1
ref.node; // will be the same with obj2
```

### Solution

```java
public class ReferenceManager {
    public Node node;

    public void copyValue(Node obj) {
        if (obj == null) {
            return;
        }
        if (node == null) {
            node = new Node(obj.val);
        }
        node.val = obj.val;
    }

    public void copyReference(Node obj) {
        node = obj;
    }
}
```

[Back to top](#OOD)

---

## Getter Setter

### Description

Implement a class `School`, including the following attributes and methods:

1. A private attribute `name` of type string.
2. A setter method `setName` which expect a parameter `name` of type string.
3. A getter method `getName` which expect no parameter and return the `name` of the school.

### Example

```java
Java:
    School school = new School();
    school.setName("MIT");
    school.getName(); // should return "MIT" as a result.

Python:
    school = School();
    school.setName("MIT")
    school.getName() # should return "MIT" as a result.
```

### Solution

```java
public class School {
    /*
     * Declare a private attribute *name* of type string.
     */
    private String name;
    
    /**
     * Declare a setter method `setName` which expect a parameter *name*.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Declare a getter method `getName` which expect no parameter and return
     * the name of this school
     */
    public String getName() {
        return this.name;
    }
}
```

[Back to top](#OOD)

---

## Shape Factory

**形状工厂**

### Description

工厂模式是一种常见的设计模式。实现一个形状工厂 `ShapeFactory` 来创建不同的形状类。这里我们假设只有三角形，正方形和矩形三种形状。

### Example

例1:

```java
输入:
ShapeFactory sf = new ShapeFactory();
Shape shape = sf.getShape("Square");
shape.draw();
输出:
  ----
 |    |
 |    |
  ----
```

例2:

```java
输入:
ShapeFactory sf = new ShapeFactory();
shape = sf.getShape("Triangle");
shape.draw();
输出:
   /\
  /  \
 /____\
```

例3:

```java
输入:
ShapeFactory sf = new ShapeFactory();
shape = sf.getShape("Rectangle");
shape.draw();
输出:
  ----
 |    |
  ----
```

### Solution

```java
/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    // Write your code here
    @Override
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
   }
}

class Square implements Shape {
    // Write your code here
   @Override
   public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
   }
}

class Triangle implements Shape {
    // Write your code here
   @Override
   public void draw() {
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");
   }
}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        // Write your code here
        if (shapeType == null) {
            return null;
        }    	
        if (shapeType.equalsIgnoreCase("Triangle")) {
            return new Triangle();
        } else if(shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();         
        } else if(shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}
```

[Back to top](#OOD)

---

## Pub sub

**发布订阅模式**

### Description

发布/订阅模式是系统设计中广泛使用的模式。 在此问题中，您需要实现发布/订阅模式以支持特定频道上的用户订阅，并从订阅的频道获取通知消息。

您需要实现3种方法：

- `subscribe（channel，user_id）`：将给定用户订阅到给定频道。
- `unsubscribe（channel，user_id）`：取消订阅给定用户的给定用户。
- `publish（channel，message）`：您需要将消息发布到频道，以便在频道上订阅的每个人都会收到此消息。 调用`PushNotification.notify（user_id，message）`将消息推送给用户。

### Example

```java
subscribe("group1",  1)
publish("group1", "hello")
>> user 1 received "Hello"
subscribe("group1", 2)
publish("group1", "thank you")
>> user 1 received "thank you"
>> user 2 received "thank you"
unsubscribe("group2", 3)
>> user 3 is not in group2, do nothing
unsubscribe("group1", 1)
publish("group1", "thank you very much")
>> user 2 received "thank you very much"
publish("group2", "are you ok?")
>> # you don't need to push this message to anyone
```

如果在同一频道上订阅的用户超过1个，则用户接收该消息的时间顺序无关紧要。 您可以在将消息推送给用户1之前推送给用户2。

### Solution

```java
/* Definition of PushNotification
 * class PushNotification {
 *     public static void notify(int user_id, String the_message)
 *  };
 */
public class PubSubPattern {
    private HashMap<String, HashSet<Integer>> channels;
    
    public PubSubPattern(){
        channels = new HashMap<String, HashSet<Integer>>();
    }
    
    /**
     * @param channel: 
     * @param user_id: 
     * @return: nothing
     */
    public void subscribe(String channel, int user_id) {
        if (!channels.containsKey(channel)) {
            channels.put(channel, new HashSet<Integer>());
        }
        HashSet<Integer> user_ids = channels.get(channel);
        user_ids.add(user_id);
    }

    /**
     * @param channel: 
     * @param user_id: 
     * @return: nothing
     */
    public void unsubscribe(String channel, int user_id) {
        if (!channels.containsKey(channel)) {
            return;
        }
        
        HashSet<Integer> user_ids = channels.get(channel);
        user_ids.remove(user_id);
    }

    /**
     * @param channel: 
     * @param message: 
     * @return: nothing
     */
    public void publish(String channel, String message) {
        if (!channels.containsKey(channel)) {
            return;
        }
        for (Integer user_id : channels.get(channel)) {
            PushNotification.notify(user_id, message);
        }
    }
}
```

[Back to top](#OOD)

---

## Follower followering

**友谊服务**

### Description

支持 follow & unfollow, getFollowers, getFollowings方法
注意：getfollow（）的结果是排序后的。

### Example

**Example 1**

```java
输入:
follow(1, 3)
getFollowers(1) 
getFollowings(3) 
follow(2, 3)
getFollowings(3) 
unfollow(1, 3)
getFollowings(3) 
输出:
[3]
[1]
[1,2]
[2]
解释:
follow(1, 3)
getFollowers(1) // return [3]
getFollowings(3) // return [1]
follow(2, 3)
getFollowings(3) // return [1,2]
unfollow(1, 3)
getFollowings(3) // return [2]
```

**Example 2**

```java
输入:
follow(1, 2)
unfollow(1, 2)
getFollowings(1)
unfollow(1, 2)
getFollowings(1)
unfollow(1, 2)
follow(1, 2)
getFollowings(1)
输出:
[]
[]
[]
```

### Solution

```java
public class FriendshipService { 

    private Map<Integer, Set<Integer>> followers, followings;

    public FriendshipService() {
        // initialize your data structure here.
        this.followers = new HashMap<Integer, Set<Integer>>();
        this.followings = new HashMap<Integer, Set<Integer>>();
    }

    // @param user_id an integer
    // return all followers and sort by user_id
    public List<Integer> getFollowers(int user_id) {
        // Write your code here
        if (!followers.containsKey(user_id))
            return new ArrayList<Integer>();

        return new ArrayList<Integer>(followers.get(user_id));
    }
        
    // @param user_id an integer
    // return all followings and sort by user_id
    public List<Integer>  getFollowings(int user_id) {
        // Write your code here
        if (!followings.containsKey(user_id))
            return new ArrayList<Integer>();

        return new ArrayList<Integer>(followings.get(user_id));
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int to_user_id, int from_user_id) {
        // Write your code here
        if (!followers.containsKey(to_user_id))
            followers.put(to_user_id, new TreeSet<Integer>());

        followers.get(to_user_id).add(from_user_id);

        if (!followings.containsKey(from_user_id))
            followings.put(from_user_id, new TreeSet<Integer>());

        followings.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int to_user_id, int from_user_id) {
        // Write your code here
        if (followers.containsKey(to_user_id))
            followers.get(to_user_id).remove(from_user_id);

        if (followings.containsKey(from_user_id))
            followings.get(from_user_id).remove(to_user_id);
    }
}
```

[Back to top](#OOD)

---

## Singleton 

**单例**

### Description

**单例** 是最为最常见的设计模式之一。对于任何时刻，如果某个类只存在且最多存在一个具体的实例，那么我们称这种设计模式为单例。例如，对于 class Mouse (不是动物的mouse哦)，我们应将其设计为 singleton 模式。

你的任务是设计一个 `getInstance` 方法，对于给定的类，每次调用 `getInstance` 时，都可得到同一个实例。

### Example

```java
在 Java 中:

	A a = A.getInstance();
	A b = A.getInstance();

a 应等于 b.
```

**挑战**

如果并发的调用 getInstance，你的程序也可以正确的执行么？

### Solution

**编写单例模式需要考虑的事情**
单例模式：任何时候获取的对象，应该是同一个

1. 需禁止类外使用new关键字构造对象，所以用private关键字修饰构造函数，将其私有化
2. 因为不能使用new关键字构建对象，所以我们需要暴露一个方法给外部，作为单例对象与外界沟通的唯一方式。使用静态方法是个不错的选择。
3. 多线程情况下，需要保证对象是单例的。

```java
// V1:双重检查+synchronized锁懒汉版
public class Solution{
    
    // 1. 私有单例对象，禁止通过 类名.属性 访问
    // 2. 将其声明为静态成员，使得在静态方法中得以访问
    // 3. 使用volatile关键字，消除指令重排序的影响
    private static volatile Solution instance;
    
    // 1. 私有构造函数
    private Soltion(){
        
    }
    
    // 静态方法，返回单例对象。双重检查+synchroinzed锁，保证多线程下instance对象唯一
    public static Solution getInstance(){
        if(instance == null){
            synchronized(Solution.class){
                if(instance == null){
                    // 多线程并发访问，只会有一个线程初始化成功
                    instance = new Soltion();
                }
            }
        }
        return instance;
            
    }
}
// V2: 静态内部类版
public class Solution{
    
    
    static class InnerClass{
        private static Solution instance = new Sotluion();
    }
    
    public static Solution getInstance(){
        return Solution.instance;
    }
    
}
// V3: 枚举类版
public enum Solution{
    INSTANCE;
    
    public static Solutin getInstance(){
        return Solution.INSTANCE;
    }
}
```

创建私有静态成员对象，每次获取时返回此对象。

```java
class Solution {
    
    
    /**
     * @return: The same instance of this class every time
     */
    public static Solution instance = null;
    public static Solution getInstance() {
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
};
```

[Back to top](#OOD)

---

## kindle OO Design

### Description

设计一个可以打开三种文件格式的Kindle，文件格式分别为：`PDF`, `MOBI` , `EPUB`。

- 尝试使用 ENUM 处理文件格式。
- 尝试使用 simple factory 设计模式为每种格式创建用户。

### Example

输入:

```java
readBook("EPUB")
readBook("PDF")
readBook("MOBI")
```

输出:

```java
Using EPUB reader, book content is: epub
Using PDF reader, book content is: pdf
Using MOBI reader, book content is: mobi
```

### Solution

```java
import java.util.ArrayList;
import java.util.List;

public class Kindle {
    private List<Book> books;
	private EBookReaderFactory readerFactory;

	public Kindle() {
		books = new ArrayList<>();
		readerFactory = new EBookReaderFactory();
	}

	public String readBook(Book book) throws Exception {
		EBookReader reader = readerFactory.createReader(book);
		if (reader == null) {
			throw new Exception("Can't read this format");
		}
		return reader.displayReaderType() + ", book content is: " + reader.readBook();
	}

	public void downloadBook(Book b) {
		books.add(b);
	}

	public void uploadBook(Book b) {
		books.add(b);
	}

	public void deleteBook(Book b) {
		books.remove(b);
	}
}

enum Format {
	EPUB("epub"), PDF("pdf"), MOBI("mobi");

	private String content;

	Format(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}

class Book {
	private Format format;

	public Book(Format format) {
		this.format = format;
	}

	public Format getFormat() {
		return format;
	}
}

abstract class EBookReader {
	
	protected Book book;
	
	public EBookReader(Book b){
		this.book = b;
	}
	
	public abstract String readBook();
	public abstract String displayReaderType();
}

class EBookReaderFactory {

	public EBookReader createReader(Book b) {
		if (b.getFormat() == Format.EPUB) {
			return new EpubReader(b);
		} else if (b.getFormat() == Format.MOBI) {
			return new MobiReader(b);
		} else if (b.getFormat() == Format.PDF) {
			return new PdfReader(b);
		} else
			return null;
	}
}

class EpubReader extends EBookReader{

	public EpubReader(Book b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readBook() {
		// TODO Auto-generated method stub
		return book.getFormat().getContent();
	}

	@Override
	public String displayReaderType() {
		// TODO Auto-generated method stub
		return "Using EPUB reader";
	}
}

class MobiReader extends EBookReader {

	public MobiReader(Book b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readBook() {
		// TODO Auto-generated method stub
		return book.getFormat().getContent();
	}

	@Override
	public String displayReaderType() {
		// TODO Auto-generated method stub
		return "Using MOBI reader";
	}

}
class PdfReader extends EBookReader{

	public PdfReader(Book b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readBook() {
		// TODO Auto-generated method stub
		return book.getFormat().getContent();
	}

	@Override
	public String displayReaderType() {
		// TODO Auto-generated method stub
		return "Using PDF reader";
	}
}
```

[Back to top](#OOD)

---

## Coffee Machine OOD

**自动咖啡机OOD**

### Description

设计一个自动咖啡机，加入一袋咖啡包，简单地煮一杯咖啡。

- 每个**咖啡包**包含有咖啡的配方，如加入了多少牛奶，或加入了多少糖
- 咖啡机可根据咖啡包提供的配方制作咖啡
- 只考虑**两种**成分成分：**糖（sugar）\**和\**牛奶（milk）**
- 普通咖啡的成本是**2元**。 加入一份**牛奶**或**糖**会使成本增加**0.5元**
- 考虑使用**Decorator Design Pattern**

### Example

输入:

```java
pack(2, 3)
makeCoffee()
```

输出:

```java
Cost for this coffee is: 4.5
Ingredients for this coffee is: Plain Coffee, Milk, Milk, Sugar, Sugar, Sugar
```

### Solution

```java
public class CoffeeMaker {

    public Coffee makeCoffee(CoffeePack pack) {
		Coffee coffee = new SimpleCoffee();

		for (int i = 0; i < pack.getNeededMilk(); i++) {
			coffee = new WithMilk(coffee);
		}

		for (int i = 0; i < pack.getNeededSugar(); i++) {
			coffee = new WithSugar(coffee);
		}

		return coffee;
	}
}

class CoffeePack {
	private int neededMilk;
	private int neededSugar;

	public CoffeePack(int neededMilk, int neededSugar) {
		this.neededMilk = neededMilk;
		this.neededSugar = neededSugar;
	}

	public int getNeededMilk() {
		return neededMilk;
	}

	public int getNeededSugar() {
		return neededSugar;
	}
}

interface Coffee {
	public double getCost();
	public String getIngredients();
}

class SimpleCoffee implements Coffee {

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getIngredients() {
		// TODO Auto-generated method stub
		return "Plain Coffee";
	}

}

abstract class CoffeeDecorator implements Coffee {
	protected final Coffee decoratedCoffee;

	public CoffeeDecorator(Coffee coffee) {
		this.decoratedCoffee = coffee;
	}

	public double getCost() {
		return decoratedCoffee.getCost();
	}

	public String getIngredients() {
		return decoratedCoffee.getIngredients();
	}
}

class WithMilk extends CoffeeDecorator {

	public WithMilk(Coffee coffee) {
		super(coffee);
	}

	public double getCost() {
		return super.getCost() + 0.5;
	}

	public String getIngredients() {
		return super.getIngredients() + ", Milk";
	}
}

class WithSugar extends CoffeeDecorator {

	public WithSugar(Coffee coffee) {
		super(coffee);
	}

	public double getCost() {
		return super.getCost() + 0.5;
	}

	public String getIngredients() {
		return super.getIngredients() + ", Sugar";
	}
}
```

[Back to top](#OOD)

---

## Google File System

### Description

为GFS(Google文件系统)实现一个简单的客户端，提供一下功能：
1.`read(文件名)`，通过文件名从GFS中读取文件。
2.`write(文件名，内容)`，通过文件名和内容写入GFS中。
现在有两种已经在基础类中实现的方法：
1.`readChunk(文件名，块索引)`，从GFS中读取一个块。
2.`writeChunk(文件名，块索引，块数据)`，向GFS中写入一个块。
为了简化这个问题，我们可以假设块大小为 *chunkSize* 位的(在真实的文件系统中，是64M)，GFS客户端的任务是将一个文件分为若干块(如果需要的话)并且保存在远端的GFS服务器上，*chunkSize*会在构造函数中给出，你需要的是实现`read`和`write`这两个private方法。

### Example

```java
GFSClient(5)
read("a.txt")
>> null
write("a.txt", "World")
>> You don't need to return anything, but you need to call writeChunk("a.txt", 0, "World") to write a 5 bytes chunk to GFS.
read("a.txt")
>> "World"
write("b.txt", "111112222233")
>> You need to save "11111" at chunk 0, "22222" at chunk 1, "33" at chunk 2.
write("b.txt", "aaaaabbbbb")
read("b.txt")
>> "aaaaabbbbb"
```

### Solution

```java
/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */
public class GFSClient extends BaseGFSClient {

    public int chunkSize;
    public Map<String, Integer> chunkNum;

    public GFSClient(int chunkSize) {
        // initialize your data structure here
        this.chunkSize = chunkSize;
        this.chunkNum = new HashMap<String, Integer>();
    }
    
    // @param filename a file name
    // @return conetent of the file given from GFS
    public String read(String filename) {
        // Write your code here
        if (!chunkNum.containsKey(filename))
            return null;

        StringBuffer content = new StringBuffer();

        for (int i = 0; i < chunkNum.get(filename); ++i) {
            String sub_content = readChunk(filename, i);
            if (sub_content != null)
                content.append(sub_content);
        }
        return content.toString();
    }

    // @param filename a file name
    // @param content a string
    // @return void
    public void write(String filename, String content) {
        // Write your code here
        int length = content.length();

        int num = (length - 1) / chunkSize + 1;
        chunkNum.put(filename, num);

        for (int i = 0; i < num; ++i) {
            int start = i * chunkSize;
            int end = i == num -1 ? length : (i + 1) * chunkSize; 
            String sub_content = content.substring(start, end);
            writeChunk(filename, i, sub_content);
        }
    }
}
```

[Back to top](#OOD)

---

## Bank System Design

**银行系统设计**

### Description

设计一个银行账户管理系统，实现以下三个函数：
1.void deposite(int id,int amount,long timestamp)
2.boolean withdraw(int id,int amount,long timestamp)
3.int[] check(int id,long startTime,long endTime)

id ： 用户账号ID
amoun : 用户存取钱的数目
timestamp ：用户存取钱的日期
startTime : 该日期时账号ID的余额
endTime ： 该日期账号ID 的余额

### Example

withdraw(0,100,0) //return false
deposite(0,100,1)
deposite(1,250,1)
withdraw(0,30,3) //return true
check(0,0,2) //[0,100]
deposite(1,5,7)
check(1,3,9) //[250,255]

### Solution

```java
public class BankSystem {

    private HashMap<Integer,TreeMap<Long,Integer>> bank;

    public BankSystem(){
        // Write your code here
        bank = new HashMap();
    }
    /**
     * @param id: user account id
     * @param amount: the number of bank deposits
     * @param timestamp: the data of bank transaction
     * @return: nothing
     */
    public void deposite(int id, int amount, long timestamp) {
        // Write your code here
        //银行有该账户的存款记录
        if(bank.containsKey(id))
        {
           
            TreeMap temp = bank.get(id);
            //返回图中的最后一个键值
            long lasttime = (long)temp.lastKey();

            temp.put(timestamp,(int)(temp.get(lasttime))+amount);
            bank.put(id,temp);

            System.out.println(id+"存款成功" + amount +  timestamp);

        }
        //原来无该账户，需要新建账户
        else
        {
            TreeMap<Long,Integer> temp = new TreeMap();
            temp.put(timestamp,amount);
            bank.put(id,temp);

            System.out.println(id+"存款成功" + amount + timestamp);
        }
    }

    /**
     * @param id: user account id
     * @param amount : the number of bank withdraw
     * @param timestamp: the data of bank transaction
     * @return: if user account can not withdraw the number of amount,return false. else return true
     */
    public boolean withdraw(int id, int amount , long timestamp) {
        //银行有该账户的存款记录
        if(bank.containsKey(id))
        {
            //该用户的所有记录
            TreeMap temp = bank.get(id);
            long lasttime = (long)temp.lastKey();

            //在最后一条记录之前取款，时间上不可能
            if(timestamp < lasttime)
                return false;
            else
            {
                int money = (int)temp.get(lasttime);
                System.out.println(id + "最后一笔存款"+money);
                //钱不够取
                if(amount > money)
                    return false;
                else
                {
                    temp.put(timestamp,money-amount);
                    bank.put(id,temp);
                }
                return true;

            }
        }
        return false;
    }

    /**
     * @param id: user account id
     * @param startTime: start time
     * @param endTime: end time
     * @return: need return two numbers,the first one is start time account balance,the second is end time account balance
     */
    public int[] check(int id, long startTime, long endTime) {
        //银行有该账户的存款记录
        int[] res = new int[2];
        if(bank.containsKey(id))
        {
             TreeMap temp = bank.get(id);
             
             //Map.Entry<Integer, Integer> entry : map.entrySet()
            Iterator<Map.Entry<Long, Integer>> it = temp.entrySet().iterator();
             while(it.hasNext())
             {
                 Map.Entry<Long, Integer> entry = it.next();
                 long a = (long)entry.getKey();
                 if(a<=startTime)
                    res[0] = (int)entry.getValue();
                if(a<=endTime)
                    res[1] = (int)entry.getValue();

             }
             return res;
             
        }
        return new int[0];

    }
}
```

[Back to top](#OOD)

---

## 21 OO Design

**二十一点 OO Design**

### Description

- 每位玩家起始有`1000`筹码
- 庄家有`10000`筹码
- 如果玩家获胜，双倍获得押注的筹码
- 庄家获胜，玩家押注的筹码归庄家
- 点数相同，庄家获胜
- A 可当做 `1` 或 `11`

### Example

```java
Player(10)
Player(100)
Player(500)
Card([1,4,2,3,1,4,2,3,9,10])
InitialCards()
compareResult()
```

输出:

```java
playerid: 1 ;Cards: 1 , 1; Current best value is: 12, current bets: 10, total bets: 990
playerid: 2 ;Cards: 4 , 4; Current best value is: 8, current bets: 100, total bets: 900
playerid: 3 ;Cards: 2 , 2; Current best value is: 4, current bets: 500, total bets: 500
Dealer Cards: 3 , 3; Current best value is: 6, total bets: 10000
playerid: 1 ;Cards: 1 , 1; Current best value is: 12, current bets: 0, total bets: 1010
playerid: 2 ;Cards: 4 , 4; Current best value is: 8, current bets: 0, total bets: 1100
playerid: 3 ;Cards: 2 , 2; Current best value is: 4, current bets: 0, total bets: 500
Dealer Cards: 3 , 3; Current best value is: 6, total bets: 10390
```

### Solution

```java
public class BlackJack {
    private List<NormalPlayer> players;
	private Dealer dealer;

	private List<Card> cards;

	public BlackJack() {
		players = new ArrayList<>();
		dealer = new Dealer();
	}

	public void initCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addPlayer(NormalPlayer p) {
		players.add(p);
	}


	public void dealInitialCards() {
		for (NormalPlayer player : players) {
			player.insertCard(dealNextCard());
		}

		dealer.insertCard(dealNextCard());

		for (NormalPlayer player : players) {
			player.insertCard(dealNextCard());
		}

		dealer.insertCard(dealNextCard());
	}

	public Card dealNextCard() {
		Card card = cards.remove(0);
		return card;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void compareResult() {
		for (NormalPlayer p : players) {
			if (dealer.largerThan(p)) {
				dealer.updateBets(p.getCurrentBets());
				p.lose();
			} else {
				dealer.updateBets(-p.getCurrentBets());
				p.win();
			}
		}
	}

	public String print() {
		String s = "";
		for (NormalPlayer player : players) {
			s += "playerid: " + (player.getId() + 1) + " ;" + player.printPlayer();
		}
		return s;
	}
}


class NormalPlayer {
	private BlackJack game;
	private int id;
	private Hand hand;
	private int totalBets;
	private int bets;
	private boolean stopDealing;

	public NormalPlayer(int id, int bets) {
		this.id = id;
		hand = new Hand();
		totalBets = 1000;
		try{
		    placeBets(bets);
		}catch(Exception e){
		    e.printStackTrace();
		}
		stopDealing = false;
	}

	public int getId() {
		return this.id;
	}

	public void insertCard(Card card) {
		hand.insertCard(card);
	}

	public int getBestValue() {
		return hand.getBestValue();
	}

	public void stopDealing() {
		stopDealing = true;
	}

	public void joinGame(BlackJack game) {
		this.game = game;
		game.addPlayer(this);
	}

	public void dealNextCard() {
		insertCard(game.dealNextCard());
	}

	public void placeBets(int amount) throws Exception {
		if (totalBets < amount) {
			throw new Exception("No enough money.");
		}
		bets = amount;
		totalBets -= bets;
	}

	public int getCurrentBets() {
		return bets;
	}

	public String printPlayer() {
		return hand.printHand() + ", current bets: " + bets + ", total bets: " + totalBets + "\n";
	}

	public void win() {
		totalBets += (bets * 2);
		bets = 0;
	}

	public void lose() {
		bets = 0;
	}
}


class Hand {
	private List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	// Get a list of possible results from hand
	private List<Integer> getPossibleValues() {
		List<Integer> results = new ArrayList<>();

		int aceCount = 0;
		int resultWithoutAce = 0;
		for (Card card : cards) {
			if (card.getValue() == 1) {
				aceCount++;
			} else if (card.getValue() == 11 || card.getValue() == 12 || card.getValue() == 13) {
				resultWithoutAce += 10;
			} else
				resultWithoutAce += card.getValue();
		}

		for (int i = 0; i <= aceCount; i++) {
			int ones = i;
			int elevens = aceCount - i;

			results.add(resultWithoutAce + ones + elevens * 11);
		}

		return results;
	}

	// -1 means went over 21, otherwise means the best value of this hand
	public int getBestValue() {
		List<Integer> results = getPossibleValues();

		int maxUnder = -1;
		for (int result : results) {
			if (result <= 21 && result > maxUnder) {
				maxUnder = result;
			}
		}
		return maxUnder;
	}

	public void insertCard(Card card) {
		cards.add(card);
	}

	public String printHand() {
		String res = "Cards: ";
		for (int i = 0; i < cards.size(); i++){
			res += (cards.get(i).getValue());
			if(i != cards.size() - 1){
				res+=" , ";
			}
			else res+=';';
		}

		res += " Current best value is: " + getBestValue();
		return res;
	}
}


class Card {
	private int value;

	public Card(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}


class Dealer {
	private BlackJack game;
	private Hand hand;
	private int bets;

	public Dealer() {
		hand = new Hand();
		bets = 10000;
	}

	public void insertCard(Card card) {
		hand.insertCard(card);
	}

	public boolean largerThan(NormalPlayer p) {
		return hand.getBestValue() >= p.getBestValue();
	}

	public void updateBets(int amount) {
		bets += amount;
	}

	public void setGame(BlackJack game) {
		this.game = game;
	}

	public void dealNextCard() {
		insertCard(game.dealNextCard());
	}

	public String printDealer() {
		return "Dealer " + hand.printHand() + ", total bets: " + bets + "\n";
	}
}
```

[Back to top](#OOD)

---

## Restaurant OO Design

**设计餐厅 OO Design**

### Description

- 不能预订座位
- 不能订外卖
- 餐馆的桌子有不同大小
- 餐馆会优先选择适合当前Party最小的空桌（例如，如果客人一共有3个人，餐厅将分配一张4人的桌子，而不是10人的桌子）
- 需要实现`Restaurant` Class

每次调用`findTable`, `takeOrder`, `checkOut`之后都会调用`restaurantDescription`, 来验证你的程序是否正确。

### Example

**Example1**

```java
输入:
//创建三个菜
meal(10.0)
meal(13.0)
meal(17.0)

//创建三个桌子
table(4)
table(4)
table(10)

//输入备选的party
party(3)
party(7)
party(4)
party(6)
party(1)

//创建order
order(1)
order(2, 3)

//给第1，3，4的party安排桌子
findTable(1)
findTable(3)
findTable(4)

//第一桌点了第一个order
takeOrder(1, 1)

//第三桌点了第二个order
takeOrder(3, 2)

//第三桌checkout
checkOut(3)

//给第4个party安排桌子
findTable(4)

输出:
Table: 0, table size: 4, isAvailable: false. No current order for this table.
Table: 1, table size: 4, isAvailable: true. No current order for this table.
Table: 2, table size: 10, isAvailable: true. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. No current order for this table.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: true. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. No current order for this table.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: false. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. Order price: 10.0.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: false. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. Order price: 10.0.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: false. Order price: 30.0.
*****************************************

Table: 0, table size: 4, isAvailable: false. Order price: 10.0.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: true. No current order for this table.
*****************************************

Table: 0, table size: 4, isAvailable: false. Order price: 10.0.
Table: 1, table size: 4, isAvailable: false. No current order for this table.
Table: 2, table size: 10, isAvailable: false. No current order for this table.
*****************************************

说明:
meal(x) 代表我们创建一个价格为x的菜品
```

**Example2**

```java
输入:
meal(12.0)
table(4)
table(4)
table(10)
party(13)
findTable(1)

输出:
Table: 0, table size: 4, isAvailable: true. No current order for this table.
Table: 1, table size: 4, isAvailable: true. No current order for this table.
Table: 2, table size: 10, isAvailable: true. No current order for this table.
*****************************************
```

### Solution

本题的难度在于模拟写起来比较麻烦，但是只要按照题目的要求进行设计就可以了。

```java
class NoTableException extends Exception{

    public NoTableException(Party p)
	{
		super("No table available for party size: " + p.getSize());
	}
}

class Meal {
	private float price;
	
	public Meal(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}

class Order {
	private List<Meal> meals;
	
	public Order()
	{
		meals = new ArrayList<Meal>();
	}
	
	public List<Meal> getMeals()
	{
		return meals;
	}
	
	public void mergeOrder(Order order)
	{
		if(order != null)
		{
			for(Meal meal : order.getMeals())
			{
				meals.add(meal);
			}
		}
	}
	
	public float getBill()
	{
		int bill = 0;
		for(Meal meal : meals)
		{
			bill += meal.getPrice();
		}
		return bill;
	}
}

class Party {
	private int size;
	
	public Party(int size)
	{
		this.size = size;
	}
	
	public int getSize()
	{
		return this.size;
	}
}

class Table implements Comparable<Table>{
	private int capacity;
	private boolean available;
	private Order order;
	
	public Table(int capacity)
	{
		this.capacity = capacity;
		available = true;
		order = null;
	}
	
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public boolean isAvailable()
	{
		return this.available;
	}
	
	public void markAvailable()
	{
		this.available = true;
	}
	
	public void markUnavailable()
	{
		this.available = false;
	}
	
	public Order getCurrentOrder()
	{
		return this.order;
	}
	
	public void setOrder(Order o)
	{
		if(order == null)
		{
			this.order = o;
		}
		else 
		{
			if(o != null)
			{
				this.order.mergeOrder(o);
			} else {
				this.order = o;
			}
		}
	}

	@Override
	public int compareTo(Table compareTable) {
		// TODO Auto-generated method stub
		return this.capacity - compareTable.getCapacity();
	}
}

public class Restaurant {
	private List<Table> tables;
	private List<Meal> menu;
	
	public Restaurant()
	{
		tables = new ArrayList<Table>();
		menu = new ArrayList<Meal>();
	}
	
	public void findTable(Party p) throws NoTableException
	{
		for(Table t: tables)
		{
			if(t.isAvailable())
			{
				if(t.getCapacity() >= p.getSize())
				{
					t.markUnavailable();
					return;
				}
			}
		}
		throw new NoTableException(p);
	}
	
	public void takeOrder(Table t, Order o)
	{
		t.setOrder(o);
	}
	
	public float checkOut(Table t)
	{
		float bill = 0;
		if(t.getCurrentOrder() != null)
		{
			bill = t.getCurrentOrder().getBill();
		}

		t.markAvailable();
		t.setOrder(null);
		
		return bill;
	}
	
	public List<Meal> getMenu()
	{
		return menu;
	}
	
	public void addTable(Table t)
	{
		tables.add(t);
		Collections.sort(tables);
	}
	
	public String restaurantDescription()
	{
        // Keep them, don't modify.
		String description = "";
		for(int i = 0; i < tables.size(); i++)
		{
			Table table = tables.get(i);
			description += ("Table: " + i + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
			if(table.getCurrentOrder() == null)
				description += " No current order for this table"; 
			else
				description +=  " Order price: " + table.getCurrentOrder().getBill();
			
			description += ".\n";
		}
		description += "*****************************************\n";
		return description;
	}
}
```

[Back to top](#OOD)

---

## Design tic tac toe

### Description

设计井字棋游戏。

- 棋盘的尺寸为3
- `X` 总是先行动走出第一步
- 如果一个位置已经被占，且一名玩家打算占领该位置，一个AlreadyTakenException信息将被抛出
- 如果一名玩家胜利，且有玩家打算继续行动，一个GameEndException信息将被抛出
- 如果所有的地方都已被占领，你需要输出"it's a draw"

### Example

例 1:

```java
输入:
move(0, 0) // X 的回合
move(1, 0) // O 的回合 
move(1, 1) // X 的回合
move(2, 0) // O 的回合
move(2, 2) // X 的回合并获得胜利
move(0, 0)  //抛出 GameEndException
move(0, 0) // X 的回合
move(0, 0) // 抛出 AlreadyTakenException
move(1, 0) // O 的回合
move(1, 1) // X 的回合
move(2, 0) // o 的回合
move(2, 2) // X 的回合并获得胜利
输出:
x player wins!
x player wins!
```

### Solution

```java
class GameEndException 
{
public:
    string what()
	{
		return "Game has been ended, cannot make any more moves";
	}
}gameEndException;

class AlreadyTakenException
{
public:
	string what()
	{
		return "This place has been taken";
	}
}alreadyTakenException;

class TicTacToe
{
private:

	char board[3][3];
	char currentPlayerMark;
	bool gameEnd;

public:

	TicTacToe()
	{
		initialize();
	}

	char getCurrentPlayer()
	{
		return currentPlayerMark;
	}

	void initialize()
	{
		gameEnd = false;
		currentPlayerMark = 'x';

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				board[i][j] = '-';
			}
		}
	}

	bool isBoardFull()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (board[i][j] == '-')
				{
					return false;
				}
			}
		}
		gameEnd = true;
		return true;
	}

	void changePlayer()
	{
		if (currentPlayerMark == 'x')
		{
			currentPlayerMark = 'o';
		}
		else
		{
			currentPlayerMark = 'x';
		}
	}

	bool move(int row, int col)
	{
		if (gameEnd)
		{
			throw gameEndException;
		}
		if (board[row][col] != '-')
		{
			throw alreadyTakenException;
		}
		board[row][col] = currentPlayerMark;
		bool win;
		//check row
		win = true;
		for (int i = 0; i < 3; i++)
		{
			if (board[row][i] != currentPlayerMark)
			{
				win = false;
				break;
			}
		}
		if (win)
		{
			gameEnd = true;
			return win;
		}
		//check column
		win = true;
		for (int i = 0; i < 3; i++)
		{
			if (board[i][col] != currentPlayerMark)
			{
				win = false;
				break;
			}
		}
		if (win)
		{
			gameEnd = true;
			return win;
		}
		//check back diagonal
		win = true;
		for(int i = 0; i < 3; i++)
		{
			if (board[i][i] != currentPlayerMark)
			{
				win = false;
				break;
			}
		}
		if (win)
		{
			gameEnd = true;
			return win;
		}
		//check forward diagonal
		win = true;
		for (int i = 0; i < 3; i++)
		{
			if (board[i][3 - i - 1] != currentPlayerMark)
			{
				win = false;
				break;
			}
		}
		if (win)
		{
			gameEnd = true;
            return win;
		}
		changePlayer();
		return win;
	}
};
```

[Back to top](#OOD)

---

## Design a parking lot

### Description

设计一个停车场

1. 一共有*n*层，每层*m*列，每列*k*个位置
2. 停车场可以停摩托车，公交车，汽车
3. 停车位分别有摩托车位，汽车位，大型停车位
4. 每一列，摩托车位编号范围为`[0,k/4)(注：包括0，不包括k/4)`,汽车停车位编号范围为`[k/4,k/4*3)(注：不包括k/4*3)`,大型停车位编号范围为`[k/4*3,k)(注：不包括k)`
5. 一辆摩托车可以停在任何停车位
6. 一辆汽车可以停在一个汽车位或者大型停车位
7. 一辆公交车可以停在一列里的连续5个大型停车位。

### Example

**Example1**

```java
输入:
level=1
num_rows=1
spots_per_row=11
parkVehicle("Motorcycle_1")
parkVehicle("Car_1")
parkVehicle("Car_2")
parkVehicle("Car_3")
parkVehicle("Car_4")
parkVehicle("Car_5")
parkVehicle("Bus_1")
unParkVehicle("Car_5")
parkVehicle("Bus_1")

输出:
true
true
true
true
true
true
false
true

说明: 
此时的车位应该是这样的：
摩托： 0 1
汽车： 2 3 4 5
公交： 6 7 8 9 10
当"Car_5"进入停车场后以后, 汽车位已经没有足够的地方了，所以Car_5停在了公交位6上，因而没有位置留给"Bus_1"。
```

**Example2**

```java
输入:
level=1
num_rows=1
spots_per_row=14
parkVehicle("Motorcycle_1")
parkVehicle("Motorcycle_2")
parkVehicle("Motorcycle_3")
parkVehicle("Car_1")
parkVehicle("Car_2")
parkVehicle("Car_3")
parkVehicle("Motorcycle_4")
parkVehicle("Car_4")
parkVehicle("Car_5")
parkVehicle("Car_6")
parkVehicle("Car_7")
parkVehicle("Bus_1")
unParkVehicle("Car_1")
unParkVehicle("Motorcycle_4")
unParkVehicle("Car_3")
unParkVehicle("Car_6")
parkVehicle("Bus_1")
unParkVehicle("Car_7")
parkVehicle("Bus_1")

输出:
true
true
true
true
true
true
true
true
true
true
true
false
false
true
```

### Solution

```java
// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
	Compact,
	Large,
}

//abstract Vehicle class
abstract class Vehicle {
    // Write your code here
	protected int spotsNeeded;
	protected VehicleSize size;
	protected String licensePlate;  // id for a vehicle

	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>(); // id for parking where may occupy multi

	public int getSpotsNeeded() {
		return spotsNeeded;
	}
	
	public VehicleSize getSize() {
		return size;
	}

	/* Park vehicle in this spot (among others, potentially) */
	public void parkInSpot(ParkingSpot spot) {
		parkingSpots.add(spot);
	}
	
	/* Remove car from spot, and notify spot that it's gone */
	public void clearSpots() {
		for (int i = 0; i < parkingSpots.size(); i++) {
			parkingSpots.get(i).removeVehicle();
		}
		parkingSpots.clear();
	}
	//this need to be implement in subclass
	public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print(); 
}

class Motorcycle extends Vehicle {
    // Write your code here
	public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}
    
    public void print() {  
        System.out.print("M");  
    }
}

class Car extends Vehicle {
    // Write your code here
	public Car() {
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
	}

    public void print() {  
        System.out.print("C");  
    } 
}

class Bus extends Vehicle {
    // Write your code here
	public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large;
	}

    public void print() {  
        System.out.print("B");  
    } 
}

class ParkingSpot {
    // Write your code here
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
		level = lvl;
		row = r;
		spotNumber = n;
		spotSize = sz;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	/* Checks if the spot is big enough for the vehicle (and is available). This compares
	 * the SIZE only. It does not check if it has enough spots. */
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSpot(this);
	}
	/* Park vehicle in this spot. */
	public boolean park(Vehicle v) {
		if (!canFitVehicle(v)) {
			return false;
		}
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	/* Remove vehicle from spot, and notify level that a new spot is available */
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getSpotNumber() {
		return spotNumber;
	}
	
	public VehicleSize getSize() {
		return spotSize;
	}

    public void print() {  
        if (vehicle == null) {  
            if (spotSize == VehicleSize.Compact) {  
                System.out.print("c");  
            } else if (spotSize == VehicleSize.Large) {  
                System.out.print("l");  
            } else if (spotSize == VehicleSize.Motorcycle) {  
                System.out.print("m");  
            }  
        } else {  
            vehicle.print();  
        }  
    }
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0; // number of free spots
	private int SPOTS_PER_ROW;


	public Level(int flr, int num_rows, int spots_per_row) {
		floor = flr;
        int SPOTS_PER_ROW = spots_per_row;
        int numberSpots  = 0;
		spots = new ParkingSpot[num_rows * spots_per_row];

		//init size for each spot in array spots
        for (int row = 0; row < num_rows; ++row) {
            for (int spot = 0; spot < spots_per_row / 4; ++spot) {
                VehicleSize sz = VehicleSize.Motorcycle;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
            for (int spot = spots_per_row / 4; spot < spots_per_row / 4 * 3; ++spot) {
                VehicleSize sz = VehicleSize.Compact;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
            for (int spot = spots_per_row / 4 * 3; spot < spots_per_row; ++spot) {
                VehicleSize sz = VehicleSize.Large;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
        }

        availableSpots = numberSpots;
	}

	/* Try to find a place to park this vehicle. Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		if (availableSpots() < vehicle.getSpotsNeeded()) {
			return false; // no enough spots
		}
		int spotNumber = findAvailableSpots(vehicle);
		if(spotNumber < 0) {
			return false;
		}
		return parkStartingAtSpot(spotNumber, vehicle);
	}

	/* find a spot to park this vehicle. Return index of spot, or -1 on failure. */
	private int findAvailableSpots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;

		for(int i = 0; i < spots.length; i++){
			ParkingSpot spot = spots[i];
			if(lastRow != spot.getRow()){
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if(spot.canFitVehicle(vehicle)){
				spotsFound++;
			}else{
				spotsFound = 0;
			}
			if(spotsFound == spotsNeeded){
				return i - (spotsNeeded - 1); // index of spot
			}
		}
		return -1;
	}

	/* Park a vehicle starting at the spot spotNumber, and continuing until vehicle.spotsNeeded. */
	private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
		vehicle.clearSpots();

		boolean success = true;
		
		for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {
			 success &= spots[i].park(vehicle);
		}
		
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}

	/* When a car was removed from the spot, increment availableSpots */
	public void spotFreed() {
		availableSpots++;
	}

	public int availableSpots() {
		return availableSpots;
	}

    public void print() {  
        int lastRow = -1;  
        for (int i = 0; i < spots.length; i++) {  
            ParkingSpot spot = spots[i];  
            if (spot.getRow() != lastRow) {  
                System.out.print("  ");  
                lastRow = spot.getRow();  
            }  
            spot.print();  
        }  
    }
}

public class ParkingLot {
	private Level[] levels;
	private int NUM_LEVELS;
	
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
	public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        NUM_LEVELS = n;
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, num_rows, spots_per_row);
		}
	}

	// Park the vehicle in a spot (or multiple spots)
    // Return false if failed
	public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}

    // unPark the vehicle
	public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
		vehicle.clearSpots();
	}

    public void print() {  
        for (int i = 0; i < levels.length; i++) {  
            System.out.print("Level" + i + ": ");  
            levels[i].print();
            System.out.println("");  
        }  
        System.out.println("");  
    } 
}
```

[Back to top](#OOD)

---

## Vending Machine OO Design

**自动售货机 OO Design**

### Description

- Vending Machine一共有三种状态：`NoSelection`, `HasSelection`, `InsertedMoney`
- Vending Machine一共卖三种饮料：`Coke`, `Sprite`和`MountainDew`
- 要求Vending Machine在正确的状态要有正确的输出

### Example

输入：

```java
select("Coke")
select("Sprite")
insert(500)
execTrans()
```

输出:

```java
Current selection is: Coke, current inserted money: 0, current state is : HasSelection
Current selection is: Sprite, current inserted money: 0, current state is : HasSelection
Current selection is: Sprite, current inserted money: 500, current state is : InsertedMoney
Current selection is: null, current inserted money: 0, current state is : NoSelection
```

### Solution

```java
public class VendingMachine {
    private String currentSelectedItem;
	private int currentInsertedMoney;
	private AbstractState state;
	private NoSelectionState noSelectionState;
	private HasSelectionState hasSelectionState;
	private InsertedMoneyState insertedMoneyState;
	private Map<String, Integer> itemPrice;

	public VendingMachine() {
		currentInsertedMoney = 0;
		currentSelectedItem = null;
		noSelectionState = new NoSelectionState(this);
		hasSelectionState = new HasSelectionState(this);
		insertedMoneyState = new InsertedMoneyState(this);
		state = noSelectionState;

		itemPrice = new HashMap<>();
		itemPrice.put("Coke", 199);
		itemPrice.put("Sprite", 299);
		itemPrice.put("MountainDew", 399);
	}

	public void setSelectedItem(String item) {
		this.currentSelectedItem = item;
	}

	public String getSelectedItem() {
		return currentSelectedItem;
	}

	public void insertMoney(int amount) {
		this.currentInsertedMoney += amount;
	}

	public void emptyInsertedMoney() {
		this.currentInsertedMoney = 0;
	}

	public int getInsertedMoney() {
		return currentInsertedMoney;
	}

	public int getSalePrice() {
		if (currentSelectedItem == null) {
			System.out.println("Please make a selection before asking price");
			return 0;
		} else {
			return itemPrice.get(currentSelectedItem);
		}
	}

	public void changeToNoSelectionState() {
		state = noSelectionState;
	}

	public void changeToHasSelectionState() {
		state = hasSelectionState;
	}

	public void changeToInsertedMoneyState() {
		state = insertedMoneyState;
	}

	public void selectItem(String selection) {
		state.selectItem(selection);
	}

	public void addMoney(int value) {
		state.insertMoney(value);
	}

	public void executeTransaction() {
		state.executeTransaction();
	}

	public int cancelTransaction() {
		return state.cancelTransaction();
	}

	public String printState() {
		String res = "";

		res = "Current selection is: " + currentSelectedItem + ", current inserted money: " + currentInsertedMoney
				+ ", current state is : " + state;

		return res;
	}
}

interface State {
	public void selectItem(String selection);
	public void insertMoney(int value);
	public void executeTransaction();
	public int cancelTransaction();
	public String toString();
}

abstract class AbstractState implements State {
	protected VendingMachine vendingMachine;

	public AbstractState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
}

class NoSelectionState extends AbstractState{

	public NoSelectionState(VendingMachine vendingMachine) {
		super(vendingMachine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectItem(String selection) {
		// TODO Auto-generated method stub
		vendingMachine.setSelectedItem(selection);
		vendingMachine.changeToHasSelectionState();
	}

	@Override
	public void insertMoney(int value) {
		// TODO Auto-generated method stub
		System.out.println("Please make a selection first");
	}

	@Override
	public void executeTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Please make a selection first");
	}

	@Override
	public int cancelTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Please make a selection first");
		return 0;
	}

	@Override
	public String toString(){
		return "NoSelection";
	}
}

class HasSelectionState extends AbstractState{

	public HasSelectionState(VendingMachine vendingMachine) {
		super(vendingMachine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectItem(String selection) {
		// TODO Auto-generated method stub
		vendingMachine.setSelectedItem(selection);
	}

	@Override
	public void insertMoney(int value) {
		// TODO Auto-generated method stub
		vendingMachine.insertMoney(value);
		vendingMachine.changeToInsertedMoneyState();
	}

	@Override
	public void executeTransaction() {
		// TODO Auto-generated method stub
		System.out.println("You need to insert money first");
	}

	@Override
	public int cancelTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Transaction canceled");
		vendingMachine.setSelectedItem(null);
		vendingMachine.changeToNoSelectionState();
		return 0;
	}
	@Override
	public String toString(){
		return "HasSelection";
	}
}

class InsertedMoneyState extends AbstractState{

	public InsertedMoneyState(VendingMachine vendingMachine) {
		super(vendingMachine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void selectItem(String selection) {
		// TODO Auto-generated method stub
		System.out.println("Already has a selection, please cancel transaction to make a new selection");
	}

	@Override
	public void insertMoney(int value) {
		// TODO Auto-generated method stub
		vendingMachine.insertMoney(value);
	}

	@Override
	public void executeTransaction() {
		// TODO Auto-generated method stub
		int diff = vendingMachine.getInsertedMoney() - vendingMachine.getSalePrice();
		if(diff >= 0){
			System.out.println("Executing transaction, will return you : " + diff + " money and item: " + vendingMachine.getSelectedItem());
			vendingMachine.setSelectedItem(null);
			vendingMachine.emptyInsertedMoney();
			vendingMachine.changeToNoSelectionState();
		}
		else{
			System.out.println("Not enough money, please insert " + (-diff) + " more.");
		}
	}

	@Override
	public int cancelTransaction() {
		// TODO Auto-generated method stub
		int insertedMoney = vendingMachine.getInsertedMoney();
		vendingMachine.setSelectedItem(null);
		vendingMachine.emptyInsertedMoney();
		vendingMachine.changeToNoSelectionState();
		return insertedMoney;
	}

	@Override
	public String toString(){
		return "InsertedMoney";
	}
}
```

[Back to top](#OOD)

---

## Elevator System OOD

**电梯系统 OO Design**

### Description

题目：为一栋大楼设计电梯系统

- 不需要考虑超重的情况
- 该电梯系统目前只有1台电梯, 该楼共有`n`层
- 每台电梯有三种状态：上升，下降，空闲
- 当电梯往一个方向移动时，在电梯内无法按反向的楼层

我们提供了其他几个已经实现好的类，你只需要实现`Elevator Class`内的部分函数即可。
注意：
Currently elevator status is : DOWN.
是指现在正在执行 `down stop list`里的命令
Currently elevator status is : UP.
是指现在正在执行 `up stop list`里的命令

每行命令之后我们都会调用elevatorStatusDescription 函数，用于测试你是否处于一个正确的状态。

### Example

**Example1**

```java
输入:
5
ExternalRequest(3, "Down")
ExternalRequest(1, "Up")
openGate()
closeGate()
openGate()
closeGate()

输出:
Currently elevator status is : DOWN.
Current level is at: 1.
up stop list looks like: [false, false, false, false, false].
down stop list looks like:  [false, false, true, false, false].
*****************************************
Currently elevator status is : DOWN.
Current level is at: 1.
up stop list looks like: [true, false, false, false, false].
down stop list looks like:  [false, false, true, false, false].
*****************************************
Currently elevator status is : DOWN.
Current level is at: 3.
up stop list looks like: [true, false, false, false, false].
down stop list looks like:  [false, false, false, false, false].
*****************************************
Currently elevator status is : UP.
Current level is at: 3.
up stop list looks like: [true, false, false, false, false].
down stop list looks like:  [false, false, false, false, false].
*****************************************
Currently elevator status is : UP.
Current level is at: 1.
up stop list looks like: [true, false, false, false, false].
down stop list looks like:  [false, false, false, false, false].
```

**Example2**

```java
输入:
5         
ExternalRequest(3, "Down")
ExternalRequest(2, "Up")
openGate()
InternalRequest(1)
closeGate()
openGate()
closeGate()
openGate()
closeGate()

输出:
Currently elevator status is : DOWN.
Current level is at: 1.
up stop list looks like: [false, false, false, false, false].
down stop list looks like:  [false, false, true, false, false].
*****************************************

Currently elevator status is : DOWN.
Current level is at: 1.
up stop list looks like: [false, true, false, false, false].
down stop list looks like:  [false, false, true, false, false].
*****************************************

Currently elevator status is : DOWN.
Current level is at: 3.
up stop list looks like: [false, true, false, false, false].
down stop list looks like:  [false, false, false, false, false].
*****************************************

Currently elevator status is : DOWN.
Current level is at: 3.
up stop list looks like: [false, true, false, false, false].
down stop list looks like:  [true, false, false, false, false].
*****************************************

Currently elevator status is : DOWN.
Current level is at: 3.
up stop list looks like: [false, true, false, false, false].
down stop list looks like:  [true, false, false, false, false].
*****************************************

Currently elevator status is : DOWN.
Current level is at: 1.
up stop list looks like: [false, true, false, false, false].
down stop list looks like:  [false, false, false, false, false].
*****************************************

Currently elevator status is : UP.
Current level is at: 1.
up stop list looks like: [false, true, false, false, false].
down stop list looks like:  [false, false, false, false, false].
*****************************************

Currently elevator status is : UP.
Current level is at: 2.
up stop list looks like: [false, false, false, false, false].
down stop list looks like:  [false, false, false, false, false].
*****************************************

Currently elevator status is : IDLE.
Current level is at: 2.
up stop list looks like: [false, false, false, false, false].
down stop list looks like:  [false, false, false, false, false].
*****************************************
```

### Solution

```java
enum Direction {
    UP, DOWN
}

enum Status {
	UP, DOWN, IDLE
}

class Request {
	private int level;
	
	public Request(int l)
	{
		level = l;
	}
	
	public int getLevel()
	{
		return level;
	}
}

class ElevatorButton {
	private int level;
	private Elevator elevator;
	
	public ElevatorButton(int level, Elevator e)
	{
		this.level = level;
		this.elevator = e;
	}
	
	public void pressButton()
	{
		InternalRequest request = new InternalRequest(level);
		elevator.handleInternalRequest(request);
	}
}

class ExternalRequest extends Request{

	private Direction direction;
	
	public ExternalRequest(int l, Direction d) {
		super(l);
		// TODO Auto-generated constructor stub
		this.direction = d;
	}
	
	public Direction getDirection()
	{
		return direction;
	}
}

class InternalRequest extends Request{

	public InternalRequest(int l) {
		super(l);
		// TODO Auto-generated constructor stub
	}
}

public class Elevator {
	
	private List<ElevatorButton> buttons;
	
	private List<Boolean> upStops;
	private List<Boolean> downStops;
	
	private int currLevel;
	private Status status;
	
	public Elevator(int n)
	{
		buttons = new ArrayList<ElevatorButton>();
		upStops = new ArrayList<Boolean>();
		downStops = new ArrayList<Boolean>();
		currLevel = 0;
		status = Status.IDLE;
		
		for(int i = 0; i < n; i++)
		{
			upStops.add(false);
			downStops.add(false);
		}
	}
	
	public void insertButton(ElevatorButton eb)
	{
		buttons.add(eb);
	}
	
	public void handleExternalRequest(ExternalRequest r)
	{
		if(r.getDirection() == Direction.UP)
		{
			upStops.set(r.getLevel() - 1, true);
			if(noRequests(downStops))
			{
				status = Status.UP;
			}
		}
		else 
		{
			downStops.set(r.getLevel() - 1, true);
			if(noRequests(upStops))
			{
				status = Status.DOWN;
			}
		}
	}
	
	public void handleInternalRequest(InternalRequest r)
	{
		// check valid
		if(status == Status.UP)
		{
			if(r.getLevel() >= currLevel + 1)
			{
				upStops.set(r.getLevel() - 1, true);
			}
		}
		else if(status == Status.DOWN)
		{
			if(r.getLevel() <= currLevel + 1)
			{
				downStops.set(r.getLevel() - 1, true);
			}
		}
	}
	
	public void openGate() throws Exception
	{
		if(status == Status.UP)
		{
			for(int i = 0; i < upStops.size(); i++)
			{
				int checkLevel = (currLevel + i) % upStops.size();
				if(upStops.get(checkLevel))
				{
					currLevel = checkLevel;
					upStops.set(checkLevel, false);
					break;
				}
			}
		}
		else if(status == Status.DOWN)
		{
			for(int i = 0; i < downStops.size(); i++)
			{
				int checkLevel = (currLevel + downStops.size() - i) % downStops.size();
				if(downStops.get(checkLevel))
				{
					currLevel = checkLevel;
					downStops.set(checkLevel, false);
					break;
				}
			}
		}
	}
	
	public void closeGate()
	{
		if(status == Status.IDLE)
		{
			if(noRequests(downStops))
			{
				status = Status.UP;
				return;
			}
			if(noRequests(upStops))
			{
				status = Status.DOWN;
				return;
			}
		}
		else if(status == Status.UP)
		{
			if(noRequests(upStops))
			{
				if(noRequests(downStops))
				{
					status = Status.IDLE;
				}
				else status = Status.DOWN;
			}
		}
		else {
			if(noRequests(downStops))
			{
				if(noRequests(upStops))
				{
					status = Status.IDLE;
				}
				else status = Status.UP;
			}
		}
	}
	
	private boolean noRequests(List<Boolean> stops)
	{
		for(int i = 0; i < stops.size(); i++)
		{
			if(stops.get(i))
			{
				return false;
			}
		}
		return true;
	}
	
	public String elevatorStatusDescription()
	{	
		String description = "Currently elevator status is : " + status 
				+ ".\nCurrent level is at: " + (currLevel + 1)
				+ ".\nup stop list looks like: " + upStops
				+ ".\ndown stop list looks like:  " + downStops
				+ ".\n*****************************************\n";
		return description;
	}
}
```

[Back to top](#OOD)

---

