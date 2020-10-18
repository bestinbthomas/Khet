package org.dwoc.khet.gameControl

import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player
import org.dwoc.khet.models.enums.Type
import org.dwoc.khet.models.pieces.Piece

class Sphinx(PlayerId: Player, position: Position, Orientation: Direction) :
  Piece(Type.SPHINX,PlayerId, position, Orientation) {

  override fun attackFrom(rayDirection: Direction): Pair<Boolean, Direction?> {
    return Pair(false, Direction.values()[Orientation.ordinal])
  }

  override val canReplace: Boolean
    get() = false
}
