package lab4

object Task_3 extends App{
  case class Film( name: String,
                   yearOfRelease: Int,
                   imdbRating: Double)
  case class Director( firstName: String,
                       lastName: String,
                       yearOfBirth: Int,
                       films: Seq[Film])


  val memento = new Film("Memento", 2000, 8.5)
  val darkKnight = new Film("Dark Knight", 2008, 9.0)
  val inception = new Film("Inception", 2010, 8.8)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = new Film("Unforgiven", 1992, 8.3)
  val granTorino = new Film("Gran Torino", 2008, 8.2)
  val invictus = new Film("Invictus", 2009, 7.4)
  val predator = new Film("Predator", 1987, 7.9)
  val dieHard = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
  val eastwood = new Director("Clint", "Eastwood", 1930,
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
  val mcTiernan = new Director("John", "McTiernan", 1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
  val nolan = new Director("Christopher", "Nolan", 1970,
    Seq(memento, darkKnight, inception))
  val someGuy = new Director("Just", "Some Guy", 1990,
    Seq())
  val directors = Seq(eastwood, mcTiernan, nolan, someGuy)
  def dirsCreatedMoreThanNFilms(numberOfFilms: Int) = directors.filter(d => d.films.length > numberOfFilms)
  def dirsBornBeforeThatYear(year: Int) = directors.filter(d => d.yearOfBirth < year)
  def task3(year: Int, numberOfFilms: Int) = directors.filter(d => d.films.length > numberOfFilms && d.yearOfBirth < year)
  def task4(ascending: Boolean = true) = {
    ascending match{
      case true => directors.sortWith(_.yearOfBirth < _.yearOfBirth)
      case _ => directors.sortWith(_.yearOfBirth > _.yearOfBirth)
    }
  }

  val task5 = nolan.films.map(f => f.name)
  val task6 = directors.flatMap(d => d.films.map(f => f.name))
  val task7 = mcTiernan.films.map(f => f.yearOfRelease).min
  val task8 = directors.flatMap(d => d.films).sortWith(_.imdbRating > _.imdbRating)
  val task9 = directors.flatMap(d => d.films.map(f => f.imdbRating))
  val task9_avg = task9.sum / task9.length
  def task10()= {
    directors.foreach(d => d.films.foreach(f => println(s"Tonight only! ${f.name} by ${d.firstName} ${d.lastName}")))
    directors.flatMap(d => d.films.map(f=>s"Tonight only! ${f.name} by ${d.firstName} ${d.lastName}"))
  }
  def task11()= {
    for(e <- directors){
      println(e.films.map(f => f.yearOfRelease).min)
    }
  }
  println(task5)
  println(task6)
  println(task7)
  println(task8)
  println(task9_avg)
  println(task10())
  task11()
}
