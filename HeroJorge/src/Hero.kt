class Hero(var name: String, var heroClass: String, var race: String) {

    var strength = 0
    var dexterity = 0
    var constitution = 0
    var intelligence = 0
    var wisdom = 0
    var charisma = 0
    var healthPoints = 0
    var level = 1
    var experience = 0

    constructor(name: String,
                strength: Int,
                dexterity: Int,
                constitution: Int,
                intelligence: Int,
                wisdom: Int,
                charisma: Int,
                healthPoints: Int,
                heroClass: String,
                race: String,
                ) : this(name,heroClass, race){
                    this.strength = strength
                    this.dexterity = dexterity
                    this.constitution = constitution
                    this.intelligence = intelligence
                    this.wisdom = wisdom
                    this.charisma = charisma
                    this.healthPoints = healthPoints
                    this.experience = 0
                }
    init {
        if (!checkHeroClass(heroClass)) this.heroClass = "Explorador"
        if (!checkRace(race)) this.race = "Humano"
        generarAttributes()
         val valorClase = when (heroClass.trim().lowercase()) {
             "bárbaro", "barbaro" -> 12
             "guerrero", "paladín", "paladin", "explorador" -> 10
             "bardo", "clérigo", "clerigo", "druida",
             "monje", "pícaro", "picaro", "brujo" -> 8
             "mago", "hechicero" -> 6
             else -> {0}
         }
        healthPoints = (valorClase +(constitution -10) / 2)
        this.level = 1
        this.experience = 0




    }


    fun checkHeroClass(heroClass: String): Boolean {
        val classes: Array<String> = arrayOf(
            "Guerrero", "Bárbaro", "Paladín", "Explorador",
            "Pícaro", "Mago", "Hechicero", "Brujo",
            "Clérigo", "Druida", "Bardo", "Monje"
        )
        return classes.contains(heroClass)
    }

    fun checkRace(race: String): Boolean {
        val races: Array<String> = arrayOf(
            "Humano", "Elfo", "Enano", "Mediano",
            "Orco", "Gnomo", "Tiefling", "Dracónido"
        )
        return races.contains(race)
    }

    fun generarAttributes(){
        val maxStats = 72
        val totalAtributes = 8
        val maxRolls = maxStats - totalAtributes  *6
        val stats = IntArray(6) {8}
        repeat(maxRolls) {
            do {
                var succesfullyRolled = false
                var position = (0..5).random()
                if (stats[position] <15) {
                    stats[position]++
                    succesfullyRolled = true
                }
            }while (!succesfullyRolled)
        }
            this.strength = stats[0]
            this.dexterity = stats[1]
            this.constitution += stats[2]
            this.intelligence += stats[3]
            this.wisdom += stats[4]
            this.charisma += stats[5]
    }
}