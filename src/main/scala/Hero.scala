class Hero extends HeroTraits {


    private var name = ""
    private var weapon = ""
    private var health = 0



    def this(name:String, weapon: String, health: Int ){
        this()
        this.name = name
        this.weapon = weapon
        this.health = health

    }


     //override def walk(): Unit =  {
        //println(name + " is walking")
    //}

    //override def run(): Unit = {
        //println("is running away")
    //}

    override def takeDamage(): Unit = {
        println(name + " has taken damage!!!")
        health -= 1
        println(name + " your health level is " + health)
    }

    





}
