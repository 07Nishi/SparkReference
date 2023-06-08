//if else

if (1>3) print("Impossible") else ("Possible")

//Matching

val num =2
num match{
  case 1 => println("One")
  case 2 => println("Two")
  case _=> println("Wrong")


}
//FOR LOOP
for(x <- 1 to 4){
  val squared = x*x
  println(squared)


}

//do while

var x=0
do{
  println(x);
  x+=1

}while(x<=10)

//WHILE LOOP

var x=10
while (x >=0)
{
  println(x);
  x = x-1;
}


//FUNCTIONS

//format def function_name (parameter_name : type) : return type
  // {  body }

def square(x:Int):Int = { x * x}

def cube(x:Int) : Int = { x*x*x }
println("Square is : " + square(2))
println("Cube is : " + cube(5))


//use function inside function

def transform(x:Int , f:Int => Int): Int={
    f(x)
 }

val result = transform(2, cube)
  println(result)

val sqresult = transform(5, x=> x*x)

val result1 = transform(10, x => x/2)


//-----------------------------Questions---------------------

// 1. String have a built-in .toUppercase method.

val string = "nishita"
println(string.toUpperCase())


// 2. Write a function that converts a string to upper-case and use that
//function of a few test strings

def toUpperCase(s: String): String = {
  s.toUpperCase()
}

val myString = "Hello, World!"
val myUppercaseString = toUpperCase(myString)
println(myUppercaseString)


//------------------DATA STRUCTURE--------------------------

val LongNames = ("Astha","Ravina","Anil")
println(LongNames)

// REFER TO THE INDIVIDUAL FIELDS WITH A ONE-BASED INDEX

println(LongNames._1)
println(LongNames._2)
println(LongNames._3)

//Lists
//Like a tuple,but more functionality
//Must be of same type

val aBunchOfStuff = ("kirk",1964,true)

val shipList = List("Enterprise","Defiant","Deep")
println(shipList(0))

//zero-based

println(shipList.head)
println(shipList.tail)
println(shipList.reverse)


for(ship <- shipList){println(ship)}

val backwardShip = shipList.map((ship:String) => {ship.reverse})

for(ship <- backwardShip){println(ship)}

//REDUCE() TO COMBINE TOGETHER ALL THE ITEMS IN A COLLECTION USING A FUNCTION

val numberList = List(1,2,3,4,5)
val sum = numberList.reduce((x: Int,y:Int) => x+y)
println(sum)

//filter() removes stuff

val fives = numberList.filter((x:Int)  => x!= 5)

val three = numberList.filter(_ != 3)


//conactenate Lists
val moreNumber= List(6,7,8)
val lotsOfNumber = numberList ++ moreNumber

val reversed = numberList.reverse
val sorted = reversed.sorted
val lotsOfDuplicates = numberList ++ numberList
val distinctvalue = lotsOfDuplicates.distinct
val maxValue = numberList.max
val total = numberList.sum
val hasThree = three.contains(3)

//-----------------------------EXERCISE-----------------------------

//create a list of the number 1-20;your job is to print out number that are evenly divisible by three

/*val listOfNumber = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
for(listOfNumber <- 1 to 20) {
  if (listOfNumber: Int % 3 == 0) {
    println(listOfNumber)

  }
}*/

  val numbers = List.range(1, 21)
  val divisibleByThree = numbers.filter(_ % 3 == 0)
  println(divisibleByThree)




//module opertor like:9%3=0

val a = 9
val b = 3
val result = a % b
println(result)

//