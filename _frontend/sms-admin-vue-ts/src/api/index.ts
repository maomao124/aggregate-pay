import ajax, { createApi, Method } from '@/api/ajax'

import { baseUrl, fileUrl } from '@/config.json'

export class Api {
  request: Method = ajax

  @createApi({ url: baseUrl + '/user/login' })
  login!: Method

  /**
   * 统计部分-发送量趋势
   */
  @createApi({ url: baseUrl + '/statistics/trend', method: 'get' })
  getStatisticsTrend!: Method

  /**
   * 统计部分-发送量统计
   */
  @createApi({ url: baseUrl + '/statistics/count', method: 'get' })
  getStatisticsCount!: Method
  
  /**
   * 统计部分-应用发送数量TOP10
   */
  @createApi({ url: baseUrl + '/statistics/top10', method: 'get' })
  getStatisticsTop10!: Method

  /**
   * 统计部分-各通道成功量（条）
   */
  @createApi({ url: baseUrl + '/statistics/countForConfig', method: 'get' })
  getStatisticsCountForConfig!: Method

  /**
   * 统计部分-各通道送达率
   */
  @createApi({ url: baseUrl + '/statistics/rateForConfig', method: 'get' })
  getStatisticsRateForConfig!: Method

  /**
   * 统计部分-营销短信发送量趋势
   */
  @createApi({ url: baseUrl + '/statistics/marketingTrend', method: 'get' })
  getStatisticsMarketingTrend!: Method

  /**
   * 短信服务-签名管理-card列表页获取
   */
  @createApi({ url: baseUrl + '/signature/page', method: 'get' })
  getSignaturePage!: Method

  /**
   * 短信服务-签名管理-添加签名
   */
  @createApi({ url: baseUrl + '/signature', method: 'post' })
  addSignature!: Method

  /**
   * 短信服务-签名管理-修改签名
   */
  @createApi({ url: baseUrl + '/signature', method: 'put' })
  editSignature!: Method

  /**
   * 短信服务-签名管理-删除签名
   */
  @createApi({ url: baseUrl + '/signature', method: 'delete' })
  deleteSignature!: Method

  /**
   * 短信服务-模板管理-card列表页
   */
  @createApi({ url: baseUrl + '/template/page', method: 'get' })
  getTemplate!: Method

  /**
   * 短信服务-模板管理-添加模板
   */
  @createApi({ url: baseUrl + '/template', method: 'post' })
  addTemplate!: Method

  /**
   * 短信服务-模板管理-修改模板
   */
  @createApi({ url: baseUrl + '/template', method: 'put' })
  editTemplate!: Method

  /**
   * 短信服务-模板管理-删除模板
   */
  @createApi({ url: baseUrl + '/template', method: 'delete' })
  deleteTemplate!: Method

  /**
   * 短信服务-通道管理-card列表获取
   */
  @createApi({ url: baseUrl + '/config/page', method: 'get' })
  getConfigPage!: Method

  /**
   * 短信服务-通道管理-添加通道
   */
  @createApi({ url: baseUrl + '/config', method: 'post' })
  addConfig!: Method

  /**
   * 短信服务-通道管理-修改通道
   */
  @createApi({ url: baseUrl + '/config', method: 'put' })
  editConfig!: Method

  /**
   * 短信服务-通道管理-删除通道
   */
  @createApi({ url: baseUrl + '/config', method: 'delete' })
  deleteConfig!: Method
  
  /**
   * 短信服务-通道管理-card列表页排序
   */
  @createApi({ url: baseUrl + '/config/level', method: 'post' })
  postConfigLevel!: Method

  /**
   * 短信服务-通道管理-信息详情接口
   */
  @createApi({ url: baseUrl + '/config', method: 'get' })
  getDetailsConfig!: Method

  /**
   * 短信服务-通道管理-通道配置-关联签名-card列表页获取
   */
  @createApi({ url: baseUrl + '/signature/customPage', method: 'get' })
  getSignatureCustomPage!: Method

  /**
   * 短信服务-通道管理-通道配置-关联模板-card列表页获取
   */
  @createApi({ url: baseUrl + '/template/customPage', method: 'get' })
  getTemplateCustomPage!: Method

  /**
   * 短信服务-通道管理-通道配置-修改其他配置接口
   */
  @createApi({ url: baseUrl + '/config/other', method: 'put' })
  editConfigOther!: Method
  /**
   * 短信服务-应用管理-card列表页获取
   */
  @createApi({ url: baseUrl + '/platform/page', method: 'get' })
  getPlatformPage!: Method

  /**
   * 短信服务-应用管理-添加应用
   */
  @createApi({ url: baseUrl + '/platform', method: 'post' })
  addPlatform!: Method

  /**
   * 短信服务-应用管理-修改应用
   */
  @createApi({ url: baseUrl + '/platform', method: 'put' })
  editPlatform!: Method

  /**
   * 短信服务-应用管理-删除应用
   */
  @createApi({ url: baseUrl + '/platform', method: 'delete' })
  deletePlatform!: Method

  /**
   * 短信服务-应用管理-详情信息
   */
  @createApi({ url: baseUrl + '/platform', method: 'get' })
  getPlatform!: Method
  
  /**
   * 短信服务-服务日志-接收日志
   */
  @createApi({ url: baseUrl + '/log/receivePage', method: 'get' })
  getLogReceivePage!: Method

  /**
   * 短信服务-服务日志-发送日志
   */
  @createApi({ url: baseUrl + '/log/sendPage', method: 'get' })
  getLogSendPage!: Method
  /**
   * 营销短信-列表页获取
   */
  @createApi({ url: baseUrl + '/marketing/page', method: 'get' })
  getMarketingPage!: Method

  /**
   * 营销短信-新建短信
   */
  @createApi({ url: baseUrl + '/marketing', method: 'post' })
  addMarketing!: Method

  /**
   * 营销短息-修改短信
   */
  @createApi({ url: baseUrl + '/marketing', method: 'put' })
  editMarketing!: Method
  /**
   * 营销短信-弹框获取变量1的接口
   */
  @createApi({ url: baseUrl + '/template/paramFields', method: 'get' })
  getTemplateParamFields!: Method

  /**
   * 营销短信-构建模板内容
   */
  @createApi({ url: baseUrl + '/template/build', method: 'post' })
  postTemplateBuild!: Method

  /**
   * 短信服务-签名管理-card列表页获取
   */
  @createApi({ url: baseUrl + '/signature/page', method: 'get' }, (res) => {
    return res.records.map((obj: any) => ({ label: obj.name, value: obj.code }))
  })
  getSignatureSelect!: Method

  /**
   * 短信服务-模板管理-card列表页
   */
  @createApi({ url: baseUrl + '/template/page', method: 'get' }, (res) => {
    return res.records.map((obj: any) => ({ label: obj.name, value: obj.code }))
  })
  getTemplateSelect!: Method

  /**
   * 营销短信-删除短信
   */
  @createApi({ url: baseUrl + '/marketing', method: 'delete' })
  deleteMarketing!: Method

  /**
   * 营销短信-审核短信
   */
  @createApi({ url: baseUrl + '/marketing/audit', method: 'put' })
  examineMarketingAudit!: Method

  /**
   * 业务统计-发送量统计-列表页接口获取
   */
  @createApi({ url: baseUrl + '/statistics/count/page', method: 'get' })
  getStatisticsCountPage!: Method

  /**
   * 业务统计-营销短信统计-列表页接口获取
   */
  @createApi({ url: baseUrl + '/statistics/marketingCount/page', method: 'get' })
  getStatisticsMarketingCountPage!: Method

  /**
   * 业务统计-营销短信统计-短信重新发送接口
   */
  @createApi({ url: baseUrl + '/marketing/reSend', method: 'put' })
  editMarketingReSend!: Method

  /**
   * 业务统计-发送记录列表页获取
   */
  @createApi({ url: baseUrl + '/log/sendLogPage', method: 'get' })
  getLogSendLogPage!: Method

  /**
   * 系统管理-黑名单列表-列表页获取
   */
  @createApi({ url: baseUrl + '/blacklist/page', method: 'get' })
  getBlacklistPage!: Method

  /**
   * 系统管理-黑明单列表-新增保存
   */
  @createApi({ url: baseUrl + '/blacklist', method: 'post' })
  addBlacklist!: Method

  /**
   * 系统管理-黑名单列表-修改
   */
  @createApi({ url: baseUrl + '/blacklist', method: 'put' })
  editBlacklist!: Method

  /**
   * 系统管理-黑名单列表-删除黑名单
   */
  @createApi({ url: baseUrl + '/blacklist', method: 'delete' })
  deleteBlacklist!: Method

  /**
   * 上传文件-营销短信
   */
  uploadFile1: Method = ({ fileItem, onProgress = null }, showMsg) => {
    const data = new FormData()
    data.append('file', fileItem)
    // data.append('appType', 'web')
    return ajax({
      url: fileUrl + '/marketing/upload',
      data,
      method: 'post',
      showMsg,
      headers: { 'Content-Type': 'multipart/form-data' },
      onUploadProgress: onProgress
    })
  }

  /**
   * 上传文件-黑名单
   */
  uploadFile: Method = ({ fileItem, onProgress = null }, showMsg) => {
    const data = new FormData()
    data.append('file', fileItem)
    // data.append('appType', 'web')
    return ajax({
      url: fileUrl + '/blacklist/upload',
      data,
      method: 'post',
      showMsg,
      headers: { 'Content-Type': 'multipart/form-data' },
      onUploadProgress: onProgress
    })
  }
}


export default new Api()