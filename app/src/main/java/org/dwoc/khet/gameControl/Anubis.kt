package org.dwoc.khet.gameControl

import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player
import org.dwoc.khet.models.enums.Type
import org.dwoc.khet.models.pieces.Piece

class Anubis(PlayerId: Player, position: Position, Orientation: Direction) :
  Piece(Type.ANUBIS,PlayerId, position, Orientation) {

  override fun attackFrom(rayDirection: Direction): Pair<Boolean, Direction?> {
    var isDeflected: Boolean = false
    if ((rayDirection.ordinal == 0 && Orientation.ordinal == 2) || (rayDirection.ordinal == 1 && Orientation.ordinal == 3)
      || (rayDirection.ordinal == 2 && Orientation.ordinal == 0) || (rayDirection.ordinal == 3 && Orientation.ordinal == 1)
    ) {
      isDeflected = true
    }
    return Pair(isDeflected, null)
  }

  override val canReplace: Boolean
    get() = false
}
