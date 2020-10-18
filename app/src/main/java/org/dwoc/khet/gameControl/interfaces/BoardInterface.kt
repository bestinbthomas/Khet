package org.dwoc.khet.gameControl.interfaces

import androidx.lifecycle.LiveData
import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Player
import org.dwoc.khet.models.pieces.Piece

interface BoardInterface {
  /**
   * The positions the selected piece can move to (to be highlighted by the UI)
   */
  val highlightPositions: LiveData<List<Position>>

  /**
   * The selected piece
   */
  val selectedPiece: LiveData<Piece?>

  /**
   *   Path traversed by the laser
   */
  val laserPath: LiveData<List<Position>>

  val currentPlayer: LiveData<Player>

  /**
   *   Get the piece selected by the user
   *
   * @param position to search
   * @return Piece
   */
  fun getPiece(position: Position): Piece?

  /**
   * general function to be called when user clicks on the board
   *
   * @param position
   */
  fun onClick(position: Position)

  /**
   * Select a piece
   *
   * @param position
   */
  fun selectPiece(position: Position)

  /**
   * reset selection to null (to be used after the move or cancel the move)
   *
   */
  fun resetSelection()

  /**
   * rotate a piece
   *
   * @param amount
   */
  fun rotatePiece(amount: Int)

  /**
   * gets triggered when user shoots the laser
   *
   * @param player
   */
  fun shootLaser(player: Player)

  /**
   * reset the laser path
   *
   */
  fun resetLaser()

  /**
   * Get the list of pieces
   *
   * @return
   */
  fun getState(): List<Piece>

  /**
   * Indicate that move is complete
   *
   */
  fun completeMove()
}
