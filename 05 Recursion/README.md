### ASSIGNMENT:
> ***Towers of Hanoi*** <br>
> Create a Visual (text-based or GUI) recursive version of Towers of Hanoi

----

### SOLUTION:

**Classes**
- Towers - represents the 3 towers which has a stack of disk/s, initially the tower A has 8 disks and towers B and C is empty.
- Disk - has a `size`.


**Recursive Method**
```java
public static void move(int count, Tower beg, Tower aux, Tower end) throws InterruptedException{
        if(count==1) beg.moveTo(aux); //base case
        else{
            move(count-1,beg,end,aux);
            beg.moveTo(aux);
            print();
            move(count-1, end,aux,beg);
        }
    }
```

This method basically do the job, which takes the number of disks - `count`, and the three towers - `beg`-begin, `aux`- auxiliary and `end`-final.

**Output**
> Given: 8 disks and 3 towers

![image](https://user-images.githubusercontent.com/16150075/48583883-9efacb80-e928-11e8-8a2a-d37efe2585ac.png)

