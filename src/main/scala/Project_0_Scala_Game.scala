import java.util.Scanner
import Console.{BLUE, GREEN, RED, UNDERLINED,RESET}




object Project_0_Scala_Game {
    var scanner = new Scanner(System.in)
    var health = 3
    var game = true


    def main(args: Array[String]): Unit = {

        

    }

    def takeDamage(): Unit = {
        println("")
        println(name + " has taken damage!!!")
        health -= 1
        println("")
        println(name + " your health level is " + health)
        println("")
    }

    // Requesting players name    
    println("Please type your name: ")
    var name = (scanner.nextLine())

    println("")
    println("    ********************************************************")
    println("                                                          ")
    println("                   Welcome To The Game                         ")
    println("                     Pet or Do Not Pet                 ")
    //Console.println("${RESET}${BLUE}" + name + "${RESET}         ")
    println("                           "  +  name + "                       ")
    println("                                                          ")
    println("    ********************************************************")
    println("")


    
    println(" You have started the game with a health level of 3")
    println(" ")
    println(" The goal is to get to the end of the game with as many health points as possible")
    println(" ")
    println(" If your health reaches 0, your game is over")
    println(" ")
    println(" ")

    while (health == 3){
        
        while (game){
            
            println(" As the game starts you find yourself in a dark forest. As you roam this forest you start to notice weird creatures")
            println("")
            println(" The creates start to come up to you and seem like they want to be petted")
            println("")
            println(" Do you pet these creates or do you shy them away. The choice is yours")
            println("")
            println(" The first create is a fairy do you pet it or do not pet")
                var pet =  (scanner.nextLine())
                if (pet == "pet it"){
                    health == health
                    babyDragon()
                }else if(pet == "do not pet"){
                    println("")
                    println(" you should have petted the fairy, it's just a fairy. Don't be chicken. You have lost 1 health")
                    takeDamage()
                    //health -=1
                    babyDragonDamage()
                }
                
            //pets fairy
            def babyDragon(){
                println("")
                println(" Good job, you petted a fairy")
                println("")
                println(" You didn't lose any health points. ")
                println("")
                println(" The next create that comes to you in a baby dragon. Do you pet it or do not pet")
                println("")
                var pet =  (scanner.nextLine())
                if (pet == "pet it"){
                    println(" You are brave but that was a silly choice")
                    takeDamage()
                    goldUnicorn()
                    
                }else if (pet == "do not pet") {
                    //println(" Wise decision not to touch a dragon's baby.")
                    goldUnicorn()

                }

            }
            
            // do not pet fairy
            def babyDragonDamage(){
                println("")
                println(" After not petting the fairy you continuing your journey")
                println("")
                println(" You currently have 2 health points left")
                println("")
                println(" The next create that comes to you in a baby dragon. Do you pet it or do not pet")
                println("")
                var pet =  (scanner.nextLine())
                if (pet == "pet it"){
                    println(" You are brave but silly")
                    takeDamage()
                    goldUnicornDamage()
                    //println(" Your health is still at 2.... good luck")
                }else if (pet == "do not pet") {
                    goldUnicorn()
                    

                }

            }//else if (health == 2){
                    //println(" After not petting the fairy you continuing your journey")
                    //println("")
                    //println(" The next creature that comes to you is a baby dragon. Do you pet the baby or do not pet the baby")
                    //health = health

                        
                

            

                def goldUnicorn(){
                    println("")
                    println("Good Choice... Why would anyone pet a baby dragon. The mommy dragon would have eaten you.")
                    println("")
                    //println(" Your health is now 2. Your health points are getting low. Be careful.")
                    println("")
                    println("The final creature in your test is a Gold Unicorn. pet it or do not pet")
                    var pet =  (scanner.nextLine())

                    //didnt pet fairy, pet baby dragon, pet gold unicorn
                    if (pet == "pet it"){
                        println(" You never touch the gold Unicorn. You have lost all your health. Your game is over")
                        println("")
                        takeDamage()
                        println(" You have lost all your health. Your GAME IS OVER")
                        game = false

                    //pet fairy, didn't pet baby dragon, didn't pet gold unicorn    
                    }else if (pet == "do not pet" && health == 3) {
                        println("Good choice not to pet the Gold Unicorn. You have ended the game with all your health points ")
                        println("")
                        println("Great Job. You have WON THE GAME")
                        println("")
                        println(" Total health points left: " + health )
                        game = false
                        // DOESNT END GAME LOOP

                    // didn't pet fairy, pet baby dragon, didn't pet gold unicorn    
                    }else if (pet == "do not pet" && health == 2) {
                        println("Good choice not to pet the Gold Unicorn. You have ended the game with 2 points. ")
                        println("")
                        println("Well done. You have WON THE GAME")
                        println("")
                        println(" Total health points left: " + health )
                        game = false

                    // didn't pet fairy, pet baby dragon, didnt pet gold unicorn    
                    }else if (pet == "do not pet" && health == 1){
                        println(" It's always a good idea to never touch the mystical unicorn. You have ended the game with 1 point.")
                        println("")
                        println("You could have done better. But either way,  You have WON THE GAME")
                        println("")
                        println(" Total health points left: " + health )
                        game = false
                    }
                }


                def goldUnicornDamage(){
                     println("")
                //     println("Why would anyone pet a baby dragon. The mommy dragon could have eaten you")
                //     println("")
                //     println("The final creature in your test is a Gold Unicorn. pet it or do not pet")
                //     var pet =  (scanner.nextLine())

                //     //didnt pet fairy, pet baby dragon, pet gold unicorn
                //     if (pet == "pet it"){
                //         println(" You never touch the gold Unicorn.")
                //         println("")
                //         takeDamage()
                //         println(" You have lost all your health. Your GAME IS OVER")
                //         println("")
                //         println(" Total health points left: " + health )
                //         println("")
                //         game = false

                    
                //     // didn't pet fairy, pet baby dragon, didn't pet gold unicorn    
                //     }else if (pet == "do not pet" && health == 2) {
                //         println("Good choice not to pet the Gold Unicorn. You have ended the game with 2 points. ")
                //         println("Well done. You have WON THE GAME")
                //         println(" Total health points left: " + health )
                //         println("")
                //         game = false

                //     // didn't pet fairy, pet baby dragon, didnt pet gold unicorn    
                //     }else if (pet == "do not pet" && health == 1){
                //         println(" It's always a good idea to never touch the mystical unicorn. You have ended the game with 1 point.")
                //         println("")
                //         println("You could have done better. But either way,  You have WON THE GAME")
                //         println(" Total health points left: " + health )
                //         println("")
                //         game = false
                //     }
                 }
   
   
        }
    }
   
   
   
   
   
}




