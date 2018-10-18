package me.stylite.logger.events

import java.awt.Color

import me.stylite.logger.Logger._
import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.hooks.ListenerAdapter
import net.dv8tion.jda.webhook._

import net.dv8tion.jda.core.events.guild.member.{GuildMemberJoinEvent, GuildMemberLeaveEvent}

object EventHandler extends ListenerAdapter  {

  override def onGuildMemberJoin(event: GuildMemberJoinEvent): Unit = {
    val member = event.getMember
    val name = member.getUser.getName
    val creationDate = member.getUser.getCreationTime.getMonthValue + "-" + member.getUser.getCreationTime.getDayOfMonth + "-" + member.getUser.getCreationTime.getYear
    val joinDate = member.getJoinDate.getMonthValue + "-" + member.getJoinDate.getDayOfMonth + "-" + member.getJoinDate.getYear
    val avatar = member.getUser.getAvatarUrl
    val uId = member.getUser.getId
    val readyClient = new WebhookClientBuilder(loghook).build()
    readyClient.send(new EmbedBuilder().setColor(Color.pink)
      .setAuthor(name, avatar, avatar)
      .setTitle(s"${member.getUser.getName} Joined!")
      .setThumbnail(avatar)
      .addField("Username", s"${member.getUser.getName}", false)
      .addField("Creation Date", s"$creationDate\n", false)
      .addField("Join Date", s"$joinDate\n", false)
      .addField("User ID", s"$uId\n", false)
      .build())
    LOG.info(s"${member.getUser.getName} Joined! " + s"$joinDate, $avatar")
    readyClient.close()
  }

  override def onGuildMemberLeave(event: GuildMemberLeaveEvent): Unit = {
    val member = event.getMember
    val name = member.getUser.getName
    val creationDate = member.getUser.getCreationTime.getMonthValue + "-" + member.getUser.getCreationTime.getDayOfMonth + "-" + member.getUser.getCreationTime.getYear
    val joinDate = member.getJoinDate.getMonthValue + "-" + member.getJoinDate.getDayOfMonth + "-" + member.getUser.getCreationTime.getYear
    val avatar = member.getUser.getAvatarUrl
    val uId = member.getUser.getId
    val readyClient = new WebhookClientBuilder(loghook).build()
    readyClient.send(new EmbedBuilder().setColor(Color.pink)
      .setAuthor(name, avatar, avatar)
      .setTitle(s"${member.getUser.getName} left!")
      .setThumbnail(avatar)
      .addField("Username", s"${member.getUser.getName}", false)
      .addField("Creation Date", s"$creationDate\n", false)
      .addField("Join Date", s"$joinDate\n", false)
      .addField("User ID", s"$uId\n", false)
      .build())
    LOG.info(s"${member.getUser.getName} Joined! " + s"$joinDate, $avatar")
    readyClient.close()
  }

}
