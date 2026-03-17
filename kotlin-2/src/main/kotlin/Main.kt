fun main(){
    var name = "Gabriel"
    var age = 19

    println(name)
    println(age)

    name = "GABRIEL"
    age = 20

    //inmutables
    val universidad = "UAM"
    val nacimiento = 2006

    var seq : Int = 0
    val totalStudents : Int = 21

    println("Cantidad total de estudiantes: $totalStudents")

    //decimal
    val price : Double = 3.0

    //texto
    val phrase : String = "Hello, this is Gabriel"

    //char
    val grade : Char = '\n'

    //boolean
    var isActive : Boolean = false
    println(!isActive)

    println("Original price: $price, price with VAT: ${calculateVAT(price + calculateVAT(price))}")
}

fun calculateVAT(price : Double): Double{
    return price * 0.15
}
