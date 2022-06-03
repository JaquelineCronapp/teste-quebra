window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.MyTeam = window.blockly.js.blockly.MyTeam || {};

/**
 * @function Next
 *
 * MyTeam
 *
 *
 * @author Root
 * @since 25/05/2022 15:12:24
 *
 */
window.blockly.js.blockly.MyTeam.NextArgs = [];
window.blockly.js.blockly.MyTeam.Next = async function() {

  //
  if ((await this.blockly.js.blockly.MyTeam.CheckValidFields())) {
    //
    (await this.cronapi.server('blockly.MyTeam.Register').names('08c3c9c3', '4f14365a', 'a07e9d82').toPromise().run(this.cronapi.screen.getValueOfField("vars.teamName"), this.cronapi.screen.getValueOfField("vars.ownerName"), this.cronapi.screen.getValueOfField("vars.team")));
    //
    this.cronapi.screen.changeView("#/app/logged/pick-player",[  ]);
  }
}

/**
 * @function CheckValidFields
 *
 *
 *
 *
 * @author Root
 * @since 25/05/2022 15:12:24
 *
 */
window.blockly.js.blockly.MyTeam.CheckValidFieldsArgs = [];
window.blockly.js.blockly.MyTeam.CheckValidFields = async function() {

  //
  valid = true;
  //
  error = '';
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.teamName"))) {
    //
    error = '- Insira o nome do time\n';
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.ownerName"))) {
    //
    error = String(error) + String('- Insira o nome do dono do time\n');
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.team"))) {
    //
    error = String(error) + String('- Selecione o seu time favorito');
  }
  //
  if (!this.cronapi.logic.isNullOrEmpty(error)) {
    //
    valid = false;
    //
    this.cronapi.screen.notify('success',error);
  }
  return valid;
}
