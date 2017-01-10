package hearthstone.parse


import Hero._;
import scala.collection.mutable.ListBuffer



class Game(xHasCoin: Boolean, xDidWin: Boolean, xHero: Hero.Value, xRank:Int, xTurns: List[Turn])extends java.io.Serializable {
	var hasCoin = xHasCoin
	var didWin = xDidWin
	var hero = xHero
	var rank = xRank
	var turns = xTurns
	
	def getCardListBuff:ListBuffer[Card] ={
		val cardBuff = new ListBuffer[Card]
		xTurns.foreach{turn =>
			turn.getCardList
			.foreach { card =>cardBuff+= card }
		}
		cardBuff
	}
	def getCardList:List[Card] = {
		getCardListBuff.toList
	}
	
	def getCardIdListBuff: ListBuffer[String] ={
		val cardIdBuff = new ListBuffer[String]
		xTurns.foreach{turn =>
			turn.getCardIdList
			.foreach { cardId =>cardIdBuff+= cardId }
		}
		cardIdBuff
	}
	
	def getCardIdList: List[String] ={
		getCardIdListBuff.toList
	}
	
	  def toStringBuilder: StringBuilder ={
		val sb = new StringBuilder
		sb.append("hero: ")
		sb.append(hero)
		sb.append(", hasCoin: ") 
		sb.append(hasCoin)
		sb.append(", didWin: ")
		sb.append(didWin)
		sb.append(", rank: ")
		sb.append(rank)
		sb.append(",\nturns: [")
		turns.foreach { turn => 
			sb.append(turn.toStringBuilder) 
			sb.append(", ") }
    	sb.delete(sb.length-3, sb.length-1)
    	sb.append("]\n")
	}
	override def toString: String=
		toStringBuilder.toString
		
	
}