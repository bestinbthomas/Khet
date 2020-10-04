package org.dwoc.khet.gameControl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.dwoc.khet.gameControl.interfaces.BoardInterface
import org.dwoc.khet.models.Position
import org.dwoc.khet.models.enums.Player
import org.dwoc.khet.models.pieces.Piece

class Board : BoardInterface {
  private val moves: Array<Position> = arrayOf(
    Position(0, 1),
    Position(0, -1),
    Position(1, 0),
    Position(-1, 0),
    Position(1, 1),
    Position(1, -1),
    Position(-1, -1),
    Position(-1, 1)
  )
  private val pieces: List<Piece> = listOf()

  private val mutableHighlightPositions = MutableLiveData<List<Position>>()
  override val highlightPositions: LiveData<List<Position>>
    get() = mutableHighlightPositions

  private val mutableSelectedPiece = MutableLiveData<Piece?>()
  override val selectedPiece: LiveData<Piece?>
    get() = mutableSelectedPiece

  private val mutableLaserPath = MutableLiveData<List<Position>>()
  override val laserPath: LiveData<List<Position>>
    get() = mutableLaserPath

  private val mutableCurrentPlayer = MutableLiveData<Player>()
  override val currentPlayer: LiveData<Player>
    get() = mutableCurrentPlayer

  init {
    mutableCurrentPlayer.value = Player.PLAYER1
  }

  override fun getPiece(position: Position) =
    pieces.find {
      it.position == position
    }

  override fun onClick(position: Position) {
    if (selectedPiece.value != null && highlightPositions.value?.contains(position) == true) {
      selectedPiece.value!!.movePiece(position)
      resetSelection()
      completeMove()
      return
    }
    selectPiece(position)
  }

  override fun selectPiece(position: Position) {
    val piece = getPiece(position)
    mutableSelectedPiece.value = piece
    updateHighlightedPositions(piece)
  }

  override fun resetSelection() {
    mutableSelectedPiece.value = null
    mutableHighlightPositions.value = listOf()
  }

  override fun rotatePiece(amount: Int) {
    selectedPiece.value ?: return
    selectedPiece.value!!.rotatePiece(amount)
  }

  override fun shootLaser(player: Player) {
    TODO("start shooting the laser, update the pieces and update the laser path")
  }

  override fun resetLaser() {
    mutableLaserPath.value = listOf()
  }

  override fun getState(): List<Piece> = pieces

  override fun completeMove() {
    shootLaser(currentPlayer.value!!)
    if (currentPlayer.value == Player.PLAYER1) mutableCurrentPlayer.value = Player.PLAYER2
    if (currentPlayer.value == Player.PLAYER2) mutableCurrentPlayer.value = Player.PLAYER1
  }

  private fun updateHighlightedPositions(piece: Piece?) {
    if (piece == null) {
      mutableHighlightPositions.value = listOf()
      return
    }
    mutableHighlightPositions.value = moves.filter {
      val newPos = piece.position + it
      newPos.checkLimits() && (piece.canReplace || getPiece(newPos) == null)
    }.map { it + piece.position }
  }
}
