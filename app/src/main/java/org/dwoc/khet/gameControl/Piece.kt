package org.dwoc.khet.gameControl

import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player

// Each Types of Piece will Extend this Piece Class
abstract class Piece(val PlayerId : Player, var PosX : Int, var PosY : Int, var Orientation : Direction)
{

  //Function MovePiece will set the PosX and PosY of the Piece
  fun MovePiece (PosX : Int,PosY : Int)
  {
    this.PosX = PosX
    this.PosY = PosY
  }

  //Function RotatePiece will Rotate the Piece's Orientation by the Said Amount
  fun RotatePiece (amount : Int)
  {
     var value: Int = amount + Orientation.ordinal + 4
    value %= 4
    Orientation = Direction.values()[value]
  }

  //Function attackFrom will use the rayDirection to calculate whether or not the object hits
  // and if reflects the output ray's direction
  // and Returns a Pair of Boolean (Hit) and Direction (null if the ray is hit)
  abstract fun attackFrom(rayDirection : Direction) : Pair<Boolean , Direction?>

}

