package org.dwoc.khet.models.pieces

import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player

/**
 * Pharoh Class Extends Piece Class
 * This Class is used to store Pharoh Pieces
 */
class Pharoh(PlayerId : Player, PosX : Int, PosY : Int, Orientation : Direction)  : Piece(PlayerId, PosX, PosY, Orientation)  {

  override fun attackFrom(rayDirection: Direction): Pair<Boolean, Direction?> {
     return Pair(true,null)
  }
}
