/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package ex_4_12


fun <T> List<T>.head(): T =
        if (this.isEmpty())
            throw IllegalArgumentException("head called on empty list")
        else
            this[0]

fun <T> List<T>.tail(): List<T> =
        if (this.isEmpty())
            throw IllegalArgumentException("tail called on empty list")
        else
            this.drop(1)


fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft(list: List<T>, acc: U): U =
            if (list.isEmpty())
                acc
            else
                foldLeft(list.tail(), f(acc, list.head()))
    return foldLeft(list, z)
}


fun <T> prepend(elem: T, list: List<T>): List<T> = foldLeft(list, listOf(elem)) { lst, elm -> lst + elm }


fun range(start: Int, end: Int): List<Int> =
    if (end < start)
        listOf()
    else
        prepend(start,range(start + 1, end))
		
		



class App {
    val greeting: String
        get() {
            return "package ex_4_12"
        }
}

fun main() {
    println(App().greeting)
	println(range(1,10))
	
}
