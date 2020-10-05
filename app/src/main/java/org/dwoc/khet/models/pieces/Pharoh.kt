package org.dwoc.khet.models.pieces

import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player
import org.dwoc.khet.models.enums.Type

/**
 * Pharoh Class Extends Piece Class
 * This Class is used to store Pharoh Pieces
 */
class Pharoh(PlayerId : Player, Position: Position, Orientation : Direction)  : Piece(Type.PHARAOH, PlayerId, Position, Orientation)  {

  override fun attackFrom(rayDirection: Direction): Pair<Boolean, Direction?> {
     return Pair(true,null)
  }

  override val canReplace: Boolean
    get() = false
}
