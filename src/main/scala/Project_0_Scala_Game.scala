import java.util.Scanner
import Console.{BLUE, GREEN, RED, UNDERLINED,RESET}
import java.sql.DriverManager
import java.sql.Connection
import com.mysql.cj.xdevapi.UpdateStatement
import java.io.File
import java.io.PrintWriter





object Project_0_Scala_Game {
 
    def main(args: Array[String]): Unit = {
        // declaring all variables needed for the game
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
        val log = new PrintWriter(new File("Game.log"))

        var health = 3
        var game = true
        val driver = "com.mysql.jdbc.Driver"
        val url = "jdbc:mysql://localhost:3306/Project0_Scala_Game" // Modify for whatever port you are running your DB on
        val username = "root"
        val password = "###########################" // Update to include your password
        var connection:Connection = null  

    

        


    

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
            log.write("Executing 'INSERT INTO Players (playerName, age) VALUES ('"+playerName+"', '"+age+"');\n")
            val resultSet3 = statement.executeUpdate("UPDATE Players SET playerHealth = ('"+playerHealth+"');")
            log.write("Executing 'UPDATE Players SET playerHealth = ('"+playerHealth+"');\n")

            // create the statement, and run the select query
            
            //val resultSet = statement.executeUpdate("SELECT * FROM Players ")
            //val statement = connection.createStatement()
            //statement.executeUpdate("INSERT INTO Players (playerName, age) VALUES (" +playerName+", " +age+");")
            
            
            // Welcome screen to the game
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

            println(" You have started the game with a health level of 3.")
            println(" ")
            println(" The goal is to get to the end of the game with as many health points as possible.")
            println(" ")
            println(" If your health reaches 0, your game is over.")
            println(" ")
            

            
                
                // Game loop
                while (game){
                    println(" ")
                    println(" As the game starts you find yourself in a dark forest. As you roam this forest you start to notice weird creatures.")
                    println("")
                    println(" The creatures start to come up to you and seem like they want to be petted.")
                    println("")
                    println(" Do you pet these creatures or do you shy them away. The choice is yours.")
                    println("")
                    println(" The first creature is a fairy do you pet it or do not pet")
                    var fairy =  (scanner.nextLine())
                    val resultSet4 = statement.executeUpdate("UPDATE Players SET fairy = ('"+fairy+"') WHERE playerName = ('"+playerName+"') ;")    
                    log.write("Executing 'UPDATE Players SET fairy = ('"+fairy+"') WHERE playerName = ('"+playerName+"') ;\n")    
                        if (fairy == "pet it"){
                            babyDragon()
                            
                        }else if(fairy == "do not pet"){
                            println("")
                            println(" you should have petted the fairy, it's just a fairy. Don't be chicken. You have lost 1 health")
                            takeDamage()
                            babyDragonDamage()
                        }
                    // taking damage method    
                    def takeDamage(): Unit = {
                        println("")
                        println( playerName + " has taken damage!!!")
                        health -= 1
                        println("")
                        println(playerName + " your health level is " + health)
                        println("")
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
                        log.write("Executing 'UPDATE Players SET babyDragon = ('"+babyDragon+"') WHERE playerName = ('"+playerName+"') ;\n")   
                        if (babyDragon == "pet it"){
                            println(" You are brave but that was a silly choice")
                            takeDamage()
                            goldUnicornDamage()
                            
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
                        log.write("Executing 'UPDATE Players SET babyDragon = ('"+babyDragonDamage+"') WHERE playerName = ('"+playerName+"') ;\n")   
                        if (babyDragonDamage == "pet it"){
                            println(" You are brave but silly")
                            takeDamage()
                            goldUnicornDamage()
                            //println(" Your health is still at 2.... good luck")
                        }else if (babyDragonDamage == "do not pet") {
                            goldUnicorn()
                            

                        }

                    }           
                        
                        // do not pet baby dragon
                        def goldUnicorn(){
                            println("")
                            println("Good Choice... Why would anyone pet a baby dragon. The mommy dragon would have eaten you.")
                            println("")
                            //println(" Your health is now 2. Your health points are getting low. Be careful.")
                            println("")
                            println("The final creature in your test is a Gold Unicorn. pet it or do not pet")
                            var goldUnicorn =  (scanner.nextLine())
                            val resultSet6 = statement.executeUpdate("UPDATE Players SET gold_Unicorn = ('"+goldUnicorn+"') WHERE playerName = ('"+playerName+"') ;")
                            log.write("Executing 'UPDATE Players SET gold_Unicorn = ('"+goldUnicorn+"') WHERE playerName = ('"+playerName+"') ;\n")  

                            //didnt pet fairy, pet baby dragon, pet gold unicorn
                            if (goldUnicorn  == "pet it" && health > 0 ){
                                println("")
                                println(" You never touch the gold Unicorn.")
                                println("")
                                takeDamage()
                                println(" Total health points left: " + health )
                                println("")
                                println(" Great Job. You have WON THE GAME")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                log.write("Executing 'UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;\n")  
                                game = false

                            //pet fairy, didn't pet baby dragon, didn't pet gold unicorn    
                            }else if (goldUnicorn  == "do not pet" && health == 3) {
                                println("")
                                println("Good choice not to pet the Gold Unicorn. You have ended the game with all your health points ")
                                println("")
                                println("Great Job. You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                log.write("Executing 'UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;\n")
                                game = false
                                // DOESNT END GAME LOOP

                            // didn't pet fairy, pet baby dragon, didn't pet gold unicorn    
                            }else if (goldUnicorn  == "do not pet" && health == 2) {
                                println("")
                                println("Good choice not to pet the Gold Unicorn. You have ended the game with 2 points. ")
                                println("")
                                println("Well done. You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                log.write("Executing 'UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;\n")
                                game = false

                            // didn't pet fairy, pet baby dragon, didnt pet gold unicorn    
                            }else if (goldUnicorn  == "do not pet" && health == 1){
                                println("")
                                println(" It's always a good idea to never touch the mystical unicorn. You have ended the game with 1 point.")
                                println("")
                                println("You could have done better. But either way,  You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                log.write("Executing 'UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;\n")
                                game = false
                            }
                        }

                        // pet baby dragon
                        def goldUnicornDamage(){
                            println("")
                            println("Why would anyone pet a baby dragon. The mommy dragon could have eaten you")
                            println("")
                            println("The final creature in your test is a Gold Unicorn. pet it or do not pet")
                            var goldUnicornDamage  =  (scanner.nextLine())
                            val resultSet6 = statement.executeUpdate("UPDATE Players SET gold_Unicorn = ('"+goldUnicornDamage+"') WHERE playerName = ('"+playerName+"') ;")
                            log.write("Executing 'UPDATE Players SET gold_Unicorn = ('"+goldUnicornDamage+"') WHERE playerName = ('"+playerName+"') \n")

                            //didnt pet fairy, pet baby dragon, pet gold unicorn
                            if (goldUnicornDamage == "pet it"){
                                println("")
                                println(" You never touch the gold Unicorn.")
                                println("")
                                takeDamage()
                                println(" You have lost all your health. You have LOST THE GAME.... BETTER LUCK NEXT TIME.")
                                println("")
                                println(" Total health points left: " + health )
                                println("")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                log.write("Executing 'UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;\n")
                                game = false

                            
                            // didn't pet fairy, pet baby dragon, didn't pet gold unicorn    
                            }else if (goldUnicornDamage == "do not pet" && health == 2) {
                                println("")
                                println("Good choice not to pet the Gold Unicorn. You have ended the game with 2 points. ")
                                println("")
                                println("Well done. You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                println("")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                log.write("Executing 'UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;\n")
                                game = false

                            // didn't pet fairy, pet baby dragon, didnt pet gold unicorn    
                            }else if (goldUnicornDamage == "do not pet" && health == 1){
                                println("")
                                println(" It's always a good idea to never touch the mystical unicorn. You have ended the game with 1 point.")
                                println("")
                                println("You could have done better. But either way,  You have WON THE GAME")
                                println("")
                                println(" Total health points left: " + health )
                                println("")
                                val resultSet7 = statement.executeUpdate("UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;")
                                log.write("Executing 'UPDATE Players SET endGameHealth = ('"+health+"') WHERE playerName = ('"+playerName+"') ;\n")
                                game = false
                            }
                        }
                        // create the statement, and run the select query
                
                }
            

            
            val resultSet1 = statement.executeQuery("SELECT * FROM Players")
            log.write("Executing 'SELECT * FROM Players' ;\n")
            while ( resultSet1.next() ) {
                print(resultSet1.getString(1) + " " + resultSet1.getString(2) + " " + resultSet1.getString(3) + " " + resultSet1.getString(4) + " " + resultSet1.getString(5) + " " + resultSet1.getString(6) + " " + resultSet1.getString(7))
                println("")
                println("")
                
            }

            // Query to delete database entry where play age is less then 5
            println("")
            println(" Next query will delete all players game who's age is less than 4")
            println("")
            // this is for the total number of people who ended the game with health above 2
            val resultSet8 =  statement.executeUpdate("DELETE FROM Players WHERE age < 4 ;")
            log.write("Executing 'DELETE FROM Players WHERE age < 2' \n")
            val resultSet9 = statement.executeQuery("SELECT * FROM Players")
            log.write("Executing  'SELECT * FROM Players' ;\n")
            while ( resultSet9.next() ) {
                 print(resultSet9.getString(1) + " " + resultSet9.getString(2) + " " + resultSet9.getString(3) + " " + resultSet9.getString(4) + " " + resultSet9.getString(5) + " " + resultSet9.getString(6) + " " + resultSet9.getString(7))
                 println("")
                 println("")
            }

                
            }catch {
                     case e: Exception => e.printStackTrace            

            }
                connection.close()


            log.close()

      
   
   
           
    }
}




