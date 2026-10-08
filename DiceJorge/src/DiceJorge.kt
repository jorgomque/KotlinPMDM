class Dice (faces : Int){
    var faces: Int = faces
        private set
    private var quantityOfThrows = 0

    constructor() : this(6){
    }
    init {
        if (faces >1 ) this.faces = faces
        else this.faces = 6
    }
    fun throwDice() : Int {
        quantityOfThrows ++
        return (1..faces).random()
    }
    fun resetStatistics() {
        this.quantityOfThrows = 0
    }

    fun statistics():String {
        return ("Este dado tiene: ${this.faces} caras y se ha tirado un total de ${this.quantityOfThrows} veces.")
    }

    fun getQuantityOfThrows():Int {
        return this.quantityOfThrows
    }

    companion object {
        fun throwDice(faces: Int) : Int {
            return (1..faces).random()
        }
    }

}