package org.dwoc.khet.models.pieces

import org.dwoc.khet.models.enums.Direction
import org.dwoc.khet.models.enums.Player

/**
 * Scarab Class Extends Piece Class
 * This Class is used to store Scarab or Djed Pieces
 */
class Scarab(PlayerId : Player, PosX : Int, PosY : Int, Orientation : Direction)  : Piece(PlayerId, PosX, PosY, Orientation)  {

  override fun attackFrom(rayDirection: Direction): Pair<Boolean, Direction?> {

    var dir : Int = rayDirection.ordinal

    dir -= Orientation.ordinal
    dir += 4
    dir %= 4

    //N-E & S-W Conversion
    dir += if (dir % 2 == 0) { 1 }
    else { -1 }

    dir += Orientation.ordinal + 4
    dir %= 4

    return Pair(false, Direction.values()[dir])
  }
}
