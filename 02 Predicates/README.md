## Assignment #2: 
### Programming with Predicates: Prolog-Student Calendar

_Problem: Create a program that models students, classs, rooms, dates, and their relations._
```
/* facts */
student(cherry).
student(diana).
student(mahnaz).
student(andreas).
student(mikkel).

room(203).
room(205).

day(monday).
day(wednesday).
day(thursday).

class('Large Systems Development').
class('Systems Integration').
class('Discrete Mathematics').

/* relations */
studies(cherry, 'Discrete Mathematics').
studies(cherry, 'Large Systems Development').
studies(cherry, 'Systems Integration').
studies(diana, 'Discrete Mathematics').
studies(diana, 'Large Systems Development').
studies(diana, 'Systems Integration').
studies(mahnaz, 'Discrete Mathematics').
studies(mahnaz, 'Large Systems Development').
studies(mahnaz, 'Systems Integration').
studies(andreas, 'Large Systems Development').
studies(mikkel, 'Discrete Mathematics').
studies(mikkel, 'Large Systems Development').
studies(mikkel, 'Systems Integration').

class('Large Systems Development',monday).
class('Systems Integration',wednesday).
class('Discrete Mathematics',thursday).

room(203,'Large Systems Development').
room(203,'System Integration').
room(203,'Discrete Mathematics').
room(205,'Internship Orientation').
```
##### Set of Rules/Questions:
1. Who are studying Discrete Mathematics?
```
dm_students :-
  listing(studies(X, 'Discrete Mathematics')),
  write(X).
```
![dm_students](https://github.com/cph-cs241/SoftDev_DM2018/blob/master/02%20Predicates/images/1.png)

2. Is Diana classmates with Mahnaz?
```
classmates_with(X,Y) :-
    studies(X, Z),
    studies(Y,Z),
    format('~w ~w ~w ~w ~w ~n', [X, 'and', Y, 'are classmates in ', Z]).
```
![classmates_with](https://github.com/cph-cs241/SoftDev_DM2018/blob/master/02%20Predicates/images/2.png)

3. Is Cherry in school on Thursday?
```
in_school(X,Y) :-
  studies(X,Z),
  class(Z,Y),
  format('~w ~w ~w ~w ~w ~n', [X, 'is in school on', Y, 'in class', Z]).
```
![in_school](https://github.com/cph-cs241/SoftDev_DM2018/blob/master/02%20Predicates/images/3.png)

4. Does Mikkel study Discrete Mathematics with Andreas?
```
study_with(X,Y,Z) :-
    studies(X, Z),
    studies(Y,Z),
    format('~w ~w ~w ~w ~w ~n', [X, 'and', Y, 'are studying', Z]).
```
![study_with](https://github.com/cph-cs241/SoftDev_DM2018/blob/master/02%20Predicates/images/4.png)

5. Which room is Discrete Mathematics?
```
in_room(X) :-
    room(Y,X),
    format('~w ~w ~w ~n', [X, 'is in room', Y]).
```
![in_room](https://github.com/cph-cs241/SoftDev_DM2018/blob/master/02%20Predicates/images/5.png)

