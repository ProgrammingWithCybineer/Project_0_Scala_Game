import java.util.Scanner
import Console.{BLUE, GREEN, RED, UNDERLINED,RESET}




object Project_0_Scala_Game {
    var scanner = new Scanner(System.in)
    


    def main(args: Array[String]): Unit = {

        

    }

        
    println("Please type your name: ")
    var name = (scanner.nextLine())

    println("")
    println("    ********************************************************")
    println("                                                          ")
    println("                         Welcome                          ")
    println("             To The World Of The Unknown                  ")
    //Console.println("${RESET}${BLUE}" + name + "${RESET}         ")
    println("                        "  +  name + "                       ")
    println("          Type 'quit' at anypoint to leave the journey    ")
    println("                                                          ")
    println("    ********************************************************")
    println("")


    
    println(" You have started the game with a health level of 3")
    println(" ")
    println(" If your health reaches 0, your game is over")

    println(" ")
    while (health > 0){
        println(" As the game starts you find yourself in a dark forest. As you roam this forrest you start to notice weird creatures")
        println("")
        println(" The creates start to come up to you and seem like they wanted to be petted")
        println("")
        println(" Do you pet these creates or do you shy them away. The choice is yours")
        println("")
        println(" The first create is a fairy do you pet it or do not pet")
            var pet =  (scanner.nextLine())
            if (pet == "pet it"){
                println(" You petted a fairy")
            }else if(pet == "do not pet"){
                println(" you should have petted the fairy. You have lost one health")
                takeDamage()
                println(" Your health level is now 2")
                //health == health
            }

            if (health == 2){
                println("")
                println(" After not petting the fairy you continuing your journey")
                println("")
                println(" The next create that comes to you in a baby dragon. Do you pet it or do not pet")
                println("")
                if (pet == "pet"){
                    println("pet")
                }else if(pet == "do not pet") {
                    println("don't pet")

                }
                println(" As the game starts you find yourself in a dark forest")
                println("")
                println(" As the game starts you find yourself in a dark forest")
                println("")
                println(" As the game starts you find yourself in a dark forest")
                println("")
            }


    println("")
    println(" As the game starts you find yourself in a dark forest")
    println("")
    println(" As the game starts you find yourself in a dark forest")
    println("")
    println(" As the game starts you find yourself in a dark forest")
    println("")
    println(" As the game starts you find yourself in a dark forest")
    println("")
    println(" As the game starts you find yourself in a dark forest")
    println("")


    }


    



  
}
