package org.dwoc.khet.models.pieces

import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player
import org.dwoc.khet.models.enums.Type

class Obelisk(PlayerId: Player, Position: Position, Orientation: Direction) :
  Piece(Type.PHARAOH, PlayerId, Position, Orientation) {

  override fun attackFrom(rayDirection: Direction) = Pair(true, null)

  override val canReplace: Boolean
    get() = false
}
