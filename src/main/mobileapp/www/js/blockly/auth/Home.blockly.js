window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.Home = window.blockly.js.blockly.auth.Home || {};

/**
 * @function change
 *
 * Home
 *
 *
 * @author Root
 * @since 23/05/2022 16:57:14
 *
 */
window.blockly.js.blockly.auth.Home.changeArgs = [];
window.blockly.js.blockly.auth.Home.change = async function() {

  //
  this.cronapi.screen.changeView("#/app/login",[  ]);
}
