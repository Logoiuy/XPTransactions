# XPTransactions
A PaperMC plugin for using experience as a currency and other quality of life features.

<b>With the Plugin you can:</b>

 - have unlimited night vision (if you want)
 - transfer experience between players
 - teleport wherever you want with Exp
 - send items to other players
 - convert your Exp into potions
 - play lotto

<b>Commands:</b>

<table>
<tr> <th> Command </th> <th> Description </th> </tr> 

<tr> <td>/nightvision </td> <td><i> gives you night vision, if the plugin fails to do it automatically </i> </td></tr>

 <tr><td>/givexp &lt;target player> &lt;transfer amount> </td> <td><i> transfers the given amount of levels to the targeted player</i></td> </tr>

<tr><td>/tpe &lt;x> &lt;y> &lt;z> </td><td><i>teleports you to the given coords for the cost of (by default) 1 level</i></td></tr>

<tr><td>/send &lt;target player></td><td><i>sends the item(s) that you are holding in your hand to the targeted player (by default) for free</i></td></tr>

<tr><td>/lotto</td><td><i>(if enabled) takes a configurable amount of levels (by default 2) to play and randomly gives you either nothing or one of the prizes configured, with the configured probabilities. Default prizes: 5 levels: 20%, 10 levels: 3%, 30 levels: 1%</i></td></tr>
<tr><td>/convert &lt;<i>optional</i> amount></td><td><i>converts all (or the given amount) of your levels into a potion that you can drink to get the levels back</i></td></tr>
</table>

<b>Config:</b>

<table>
<tr>
<td>allowConversion: true</td> <td>enables or disables the convert command (Already converted bottles can still be used)</td>
</tr><tr>
<td>autoNightVision: true</td> <td>enables or disables night vision</td>
</tr><tr>
<td>ItemSendCost: 0</td> <td>sets the cost in levels for the sending of items</td>
</tr><tr>
<td>enableExpTeleportation: true </td><td>enables or disables the tpe command</td>
</tr><tr>
<td>ExpTeleportationCost: 1 </td> <td>sets the cost of the tpe command</td>
</tr><tr>
<td>enableExpLotto: false </td><td>enables or disables the lotto command</td>
</tr><tr>
<td>lottoCooldown: 600 </td><td>set the cooldown between uses of lotto in seconds</td>
</tr><tr>
<td>lottoPrizes: - '&lt;amount of levels>:&lt;winning probability in percent>'</td><td>define how many levels can be won with what probability. You can have multiple prizes with different probabilities. The probabilities have to add up to less then 100%, else buggy behaviour will occur. You can use fractions of percents with a . as decimal separator. The default values are balanced to have an expected value close to 0, so on average you won't win or lose experience when playing.</td>
</tr>
</table>

<b>Download:</b> <br>
https://modrinth.com/plugin/xptransactions
