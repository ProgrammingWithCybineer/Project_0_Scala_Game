import java.util.Scanner
import Console.{BLUE, GREEN, RED, UNDERLINED,RESET}
import java.sql.DriverManager
import java.sql.Connection
import com.mysql.cj.xdevapi.UpdateStatement





object Project_0_Scala_Game {
 
    def main(args: Array[String]): Unit = {
        var scanner = new Scanner(System.in)
        var name = ""
        var fairy = ""
        var babyDragon = ""
        var babyDragonDamage = ""
        var goldUnicorn = ""
        var goldUnicornDamage = ""
        var playerName = ""
        var endGameHealth = 0
        var playerHealth = 3

        var health = 3
        var game = true
        val driver = "com.mysql.jdbc.Driver"
        val url = "jdbc:mysql://localhost:3306/Project0_Scala_Game" // Modify for whatever port you are running your DB on
        val username = "root"
        val password = "ProgramWithNoFears920" // Update to include your password
        var connection:Connection = null  

    

        def takeDamage(): Unit = {
            println("")
            println(name + " has taken damage!!!")
            health -= 1
            println("")
            println(name + " your health level is " + health)
            println("")
        }


    

    // Requesting players name
        try{
            
            // make the connection
            Class.forName(driver)
            connection = DriverManager.getConnection(url, username, password)  
            //val statement = connection.createStatement()

            val statement = connection.createStatement()          
            
            println("Please type your name: ")
            var playerName= (scanner.nextLine())
            
            //statement.executeUpdate("INSERT INTO Players (playerName) VALUES (" +playerName+");")
            println(" Please enter your age: ")
            var age = (scanner.nextInt())
            scanner.nextLine()
            //statement.executeUpdate("INSERT INTO Players (age) VALUES (" +age+");")
            val resultSet2 = statement.executeUpdate("INSERT INTO Players (playerName, age) VALUES ('"+playerName+"', '"+age+"');")
            val resultSet3 = statement.executeUpdate("UPDATE Players SET playerHealth = ('"+playerHealth+"');")

            // create the statement, and run the select query
            
            //val resultSet = statement.executeUpdate("SELECT * FROM Players ")
            //val statement = connection.createStatement()
            //statement.executeUpdate("INSERT INTO Players (playerName, age) VALUES (" +playerName+", " +age+");")
            
            

            println("")
            println("    ********************************************************")
            println("                                                          ")
            println("                   Welcome To The Game                         ")
            println("                     Pet or Do Not Pet                 ")
            //Console.println("${RESET}${BLUE}" + name + "${RESET}         ")
            println("                           "  +  playerName + "                       ")
            println("                                                          ")
            println("    ********************************************************")
            println("")


    
            println(" You have started the game with a health level of 3")
            println(" ")
            println(" The goal is to get to the end of the game with as many health points as possible")
            println(" ")
            println(" If your health reaches 0, your game is over")
            println(" ")
            

            //while (health == 3){ // LOOK INTO THIS
                
                
                while (game){
                    println(" ")
                    println(" As the game starts you find yourself in a dark forest. As you roam this forest you start to notice weird creatures")
                    println("")
                    println(" The creates start to come up to you and seem like they want to be petted")
                    println("")
                    println(" Do you pet these creates or do you shy them away. The choice is yours")
                    println("")
                    println(" The first create is a fairy do you pet it or do not pet")
                    var fairy =  (scanner.nextLine())
                    val resultSet4 = statement.executeUpdate("UPDATE Players SET fairy = ('"+fairy+"') WHERE playerName = ('"+playerName+"') ;")    
                        // NEED TO ADD THIS CHOICE INTO DATABASE
                        if (fairy == "pet it"){
                            babyDragon()
                            
                        }else if(fairy == "do not pet"){
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
                        var babyDragon =  (scanner.nextLine())
                        val resultSet5 = statement.executeUpdate("UPDATE Players SET babyDragon = ('"+babyDragon+"') WHERE playerName = ('"+playerName+"') ;") 
                        if (babyDragon == "pet it"){
                            println(" You are brave but that was a silly choice")
                            takeDamage()
                            goldUnicorn()
                            
                        }else if (babyDragon == "do not pet") {
                            //println(" Wise decision not to touch a dragon's baby.")
                            goldUnicorn()

                        }

                    }
                    
                    // do not pet fairy
                    def babyDragonDamage(){
                        println("")
                        println(" After not petting the fairy you continuing your journey")
                        println("")
                        println(" The next create that comes to you in a baby dragon. Do you pet it or do not pet")
                        println("")
                        var babyDragonDamage =  (scanner.nextLine())
                        val resultSet5 = statement.executeUpdate("UPDATE Players SET babyDragon = ('"+babyDragonDamage+"') WHERE playerName = ('"+playerName+"') ;") 
                        if (babyDragonDamage == "pet it"){
                            println(" You are brave but silly")
                            takeDamage()
                            goldUnicornDamage()
                            //println(" Your health is still at 2.... good luck")
                        }else if (babyDragonDamage == "do not pet") {
                            goldUnicorn()
                            

                        }

                    }           
                        

                        def goldUnicorn(){
                            println("")
                            println("Good Choice... Why would anyone pet a baby dragon. The mommy dragon would have eaten you.")
                            println("")
                            //println(" Your health is now 2. Your health points are getting low. Be careful.")
                            println("")
                            println("The final creature in your test is a Gold Unicorn. pet it or do not pet")
                            var goldUnicorn =  (scanner.nextLine())
                            val resultSet6 = statement.executeUpdate("UPDATE Players SET gold_Unicorn = ('"+goldUnicorn+"') WHERE playerName = ('"+playerName+"') ;") 

                            //didnt pet fairy, pet baby dragon, pet gold unicorn
                            if (goldUnicorn  == "pet it" && health > 0 ){
                                println(" You never touch the gold Unicorn.")
                                println("")
                                takeDamage()
                                println(" Total health points left: " + health )
                                println("")
                                println(" Great Job. You have WON THE GAME")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                game = false

                            //pet fairy, didn't pet baby dragon, didn't pet gold unicorn    
                            }else if (goldUnicorn  == "do not pet" && health == 3) {
                                println("Good choice not to pet the Gold Unicorn. You have ended the game with all your health points ")
                                println("")
                                println("Great Job. You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                game = false
                                // DOESNT END GAME LOOP

                            // didn't pet fairy, pet baby dragon, didn't pet gold unicorn    
                            }else if (goldUnicorn  == "do not pet" && health == 2) {
                                println("Good choice not to pet the Gold Unicorn. You have ended the game with 2 points. ")
                                println("")
                                println("Well done. You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                game = false

                            // didn't pet fairy, pet baby dragon, didnt pet gold unicorn    
                            }else if (goldUnicorn  == "do not pet" && health == 1){
                                println(" It's always a good idea to never touch the mystical unicorn. You have ended the game with 1 point.")
                                println("")
                                println("You could have done better. But either way,  You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                game = false
                            }
                        }


                        def goldUnicornDamage(){
                            println("")
                            println("Why would anyone pet a baby dragon. The mommy dragon could have eaten you")
                            println("")
                            println("The final creature in your test is a Gold Unicorn. pet it or do not pet")
                            var goldUnicornDamage  =  (scanner.nextLine())
                            val resultSet6 = statement.executeUpdate("UPDATE Players SET gold_Unicorn = ('"+goldUnicornDamage+"') WHERE playerName = ('"+playerName+"') ;")

                            //didnt pet fairy, pet baby dragon, pet gold unicorn
                            if (goldUnicornDamage == "pet it"){
                                println(" You never touch the gold Unicorn.")
                                println("")
                                takeDamage()
                                println(" You have lost all your health. Your GAME IS OVER")
                                println("")
                                println(" Total health points left: " + health )
                                println("")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                game = false

                            
                            // didn't pet fairy, pet baby dragon, didn't pet gold unicorn    
                            }else if (goldUnicornDamage == "do not pet" && health == 2) {
                                println("Good choice not to pet the Gold Unicorn. You have ended the game with 2 points. ")
                                println("")
                                println("Well done. You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                println("")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                game = false

                            // didn't pet fairy, pet baby dragon, didnt pet gold unicorn    
                            }else if (goldUnicornDamage == "do not pet" && health == 1){
                                println(" It's always a good idea to never touch the mystical unicorn. You have ended the game with 1 point.")
                                println("")
                                println("You could have done better. But either way,  You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                println("")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                game = false
                            }
                        }
                        // create the statement, and run the select query
                
                }
            //}

            //val statement = connection.createStatement()
            //val resultSet = statement.executeUpdate("SELECT * FROM Players ") // Change query to your table
            val resultSet1 = statement.executeQuery("SELECT * FROM Players")
            while ( resultSet1.next() ) {
                print(resultSet1.getString(1) + " " + resultSet1.getString(2) + " " + resultSet1.getString(3) + " " + resultSet1.getString(4) + " " + resultSet1.getString(5) + " " + resultSet1.getString(6) + " " + resultSet1.getString(7))
                println("")
                println("")
            }

                
        //}catch {
            //    case e: Exception => e.printStackTrace
            //}
            println("")
            println(" Next query will delete all players game who's age is less than 2")
            println("")
            // this is for the total number of people who ended the game with health above 2
            val resultSet8 =  statement.executeUpdate("DELETE FROM Players WHERE age < 2 ;")
            val resultSet9 = statement.executeQuery("SELECT * FROM Players")
            while ( resultSet9.next() ) {
                 print(resultSet9.getString(1) + " " + resultSet9.getString(2) + " " + resultSet9.getString(3) + " " + resultSet9.getString(4) + " " + resultSet9.getString(5) + " " + resultSet9.getString(6) + " " + resultSet9.getString(7))
                 println("")
                 println("")
            }

                
            }catch {
                     case e: Exception => e.printStackTrace            

            }
                connection.close()

      
   
   
           
    }
}




