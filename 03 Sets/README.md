### Assignment #3: An API for handling sets

I. Methods for handling:
- membership
- intersection
- union
- difference
- complement

II. Methods for handling subsets and equality: <br>
![image](https://user-images.githubusercontent.com/16150075/45599320-9c8ffa00-b9e9-11e8-8fc8-cbcfeef17256.png)


# _SOLUTION:_

This assignament is written in Java programming language using following libraries to acheave the requirements:

  - Comparable Interface to compare the elements of the given sets
  - Set and HashSet
  - Magic

### _Usage_
--------------------------
1. Clone project
[https://github.com/cph-cs241/SoftDev_DM2018]()

2. Open 
```SoftDev_DM2018/03 Sets/03sets```

3. Run _Main.java_ class

Output:
```java
------------------------------------------------------------------------
Building 03sets 1.0-SNAPSHOT
------------------------------------------------------------------------

--- exec-maven-plugin:1.2.1:exec (default-cli) @ 03sets ---
Union Set: {INF, 1, 2, 3, 4, 5, } 
Intersection Set: {3, } 
Difference set: {1, 2, } 
-1
Set A: {1, 2, 3, } 
Set B: null
Complement Set --> {U\A, } 
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 1.448s
Finished at: Wed Sep 19 08:33:11 CEST 2018
Final Memory: 5M/123M
```


### _Structure_
------------------------
##### _Main.java_
The sets are hard coded. The aprouch, which is used to create the sets, is defining a set and then add integer numbers as set's member. This structure is implemented in "Main" class.
  - Adds Integers to `members`, `secondMembers` and `thirdMembers` Set
  - Runs `union` method on both Sets.

```Java
Union Set: {INF, 1, 2, 3, 4, 5, }
```
  - Runs `intersection` method on both Sets.

```Java

Intersection Set: {3, }

 - Runs `Difference` method on both Sets.
```Java
Difference set: {1, 2, } 
```
  - Runs `compareTo` method on `members` and `thirdMembers` Set.

```Java
-1
Set A: {1, 2, 3, }
```
  - Runs `compliment` method on all sets returning universal compliment of the Set `A`.
  
```Java
Complement Set --> {U\A, }
```

------------------------
##### _Sets.java_

  - Interface class that is implemented by `SetsImpl.java` class with the stated methods.
  I interface class there are some methods with different output.
  All methods work on Sets but the last method "printFormat" has used to display the method outputs.

```Java
public interface Sets<T extends Comparable> {
    Set<T> members();
    boolean hasMin();
    boolean hasMax();
    boolean member(T member);
    Sets<T> union(Sets<T> set);
    Sets<T> intersection(Sets<T> set);
    Sets<T> difference(Sets<T> set);
    Sets<T> complement(Sets<T> set);
    int compareTo(Sets<T> set);
    void printFormatted(String s);
}
``` 

------------------------
##### _SetsImpl.java_
- Description and screenshots  
------------------------
![image](https://user-images.githubusercontent.com/16150075/45599320-9c8ffa00-b9e9-11e8-8fc8-cbcfeef17256.png)
