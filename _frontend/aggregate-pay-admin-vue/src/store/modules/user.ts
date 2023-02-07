import { VuexModule, Module, Action, Mutation, getModule } from 'vuex-module-decorators'
import { login, checkToken } from '@/api/users'
import { getToken, setToken, removeToken, setTenantId, getTenantId } from '@/utils/cookies'
import store from '@/store'
import { format } from 'path'
export interface IUserState {
  token: string
  name: string
  avatar: string
  introduction: string
  roles: string[]
  userId: number

}

@Module({ dynamic: true, store, name: 'user' })
class User extends VuexModule implements IUserState {
  public token = getToken() || ''
  public name = ''
  public avatar = ''
  public introduction = ''
  public roles: string[] = []
  public userId = 0
  public tenantId = getTenantId() || 0
  
  public userName = ''
  public mobile = ''
  public menus: string[] = []
  public buttons: string[] = []
  public hasLoaded = false

  @Mutation
  private SET_TOKEN(token: string) {
    this.token = token
  }

  @Mutation
  private SET_NAME(name: string) {
    this.name = name
  }

  @Mutation
  private SET_AVATAR(avatar: string) {
    this.avatar = avatar
  }

  @Mutation
  private SET_INTRODUCTION(introduction: string) {
    this.introduction = introduction
  }

  @Mutation
  private SET_TENANTID(tenantId: number) {
    this.tenantId = tenantId
  }

  @Mutation
  private SET_ROLES(roles: string[]) {
    this.roles = roles
  }

  @Mutation
  private SET_USER_ID(userId: number) {
    this.userId = userId
  }

  @Mutation
  private SET_USERNAME(userName: string) {
    this.userName = userName
  }

  @Mutation
  private SET_MOBILE(mobile: string) {
    this.mobile = mobile
  }

  @Mutation
  private SET_MENUS(menus: string[]) {
    this.menus = menus
  }

  @Mutation
  private SET_BUTTONS(buttons: string[]) {
    this.buttons = buttons
  }

  @Mutation
  private SET_HAS_LOADED(hasLoaded: boolean) {
    this.hasLoaded = hasLoaded
  }

  @Action
  public async Login(userInfo: { usernames: string, password: string }) {
    let { usernames, password } = userInfo
    usernames = usernames.trim()
    let client_id = 'merchant-platform'
    let client_secret = '123456'
    let grant_type = 'password'
    let username = {
      username: usernames,
      authenticationType: 'password'
    }

    const params = new URLSearchParams()

    params.append('client_id', client_id)
    params.append('client_secret', client_secret)
    params.append('grant_type', grant_type)
    params.append('password', password)
    params.append('username', JSON.stringify(username))
    let arr = []

    const res = await login(params)
    const param = new URLSearchParams()
    param.append('token', res.access_token)
    const responses = await checkToken(param)
    for (var item in responses.payload) {
      arr.push(item)
    }
    setToken(res.access_token)
    setTenantId(arr[0])
    console.log(responses)
    console.log(arr)
    localStorage.setItem('username', responses.user_name)
    localStorage.setItem('mobile', responses.mobile)
    this.SET_TOKEN(res.access_token)
    this.SET_TENANTID(arr[0])
  }
  @Action
  public async operationLogin(userInfo: { usernames: string, password: string }) {
    let { usernames, password } = userInfo
    usernames = usernames.trim()
    let client_id = 'operation-platform'
    let client_secret = '123456'
    let grant_type = 'password'
    let username = {
      username: usernames,
      authenticationType: 'password'
    }

    const params = new URLSearchParams()

    params.append('client_id', client_id)
    params.append('client_secret', client_secret)
    params.append('grant_type', grant_type)
    params.append('password', password)
    params.append('username', JSON.stringify(username))
    let arr = []

    const res = await login(params)
    const param = new URLSearchParams()
    param.append('token', res.access_token)
    const responses = await checkToken(param)
    for (var item in responses.payload) {
      arr.push(item)
    }
    setToken(res.access_token)
    setTenantId(arr[0])
    console.log(responses)
    console.log(arr)
    localStorage.setItem('username', responses.user_name)
    localStorage.setItem('mobile', responses.mobile)
    this.SET_TOKEN(res.access_token)
    this.SET_TENANTID(arr[0])
  }
  @Action
  public async Logins(userInfo: {
    phone: string,
    code: string,
    smsKey: string
  }) {
    let { phone, code, smsKey } = userInfo
    phone = phone.trim()
    let client_id = 'merchant-platform'
    let client_secret = '123456'
    let grant_type = 'password'
    let username = {
      username: phone,
      authenticationType: 'sms',
      payload: {
        smsKey: smsKey
      }
    }

    const params = new URLSearchParams()

    params.append('client_id', client_id)
    params.append('client_secret', client_secret)
    params.append('grant_type', grant_type)
    params.append('password', code)
    params.append('username', JSON.stringify(username))
    let arr = []

    const res = await login(params) 
    const param = new URLSearchParams()
    param.append('token', res.access_token)
    const responses = await checkToken(param)

    for (var item in responses.payload) {
      arr.push(item)
    }
    console.log(arr)
    setToken(res.access_token)
    setTenantId(arr[0])
    localStorage.setItem('username', responses.user_name)
    localStorage.setItem('mobile', responses.mobile)
    this.SET_TOKEN(res.access_token)
    this.SET_TENANTID(arr[0])
  }
  @Action
  public ResetToken() {
    removeToken()
    this.SET_TOKEN('')
    this.SET_ROLES([])
    this.SET_USER_ID(0)
  }

  @Action
  public async GetUserInfo() {
    this.SET_ROLES(['11'])
    this.SET_NAME(this.name)
    this.SET_AVATAR(
      'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif'
    )
    this.SET_INTRODUCTION('I am a super administrator')
    // TODO: 通过/uaa/oauth/check_token接口获取菜单权限
    this.SET_MENUS([
      'P001',
      'P001001',
      'P001002',
      'P002',
      'P002001',
      'P002002',
      'P002003',
      'P002004',
      'P003',
      'P003001',
      'P003002'
      // 'P004',
      // 'P004001',
      // 'P004002',
      // 'P004003',
      // 'P005',
      // 'P005001',
      // 'P006',
      // 'P006001',
      // 'P006002',
    ])
    this.SET_BUTTONS(['P001001001', 'P001001002', 'P001001003', 'P001001004'])
    this.SET_HAS_LOADED(true)
  }

  // @Action
  // public async GetUserInfo() {
  //   if (this.token === '') {
  //     throw Error('GetUserInfo: token is undefined!')
  //   }
  //   const { data } = await getUserInfo({ /* Your params here */ })
  //   if (!data) {
  //     throw Error('Verification failed, please Login again.')
  //   }
  //   const { roles, name, avatar, introduction } = data.user
  //   // roles must be a non-empty array
  //   if (!roles || roles.length <= 0) {
  //     throw Error('GetUserInfo: roles must be a non-null array!')
  //   }
  //   this.SET_ROLES(roles)
  //   this.SET_NAME(name)
  //   this.SET_AVATAR(avatar)
  //   this.SET_INTRODUCTION(introduction)
  // }

  @Action
  public async LogOut() {
    if (this.token === '') {
      throw Error('LogOut: token is undefined!')
    }
    removeToken()
    this.SET_TOKEN('')
  }
}

export const UserModule = getModule(User)
