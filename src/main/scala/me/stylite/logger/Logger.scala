package me.stylite.logger


import java.awt.Color
import java.io.FileInputStream
import java.util.Properties

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import net.dv8tion.jda.bot.sharding.{DefaultShardManagerBuilder, ShardManager}
import net.dv8tion.jda.core.entities.Game
import me.stylite.logger.events.EventHandler



object Logger extends App {

  val prop = new Properties()
  prop.load(new FileInputStream("config.properties"))
  val LOG: Logger = LoggerFactory.getLogger("Logger")

  val PREFIX = prop.getProperty("PREFIX")
  val loghook = prop.getProperty("WEBHOOK")
  val BOT_COLOR = Color.pink


  val Sana = new DefaultShardManagerBuilder()
    .setToken(prop.getProperty("DISCORD_TOKEN"))
    .addEventListeners(EventHandler)
    .setGame(Game.watching("you"))
    .build()


}
