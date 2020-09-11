package org.dwoc.khet.gameControl

import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player

/**
 * Each Types of Piece will Extend this Piece Class
 */
abstract class Piece(val PlayerId : Player, var PosX : Int, var PosY : Int, var Orientation : Direction)
{

  /**
   * MovePiece will set the PosX and PosY of the Piece
   * @param PosX The X-Coordinate of the Position to move
   * @param PosY The Y-Coordinate of the Position to move
   */
  fun MovePiece (PosX : Int,PosY : Int)
  {
    this.PosX = PosX
    this.PosY = PosY
  }

  /**
   * RotatePiece will Rotate the Piece's Orientation by the Said amount
   * @param amount the amount to rotate will take values between -3 to 3
   */
  fun RotatePiece (amount : Int)
  {
     var value: Int = amount + Orientation.ordinal + 4
    value %= 4
    Orientation = Direction.values()[value]
  }

  /**
   * attackFrom will use the rayDirection to calculate whether or not the object hits
   * and if reflects the output ray's direction
   * @param rayDirection the Direction of the Incident ray with respect to the Board
   * @return a Pair of Boolean (Hit on Object) and Direction (null if the ray is hit)
   */
  abstract fun attackFrom(rayDirection : Direction) : Pair<Boolean , Direction?>

}

