window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.Login = window.blockly.js.blockly.auth.Login || {};

/**
 * @function login
 *
 * Login
 *
 * @param login
 * @param password
 * @param options
 *
 * @author Root
 * @since 23/05/2022 16:54:14
 *
 */
window.blockly.js.blockly.auth.Login.loginArgs = [{ description: 'login', id: '59ce6194' }, { description: 'password', id: 'f419e7db' }, { description: 'options', id: '0ba16150' }];
window.blockly.js.blockly.auth.Login.login = async function(login, password, options) {
 var item, route;
  //
  if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getHostapp())) {
    //
    this.cronapi.util.getURLFromOthers('POST', 'application/x-www-form-urlencoded', String(this.cronapi.screen.getHostapp()) + String('auth'), this.cronapi.object.createObjectLoginFromString(login, password), null, async function(sender_item) {
        item = sender_item;
      //
      this.cronapi.util.setLocalStorage('_u', this.cronapi.object.serializeObject(item));
      //
      route = (await this.cronapi.server('blockly.Route.ToTake').names('c19ec136').toPromise().run(login));
      //
      if (route == 'my-team') {
        //
        this.cronapi.screen.changeView("#/app/logged/my-team",[  ]);
      } else if (route == 'pick-player') {
        //
        this.cronapi.screen.changeView("#/app/logged/pick-player",[  ]);
      }
    }.bind(this), async function(sender_item) {
        item = sender_item;
      //
      if (this.cronapi.object.getProperty(item, 'status') == '403' || this.cronapi.object.getProperty(item, 'status') == '401') {
        //
        this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.invalidPassword",[  ]));
      } else if (this.cronapi.object.getProperty(item, 'status') == '502') {
        //
        this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.ServerOff",[  ]));
      } else if (this.cronapi.object.getProperty(item, 'status') == '404') {
        //
        this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Login.view.HostAppOff",[  ]));
      } else if (this.cronapi.object.getProperty(item, 'status') == '0') {
        //
        this.cronapi.screen.notify('error',this.cronapi.i18n.translate("Admin.server.out",[  ]));
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.object.getProperty(item, 'responseJSON.message'));
      }
    }.bind(this));
  } else {
    //
    this.cronapi.screen.notify('error','HostApp is Required');
  }
}
