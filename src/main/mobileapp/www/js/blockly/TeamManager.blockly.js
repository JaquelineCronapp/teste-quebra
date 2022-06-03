window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TeamManager = window.blockly.js.blockly.TeamManager || {};

/**
 * @function SetPlayerPositionHideBalance
 *
 * Descreva esta função...
 *
 * @param player
 * @param position
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.SetPlayerPositionHideBalanceArgs = [{ description: 'player', id: '79764729' }, { description: 'position', id: '4cd7fee8' }];
window.blockly.js.blockly.TeamManager.SetPlayerPositionHideBalance = async function(player, position) {

  //
  playerPositionContent = this.cronapi.screen.getContent(String(player) + String('-position'));
  //
  allowedPositions = ['ATA', 'MEI', 'ZAG', 'GOL', 'TÉC'];
  //
  if (allowedPositions.indexOf(playerPositionContent) + 1 != 0) {
    //
    this.cronapi.screen.changeContent(String(player) + String('-position'), position, 'false');
    //
    this.cronapi.screen.changeAttrValue(String(player) + String('-image'), 'src', 'img/addPlayerGreen.png');
    //
    this.cronapi.screen.setVisibility(String(player) + String('-container-balance'), 'false');
  }
  //
  this.cronapi.screen.changeAttrValue(player, 'data-position', position);
}

/**
 * @function RemoveAllPlayersClass
 *
 * Descreva esta função...
 *
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.RemoveAllPlayersClassArgs = [];
window.blockly.js.blockly.TeamManager.RemoveAllPlayersClass = async function() {
 var selectedSchema;
  //
  for (playerIdx = 2; playerIdx <= 11; playerIdx++) {
    //
    for (bootstrapIdx = 1; bootstrapIdx <= 12; bootstrapIdx++) {
      //
      this.cronapi.screen.removeClass(String('player') + String(playerIdx), String('col-xs-') + String(bootstrapIdx));
      //
      this.cronapi.screen.removeClass(String('player') + String(playerIdx), ['col-xs-',bootstrapIdx,'-4'].join(''));
    }
  }
}

/**
 * @function ChangeScheme
 *
 * TeamManager
 *
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.ChangeSchemeArgs = [];
window.blockly.js.blockly.TeamManager.ChangeScheme = async function() {
 var selectedSchema;
  //
  selectedSchema = this.cronapi.screen.getValueOfField("vars.schema");
  //
  if (this.cronapi.logic.isNullOrEmpty(selectedSchema)) {
    //
    this.cronapi.screen.notify('error','Selecione um esquema');
  } else {
    //
    (await this.cronapi.server('blockly.PickPlayer.UpdateScheme').names('99ba610a').toPromise().run(selectedSchema));
    //
    (await this.blockly.js.blockly.TeamManager.RemoveAllPlayersClass());
    //
    (await this.blockly.js.blockly.TeamManager.SetScheme(selectedSchema));
  }
}

/**
 * @function SetScheme
 *
 * Descreva esta função...
 *
 * @param scheme
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.SetSchemeArgs = [{ description: 'scheme', id: '2376e36b' }];
window.blockly.js.blockly.TeamManager.SetScheme = async function(scheme) {

  //
  schemaSplited = scheme.split('-');
  //
  for (i = 0; i <= 2; i++) {
    //
    if (i == 0) {
      //
      currentPlayer = 2;
      //
      currentPosition = 'ZAG';
    } else if (i == 1) {
      //
      currentPosition = 'MEI';
    } else {
      //
      currentPosition = 'ATA';
    }
    //
    schemaValue = schemaSplited[(((i + 1)) - 1)];
    //
    classNumber = this.cronapi.text.replaceAll(String((12 / schemaValue)), '.', '-', '-');
    //
    var j_inc = 1;
    if (1 > schemaValue) {
      j_inc = -j_inc;
    }
    for (j = 1; j_inc >= 0 ? j <= schemaValue : j >= schemaValue; j += j_inc) {
      //
      this.cronapi.screen.addClass(String('player') + String(currentPlayer), String('col-xs-') + String(classNumber));
      //
      (await this.blockly.js.blockly.TeamManager.SetPlayerPositionHideBalance(String('player') + String(currentPlayer), currentPosition));
      //
      currentPlayer = (currentPlayer + 1);
    }
  }
  //
  (await this.blockly.js.blockly.TeamManager.SetPlayerPositionHideBalance('player1', 'GOL'));
  //
  (await this.blockly.js.blockly.TeamManager.SetPlayerPositionHideBalance('coach', 'TÉC'));
  //
  allPositions = ['ATA', 'MEI', 'ZAG', 'GOL'];
  //
  for (k = 1; k <= 5; k++) {
    //
    (await this.blockly.js.blockly.TeamManager.SetPlayerPositionHideBalance(String('playerReserve') + String(k), allPositions[(k - 1)]));
  }
}

/**
 * @function Test
 *
 * Descreva esta função...
 *
 * @param how
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.TestArgs = [{ description: 'how', id: 'cb121688' }];
window.blockly.js.blockly.TeamManager.Test = async function(how) {

  //
  this.cronapi.screen.showIonicModal("modal56373");
  //
  this.cronapi.screen.notify('success',how);
}

/**
 * @function RemovePlayer
 *
 * Descreva esta função...
 *
 * @param player
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.RemovePlayerArgs = [{ description: 'player', id: '6e784b3e' }];
window.blockly.js.blockly.TeamManager.RemovePlayer = async function(player) {

  //
  img = this.cronapi.screen.getAttrValue(String(player) + String('-image'), 'src');
  //
  if (img.indexOf('data:image/') + 1 != 0) {
    //
    answerQuestion = this.cronapi.screen.confimDialog('Deseja vender?');
    //
    if (answerQuestion) {
      //
      (await this.cronapi.server('blockly.PickPlayer.SelectPlayer').names('67ad29de', 'bdc9375c').toPromise().run(player, null));
    }
    //
    (await this.cronapi.server('blockly.PickPlayer.OnLoad').toPromise().run());
  }
}

/**
 * @function SelectPlayer
 *
 * Descreva esta função...
 *
 * @param playerId
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.SelectPlayerArgs = [{ description: 'playerId', id: '919c63d8' }];
window.blockly.js.blockly.TeamManager.SelectPlayer = async function(playerId) {

  //
  player = this.cronapi.util.getLocalStorage('player');
  //
  (await this.cronapi.server('blockly.PickPlayer.SelectPlayer').names('67ad29de', 'bdc9375c').toPromise().run(player, playerId));
  //
  this.cronapi.screen.hideIonicModal("modal56373");
  //
  (await this.cronapi.server('blockly.PickPlayer.OnLoad').toPromise().run());
}

/**
 * @function CloseModalAllPlayer
 *
 * Descreva esta função...
 *
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.CloseModalAllPlayerArgs = [];
window.blockly.js.blockly.TeamManager.CloseModalAllPlayer = async function() {
 var selectedSchema;
  //
  this.cronapi.screen.hideIonicModal("modal56373");
}

/**
 * @function ListAllPlayers
 *
 * Descreva esta função...
 *
 * @param player
 *
 * @author Root
 * @since 02/06/2022 15:23:59
 *
 */
window.blockly.js.blockly.TeamManager.ListAllPlayersArgs = [{ description: 'player', id: '82d6bb38' }];
window.blockly.js.blockly.TeamManager.ListAllPlayers = async function(player) {

  //
  this.cronapi.util.setLocalStorage('player', player);
  //
  position = this.cronapi.screen.getAttrValue(player, 'data-position');
  //
  idsFromMyTeam = (await this.cronapi.server('blockly.PickPlayer.GetAllPlayersIdsFromTeam').toPromise().run());
  //
  idsFilter = '';
  //
  var i_end = idsFromMyTeam.length;
  var i_inc = 1;
  if (1 > i_end) {
    i_inc = -i_inc;
  }
  for (i = 1; i_inc >= 0 ? i <= i_end : i >= i_end; i += i_inc) {
    //
    currentId = idsFromMyTeam[(i - 1)];
    //
    idsFilter = [idsFilter,' and id ne \'',currentId,'\''].join('');
  }
  //
  (await this.cronapi.screen.showIonicModal("modal56373"));
  //
  this.cronapi.screen.filter("Player", ['substringof(\'',position,'\',position_name)',idsFilter].join(''));
}
