//package lab2

//class lab2 {
//
//}


// Theoretical questions: why do we need abstraction
//It will only expose the relevant information to outside world. It will provide the necessary information to the user and hide unnecessary information from the user.


// How `traits` in Scala are used?
//by extending in classes

trait Animal {
  // Is this abstract or concrete (implemented) member?
  //this is an abstract method because the method is not complete
  def name: String

  // Is this abstract or concrete (implemented) member?
  //this is an abstract method because the method is not complete
  def makeSound(): String
}

trait Walks {

  // What does this line mean?
  // it means that class that extend Walks have to be extended from Animal;
  // also we can mixin two traits even if they do not extend each other
  this: Animal =>

  // Is this abstract or concrete (implemented) member?
  // this is concrete member

  // Why `name` parameter is available here?
  // Because it's known that any class that will extend Walks, will also extended from Animal
  def walk: String = s"$name is walking"

}


// Can Dog only extend from `Walks`?
// No, because Dog have to be extended from Animal
// Try to fix Dog, so it extends proper traits
// Implement Dog class so it passes tests
case class Dog(_name: String, sound: String = "Whoof") extends Walks with Animal{
  override def name: String = _name

  override def makeSound(): String = sound
}

// Implement Cat class so it passes tests
case class Cat(_name: String, sound: String = "Miiyaaau") extends Animal with Walks{
  override def name: String = _name

  override def makeSound(): String = sound
}

object Lab2 extends App {

  // Here we will test Dog and Cat classes

  val dog1 = Dog("Ceasar")
  val dog2 = Dog("Laika")

  assert(dog1.name == "Ceasar")
  assert(dog2.name == "Laika")

  assert(dog1.makeSound() == "Whooof")
  assert(dog2.makeSound() == "Whooof")

  assert(dog1.walk == "Ceasar is walking")
  assert(dog2.walk == "Laika is walking")

  val cat1 = Cat("Tosha")
  val cat2 = Cat("Chocolate")

  assert(cat1.name == "Tosha")
  assert(cat2.name == "Chocolate")

  assert(cat1.makeSound() == "Miiyaaau")
  assert(cat2.makeSound() == "Miiyaaau")

  assert(cat1.walk == "Tosha is walking")
  assert(cat2.walk == "Chocolate is walking")

}
